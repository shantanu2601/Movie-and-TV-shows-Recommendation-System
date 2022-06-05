package net.codej.Review;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewService  {

	@Autowired 
	private ReviewRepository repository;
	
	public List<Review> findReviewByuser_id(int user_id)
	{
		return repository.findReviewByuser_id(user_id);
	}
	
	public List<Review> findReviewBymovid(int movid)
	{
		return repository.findReviewBymovid(movid);
	}
	
	public List<Review>  findReviewBymovidAnduser_id(int user_id,int movid)
	{
		return repository.findReviewBymovidAnduser_id(user_id, movid);
	}
	
	public Review findReview(int revid ,int user_id,int movid)

	{
		Review_id review_id = new Review_id(revid,movid,user_id);
		return repository.findReview(review_id);
	}
	
	public int findReviewCount(int user_id, int movid)
	{
		return repository.findReviewCount(user_id,movid);
	}
	
	public Review save(Review a)
	{
		return repository.save(a);
		
	}

}