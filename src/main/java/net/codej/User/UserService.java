package net.codej.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


	@Autowired 
	private UserRepository repository;
	
	public User findUser(int user_id)
	{
		return repository.findUser(user_id);
	}
	

	
	public User save(User a)
	{
		return repository.save(a);
		
	}


}