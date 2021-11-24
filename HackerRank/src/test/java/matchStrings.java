import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class matchStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		Scanner sc = new Scanner(System.in);
		List <String> strings=new ArrayList<String>();
		List<String> queries =new ArrayList<String>();
		List <Integer> results=new ArrayList<>();

		System.out.println("Enter Strings count:");
		n=sc.nextInt();
		for(int i=0;i<n+1;i++) {
			strings.add(sc.nextLine());
		}

		System.out.println("Enter quereis count:");
		int bn=sc.nextInt();
		for(int i=0;i<bn+1;i++) {
			queries.add(sc.nextLine());
		}

		results.addAll(matchingStrings(strings,queries));

		for(int i=0;i<results.size();i++) {
			System.out.println(results.get(i));
		}
		sc.close();
	}

	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

		List<Integer> counter =new ArrayList<Integer>();

		for(int i=0;i<queries.size();i++) {
			int count=0;

			System.out.println("Compairing query no:- "+i+" :- "+queries.get(i));
			count=Collections.frequency(strings, queries.get(i));

			counter.add(count);
		}
		return counter;
	}
	
	////ong menthod without usig frequency function of collections

	public static List<Integer> matchingStringslong(List<String> strings, List<String> queries) {

		List<Integer> counter =new ArrayList<Integer>();

		for(int i=0;i<queries.size();i++) {
			int count=0;

			System.out.println("Compairing query no:- "+i+" :- "+queries.get(i));

			if(strings.contains(queries.get(i))) {


				for(int j=0;j<strings.size();j++) {

					System.out.println("from String :- "+strings.get(j));

					if(queries.get(i).equals(strings.get(j))) {
						count++;
						System.out.println(i +"count increased to :- "+count);
					}
				}
			}
			counter.add(count);
		}
		return counter;
	}

}
