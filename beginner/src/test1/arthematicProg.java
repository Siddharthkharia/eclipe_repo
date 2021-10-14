package test1;

public class arthematicProg {

	public int getNext(int x, int y) {
		int z=x+y;
		return z;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetInput m = new GetInput();
		
	//Initialization of variaables and getting input for them
		
		System.out.println("Enter the first number:");
		int a=m.getInt();
		System.out.println("Enter the commmon difference:");
		int b=m.getInt();
		System.out.println("Enter the number of iterations required:");
		int l=m.getInt();
		
	//Creating arthematicProg object and calling its function
		//git test
		arthematicProg obj =new arthematicProg();
		
		int i=0;
		if (l==0) {
			System.out.println(a);
		}
			else {
				System.out.println(a);
		for (i=1;i<l;i++) {
			a=obj.getNext(a, b);
			System.out.println(a);
		}
			}

	}

}
