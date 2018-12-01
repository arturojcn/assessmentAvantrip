package ar.com.avantrip.binding;

public class UserResquest {
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private PersonRequest userDetail;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the userDetail
	 */
	public PersonRequest getPesonDetail() {
		return userDetail;
	}

	/**
	 * @param userDetail the userDetail to set
	 */
	public void setPesonDetail(PersonRequest userDetail) {
		this.userDetail = userDetail;
	}
	
	

}
