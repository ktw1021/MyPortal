package himedia.myportal.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import himedia.myportal.services.UserService;
import himedia.myportal.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
            throws Exception {
        logger.debug("AuthInterceptor");

        // 사용자가 로그인한 사용자?
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
        UserService us = context.getBean(UserServiceImpl.class);
        
        if (us.isAuthenticated(req)) {
            logger.debug("인증된 사용자");
            return true;
        } else {
            logger.debug("인증되지 않은 사용자");
            // 로그인 페이지로 리다이렉트
            HttpSession session = req.getSession();
            session.setAttribute("loginAlert", "로그인해야 이용할 수 있습니다.");
            resp.sendRedirect(req.getContextPath() + "/users/login");
            return false;    // 통과시키지 않음
        }
    }
}
