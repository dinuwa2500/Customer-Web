package dbc;

import java.util.List;

import entity.Feedback;
import entity.User;

public interface Userdbc {

	public boolean insertData(String fname, String lname, String email, String phno, String password);

	public User UserLogin(String email, String password);

	public List<Feedback> getAllFd(int userId);

}
