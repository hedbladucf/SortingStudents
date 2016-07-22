/* 
 * Name: Oscar Hedblad
 * NID: os153937
 * COP 4331 - Homework #2
 * 
 * DESCRIPTION: Program that takes in input of students, classes, etc. then stores
 * them. It then gives the user the option of sorting them according to a specific criteria, 
 * selected by the user. 
 * 
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;

public class HW2 {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		/* SCANNER */
		Scanner inputFile = new Scanner(new File("inputFile.txt"));
		
		/* CREATE ARRAYLIST AND READ IN FILE */
		ArrayList<String> file = new ArrayList<String>();
		while (inputFile.hasNext()){
			file.add(inputFile.nextLine());
		}
		
		/* GET NUMBER OF LINES OF INPUT FILE */
		int lineSize = file.size();

		/* KEEP TRACK OF LINE NUMBER */
		int i = 2;
		
		/* KEEP TRACK OF WHICH COURSE */
		int j = 0;
		
		/* CREATE STRINGS TO HOLD DATE, ETC. */
		String dateTemp;
		int day;
		int month;
		int year;
		int charDate = 0;
		int numericDate;
		
		/* CREATE ARRAYLIST FOR NUMBER OF COURSES */
		ArrayList<course> courses = new ArrayList<course>();
		
		while (i < lineSize){
			
			if (file.get(i-1).trim().length() == 0 && file.get(i+1).trim().length() == 0){
				
				/* ADD TO LIST OF COURSES */
				course currentCourse = new course(file.get(i));
				courses.add(currentCourse);
				i +=2;
				j++;
				
			}
			
			else {
				
				/* GET DAY, MONTH, ETC. */
				dateTemp = file.get(i+1);
				if (dateTemp.charAt(charDate+2) == '/'){
					month = Integer.parseInt(dateTemp.substring(charDate, charDate+2));
					charDate += 3;
				}
				else {
					month = Integer.parseInt(dateTemp.substring(charDate, charDate+1));
					charDate += 2;
				}
				if (dateTemp.charAt(charDate+2) == '/'){
					day = Integer.parseInt(dateTemp.substring(charDate, charDate+2));
					charDate += 3;
				}
				else {
					day = Integer.parseInt(dateTemp.substring(charDate, charDate+1));
					charDate += 2;
				}
				year = Integer.parseInt(dateTemp.substring(charDate, charDate+4));
				
				
				/* SET INT VALUE FOR THE DATE */
				numericDate = (int)(new Date(year,month,day).getTime()/1000);
				
				charDate = 0;
				
				/* STORES STUDENT IN THE CORRECT COURSE */ 
				student currStudent = new student(file.get(i), file.get(i+1), numericDate, Integer.parseInt(file.get(i+2)),
						Integer.parseInt(file.get(i+3)));
				courses.get(j-1).students.add(currStudent);
				i +=5;
			}
		}
		
		/* FOR THE CURRENT OPTION */
		int option = 2;
		int optionSort = 0;
		String any;
		
		/* SCANNER FOR USER INPUT */
		Scanner sc = new Scanner(System.in);
		
		/* KEEP GOING UNTIL USER EXITS */
		while (option == 2)
		{
			/* PRINT */
			System.out.println("Choose a course (1, 2, 3, and so on).\n");
			i = 1;
			for (course a : courses) {
				System.out.println(i + ". " + a.name);
				i++;
			}
			int courseNumber = sc.nextInt();
			System.out.println("\n");
			option = 1;
			while (option == 1) {
				
				/* PRINT OUT STUDENT AND ITS APPROPRIATE INFORMATION */
				System.out.println(courses.get(courseNumber - 1).name
						+ "\n\nStudents:");
				System.out.printf("%-25s%-25s%-25s%-25s\n", "Name",
						"Registration Date", "Time Spent (minutes)",
						"Videos Watched");
				for (student a : courses.get(courseNumber - 1).students) {
					System.out.printf("%-25s", a.firstName);
					System.out.printf("%-25s", a.registerDate);
					System.out.printf("%-25d", a.timeSpent);
					System.out.printf("%-25d\n", a.videosWatched);
				}
				
				System.out.println("\nPress any key followed by 'Enter' to continue");
				any = sc.next();
				System.out.println("\nPlease select a sorting criteria.\n\n1. Registration Date (Last-First)" +
						"\n2. Registration Date (First-Last)\n3. Time Spent (Most-Least)\n4. Time Spent" +
						" (Least-Most)\n5. Videos Watched (Most-Least)\n6. Videos Watched (Least-Most)");
				optionSort = sc.nextInt();
				
				/* FIND BEST WAY TO SORT, THEN SORT */
				if (optionSort == 1)
					Collections.sort(courses.get(courseNumber-1).students, new dateComparator1());
				else if (optionSort == 2)
					Collections.sort(courses.get(courseNumber-1).students, new dateComparator2());
				else if (optionSort == 3)
					Collections.sort(courses.get(courseNumber-1).students, new timeComparator1());
				else if (optionSort == 4)
					Collections.sort(courses.get(courseNumber-1).students, new timeComparator2());
				else if (optionSort == 5)
					Collections.sort(courses.get(courseNumber-1).students, new videosComparator1());
				else if (optionSort == 6)
					Collections.sort(courses.get(courseNumber-1).students, new videosComparator2());
				
				System.out.printf("%-25s%-25s%-25s%-25s\n", "Name",
						"Registration Date", "Time Spent (minutes)",
						"Videos Watched");
				for (student a : courses.get(courseNumber - 1).students) {
					System.out.printf("%-25s", a.firstName);
					System.out.printf("%-25s", a.registerDate);
					System.out.printf("%-25d", a.timeSpent);
					System.out.printf("%-25d\n", a.videosWatched);
				}
				
				System.out.println("\nPress any key and 'Enter' in order to continue");
				any = sc.next();
				System.out.println("\nPlease choose an option.\n\n1. Go back to current course.\n" +
						"2. Pick another course.\n3. EXIT");
				option = sc.nextInt();
				System.out.println("\n\n");
			}
		}
		System.out.print("Terminated.");
	}

}
