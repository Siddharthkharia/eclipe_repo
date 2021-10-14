package testProject;

public class sorting{
	
//Sorting and aaray without using libraries in ascending order, parameters required unsorted array
public int[] ascSort (int [] array){
	int temp=0;
		for(int i=0;i<array.length;i++) {
			for(int j=i;j<array.length-1;j++) {
				
				if(array[j+1]<array[j]) {
					temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
				
			}
			System.out.print(array);
		}
	return array;
	}
}
