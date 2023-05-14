package com.example.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class VotingController {
	
	@Autowired
	VotingRepo repo;
	
	
	
	@GetMapping("/show")
	@CrossOrigin
	public List<Voting> display()
	{
		return repo.findAll();
	}
	
	@GetMapping("/show/{cid}")
	@CrossOrigin
	public Voting show(@PathVariable("cid") int cid)
	{
		return repo.findByCid(cid);
	}
	
	@PostMapping("/posts")
	@CrossOrigin
	public Voting post(@RequestBody Voting vot)
	{
		return repo.save(vot);
	}
	
	@DeleteMapping("/delete/{cid}")
	@CrossOrigin
	public String dele(@PathVariable("cid") int cid)
	{
		
		repo.deleteByCid(cid);
		
		return "deleted succesfuly";
		
	}
	@PutMapping("/upd/{cid}")
	public String update(@PathVariable("cid") int cid)
	{
		Voting demo=repo.findAndUpdate(cid);
		dele(cid);
		repo.save(demo);
		return "updated";
		
	}
}
