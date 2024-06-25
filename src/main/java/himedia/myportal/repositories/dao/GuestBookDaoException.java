package himedia.myportal.repositories.dao;

import himedia.myportal.repositories.vo.GuestBookVo;

public class GuestBookDaoException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GuestBookVo guestbookvo=null;
	
	// 생성자
	public GuestBookDaoException() {
		
	}
	public GuestBookDaoException(String message) {
		super(message);
	}
	
	public GuestBookDaoException(String message, GuestBookVo vo) {
		super(message);
		this.guestbookvo = vo;
	}
	public GuestBookVo getGuestbookvo() {
		return guestbookvo;
	}
	
}
