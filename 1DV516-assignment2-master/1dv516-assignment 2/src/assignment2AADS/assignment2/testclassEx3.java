package assignment2AADS.assignment2;
import java.util.*;

public class testclassEx3 {

	public static void main(String[] args) {
		Random rnd = new Random();
		int[] array1 = new int[10];
		for (int i = 0; i<array1.length; i++) {
			array1[i] = rnd.nextInt(100);
		}
		String beforeSort = "This is the array before sorting [";
		for (int i = 0; i<array1.length; i++) {
			beforeSort += array1[i]+", ";
		}
		beforeSort += "]";
		System.out.println(beforeSort);
		
		MyMeasure MM = new MyMeasure();
		MM.mergeSort(array1);
		
		String afterSort = "This is the array after sorting [";
		for (int i = 0; i<array1.length; i++) {
			afterSort += array1[i]+", ";
		}
		afterSort += "]";
		System.out.println(afterSort);
		
		int [] arr = {2,5,3,9};
		int [] arr1 = {15,12,1,3};
		
		System.out.println(MM.minDifferences(arr, arr1));
		
		int[] percentileArr = {20, 16, 2, 4, 10, 6, 12, 8, 14, 18};
		
		int[] finishedArr = MM.getPercentileRange(percentileArr, 0, 100);
		
		for ( int i = 0; i< finishedArr.length; i++) {
			System.out.println(finishedArr[i]);
		}
	
	}

}
