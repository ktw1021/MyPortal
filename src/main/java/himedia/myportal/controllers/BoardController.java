package himedia.myportal.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import himedia.myportal.repositories.vo.BoardVo;
import himedia.myportal.services.BoardService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

    private static final String UPLOAD_DIR = "C:/uploads/";

    @Autowired
    private BoardService boardService;

    // 디폴트 페이지 설정
    @GetMapping({"", "/"})
    public String defaultView(Model model) {
        return list(model);
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardVo> boards = boardService.getList();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute BoardVo board, @RequestParam("file") MultipartFile file, HttpSession session) {
        // 로그인한 사용자의 이름 가져오기
        String userName = (String) session.getAttribute("authUserName");
        board.setName(userName);

        // 파일 업로드 처리
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String filePath = UPLOAD_DIR + fileName;

            try {
                file.transferTo(new File(filePath));
                board.setFilePath("/uploads/" + fileName);  // 웹 경로 설정
                board.setFilename(fileName); // 파일명 설정
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/view/{no}")
    public String view(@PathVariable("no") Long no, Model model) {
        boardService.increaseViewcount(no);
        BoardVo board = boardService.getContent(no);
        model.addAttribute("board", board);
        return "board/view";
    }

    @GetMapping("/edit/{no}")
    public String editForm(@PathVariable("no") Long no, Model model) {
        BoardVo board = boardService.getContent(no);
        model.addAttribute("board", board);
        return "board/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute BoardVo board, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String filePath = UPLOAD_DIR + fileName;

            try {
                file.transferTo(new File(filePath));
                board.setFilePath("/uploads/" + fileName);  // 웹 경로 설정
                board.setFilename(fileName); // 파일명 설정
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boardService.updateWithFile(board, file);
        return "redirect:/board/view/" + board.getNo();
    }

    @GetMapping("/delete/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.delete(no);
        return "redirect:/board/list";
    }
}
