package net.codej.Connected;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConnectedService  {


	@Autowired 
	private ConnectedRepository repository;
	
	public List<Connected> findRelated(int movid)
	{
		return repository.findRelated(movid);
	}
	
	
	public Connected save(Connected a)
	{
		return repository.save(a);
		
	}
}