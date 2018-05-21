/**
 * 
 */
package it.polito.ai.businesslogic;

/**
 * @author riccardopersiani
 *
 */
public class RegistrationServiceImpl implements RegistrationService {

	private UserInfo userInfo;
	private String username;
	private String password;

	public boolean register(String username, String password, String confirmPassword, UserInfo userInfo) {
		if (username == null || password == null || confirmPassword == null || userInfo == null){
			return false;
		}
		
		if(password.equals(confirmPassword) == false){
			return false;
		}

		this.setUserInfo(userInfo);
		this.username = username;
		this.password = password;

		/**
		 * Send the parameters to the database
		 * **/

		return true;
	}

	public void cancelRegistration(String username, String password) {

		/**
		 * Send the DELETE request to the database of the user account
		 * **/
	}
	
	public boolean activate(String activationCode) {
		/**
		 * Send the DELETE request to the database of the user account
		 * **/

		return false;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
