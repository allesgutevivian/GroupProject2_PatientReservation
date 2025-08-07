package GroupProject2_Reservation;

public class Patient {

	String name;
	String username;
	String password;
	String email;
	String address;
	String telephone;
	/**
	 * @param name
	 * @param username
	 * @param password
	 * @param email
	 * @param address
	 * @param telephone
	 */
	public Patient(String name, String username, String password, String email, String address, String telephone) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	@Override
	public String toString() {
		return "Patient [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", telephone=" + telephone + "]";
	}
	
	
}
