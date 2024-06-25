package himedia.myportal.services;

import himedia.myportal.repositories.vo.UserVo;

public interface UserService {
	public boolean join(UserVo vo);	//회원가입
	public UserVo getUser(String email);	//중복가입 체크
	public UserVo getUser(String email, String password);	//로그인
	
}
