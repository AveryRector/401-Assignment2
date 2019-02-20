import java.util.Scanner;

public class MyQuicksort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] stringArray = line.split("\\s+");					//Splits string by spaces
		int[] unsortedArray = new int[stringArray.length];		
		for(int i = 0; i < stringArray.length; i++) {				//Fills int array with numbers from string array
			unsortedArray[i] = Integer.parseInt(stringArray[i]);
		}
		quickSort(unsortedArray, 0, unsortedArray.length - 1);
		for(int i = 0; i < unsortedArray.length; i++) {				//Prints array
			System.out.println(unsortedArray[i]);
		}
	}
	
	public static int partition(int array[], int start, int finish) {
		int pivot = array[start];				//pivot is far left element 
		int i = start;
		for(int j = start; j <= finish; j++) {
			if(array[j] < pivot) {				//if element is bigger than pivot switch i and j 
				i++;
				int hold = array[j];
				array[j] = array[i];
				array[i] = hold;
			}
		}
		int hold = array[i];					//put pivot in respective place
		array[i] = array[start];
		array[start] = hold;
		return i;
	}
	
	public static void quickSort(int array[], int start, int finish) {
		if(start < finish) {
			int partition = partition(array, start, finish);	//finds partition value and sorts 
			quickSort(array, start, partition -1);				//recursively sorts left half of array
			quickSort(array, partition+1, finish);				//recursively sorts right half of array
		}
	}
	
	
}
