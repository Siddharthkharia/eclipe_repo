
public class chartst {

	
	public static char charcnt(String s) {
			
		int count=0;
		char fin=' ';
		
		for (int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			int Currentcount=0;
		
			for (int j=i;j<s.length();j++) {			
				if(c==s.charAt(j)) {
					Currentcount++;
					System.out.println("Char and count :" +c + Currentcount);
				}
				if(Currentcount<=count) {
					count=Currentcount;
					fin=c;	
				}	
			}	
		}		
		return fin;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Siddharth";
		System.out.println(charcnt(s));
	}

}
