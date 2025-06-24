package dbc;

import java.util.List;

import entity.Feedback;
import entity.Package;
import entity.Payment;

public interface FeedbackDbc {

	public boolean addFeedback(int user_id, String name, String email, String rate, String feedback);

	public List<Feedback> getAllFd();

	public Feedback getFdById(int id);

	public boolean FeedbackEdit(Feedback fb);
	
	public boolean DeleteFeedback(int id);

}
