package net.codej.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codej.Transfer;

@Service

public class LoginService {
	@Autowired 
	private LoginRepository repository;
	
	public  Login  findByUsername(String username)
	{
		return repository.findByUsername(username);
	}
	
	
	public  Login  findByEmail(String email)
	{
		return repository.findByEmail(email);
	}
	
	
	public  Login  findByLogin(int login_id)
	{
		return repository.findByLogin(login_id);
	}
	
	public Login save(Login a)
	{
		return repository.save(a);
		
	}
	public int check()
	{
		
		if(Transfer.getLogin()==null&&
			Transfer.getUser()==null&&
			Transfer.getId()==0)
		return 0;
		else
			return 1;
		
	}
}
