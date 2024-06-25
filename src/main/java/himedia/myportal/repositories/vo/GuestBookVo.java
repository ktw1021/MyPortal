package himedia.myportal.repositories.vo;

import java.util.Date;

public class GuestBookVo {
	// field
	private Long no;
	private String name;
	private String password;
	private String content;
	private Date reg_date;
	
	public GuestBookVo() {
		
	}

	
	
	public GuestBookVo(Long no, String name, String content) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
	}



	public GuestBookVo(Long no, String name, String content, Date reg_date) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
		this.reg_date = reg_date;
	}



	public GuestBookVo(Long no, String password) {
		super();
		this.no = no;
		this.password = password;
	}



	public GuestBookVo(Long no, String name, String password, String content, Date reg_date) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.reg_date = reg_date;
	}


	/**
	 * @return the no
	 */
	public Long getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(Long no) {
		this.no = no;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the reg_date
	 */
	public Date getReg_date() {
		return reg_date;
	}
	/**
	 * @param reg_date the reg_date to set
	 */
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "GuestBookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", reg_date=" + reg_date + "]";
	}
	
	
	
}
