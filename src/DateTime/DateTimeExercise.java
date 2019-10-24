package DateTime;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeExercise {
	public static void main(String[] args) {
		System.out.println("Howdy y'all. Please enter your date of birth to continue");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Month(MM):");
		int month = scan.nextInt();
		
		System.out.println("date(dd):");
		int date = scan.nextInt();
		
		System.out.println("Year(YYYY):");
		int year = scan.nextInt();
		scan.close();
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		
		
		LocalDate birthday = LocalDate.of(year, month, date);
		String s = dtf.format(birthday);
		
		System.out.println("Birthday: " + s);
		long t = ChronoUnit.YEARS.between(birthday, currentDateTime);
		System.out.println("Age: " + t + " years old");
		
		
				
	}
}