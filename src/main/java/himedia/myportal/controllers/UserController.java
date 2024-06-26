package himedia.myportal.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.myportal.repositories.vo.UserVo;
import himedia.myportal.services.UserService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // 가입 폼
    @GetMapping({"", "/", "/join"})
    public String join() {
        return "users/joinform";
    }

    // 가입 처리(액션)
    @PostMapping("/join")
    public String join(@ModelAttribute UserVo userVo, RedirectAttributes redirectAttributes) {
        System.out.println("회원 가입 폼: " + userVo);

        boolean success = userService.join(userVo);
        if (success) { // 가입 성공
            // 가입 성공 페이지로 리다이렉트
            System.out.println("회원 가입 성공");
            return "redirect:/users/joinsuccess";
        } else {
            // 다시 가입 폼으로
            System.err.println("회원 가입 실패");
            redirectAttributes.addFlashAttribute("message", "회원 가입에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/users/join";
        }
    }

    // 가입 성공 페이지 
    @RequestMapping("/joinsuccess")
    public String joinSuccess() {
        return "users/joinsuccess";
    }

    // 로그인 폼 페이지
    @GetMapping("/login")
    public String loginForm() {
        return "users/loginform";
    }

    // 로그인 액션 
    @PostMapping("/login")
    public String loginAction(
            @RequestParam(value="email", required=false, defaultValue = "") String email,
            @RequestParam(value="password", required=false, defaultValue = "") String password,
            HttpSession session, RedirectAttributes redirectAttributes) {
        System.out.println("email:" + email);
        System.out.println("password:" + password);

        if (email.length() == 0 || password.length() == 0) {
            System.out.println("email 혹은 password가 입력되지 않음");
            redirectAttributes.addFlashAttribute("message", "이메일과 비밀번호를 모두 입력해주세요.");
            return "redirect:/users/login";
        }

        // email과 password 이용, 사용자 정보 질의
        UserVo authUser = userService.getUser(email, password);

        if (authUser != null) {
            // 로그인 처리
            session.setAttribute("authUser", authUser);
            // 홈페이지로 이동
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("message", "잘못된 이메일 또는 비밀번호입니다.");
            return "redirect:/users/login";
        }
    }

    // 로그아웃
    @RequestMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.removeAttribute("authUser");
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "로그아웃 되었습니다.");
        return "redirect:/";
    }

    // 중복 이메일 체크 (API) -> 응답을 json
    @ResponseBody // -> MessageConverter 사용
    @RequestMapping("/checkEmail")
    public Object checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {
        UserVo vo = userService.getUser(email);
        boolean exists = vo != null ? true : false;

        System.out.println("Controller UserVo: " + vo);

        Map<String, Object> json = new HashMap<>();
        json.put("result", "success");
        json.put("exists", exists);

        return json;
    }

    @GetMapping("/emailcheck")
    @ResponseBody
    public boolean emailCheck(@RequestParam("email") String email) {
        return userService.getUser(email) != null;
    }
}
