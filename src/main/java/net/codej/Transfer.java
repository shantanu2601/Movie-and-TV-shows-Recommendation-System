package net.codej;

import net.codej.Login.Login;
import net.codej.User.User;

public class Transfer {
	
	private static int id;
	private static User user;
	private static Login login;

	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Transfer.id = id;
	}
	public static User getUser() {
		return user;
	}
	public static void setUser(User user) {
		Transfer.user = user;
	}
	public static Login getLogin() {
		return login;
	}
	public static void setLogin(Login login) {
		Transfer.login = login;
	}
	
	
	

}
