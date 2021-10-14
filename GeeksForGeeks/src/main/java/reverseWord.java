import java.util.ArrayList;
import java.util.Stack;

public class reverseWord {

	public static void main(String[] args) {
		
		String s="My Name is Siddharth ";
		
		
		String[] arr=s.split(" ");
		
		int j=0;
		while(j<arr.length) {
			System.out.println(arr[j]);
			j++;
		}
		
		Stack<Character> st = new Stack<Character>();
		
		for (int i=0;i<s.length();i++) {
			if(s.charAt(i)!=' ') {
				st.push(s.charAt(i));				
			}
			else {
				while(!(st.isEmpty())) {
					System.out.print(st.pop());
			}
				System.out.print(s.charAt(i));
			}
		}
		while(st.empty()==false) {
			System.out.print(st.pop());
		}
		
	}
}
