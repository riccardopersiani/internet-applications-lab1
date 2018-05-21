package it.polito.ai.businesslogic;

public class UserInfo {
	private String firstName, lastName, address, city, birthdate;
	private String telephone, cellPhone, organization;
	private String cap;

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param birthdate
	 * @param telephone
	 * @param cellPhone
	 * @param organization
	 * @param cap
	 */
	public UserInfo(String firstName, String lastName, String address, String city, String birthdate, String telephone,
			String cellPhone, String organization, String cap) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.birthdate = birthdate;
		this.telephone = telephone;
		this.cellPhone = cellPhone;
		this.organization = organization;
		this.cap = cap;
	}

	public static UserInfo createUserInfo(String firstName, String lastName, String address, String city, String birthdate, String telephone,
			String cellPhone, String organization, String cap){
		if(firstName == null || lastName == null || address == null || city == null || birthdate == null || telephone == null ||
				firstName.equals("") || lastName.equals("") || address.equals("") || city.equals("") || birthdate.equals("") || telephone.equals("")){
			//cellPhone, organization are optional
			return null;
		}
		try{
			int capCode = Integer.parseInt(cap);
			if(capCode < 9999){
				//cap è un numero di 5 cifre
				return null;
			}

			return new UserInfo(firstName,lastName,address, city, birthdate, telephone, cellPhone, organization, cap);
		}
		catch(NumberFormatException e){
			return null;
		}
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
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

	/**
	 * @return the cap
	 */
	public String getCap() {
		return cap;
	}

	/**
	 * @param cap the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}




}
