package entity;

public class Payment {
	
	
	private int payid;
	private int UserId;
	private String cardnumber;
	private String cardname;
	private String expirydate;
	private String cvv;
	private String amount;
	
	
	
	public Payment(int userId,String cardname, String cardnumber,  String expirydate, String cvv,
			String amount) {
		super();
		this.UserId = userId;
		this.cardnumber = cardnumber;
		this.cardname = cardname;
		this.expirydate = expirydate;
		this.cvv = cvv;
		this.amount = amount;
	}

	
	public Payment() {}


	public int getPayid() {
		return payid;
	}



	public void setPayid(int payid) {
		this.payid = payid;
	}



	public int getUserId() {
		return UserId;
	}



	public void setUserId(int userId) {
		UserId = userId;
	}



	public String getCardnumber() {
		return cardnumber;
	}



	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}



	public String getCardname() {
		return cardname;
	}



	public void setCardname(String cardname) {
		this.cardname = cardname;
	}



	public String getExpirydate() {
		return expirydate;
	}



	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}



	public String getCvv() {
		return cvv;
	}



	public void setCvv(String cvv) {
		this.cvv = cvv;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}

	

}
