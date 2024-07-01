package himedia.myportal.repositories.vo;

public class PhoneBookVo {
    private Long phId;
    private String phName;
    private String phNum;
    private String hmNum;

    public PhoneBookVo() {
    	
    }
    
    public PhoneBookVo(Long phId) {
		this.phId = phId;
	}

	public PhoneBookVo(String phName, String phNum, String hmNum) {
		this.phName = phName;
		this.phNum = phNum;
		this.hmNum = hmNum;
	}

	public PhoneBookVo(Long phId, String phName, String phNum, String hmNum) {
		this.phId = phId;
		this.phName = phName;
		this.phNum = phNum;
		this.hmNum = hmNum;
	}

	// Getters and Setters
    public Long getPhId() {
        return phId;
    }

    public void setPhId(Long phId) {
        this.phId = phId;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getHmNum() {
        return hmNum;
    }

    public void setHmNum(String hmNum) {
        this.hmNum = hmNum;
    }

	@Override
	public String toString() {
		return "PhoneBookVo [phId=" + phId + ", phName=" + phName + ", phNum=" + phNum + ", hmNum=" + hmNum + "]";
	}
    
}
