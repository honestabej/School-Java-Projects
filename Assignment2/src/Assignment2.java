// Assignment #: 
// Arizona State University - CSE205
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: 1:30 - 2:45 
//  Description: This class reads integers from a loop until 0 is entered and displays information about the integers entered

import java.util.Scanner; //import scanner class

public class Assignment2 {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		
		//reads the first integer
		int anInt = in.nextInt();
		
		//initialize variables
		int sum = 0;
		int min = anInt;
		int negcount = 0;
		int evenmin = anInt;
		
		//continues to ask for integers until the user inputs 0
		while (anInt != 0) {
			//sets the minimum value of all of the integers that were entered
			if (anInt < min) {
				min = anInt;
			}
			//first checks if the input is even, and if it is it sets the minimum value of even integers only
			if (anInt % 2 == 0) {
				if (anInt < evenmin) {
					evenmin = anInt;
				}
			}
			//first checks if the input was negative, if it is it bumps the count of negative integers by one
			if (anInt < 0) {
				negcount++;
			}
			//first checks if the input was odd, and if it is, adds it to a sum of the total odd integers
			if (anInt % 2 != 0) {
				sum += anInt;
			}
			//asks for another input 
			anInt = in.nextInt();
		}
			
		
		
		//displays the information from the data input
		System.out.println("The minimum integer is "+min);
		System.out.println("The smallest even integer in the sequence is "+evenmin);
		System.out.println("The count of negative integers in the sequence is "+negcount);
		System.out.println("The sum of odd integers is "+sum);
		
		//closes the scanner class
		in.close();
	}

}
