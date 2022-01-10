package testProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class bankingSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ArrayList<String> arr= new ArrayList<String>();
		
	}
	
	public int sol (int [] A, String[] D) {
		
		int fin=0;
		ArrayList<String> m=new ArrayList<String>();
		
		int sum=0;
		
		for(int i=0;i<D.length;i++) {
			m.add(D[i].substring(5, 7));
			sum=sum+A[i];
		}
		
		int count=0;
		int sum2=0;
		int fee=0;
		
		for(int i=0;i<m.size()-2;i++) {
			sum2=A[i];
			
			for(int j=i+1;j<m.size();j++) {
				if(m.get(i)==m.get(j)) {
					count++;
					sum2=sum2+A[j];
				}
			}
			if(count>=3 && sum2<=-100) {
				fee++;
			}
		}
		fin=sum-(5*(12-fee));
		return fin;
	}

}
