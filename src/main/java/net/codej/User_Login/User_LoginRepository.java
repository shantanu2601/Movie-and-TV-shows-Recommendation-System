package net.codej.User_Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface User_LoginRepository extends JpaRepository<User_Login,Integer> {



	@Query("SELECT a FROM User_Login a WHERE a.login_id =?1")
	User_Login findUser(int login_id);
	


}