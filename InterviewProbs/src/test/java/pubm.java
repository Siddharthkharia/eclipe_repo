import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class pubm {

	public static  ArrayList<Integer> repeator(ArrayList<Integer> s) {
		int len=s.size();
		ArrayList<Integer> fin= new ArrayList<Integer>();
		
		for(int i=0;i<len-1;i++) {
			
			if(s.get(i)!=s.get(i+1)) {
				fin.add(s.get(i));
			}
			else
				i++;
		}
		return fin;		
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> s= new ArrayList<Integer>();
			Arrays.asList(1,1,1,1,2,3,4,5,5,5,5,5,5);
			
			s.sort(null);
			Collections.sort(s);
			
		//s= {1,1,1,1,2,3,4,5,5,5,5,5,5};
		
		System.out.println(repeator(s));
		
		// TODO Auto-generated method stub

	}

}
