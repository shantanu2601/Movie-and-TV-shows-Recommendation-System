package net.codej.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codej.User.User;

public interface LoginRepository extends JpaRepository<Login,Integer>{
	
	@Query("SELECT a FROM Login a WHERE a.username =?1")
	Login findByUsername(String username);
	
	@Query("SELECT a FROM Login a WHERE a.email =?1")
	Login findByEmail(String email);
	
	@Query("SELECT a FROM Login a WHERE a.login_id =?1")
	Login findByLogin(int login_id);

}
