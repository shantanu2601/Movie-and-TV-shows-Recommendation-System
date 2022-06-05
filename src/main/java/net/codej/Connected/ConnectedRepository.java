package net.codej.Connected;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ConnectedRepository extends JpaRepository<Connected,Connected_id> {

	@Query("SELECT a FROM Connected a WHERE a.movie.movid =?1")
	List<Connected> findRelated(int movid);
	

}