package himedia.myportal.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.UserDao;
import himedia.myportal.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	 private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	 
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean join(UserVo vo) {
		int insertedCount = 0;
		insertedCount = userDao.insert(vo);
		return insertedCount == 1;
	}

	@Override
	public UserVo getUser(String email) {
		UserVo userVo = userDao.selectUser(email);
		System.out.println("Service UserVo: " + userVo);
		return userVo;
	}

	@Override
	public UserVo getUser(String email, String password) {
		UserVo userVo = userDao.selectUser(email, password);
		return userVo;
	}

	@Override
	public boolean isAuthenticated(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null) {	// 인증했을 가능성이 있다
			UserVo authUser = (UserVo) session.getAttribute("authUser");
			return authUser != null;
		}
		return false;
	}

}