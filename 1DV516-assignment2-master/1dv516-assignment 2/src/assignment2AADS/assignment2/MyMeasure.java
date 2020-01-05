package assignment2AADS.assignment2;

public class MyMeasure implements A2Measure {

	public int[] mergeSort(int[] in){
		if(in.length<2){
			return in;
		}
		int middle = in.length/2;
		int[] left = new int[middle];
		int[] right = new int[in.length-middle];
		System.arraycopy(in, 0, left, 0, middle);
		System.arraycopy(in, middle, right, 0, in.length-middle );
		mergeSort(left);
		mergeSort(right);
		merge(left,right,in);
		return in;
	}
	private void merge(int[] left, int [] right, int[] in){
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length){ //smaller integer goes into the array first
			if (left[i] <= right[j]){
				in[k++] = left[i++];
			}else{
				in[k++] = right[j++]; 
			}
		}
		while (i < left.length){
			in[k++] = left[i++];
		}
		while (j < left.length){
			in[k++] = right[j++];
		}
	}

	@Override
	public boolean isSameCollection(int[] array1, int[] array2) {
		array1 = mergeSort(array1);
		array2 = mergeSort(array2);
		if (array1.length != array2.length) {
			return false;
		}
		else {
			for ( int i = 0; i< array1.length; i++) {
				if (array1[i] != array2[i]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int minDifferences(int[] array1, int[] array2) {
		array1 = mergeSort(array1);
		array2 = mergeSort(array2);
		int squaredSum = 0;
		if(array1.length == array2.length) {
			for(int i = 0; i < array1.length; ++i) {
				squaredSum += Math.pow((array2[i]-array1[i]), 2);
			}
		}
		return squaredSum;
	}

	@Override
	public int[] getPercentileRange(int[] arr, int lower, int upper) {
		// TODO Auto-generated method stub
		arr = mergeSort(arr);
		int maxValue = arr.length;
		double start = (0.01*lower) *maxValue;
		System.out.println("the start value is: "+start);
		double end = (0.01*upper)*maxValue;
		System.out.println("the End value is: "+end);
		int counter = 0;
		int[] returnArray = new int[(int)(end-start)];
		for(int i = (int)start; i < (int)end; i++) {
			returnArray[counter] = arr[i];
			++counter;
		}
		
		return returnArray;
	}

}
