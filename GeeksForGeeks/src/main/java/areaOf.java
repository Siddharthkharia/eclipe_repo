import java.util.*;

public class areaOf {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int T=sc.nextInt();
		int i=0;
		double area=0;
		while(i<T) {
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				int radius=sc.nextInt();
				area=(double) (Math.PI*radius*radius);
				System.out.println(area);
				break;
			}
			case 2:{
				int len=sc.nextInt();
				int bre=sc.nextInt();
				System.out.println(len*bre);
				break;
			}
			}
		i++;
		}
		sc.close();
	}

}
