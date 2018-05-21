package it.polito.ai.businesslogic;

import java.util.Map;

public interface PaymentService {
	boolean setCartItem(Map<String,Integer> cartItems);
	Map<String,Integer> getCartItems();
	boolean setPaymentInfo(PaymentInfo paymentInfo);
	PaymentInfo getPaymentInfo();
	boolean pay();
}
