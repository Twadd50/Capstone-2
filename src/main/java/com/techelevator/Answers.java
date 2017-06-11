package com.techelevator;

public class Answers {
	
	private Long    answerId;
	private Long    questionId;
	private String  answerText;
	private boolean isCorrect;
	
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {  
		this.answerId = answerId;
	}
	public Long getQuestionId() {
		return questionId;
	}		// should be Long??
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	} 
	 // check
	public void setAllAnswers(String allAnswers) {
		this.answerText = allAnswers;
	}
}
