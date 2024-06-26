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

import himedia.myportal.repositories.vo.BoardVo;
import himedia.myportal.repositories.vo.UserVo;
import himedia.myportal.services.BoardService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
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
        return "board/list";
    }

    @GetMapping("/write")
    public String writeForm(HttpSession session, Model model) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            session.setAttribute("loginAlert", "로그인해야 글을 쓸 수 있습니다.");
            return "redirect:/users/login";
        }
        return "board/write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute BoardVo boardVo, HttpSession session) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            session.setAttribute("loginAlert", "로그인해야 글을 쓸 수 있습니다.");
            return "redirect:/users/login";
        }
        boardVo.setName(authUser.getName());
        boardService.write(boardVo);
        return "redirect:/board/list";
    }

    @GetMapping("/view/{no}")
    public String view(@PathVariable("no") Long no, Model model) {
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
    public String edit(@ModelAttribute BoardVo boardVo) {
        boardService.update(boardVo);
        return "redirect:/board/view/" + boardVo.getNo();
    }
    @GetMapping("/delete/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.delete(no);
        return "redirect:/board/list";
    }
}
