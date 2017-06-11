package com.techelevator;

import java.util.List;

public interface ResultsDAO {

	public List<Results>   getAllResults();
		
	public List<Results>   getOverallScore();
	public List<Results>   addNewUserName(String askName);

	public List<Results>   viewTopScores();

	
	
}
