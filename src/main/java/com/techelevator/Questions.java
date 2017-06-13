package com.techelevator;
//POJO reference
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
	}		////////check/////////
	public static String getAllQuestions() {
		return getAllQuestions();  
	}
	/////is this right? --(question_text)? setter??
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public static Object getAnswers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
