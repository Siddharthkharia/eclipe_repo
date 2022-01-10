import java.util.ArrayList;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.lang3.math.NumberUtils;

public class Thought {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="23h2sshbg";
		int sum=0;
		
		String[] arr=s.split("[a-zA-Z]");
		
		for(int i=0;i<arr.length;i++) {
			
			if(NumberUtils.isParsable(arr[i])) {
				sum=sum+ NumberUtils.toInt(arr[i]);
				//System.out.println(arr[i]);
			}
		}
		System.out.print(sum);
		
		

	}

}
