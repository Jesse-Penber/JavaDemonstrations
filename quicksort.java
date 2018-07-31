package test;

import java.util.Arrays;

//Demonstration of quicksort of an array of integers, based off tutorial by Derek Banas, source: http://www.newthinktank.com/2013/03/java-quick-sort/
//modified by Jesse Penber 7-30-2018

public class QuickSort {
	
	private static int[] theArray;
	private static int arraySize;
	
	public static void main(String[] args) {
		QuickSort theSort = new QuickSort(10);
		theSort.generateRandomArray();
		System.out.println(Arrays.toString(QuickSort.theArray));
		theSort.quickSort(0, 9); //10 items in the array
		System.out.println(Arrays.toString(QuickSort.theArray));
	}

	QuickSort(int newArraySize) {
		
		arraySize = newArraySize;
		theArray = new int[arraySize]; 
		generateRandomArray();
	}
	
	public int partitionArray(int left, int right, int pivot) { 
		int leftPointer = left - 1;
		int rightPointer = right;
		
		while(true) {
			while(theArray[++leftPointer] < pivot) 
				; 
			System.out.println(theArray[leftPointer] + " in index " + leftPointer + " is greather than the pivot value " + pivot);
			
			while(rightPointer > 0 && theArray[--rightPointer] > pivot) 
				; 
			System.out.println(theArray[rightPointer] + " in index " + rightPointer + " is smaller than the pivot value " + pivot);
			
			if(leftPointer >= rightPointer) {
				System.out.println("Leftmost value is greater than rightmost value, start again");
				break;
			} else {
				swapValues(leftPointer, rightPointer);				
				System.out.println(theArray[leftPointer] + " was swapped for" + theArray[rightPointer]);
			}
		}	
		
		swapValues(leftPointer, right);
		return leftPointer;
	}
	
	public void quickSort(int left, int right) {
		
		if(right-left <= 0) { //sorting complete
			return; 
		} else {
			int pivot = theArray[right]; //pivot has to be a value in the array
			System.out.println("Leftmost value: " + left + " Pivot value: " + pivot + " Rightmost value: " + right);
			
			int pivotLocation = partitionArray(left, right, pivot);
			System.out.println("Leftmost value: " + theArray[left] + " is made the pivot value");
			
			quickSort(left, pivotLocation - 1);
			quickSort(pivotLocation + 1, right); 
			
		}
	
	}
	
	public void swapValues(int indexOne, int indexTwo) {
		int temporary = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temporary;
	}
	
	public void generateRandomArray( ) { //creates array with values between 10 and 54
		for (int i=0; i < arraySize; i++) {
			theArray[i] = (int)(Math.random() * 50) + 10;
		}
	}
}
