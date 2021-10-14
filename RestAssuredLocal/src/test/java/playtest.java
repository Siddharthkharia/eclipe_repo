
public class playtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,10,-5,6};
		int suml=0;
		int sumr=0;
		int count=arr.length/2;
		int l=arr.length;


		for(int i=0;i<l/2;i++) {
			suml+=arr[i];
		}
		for(int j=(l/2);j<l;j++) {
			sumr+=arr[j];
		}
		
		if(suml<sumr) {
			suml=suml+arr[count+1];
			sumr=sumr-arr[count+1];
			count++;
		}
		
		System.out.println(count);
		//System.out.println(suml);
		//System.out.println(sumr);

	}

}
