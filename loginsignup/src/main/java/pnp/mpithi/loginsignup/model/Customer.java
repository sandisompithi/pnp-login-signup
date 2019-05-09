package pnp.mpithi.loginsignup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custId")
	private int custId;
	
	@NotEmpty
	@Column(name = "first_name")
	private String firstname;
	
	@NotEmpty
	@Column(name = "surname")
	private String surname;
	
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;
	
	@NotEmpty
	@Column(name = "password")
	private String password;

	public int getCustId() { return custId;}

	public void setCustId(int custId) { this.custId = custId;}

	public String getFirstname() { return firstname;}

	public void setFirstname(String firstname) { this.firstname = firstname;}

	public String getSurname() { return surname;}

	public void setSurname(String surname) { this.surname = surname;}

	public String getEmail() { return email;}

	public void setEmail(String email) { this.email = email;}

	public String getPassword() { return password;}

	public void setPassword(String password) { this.password = password;}
	
	
	
}
