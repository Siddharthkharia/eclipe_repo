//Problem Statement
/*         "https://practice.geeksforgeeks.org/problems/arraylist-operation/1"
 * 
 * 
 Given an ArrayList of N lowercase characters. The task is to count frequency of elements in the list.

Note: use add() to append element in the list and contains() to check an element is present or not in the list and collections.frequency() to find the frequency of the element in the list.

Input Format:
First line of testcase contains T, number of testcases. For each testcase, first line contains number of queries Q. Each query may be any one of the two type:
1. "i" with "c" : insert the element "c" into the ArrayList
2. "f" with "c": find the frequency of "c" in the ArrayList.

Output Format:
For each testcase, output the frequency of elements. Print "Not Present" if element is not present in the list else its frequency in new line for every query.

Your Task:
Your task is to complete the functions insert() and freq() which are used to insert and find frequency of element respectively.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= Q <= 102

Example:
Input:
2
6
i g i e i e i k i s f e
4
i c i p i p f f

Output:
2
Not Present

Explanation:
Testcase 1: Inserting g, e, e, k, s into the list. Frequency of e is 2 in the list.
Testcase 2: Inserting c, p, p into the list. Frequency of f is 0 in the list.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class arrayOperationOp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number of test cases in the current run : ");
		int t= sc.nextInt();
		
		for(int i=0;i<t;i++) {
			System.out.println("Enter number of queries for the test case number: " );
			int q=sc.nextInt();
			
			//Declaring the ArrayList
			ArrayList<Character> li=new ArrayList<Character>();
			System.out.println("Enter queries for the test case i/f followed by a space than required character : ");
			
			//Loops for Queries
			for (int j=0;j<q;j++) {
				
				char c=sc.next().charAt(0);
				
				if(Character.toString(c).equalsIgnoreCase("c")) {
					
				}
				
				if(Character.toString(c).equalsIgnoreCase("i")) {
					c=sc.next().charAt(0);
					insert(li,c);	
				}
				else if(Character.toString(c).equalsIgnoreCase("f")) {
					c=sc.next().charAt(0);
					freq(li,c);
				}
				else {
					System.out.println("Invalid character, please enter i(inser) or f (frequency) followed by the character");
				}
			}
		}
		sc.close();
	}
	public static void insert(ArrayList<Character> li2, char c) {
		li2.add(c);
	}

	public static void freq(ArrayList<Character> li2, char c) {
		int count=0;

		if(li2.contains(c)) {
			count=Collections.frequency(li2, c);
			System.out.print(count);
		}
		else {
			System.out.println("Not Present");
		}
	}

}
