package entity;

public class Feedback {

	private int user_id;
	private int feedbackid;
	private String name;
	private String email;
	private String rate;
	private String feedback;
	
	
	public Feedback() {}


	public Feedback(int user_id, int feedbackid, String name, String email, String rate, String feedback) {
		super();
		this.user_id = user_id;
		this.feedbackid = feedbackid;
		this.name = name;
		this.email = email;
		this.rate = rate;
		this.feedback = feedback;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getFeedbackid() {
		return feedbackid;
	}


	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRate() {
		return rate;
	}


	public void setRate(String rate) {
		this.rate = rate;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
	
	
	
	
	
	
	

}
