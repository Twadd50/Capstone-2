package com.techelevator;

import java.util.List;

public interface AnswersDAO {

	public List<Answers> getAllAnswers(Questions question);			//answer connectioned to question object
	public List<Answers> getAnswerId(Questions question);
//	
}
