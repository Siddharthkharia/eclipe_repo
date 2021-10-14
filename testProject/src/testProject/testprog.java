package testProject;
import java.util.*;

public class testprog {

	public static void main(String[] args) {
		int first=0;
		int second=1;
		
		Scanner sc=new Scanner(System.in);
		int len=10;
		int next=0;
		System.out.println(first);
		System.out.println(second);
		
		for (int i=0;i<len;i++) {
			next=first+second;
			System.out.println(next);
			first=second;
			second=next;
		}
		sc.close();
	}
}
