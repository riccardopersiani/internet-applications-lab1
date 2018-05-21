package it.polito.ai.businesslogic;

import java.util.*;

public class LoginServiceImpl implements LoginService {
	
	private boolean loggedIn;
	private String username;
	
	private boolean initialized = false;
	private static Map<String, String> users = new HashMap<String,String>();
	
	public LoginServiceImpl() {
		if (!initialized) {
			// TODO this part of code should be done by asking DB
			users.put("martino", "martino");
			users.put("riccardo", "riccardo");
			users.put("alessio", "alessio");
			users.put("sabrina", "sabrina");
			initialized = true;
		}
		this.loggedIn = false;
		this.username = null;
	}

	public boolean login(String username, String password) {
		if(username == null || password == null){
			return false;
		}
		
		String correctPwd = users.get(username);
		loggedIn = (correctPwd != null && correctPwd.equals(password));
		if (loggedIn) {
			this.username = username;
		}
		System.out.println("login() - loggedIn:" + loggedIn);
		return loggedIn;
	}

	public void logout() {
		loggedIn = false;
		System.out.println("logout() - loggedIn:" + loggedIn);
		username = null;
	}

	public String getUsername() {
		return username;
	}

	public void resetPassword(String username) {
		// TODO
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

}
