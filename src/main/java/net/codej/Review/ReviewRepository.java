package net.codej.Review;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ReviewRepository extends JpaRepository<Review,Review_id> {


	@Query("SELECT a FROM Review a WHERE a.user.user_id =?1")
	List<Review> findReviewByuser_id(int user_id);
	
	@Query("SELECT a FROM Review a WHERE a.movie.movid =?1")
	List<Review>  findReviewBymovid(int movid);
	
	@Query("SELECT a FROM Review a WHERE(a.user.user_id =?1 AND a.movie.movid =?2)")
	List<Review>  findReviewBymovidAnduser_id(int user_id,int movid);
	
	@Query("SELECT a FROM Review a WHERE a.review_id =?1")
	Review findReview(Review_id review_id);
	
	@Query("SELECT count(*) FROM Review a WHERE(a.user.user_id =?1 AND a.movie.movid =?2)")
	int findReviewCount(int user_id, int movid);
	
	

}