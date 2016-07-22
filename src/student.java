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

import java.util.*;

	public class student{
		String firstName;
		String registerDate;
		int posixDate;
		int timeSpent;
		int videosWatched;
		
		public student(String fName, String rDate, int pDate, int tSpent, int vWatched){
			firstName = fName;
			registerDate = rDate;
			posixDate = pDate;
			timeSpent = tSpent;
			videosWatched = vWatched;
		}
	}
	
	/* VIDEOS WATCHED : MOST - LEAST */
	class videosComparator1 implements Comparator<student>  {
			
		public int compare(student a, student b) {
				if (a.videosWatched > b.videosWatched) {
					return -1;
				} else if (a.videosWatched < b.videosWatched) {
					return 1;
				} else
					return 0;
		};
	}
	
	/* VIDEOS WATCHED : LEAST - MOST */ 
	class videosComparator2 implements Comparator<student>  {
		
		public int compare(student a, student b) {
				if (a.videosWatched > b.videosWatched) {
					return 1;
				} else if (a.videosWatched < b.videosWatched) {
					return -1;
				} else
					return 0;
		};
	}
	
	/* TIME SPENT : MOST - LEAST */
	class timeComparator1 implements Comparator<student>  {
			
		public int compare(student a, student b) {
				if (a.timeSpent > b.timeSpent) {
					return -1;
				} else if (a.timeSpent < b.timeSpent) {
					return 1;
				} else
					return 0;
		};
	}
	
	/* TIME SPENT : LEAST - MOST */
	class timeComparator2 implements Comparator<student>  {
			
		public int compare(student a, student b) {
				if (a.timeSpent > b.timeSpent) {
					return 1;
				} else if (a.timeSpent < b.timeSpent) {
					return -1;
				} else
					return 0;
		};
	}
	
	/* DATE : LAST - FIRST */
	class dateComparator1 implements Comparator<student>  {
			
		public int compare(student a, student b) {
				if (a.posixDate > b.posixDate) {
					return -1;
				} else if (a.posixDate < b.posixDate) {
					return 1;
				} else
					return 0;
		};
	}
	
	/* DATE : FIRST - LAST */
	class dateComparator2 implements Comparator<student>  {
			
		public int compare(student a, student b) {
				if (a.posixDate > b.posixDate) {
					return 1;
				} else if (a.posixDate < b.posixDate) {
					return -1;
				} else
					return 0;
		};
	}