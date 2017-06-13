package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class QuizMakerCLI {

	private static final String MAIN_MENU_OPTION_BEGIN_QUIZ  = "Begin Quiz";
	private static final String MAIN_MENU_OPTION_VIEW_SCORES = "View Top Scores";
	private static final String MAIN_MENU_OPTION_EXIT_QUIZ   = "Exit"; // Associated// options show  on  menu  screen
																		
																		

	private static final String[] MAIN_MENU_OPTIONS          = new String[] { MAIN_MENU_OPTION_BEGIN_QUIZ,
																	          MAIN_MENU_OPTION_VIEW_SCORES,
																	          MAIN_MENU_OPTION_EXIT_QUIZ };
	// --------------------------------------------------------------------------------------------------------------------------------------
	// In quiz menu options ????
	// --------------------------------------------------------------------------------------------------------------------------------------
	// private static final String IN_QUIZ_RESTART_OPTION = "Restart Quiz";
	// private static final String IN_QUIZ_RETURN_TO_MAIN_MENU = "Return to Main
	// Menu";
	//
	// private static final String[] IN_QUIZ_MENU_OPTIONS  = new String[]
	// {IN_QUIZ_RESTART_OPTION,
	// IN_QUIZ_RETURN_TO_MAIN_MENU};
	private static final String MENU_OPTION_RETURN_TO_MAIN   = "Return to main menu";
	// --------------------------------------------------------------------------------------------------------------------------------------
	// View top scores menu options
	// --------------------------------------------------------------------------------------------------------------------------------------
	private static final String SCORES_BACK_TO_MENU_OPTION   = "Return To Menu";
	private static final String CLOSE_OUT_OF_SCORE_OPTION    = "Exit Program";

	private static final String[] IN_VIEW_SCORE_MENU_OPTION  = new String[] { SCORES_BACK_TO_MENU_OPTION,
			CLOSE_OUT_OF_SCORE_OPTION };

	private Menu menu;
	private QuestionsDAO questionsDAO;
	private AnswersDAO   answersDAO;
	private ResultsDAO   resultsDAO;

	// -----------------------------------------------------------------------------------------------
	// Run application -- data source error????
	// -----------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setUrl("jdbc:postgresql://localhost:5432/quizmaker");
		datasource.setUsername("postgres");
		datasource.setPassword("postgres1");
		
		QuizMakerCLI application = new QuizMakerCLI(datasource);
		application.run();
	}

	// -----------------------------------------------------------------------------------------------
	// Database connections
	// -----------------------------------------------------------------------------------------------
	public QuizMakerCLI(DataSource datasource) {
		
		questionsDAO = new JDBCQuestionsDAO(datasource);
		answersDAO   = new JDBCAnswersDAO(datasource);
		resultsDAO   = new JDBCResultsDAO(datasource);
		this.menu    = new Menu(System.in, System.out);			//pulling info from menu
	}

	// -----------------------------------------------------------------------------------------------
	// Main Menu -- options are "Begin Quiz" "View Top Scores" and "Exit"
	// -----------------------------------------------------------------------------------------------
	private void run() {
		while (true) {
			printHeading("Main Menu");
			Object choice = null;			//knows what the user is entering (uses scanner in menu)
				     choice = (Object) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_BEGIN_QUIZ)) {
				handleBeginQuiz();
			} else if (choice.equals(MAIN_MENU_OPTION_VIEW_SCORES)) {
				handleViewTopScores();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT_QUIZ));
				System.exit(1);
			}
		}
	

	// -----------------------------------------------------------------------------------------------
	// Begin quiz code -- Handle name input from user \n = insert new line
	// -----------------------------------------------------------------------------------------------
	private void handleBeginQuiz() {
		printHeading("Welcome to the quiz");

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		Questions question;		//pulls info from questions.java

		Object storeName        = menu.getChoiceFromUserInput("Please enter your name?"); 	//
		List<Results> nameAdd   = resultsDAO.getAddNewUserName(storeName);
		System.out.println("\n  Nice to meet you " + storeName + "! Good luck on the quiz! ");
	 // print questions? insert answers???

	// int totalQuestions = 0; DB
	// int numberOfCorrectAnswers = 0; DB
	
	List<Answers>   allAnswers   = answersDAO.getAllAnswers(question); 		//1 question can have many answers?
	List<Questions> allQuestions = questionsDAO.getAllQuestions();
	 List<Results>   allResults  = resultsDAO.getAllResults(null); 
	 {
 				
		//if (allAnswers.contains(allQuestions)); {
		while(allAnswers.contains(allQuestions)) {			
//								for (dataType   variable  : array / collection)
			for(Questions questionsLoop : questionsDAO.getAllQuestions()) {
		}							//--check--
				System.out.println("Question 1." + Questions.getAllQuestions());
				
				
							
			} 											  
	
//-----------------------------------------------------------------------------------------------
//			answers?   scanner -- next line()?
//-----------------------------------------------------------------------------------------------	
			System.out.println("\n" + Questions.getAllQuestions());
			for (int i = 0; i < questionsDAO.hashCode(); i++) {
				System.out.println((i + 1) + ") " + questionsDAO.toString());
			}
			int totalQuestions   = 0;
			int correctAnswers   = 0;
			float percentage;

			Scanner userInput = new Scanner(System.in);
			userInput.nextLine();

			System.out.println("\n Input answer here");
			String userAnswer = userInput.nextLine();
			if ((userAnswer.isEmpty() == false) && (userAnswer.matches("[1-4]"))) {

				if (userAnswer.equals(answersDAO.getAnswerId(question))) {   			//		user answer equals isCOrrect??
					System.out.println("Correct!");
					correctAnswers += 1;
				} else {
					System.out.println("Sorry that isn't correct!");
				}
			}
			if ("answer_id" != "id");  /////"????
			System.out.println("Invalid answer!");
		
					// ??(totalQuestions)   (correctAnswers) ??
			percentage += allAnswers * 100 / allQuestions;     //all answers is object .. can't do math on answers object??
	System.out.println("You got "+ correctAnswers +" answers correct out of the total "+totalQuestions+" questions asked.");
	}
	}
	// ---------------------------------------------------------------------------------------------------------------------------------
	// View top scores section
	// ---------------------------------------------------------------------------------------------------------------------------------

	private void handleViewTopScores(List<Results> results) {
			printHeading("**** Top Quiz Scores ****");
			if(results.size()  > 0 && results.size() < 6) {  		   //
				while(true) { 
					for(Results showResults: results) {
						System.out.println();
					
					}	
				}	
			}
	}
	private void printHeading(String heading) {      
		System.out.println("\n" + heading);
		for (int i = 0; i < heading.length(); i++) { 
			System.out.print("-");
		}
		System.out.println();
			
		
	}
}
