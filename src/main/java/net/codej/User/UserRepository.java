package net.codej.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Integer> {


	@Query("SELECT a FROM User a WHERE a.user_id =?1")
	User findUser(int user_id);
	
	


}