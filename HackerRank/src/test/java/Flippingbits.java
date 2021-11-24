
public class Flippingbits {
	
	public static long flippingBits(long n) {
	    // Write your code here
		
		String s= Integer.toBinaryString((int) n);
		
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				str.append('1');
			}
			else {
				str.append('0');
			}
		}
		
		String fin=str.toString();
		
	    }

}
