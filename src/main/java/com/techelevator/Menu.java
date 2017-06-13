package com.techelevator;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	//menu methods should always be public 
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in  = new Scanner(input);
	}

	public Object getChoiceFromOptions2(String message, Object[] options) {  //covers if user puts in wrong choice 
		Object choice = null;
		while(choice == null) {
			out.print(message);
			out.flush();     	 // make sure data from system.out is put out immediately and not buffering
			choice = getChoiceFromUserInput(options);			//exception, different from throws 
			if(choice == null) {
				out.println("\n Invalid selection. Please choose again. \n");
			}
		
		}
		return choice;
	}
	
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
		displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);			//exception, different from throws 
		}
		return choice;
	}

	public Object getChoiceFromUserInput(Object[] options) {					//22
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);					//22
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");			
			out.flush();
		}
		return choice;
	}

	public  void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

//	public Object[] getChoiceFromUserInput(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
	
	
	


































	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

