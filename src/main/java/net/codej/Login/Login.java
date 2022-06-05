package net.codej.Login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.User_Login.User_Login;
@EnableAutoConfiguration
@Entity
@Table(name="Login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int login_id;
	@Column(unique=true)
	private String username;
	@Column(unique=true)
	private String email;
	private String password;
	@OneToOne(mappedBy = "login")
	@NotFound(action=NotFoundAction.IGNORE)
	private User_Login user_login;
	public Login() {
		super();
	}
	
	public Login( String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User_Login getUser_login() {
		return user_login;
	}

	public void setUser_login(User_Login user_login) {
		this.user_login = user_login;
	}

	public Login(int login_id, String username, String email, String password, User_Login user_login) {
		super();
		this.login_id = login_id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.user_login = user_login;
	}
	

	
	
	
}
