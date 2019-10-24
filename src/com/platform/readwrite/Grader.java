package com.platform.readwrite;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grader {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = null; //This will be used to read our .txt file
		PrintWriter printWriter = null; // This will be used to write to our .txt file
		
		String[] answers = new String[5]; //We make an array to hold all the user's answers
		char[] answerKey = {'c','d','d','a','b'}; // This array holds all the actual answers
		
		String answerRegex = "[(][a-d][)]";
		Pattern answerPattern = Pattern.compile(answerRegex);
		
		try {
			bufferedReader = new BufferedReader(new FileReader("answers.txt"));
			
			for(int i = 0; i < answers.length; i++) {
				String answer = bufferedReader.readLine();
				answers[i] = answer;
				
			}
			
		}catch(IOException e) {
		}finally {
			if(bufferedReader != null)
				bufferedReader.close();
		}
		
		int correct = 0 ;
		for(int i = 0; i < answerKey.length; i++) {
			String answer = answers[i];
			Matcher answerMatcher = answerPattern.matcher(answer);
			if(answerMatcher.find()) {
				String userAnswer = answerMatcher.group();
				
				char grading = userAnswer.charAt(1);
				if(grading == answerKey[i])
					correct++;
			}
		}
		String grade = "Grade: " + ((double) correct / 5) * 100;
		
		FileWriter fileWriter = new FileWriter("answers.txt", true);
		printWriter = new PrintWriter(fileWriter);
		printWriter.println("\n"+ grade + "%");
		printWriter.close();
		
		System.out.println(grade + "%");
	}

}
