package it.polito.ai.businesslogic;

public interface RegistrationService {
	boolean register(String username, String password, String confirmPassword, UserInfo userInfo);
	void cancelRegistration(String username, String password);
}
