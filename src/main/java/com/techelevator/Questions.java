package com.techelevator;

public class Questions {

	private Long id;
	private String questionText;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;  
	}
	public static String getAllQuestions() {
		return getAllQuestions();  
	}
	/////is this right? --(question_text)? setter??
	public void setQuestionText(String question_Text) {
		this.questionText = question_Text;
	}
	
}
