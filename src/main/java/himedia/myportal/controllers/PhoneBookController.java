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

import himedia.myportal.repositories.vo.PhoneBookVo;
import himedia.myportal.services.PhoneBookService;

@Controller
@RequestMapping("/phonebook")
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping({"", "/"})
    public String defaultView(Model model) {
        return list(model);
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<PhoneBookVo> phoneBooks = phoneBookService.getList();
        model.addAttribute("phoneBooks", phoneBooks);
        return "phonebook/list";
    }

    @GetMapping("/add")
    public String addForm() {
        return "phonebook/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute PhoneBookVo phoneBook) {
        phoneBookService.addPhoneBook(phoneBook);
        return "redirect:/phonebook/list";
    }

    @GetMapping("/delete/{phId}")
    public String delete(@PathVariable("phId") Long phId, Model model) {
        phoneBookService.deletePhoneBook(phId);
        return "redirect:/phonebook/list";
    }
}
