/**
 * 
 */
package it.polito.ai.businesslogic;

import java.util.Map;

/**
 * @author 
 *
 */
public class PaymentServiceImpl implements PaymentService {
	
	Map<String, Integer> cartItems;
	PaymentInfo paymentInfo;

	public boolean setCartItem(Map<String, Integer> cartItems) {
		this.cartItems = cartItems;
		return true;
	}
	
	public Map<String,Integer> getCartItems() {
		return cartItems;
	}

	public boolean setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
		return true;
	}
	
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public boolean pay() {
		/**
		 * Send the paymentInfo and this.cartItems. 
		 * **/
		return true;
	}

}
