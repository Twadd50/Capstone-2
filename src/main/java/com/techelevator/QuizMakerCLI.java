package com.techelevator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.projects.model.Employee;


public class QuizMakerCLI {
	
	private static final String   MAIN_MENU_OPTION_BEGIN_QUIZ  = "Begin Quiz";
	private static final String   MAIN_MENU_OPTION_VIEW_SCORES = "View Top Scores";
	private static final String   MAIN_MENU_OPTION_EXIT_QUIZ   = "Exit";		//Associated options shown on menu screen
	
	private static final String[] MAIN_MENU_OPTIONS            = new String[] {MAIN_MENU_OPTION_BEGIN_QUIZ,
																			   MAIN_MENU_OPTION_VIEW_SCORES,				
																			   MAIN_MENU_OPTION_EXIT_QUIZ};
//--------------------------------------------------------------------------------------------------------------------------------------
//		In quiz menu options ?????
//--------------------------------------------------------------------------------------------------------------------------------------
//	private static final String   IN_QUIZ_RESTART_OPTION       = "Restart Quiz";
//	private static final String   IN_QUIZ_RETURN_TO_MAIN_MENU  = "Return to Main Menu";  
//	
//	private static final String[] IN_QUIZ_MENU_OPTIONS         =  new String[]   {IN_QUIZ_RESTART_OPTION,
//			  																	  IN_QUIZ_RETURN_TO_MAIN_MENU};
//private static final String MENU_OPTION_RETURN_TO_MAIN   = "Return to main menu";																			
//--------------------------------------------------------------------------------------------------------------------------------------
//		View top scores menu options
//--------------------------------------------------------------------------------------------------------------------------------------	
	private static final String   SCORES_BACK_TO_MENU_OPTION   = "Return To Menu";
	private static final String   CLOSE_OUT_OF_SCORE_OPTION    = "Exit Program";
	
	private static final String[] IN_QUIZ_MENU_OPTION          =  new String[]   {SCORES_BACK_TO_MENU_OPTION,
																				  CLOSE_OUT_OF_SCORE_OPTION};
	
	private Menu menu;
	private QuestionsDAO  questionsDAO;
	private AnswersDAO    answersDAO;
	private ResultsDAO    resultsDAO;
	
//-----------------------------------------------------------------------------------------------
//		Runs application     data source error????
//-----------------------------------------------------------------------------------------------
	public static void main(String[] args) {
	}
	
	
		
//-----------------------------------------------------------------------------------------------
//		SQL Database connections made through DAO files	 
//-----------------------------------------------------------------------------------------------
	
	public QuizMakerCLI() {

	BasicDataSource dataSource = new BasicDataSource(); 
	dataSource.setUrl      ("jdbc:postgresql://localhost:5432/quizmaker");
	dataSource.setUsername ("postgres");
	dataSource.setPassword ("postgres1");
	
	QuizMakerCLI application = new QuizMakerCLI();
	application.run();
		
	questionsDAO = new JDBCQuestionsDAO (dataSource);
	answersDAO   = new JDBCAnswersDAO   (dataSource);
	resultsDAO   = new JDBCResultsDAO   (dataSource);
	}
//-----------------------------------------------------------------------------------------------
//		Main Menu -- options are "Begin Quiz" "View Top Scores" and "Exit"
//-----------------------------------------------------------------------------------------------
	
	private void run() {
		while(true) {
			printHeading("Main Menu");
		String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
		if(choice.equals(MAIN_MENU_OPTION_BEGIN_QUIZ)) {
			handleBeginQuiz();
		} else if(choice.equals(MAIN_MENU_OPTION_VIEW_SCORES)) {
			handleViewTopScores();
		} else if(choice.equals(MAIN_MENU_OPTION_EXIT_QUIZ)); {
			System.exit(1);
		}
		}
	}
//-----------------------------------------------------------------------------------------------
//	
//-----------------------------------------------------------------------------------------------
	
//-----------------------------------------------------------------------------------------------
//	Begin quiz code --  Handle name input from user  \n = insert new line
//-----------------------------------------------------------------------------------------------
	private void handleBeginQuiz() {	
		printHeading("Welcome to to the quiz");
	
	
		String askName = getUserInput("What is your name?");
		List<Results> nameAdd = resultsDAO.addNewUserName(askName);
		System.out.println("\n  Nice to meet you " +nameAdd.getName()+ "!. Good luck on the quiz! ");
	}
	

	
	
	
	
	
					
					int totalQuestions = 0;
					int numberOfCorrectAnswers = 0;
					List<Answers>   allAnswers   = answersDAO.getAllAnswers();
					List<Questions> allQuestions = questionsDAO.getAllQuestions(); {
							if ((allQuestions.size() > 0 && allQuestions.size()< 6)) {
					/			while(true) {
								for(Questions questionsLoop : allQuestions) {
									System.out.println(questionsLoop.getQuestionText());
								}
								
								System.out.println();
								
								
							} else {
								System.out.println("\n*** No results ***");
							}
						}

						
						
						
						
						
						
						
				
				
				
					
						System.out.println("\n" + Questions.getAllQuestions());
						for (int i = 0; i < Questions.getAnswers().length; i++) {
							System.out.println((i + 1) + ") " + Questions.getAnswers()[i]);
						}
						
						
						List<Answers>   allAnswers   = answersDAO.getAllAnswers();
						List<Questions> allQuestions = questionsDAO.getAllQuestions();
						System.out.println("\nYour answer?");
						String userAnswer = userInput.nextLine();
						if ((userAnswer.isEmpty() == false) && (userAnswer.matches("[1-4]")) ) {
							if (userAnswer ) {
								System.out.println("Correct!");
								numberOfCorrectAnswers += 1;
							}
							else {
								System.out.println("Sorry that isn't correct!");
							}
							break;
						}
						System.out.println("Invalid answer!");
					}
					totalQuestions += 1;
				}
				System.out.println("You got " + numberOfCorrectAnswers + " answers correct out of the total " + totalQuestions + " questions asked.");
			
			
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//-----------------------------------------------------------------------------------------------
//	
//-----------------------------------------------------------------------------------------------
//		
		
//		public String getQuestion() {
//			return this.getQuestion();
//		}	
//			public boolean isCorrectAnswer(String selectedAnswer) {
//				return this.correctAnswer.equals(selectedAnswer);
//			
//			}
//-----------------------------------------------------------------------------------------------
//	View top scores section
//-----------------------------------------------------------------------------------------------
	private void handleViewTopScores() {	
		printHeading("**** Top Quiz Scores ****");
		List<Results> allResults = ResultsDAO.getAllResults();
		listEmployees(allResults);
		//display scores 
		
		if(getViewTopScores.size() > 0) {
			for(Employee emp : employees) {
				System.out.println(emp.getLastName() + ", " + emp.getFirstName());
			}
		
		

}
//-----------------------------------------------------------------------------------------------
//	
//-----------------------------------------------------------------------------------------------
		
	private String getUserInput(String prompt) {	
		System.out.print(prompt + " >>> ");
		return new Scanner(System.in).nextLine();
	}
	
	
	private void printHeading(String string) {
	}
}
