import java.util.Stack;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {1,1,0,1,1,0};
		
		Stack<Integer> st= new Stack<Integer>();
		st.push(a[0]);
		Stack<Integer> st2= new Stack<Integer>();
		
		for (int i=1;i<a.length;i++) {
			
			if(st.peek()!=a[i]) {
				st.push(a[i]);
			}
			else {
				st2.push(a[i]);
			}			
		}
		while(!(st2.isEmpty())) {
			st.push(st2.pop());
		}
		System.out.println(st.toString());

	}

}
