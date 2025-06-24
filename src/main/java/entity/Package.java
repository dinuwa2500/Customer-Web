package entity;

public class Package {

	private int Pckid;
	private int UserId;
	private String pcktype;
	private String num;
	private String full_name;
	private String duration;
	private String price;
	private String pMethod;

	public Package() {
		super();

	}

	
	
	/*
	 * public Package(String full_name, String num ,String duration, String price,
	 * String dataAllowance) { super();
	 * 
	 * this.num=num; this.full_name = full_name; this.duration = duration;
	 * this.price = price; this.dataAllowance = dataAllowance; }
	 */

	public Package(int UserId,String full_name,String pcktype, String num,  String duration, String price,
			String pMethod) {
		super();
		this.UserId = UserId;
		this.full_name = full_name;
		this.pcktype = pcktype;
		this.num = num;
		this.duration = duration;
		this.price = price;
		this.pMethod = pMethod;
	}



	public int getPckid() {
		return Pckid;
	}

	public void setPckid(int pckid) {
		Pckid = pckid;
	}

	/*
	 * public String getPckname() { return Pckname; }
	 * 
	 * public void setPckname(String pckname) { Pckname = pckname; }
	 */

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	/*
	 * public String getDataAllowance() { return dataAllowance; }
	 * 
	 * public void setDataAllowance(String dataAllowance) { this.dataAllowance =
	 * dataAllowance; }
	 */

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}



	public int getUserId() {
		return UserId;
	}



	public void setUserId(int userId) {
		UserId = userId;
	}



	public String getPcktype() {
		return pcktype;
	}



	public void setPcktype(String pcktype) {
		this.pcktype = pcktype;
	}



	public String getpMethod() {
		return pMethod;
	}



	public void setpMethod(String pMethod) {
		this.pMethod = pMethod;
	}
	
	
	
	

}
