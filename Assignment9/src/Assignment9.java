// Assignment #: 9
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: T TH 1:30

import java.io.*;

public class Assignment9 {
	
	
	public static void main(String[] args) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		int size = 0;
		int startIndex = 0;
		int[] arr = new int[100];
		
		String number;
		try {
			while ((number = reader.readLine()) != null) {
				//number = reader.readLine();
				arr[size] = Integer.parseInt(number);
				if (arr[size] == 0) {
					break;
				}
				size++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			input.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int endIndex = size;
		int[] elements = new int[endIndex + 1];
		System.arraycopy(arr, 0, elements, 0, endIndex +1);
		
		System.out.println("\nThe minimum number is: "+ findMin(elements, startIndex, endIndex)
			+"\nThe smallest even integer in the sequence is: "+ computeSmallestEven(elements, startIndex, endIndex)
			+"\nThe count of negative integers in the sequence is: "+ countNegativeNumbers(elements, startIndex, endIndex)
			+"\nThe sum of numbers that are divisible by 3 is: "+ computeSumOfNumbersDivisibleBy3(elements, startIndex, endIndex));
		
	}
	public static int findMin(int[] elements, int startIndex, int endIndex) { 
		if (startIndex == endIndex) {
			 return elements[startIndex];
		}
		
		int num = findMin(elements, startIndex + 1, endIndex);
		
		if (elements[startIndex] < num) {
			return elements[startIndex];
		} else {
			return num;
		}
		 
	}
	public static int computeSmallestEven(int[] elements, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			if (elements[startIndex] % 2 == 0) {
				return elements[startIndex];
			} else {
				return 0;
			}
		}   
		int num = computeSmallestEven(elements, startIndex + 1, endIndex);
		if (elements[startIndex] % 2 == 0 && num % 2 == 0) {
			if (elements[startIndex] < num) {
				return elements[startIndex];				
			} else {
				return num;
			}
		} else if (elements[startIndex] % 2 == 0 && num % 2 !=0){
			return elements[startIndex];
		} else if (elements[startIndex] % 2 != 0 && num % 2 ==0) {
			return num;
		} else {
			return 0;
		}	
	}
		
	
	public static int countNegativeNumbers(int[] elements, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			 if (elements[startIndex] < 0) {
				 return 1;
			 } else {
				 return 0;
			 }
		 } else {
			 if (elements[startIndex] < 0) {
				 return 1 + countNegativeNumbers(elements, startIndex + 1, endIndex);
			 } else {
				 return 0 + countNegativeNumbers(elements, startIndex + 1, endIndex);
			 }
		 }
		 
	}
	public static int computeSumOfNumbersDivisibleBy3(int[] elements, int startIndex, int endIndex) {
		 if (startIndex == endIndex) {
				 return 0; 
		 } else {
			 if (elements[startIndex] % 3 == 0) {
				 return elements[startIndex] + computeSumOfNumbersDivisibleBy3(elements, startIndex + 1, endIndex);
			 } else {
				 return 0 + computeSumOfNumbersDivisibleBy3(elements, startIndex + 1, endIndex);
			 }
		 }
	}
	
}
