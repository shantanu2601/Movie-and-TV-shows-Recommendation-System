package net.codej.User_Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codej.Transfer;

@Service
public class User_LoginService  {


	@Autowired 
	private User_LoginRepository repository;
	
	public User_Login findUser(int login_id)
	{
		return repository.findUser(login_id);
	}
	
	public User_Login save(User_Login a)
	{
		return repository.save(a);
		
	}
	
	

}