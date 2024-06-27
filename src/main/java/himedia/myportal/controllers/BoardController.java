package himedia.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import himedia.myportal.repositories.vo.BoardVo;
import himedia.myportal.repositories.vo.UserVo;
import himedia.myportal.services.BoardService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public String defaultView() {
        return "redirect:/board/list";
    }
    
    @GetMapping("/list")
    public String list(Model model) {
        List<BoardVo> boards = boardService.getList();
        model.addAttribute("boards", boards);
        logger.info("Board list fetched successfully.");
        return "board/list";
    }

    @GetMapping("/write")
    public String writeForm(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            redirectAttributes.addFlashAttribute("loginAlert", "로그인해야 글을 쓸 수 있습니다.");
            logger.warn("Unauthorized access attempt to write form.");
            return "redirect:/users/login";
        }
        return "board/write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute BoardVo boardVo, HttpSession session, RedirectAttributes redirectAttributes) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            redirectAttributes.addFlashAttribute("loginAlert", "로그인해야 글을 쓸 수 있습니다.");
            logger.warn("Unauthorized access attempt to write.");
            return "redirect:/users/login";
        }
        boardVo.setName(authUser.getName());
        boardService.write(boardVo);
        logger.info("New board entry written by user: {}", authUser.getName());
        return "redirect:/board/list";
    }

    @GetMapping("/view/{no}")
    public String view(@PathVariable("no") Long no, Model model) {
        BoardVo board = boardService.getContent(no);
        model.addAttribute("board", board);
        logger.info("Board entry viewed: {}", no);
        return "board/view";
    }

    @GetMapping("/edit/{no}")
    public String editForm(@PathVariable("no") Long no, Model model) {
        BoardVo board = boardService.getContent(no);
        model.addAttribute("board", board);
        return "board/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute BoardVo boardVo) {
        boardService.update(boardVo);
        logger.info("Board entry updated: {}", boardVo.getNo());
        return "redirect:/board/view/" + boardVo.getNo();
    }

    @GetMapping("/delete/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.delete(no);
        logger.info("Board entry deleted: {}", no);
        return "redirect:/board/list";
    }
}
