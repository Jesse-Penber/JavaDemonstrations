package test;

import java.util.Arrays;

// Demonstration of partitioning of an array of integers, based off tutorial by Derek Banas, source: http://www.newthinktank.com/2013/03/java-quick-sort/
// modified by Jesse Penber 7-30-2018

public class Partitioning {
	
	private static int[] theArray;
	private static int arraySize;
	
	public static void main(String[] args) {
		Partitioning partitionArray = new Partitioning(10);
		partitionArray.generateRandomArray();
		System.out.println(Arrays.toString(Partitioning.theArray));
		partitionArray.partitionArray(35); //35 argument is the pivot value
		System.out.println(Arrays.toString(Partitioning.theArray));
	}
	
	public void partitionArray(int pivot) {
		int leftPointer = -1; //left side of array
		int rightPointer = arraySize; //right side of array
		
		while(true) {
			while(leftPointer < (arraySize -1) && theArray[++leftPointer] < pivot)
				;
			System.out.println(theArray[leftPointer] + " in index " + leftPointer + " is greather than the pivot value " + pivot);
			
			while(rightPointer > 0 && theArray[--rightPointer] > pivot) 
				; 
			System.out.println(theArray[rightPointer] + " in index " + rightPointer + " is smaller than the pivot value " + pivot);
				
			if(leftPointer >= rightPointer) break; //when leftPointer - rightPointer <=0 , sorting complete
			
			else {
				swapValues(leftPointer,rightPointer); //swaps positions of current values in leftPointer and rightPointer 
				System.out.print(theArray[leftPointer] + " was swapped for " + theArray[rightPointer]);
			}
		}
		
	}
	
		Partitioning(int newArraySize) {
			arraySize = newArraySize;
			theArray = new int[arraySize]; 
			generateRandomArray();
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
