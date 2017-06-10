package com.techelevator;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class QuizMakerCLI {
	
	private static final String   MAIN_MENU_OPTION_BEGIN_QUIZ  = "Begin Quiz";
	private static final String   MAIN_MENU_OPTION_VIEW_SCORES = "View Top Scores";
	private static final String   MAIN_MENU_OPTION_EXIT_QUIZ   = "Exit";		//Associated options shown on menu screen
	
	private static final String[] MAIN_MENU_OPTIONS            = new String[] {MAIN_MENU_OPTION_BEGIN_QUIZ,
																			   MAIN_MENU_OPTION_VIEW_SCORES,				
																			   MAIN_MENU_OPTION_EXIT_QUIZ};
//--------------------------------------------------------------------------------------------------------------------------------------
//		In quiz menu options - are they even needed?? -- add restart if you have time
//--------------------------------------------------------------------------------------------------------------------------------------
	private static final String   IN_QUIZ_RESTART_OPTION       = "Restart Quiz";
	private static final String   IN_QUIZ_RETURN_TO_MAIN_MENU  = "Return to Main Menu";  
	
	private static final String[] IN_QUIZ_MENU_OPTIONS         =  new String[]   {IN_QUIZ_RESTART_OPTION,
			  																	  IN_QUIZ_RETURN_TO_MAIN_MENU};
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
	
//-----------------------------------------------------------------------------------------------
//		Runs application     data source error????
//-----------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		
		QuizMakerCLI application   = new QuizMakerCLI(dataSource);
		application.run();
	}
	
	public QuizMakerCLI() {
		
//-----------------------------------------------------------------------------------------------
//		SQL Database connections made through DAO files	 
//-----------------------------------------------------------------------------------------------
	
	
	BasicDataSource dataSource = new BasicDataSource(); 
	dataSource.setUrl     ("jdbc:postgresql://localhost:5432/quizmaker");
	dataSource.setUsername("postgres");
	dataSource.setPassword("postgres1");
		
	questionsDAO = new JDBCQuestionsDAO(dataSource);
	answersDAO = new JDBCAnswersDAO(dataSource);
	}
		
	//	this.menu = new Menu();
	
		
	
//		answersDAO   = new JDBCAnswersDAO  (dataSource);

//-----------------------------------------------------------------------------------------------
//		Main Menu -- options are "Begin Quiz" "View Top Scores" and "Exit"
//-----------------------------------------------------------------------------------------------
	private void run() {
		while(true) {
			printHeading("Main Menu");
		String choice = (String)menu.get(MAIN_MENU_OPTIONS); // WHY IS THIS NOT WORKING!?!?!
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
//		Allows for print heading
//-----------------------------------------------------------------------------------------------
	private void printHeading(String string) {
	
	}
//-----------------------------------------------------------------------------------------------
//	Begin quiz code --loop through questions add to array????????????????/ejfbejfnew
//-----------------------------------------------------------------------------------------------
	private void handleBeginQuiz() {	
		printHeading("Welcome to the quiz. Good Luck!");
		
		// Deliver the quiz by displaying the questions along with their possible answers one question at a time. Keep track
		// of the number of questions asked, and the number of correct answers. 
		List<Questions> allQuestions = new ArrayList<Questions>();
		int numberOfQuestions = 0;
		int numberOfCorrectAnswers = 0;
		
		
		for(Questions  question : allQuestions) {
			List<Questions> getAllQuestions;
		
			while(true) {
			System.out.println("\n" + Questions.getAllQuestions());
		
			for (int i = 0; i < getAllQuestions.getAnswers().length; i++) {
			System.out.println((i + 1) + ") " + getAllQuestions.getAnswers()[i]);
			}
			
		System.out.println("\nYour answer?");
			Scanner userInput;
			String userAnswer = userInput.nextLine();
				if ((userAnswer.isEmpty() == false) && (userAnswer.matches("[1-4]")) ) {
					if (allQuestions.isCorrectAnswer(userAnswer)) {
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
		}
				System.out.println("You got " + numberOfCorrectAnswers + " answers correct out of the total " + numberOfQuestions + " questions asked.");
	}
//-----------------------------------------------------------------------------------------------
//	
//-----------------------------------------------------------------------------------------------
//		
		
		public String getQuestion() {
			return this.getQuestion();
		}	
			public boolean isCorrectAnswer(String selectedAnswer) {
				return this.correctAnswer.equals(selectedAnswer);
			
			}
//-----------------------------------------------------------------------------------------------
//	View top scores section
//-----------------------------------------------------------------------------------------------
	private void handleViewTopScores() {	
		printHeading("Top Quiz Scores");
		
//		else if(choice.equals(MAIN_MENU_OPTION_EXIT_QUIZ)) {
//			System.exit(1);
//		}
}
//-----------------------------------------------------------------------------------------------
//	
//-----------------------------------------------------------------------------------------------
		
	private String getUserInput(String prompt) {	
		System.out.print(prompt + " >>> ");
		return new Scanner(System.in).nextLine();
	}
	
}
