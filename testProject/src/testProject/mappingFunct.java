package testProject;

import java.util.*;

public class mappingFunct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		String input = sc.nextLine();
		
		Map<String, Integer> dict= new HashMap<String, Integer>();
		
		String[] wordsArray = input.split(" ");
		
		for(String word : wordsArray) {
			if(dict.containsKey(word)){
				Integer val = dict.get(word);
				dict.put(word, val+1);
			}
			else {
				dict.put(word, 1);
			}
		}
		for(String word: wordsArray)
			System.out.print(word);
		for (String key:dict.keySet())
			System.out.println(key +" "+ dict.get(key));
		sc.close();

	}

}
