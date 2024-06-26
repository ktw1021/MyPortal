package himedia.myportal.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class GlobalExceptionHandler {
	 @ExceptionHandler(Exception.class)
	    public String handleException(Exception e, Model model, RedirectAttributes redirectAttributes) {
	        // 로그 출력
	        System.err.println("예외 발생: " + e.getMessage());
	        e.printStackTrace();
	        
	        // 에러 메시지 설정
	        redirectAttributes.addFlashAttribute("errorMessage", "알 수 없는 오류가 발생했습니다. 나중에 다시 시도해주세요.");
	        return "redirect:/error";
	    }
}
