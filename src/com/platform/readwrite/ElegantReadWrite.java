package com.platform.readwrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ElegantReadWrite {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = null; //This will be used to read our .txt file
		PrintWriter printWriter = null; // This will be used to write to our .txt file
		
		String[] questions = new String[5]; // This array will store all the questions we have
		String[][] choices = new String[5][4]; // This 2D array will store all the answers to the questions we have
		
		Scanner scanner = new Scanner(System.in); // Scanner will be used to collect input from the user
		
		/*bufferedReader and PrintWriter will both throw exceptions if they cannot find the file
		 *so we have to write a try/catch block. the finally block will always be executed after 
		 *try/catch have completed their executions
		 *  */
		try {
			bufferedReader = new BufferedReader(new FileReader("questions.txt")); // We use the FileReader class to open "questions.txt" and the pass that to our bufferedReader
			printWriter = new PrintWriter(new FileWriter("answers.txt")); //We use the FileWriter class to open "answers.txt" and then pass that to our PrintWriter
			
			for(int qLine = 0; qLine < questions.length; qLine++) {//int qLine will serve to track which question we're on
				questions[qLine] = bufferedReader.readLine();/*bufferedReader is taking each line from questions.txt(line 25) and passing
				it into our String[] questions array based on the index we set for qLine(line 28)
				*/
				
				for(int cLine = 0; cLine < choices[qLine].length; cLine++) //int cLine will serve to track the choices for each question
					choices[qLine][cLine] = bufferedReader.readLine();// We do the same thing we did for questions to choices.
				/*Note that the choices for loop is nested within the questions for loop so that we're able to use the position of the question
				 * in the array to match it to our choices, which is a 2D array/nested array
				 * */
			}
			
		}catch(IOException e) {//If the questions.txt is not found by the FileReader then it will throw an exception here
			System.out.println("File Not Found!");
		}finally {
			if(bufferedReader != null)// If we try to close bufferedReader when we haven't opened it, which we do on line 25, then we will throw an exception
				bufferedReader.close();
		}
		
		//We use the same pattern we did for collecting the questions and choices and storing them to the arrays on lines 28-34, bellow
		//The difference is instead of storing the strings, we are outputting them to the console 
		for(int qLine = 0; qLine < questions.length; qLine++) {
			System.out.println("\n" + questions[qLine]); // We print out a question
			
			for(int cLine = 0; cLine < choices[qLine].length; cLine++) {
				System.out.println(choices[qLine][cLine]);// We print out each corresponding answer choice for each question
			}
			
			System.out.print("\nAnswer: ");
			printWriter.println(questions[qLine] + " (" + scanner.nextLine() + ")"); // Before we print a new question, we ask the user to input an answer
		}
		//lastly we tell the user that the program is complete and close our remaining resources(scanner and printWriter)
		System.out.println("\nQuestionare complete. GOODBYE");
		scanner.close();
		if(printWriter != null)//see line 43 to understand why we did this
			printWriter.close();
	
		new Grader().main(args); // this line will open a new Grader class and call it's main method which is not covered in the scope
		//of this project.
	}
}
