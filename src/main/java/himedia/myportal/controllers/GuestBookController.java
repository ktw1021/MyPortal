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

import himedia.myportal.repositories.vo.GuestBookVo;
import himedia.myportal.services.GuestBookService;

@RequestMapping("/guestbook")
@Controller
public class GuestBookController {

    @Autowired
    GuestBookService guestbookService;

    @RequestMapping({"", "/", "/list"})
    public String list(Model model) {
        List<GuestBookVo> list = guestbookService.getMessageList();
        model.addAttribute("list", list);
        return "guestbook/list"; // view로 포워딩
    }

    // /guestbook/write (POST) -> 방명록 기록
    @PostMapping("/write")
    public String write(@ModelAttribute GuestBookVo vo, RedirectAttributes redirectAttributes) {
        System.out.println("HTML FORM: " + vo);
        boolean success = guestbookService.writeMessage(vo);
        System.out.println("Write Result: " + success);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "등록되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("message", "등록에 실패했습니다.");
        }
        // INSERT -> Redirect
        return "redirect:/guestbook";
    }

    // /guestbook/delete/{no} -> 삭제 폼
    @GetMapping("/delete/{no}")
    public String delete(@PathVariable("no") Long no, Model model) {
        model.addAttribute("no", no);
        return "guestbook/deleteform"; // 목록 페이지로 리다이렉트
    }

    // /guestbook/delete (POST)
    @PostMapping("/delete")
    public String delete(@ModelAttribute GuestBookVo vo, RedirectAttributes redirectAttributes) {
        boolean success = guestbookService.deleteMessage(vo);
        System.out.println("DELETE RESULT: " + success);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "삭제되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("message", "삭제에 실패했습니다.");
        }
        return "redirect:/guestbook";
    }

    // /guestbook/edit/{no} -> 수정 폼
    @GetMapping("/edit/{no}")
    public String editForm(@PathVariable("no") Long no, Model model) {
        GuestBookVo guestBookVo = guestbookService.getMessageById(no); // 수정할 항목을 서비스에서 받아옴
        model.addAttribute("guestbookVo", guestBookVo);
        return "guestbook/editform"; // 수정 폼 페이지로 이동
    }

    // /guestbook/edit (POST) -> 수정 처리
    @PostMapping("/edit")
    public String edit(@ModelAttribute GuestBookVo vo, RedirectAttributes redirectAttributes) {
        boolean success = guestbookService.updateMessage(vo);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "수정되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("message", "수정에 실패했습니다.");
        }
        return "redirect:/guestbook";
    }
}
