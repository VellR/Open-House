package com.platform.readwrite;

import java.io.*;
import java.util.Scanner;

public class ReadWriteExcer {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		String[] questions = new String[5];
		String[][] choices = new String[5][4];
		
		Scanner scanner = new Scanner(System.in);
		String answer = "";
		
		try {
			br = new BufferedReader(new FileReader("questions.txt"));
			pw = new PrintWriter(new FileWriter("answers.txt"));
		
			String currentLine;
			int line = 0;
			int qLine = 0;
			int cLine = 0;
			
			while((currentLine = br.readLine()) != null) {
				if(cLine == 4) {
					cLine = 0;
					qLine++;
				}
				if(line % 5 == 0 & line <= 20) {
					questions[qLine] = currentLine;
				}else {
					choices[qLine][cLine++] = currentLine;
				}
					
				line++;
			}
			
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			if(br != null)
				br.close();
		}
		
		for(int i = 0; i < questions.length; i++) {
			System.out.println(questions[i]);
			for(int j = 0; j < choices[i].length; j++) {
				System.out.println(choices[i][j]);
			}
			System.out.println("Answer: ");
			answer = scanner.nextLine();
			pw.println(questions[i] + " (" + answer + ")");
		}
		scanner.close();
		if(pw != null)
			pw.close();
		
	}
}
