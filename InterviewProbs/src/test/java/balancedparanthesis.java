import java.util.ArrayList;

//import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class balancedparanthesis {
	
	public static boolean checkstring(String s) {
		sk st= new sk();
		int len =s.length();
		char c;

		for (int i=0;i<len;i++) {
			c=s.charAt(i);

			if(c=='(' ||c=='{' || c=='[' ) {
				st.push(c);
				//System.out.println(s.arr);
			}
			
			else {
				if(c==')' && st.at() =='(' ) {
					st.pop();
				}
				else {
					if(c=='}' && st.at() =='}') {
						st.pop();
					}
					else {
						if(c==']'&& st.at() ==']' ) {
							st.pop();
						}
						else
							return false;
					}

				}

			}
		}
		if(st.empty())
			return true;
		else
			return false;

	}
	
	

	public static void main(String[] args) {

		
		String s = "}";
		if(checkstring (s)==true)
			System.out.println("balanced");
		else
			System.out.println("not balanced");
		}

	}

	class sk{

		ArrayList<Character> arr= new ArrayList<Character>();


		public void push(char c) {	
			arr.add(c);	
			//arr.add(i+1, c);
		}

		public  void pop() {
			if(arr.size()>0) {
				int i=arr.size();
				arr.remove(i-1);	
			}
		}
		public char at() {
			if(arr.size()>0) {
				int i=arr.size();
				return arr.get(i-1);
			}
			else 
				return ' ';
		}
		public boolean empty() {
			if(arr.size()==0) {
				System.out.println(arr.size());
				return true;
			}
			else 
				return false;
		}
	}