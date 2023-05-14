package com.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="voting")
public class Voting {

	private int cid;
	private int vote;
	private String name;
	private String party;
	
	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getVote() {
		return vote;
	}


	public void setVote(int vote) {
		this.vote = vote;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getParty() {
		return party;
	}


	public void setParty(String party) {
		this.party = party;
	}


	@Override
	public String toString() {
		return "Voting [cid=" + cid + ", vote=" + vote + ", name=" + name + ", party=" + party + "]";
	}
	
	
}
