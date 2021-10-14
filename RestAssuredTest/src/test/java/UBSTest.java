
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class UBSTest {

		// TODO Auto-generated method stub
		

		    /*
		     * Complete the 'splitIntoTwo' function below.
		     *
		     * The function is expected to return an INTEGER.
		     * The function accepts INTEGER_ARRAY arr as parameter.
		     */

		    public static int sum(List<Integer> l){
		        int fin=0;
		        for(int i=0;i<l.size();i++){
		            fin=fin+l.get(i);
		        }
		        return fin;
		    }
		    
		    public static int splitIntoTwo(List<Integer> arr) {
		    // Write your code her
		    int n=arr.size();

		    int suml=0;
		    int sumr=0;
		    int count=0;

		    sumr=sum(arr);
		    
		    for(int i =0;i<n-1;i++){
		        
		        suml=suml+arr.get(i);
		        sumr=sumr-arr.get(i);
		        
		        // System.out.println("loop "+i+"Suml :"+suml);
		        // System.out.println("loop "+i+"Sumr :"+sumr);
		        
		        if(suml>sumr)
		            count++;
		        }
		        // System.out.println(count);
		       return count; 
		    }

		    public static void main(String args[]) {
		    	
		    }
		}
		
