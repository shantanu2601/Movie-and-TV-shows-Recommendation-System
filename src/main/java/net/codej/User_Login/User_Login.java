package net.codej.User_Login;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import net.codej.Login.Login;
import net.codej.User.User;

@Entity
public class User_Login {
	
	@Id
	private int login_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_id", referencedColumnName="login_id")
	@NotFound(action=NotFoundAction.IGNORE)
	private Login login;
	
	
	
	public User_Login(int login_id, User user, Login login) {
		super();
		this.login_id = login_id;
		this.user = user;
		this.login = login;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public User_Login(int login_id, User user) {
		super();
		this.login_id = login_id;
		this.user = user;
	}


	public int getLogin_id() {
		return login_id;
	}


	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User_Login() {
		super();
	}
	
	

}
