import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		String s=sc.next();
		System.out.println(timeconver(s));
		sc.close();
		
		System.out.println(timec(s));

	}
	
	public static String timeconver(String s) {
		String[] time =s.split(":");

		System.out.println(time[0]+" "+time[1] +" "+ time[2]);
		
		StringBuilder sb = new StringBuilder();
		//String result=null;
	
		int hour=Integer.parseInt(time[0]);
		System.out.println("hour value :- "+hour);
		
		
		String sc= time[2].substring(0,2);
		//int sec=Integer.parseInt(sc);
		System.out.println("sec value :- "+sc);
		
		
		String ampm=time[2].substring(2,4);
		System.out.println("AMPM value :- "+ampm);

		
		time[2]=sc;
		if(ampm.charAt(0)=='A') {
			if(hour==12) {
				hour=00;				
			}
			else {
				hour=hour;
			}
		}
		else {
			if(hour<12) {
				hour=hour+12;
			}
			
			else{
				if(hour==12){
					hour=12;
				}
			}
		}
		
		if(hour<10) {
			time[0]="0"+String.valueOf(hour);	
		}
		else {
			time[0]=String.valueOf(hour);
		}
		
		
		
		for(int i=0;i<time.length;i++) {
			//System.out.print(time[i]);
			
			sb.append(time[i]);
			if(i<2) {
				//System.out.print(":");
				sb.append(":");
			}
		}
		return sb.toString();
	}

	public static String timec(String s) {
		
		//String result="res";
		String hour=s.substring(0, 2);
		String ampm=s.substring(8,10);
		
		StringBuilder sb = new StringBuilder();
		
		
		System.out.println("hour value 2nd function:- "+hour);
		System.out.println("ampm value 2nd function:- "+ampm);
		
		if(hour=="12" && ampm == "AM") {
			sb.append("00");
			System.out.println("00");
		}
		else {
			if(hour=="12" && ampm=="PM") {
				sb.append(Integer.valueOf(hour)+12);
			}
		}
		
		sb.append(s.substring(2,8));
		
		return sb.toString();
	}

}
