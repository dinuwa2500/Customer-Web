package dbc;

import java.util.List;

import entity.Package;
import entity.Payment;

public interface PaymentDbc {

	
	public boolean addPayment(int userid,String cardName,String cardNumber , String expiryDate , String Cvv,String Amount);
	
	
	public List<Payment> getAllPay();
	
	
	public 	Payment getPaymentById(int id);
	
	
	public boolean deletePayment(int id);
	
	
	
	
}
