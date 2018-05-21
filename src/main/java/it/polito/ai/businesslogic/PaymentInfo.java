/**
 * 
 */
package it.polito.ai.businesslogic;

import java.util.regex.Pattern;

/**
 *
 *
 */
public class PaymentInfo {
	private String method;
	private String creditCard;
	private String billingAddress, city;
	private int cap;
	private String organization;
	
	/**
	 * @param method
	 * @param creditCard
	 * @param billingAddress
	 * @param city
	 * @param cap
	 * @param organization
	 */
	private PaymentInfo(String method, String creditCard, String billingAddress, String city, int cap,
			String organization) {
		super();
		this.method = method;
		this.creditCard = creditCard;
		this.billingAddress = billingAddress;
		this.city = city;
		this.cap = cap;
		this.organization = organization;
	}
	
	public static PaymentInfo createPaymentInfo(String method, String creditCard, String billingAddress, String city, String cap, String organization) {
		if (method == null || creditCard == null || billingAddress == null || city == null || cap == null
				|| method.equals("") || creditCard.equals("") || billingAddress.equals("") || city.equals("") || cap.equals("")) {
			// checking required fields
			return null;
		}
		String creditCartRegexp = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
		        "(?<mastercard>5[1-5][0-9]{14})|" +
		        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
		        "(?<amex>3[47][0-9]{13})|" +
		        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
		        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
		if (!Pattern.compile(creditCartRegexp).matcher(creditCard).matches()) {
			return null;
		}
		try {
			int capInt = Integer.parseInt(cap);
		return new PaymentInfo(method, creditCard, billingAddress, city, capInt, organization);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the creditCard
	 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard the creditCard to set
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * @return the billingAddress
	 */
	public String getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the cap
	 */
	public int getCap() {
		return cap;
	}

	/**
	 * @param cap the cap to set
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	
	
}
