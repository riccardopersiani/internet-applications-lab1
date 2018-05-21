package it.polito.ai.businesslogic;

public interface LoginService {
	/**
	 * The username is actually an email address.
	 * There is no reason to create another field to manage in a e-commerce website.
	 * **/
	boolean login(String username, String password);
	/**
	 * The user does not receive any because the logout is always completed with success.
	 * **/
	void logout();
	/**
	 * 
	 * **/
	String getUsername();
	/**
	 * The user does not receive any feedback for security and privacy reasons.
	 * **/
	void resetPassword(String username);
	/**
	 * If the user is logged in or not
	 */
	boolean isLoggedIn();
}
