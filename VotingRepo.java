package com.example.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

//import com.example.demo.Emp;




public interface VotingRepo extends MongoRepository<Voting,Integer>{

	public Voting findByCid(int cid);

	public void deleteByCid(int cid);

	@Query
	public default Voting findAndUpdate(int cid)
	{
		Voting e=findByCid(cid);
		int votes=e.getVote();
		int newid=e.getCid();
		String namenew=e.getName();
		votes=votes+1;
		e.setCid(newid);
		e.setVote(votes);
		e.setName(namenew);
		
		return e;
	};

}
