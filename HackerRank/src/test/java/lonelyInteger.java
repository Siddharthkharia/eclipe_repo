import java.util.Collections;
import java.util.List;

public class lonelyInteger {
	// Function to return the integer that occurs only once in a List of integer array

	public static int lonelyinteger(List<Integer> a) {
	    // Write your code here
		
		for(int i=0;i<a.size();i++) {
		int count=Collections.frequency(a, a.get(i));
		System.out.println(count);
			
		if (Collections.frequency(a, a.get(i))==1) {
			return a.get(i);
		}
		}
		return 0;

	    }
	
}
