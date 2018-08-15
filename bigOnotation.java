package test;

//implements common examples of Big O Notation
//O1 adding item to array, On linear search, On^2 bubble sort, logN binary search, and NlogN quick sort
//template by Derek Banas, modified by Jesse Penber to show difference in results for multiple array sizes

public class BigONotation {
	
	private int[] theArray;
	private int arraySize;
	private int itemsInArray = 0;
	static long startTime;
	static long endTime;
	
	public static void main(String[] args) {
		
		BigONotation testAlg1 = new BigONotation(10000);
		testAlg1.generateArray();
		
		BigONotation testAlg2 = new BigONotation(20000);
		testAlg2.generateArray();
		
		testAlg1.linearSearch(20);
		testAlg2.linearSearch(20);
		
		testAlg1.bubbleSort();
		testAlg2.bubbleSort();
		
		testAlg1.binarySearch(20);
		testAlg2.binarySearch(20);
		
		long startTime1 = System.currentTimeMillis();
		testAlg1.quickSort(0, testAlg1.itemsInArray);
		long endTime1 = System.currentTimeMillis();
		System.out.println("Quick Sort 1 Took " + (endTime1 - startTime1) + " milliseconds");
		
		long startTime2 = System.currentTimeMillis();
		testAlg2.quickSort(0, testAlg2.itemsInArray);
		long endTime2 = System.currentTimeMillis();
		System.out.println("Quick Sort 2 Took " + (endTime2 - startTime2) + " milliseconds");
	}
	
	//O(1) (order of one), executes in same amount of time regardless of array size
	public void addItemToArray(int newItem) {
		theArray[itemsInArray++] = newItem;
		}
	
	//O(N) (order of N), time to complete grows directly in proportion with array size
    public void linearSearch(int searchValue) {
    	boolean valueInArray = false;
    	String indexWithValue = "";
    	startTime = System.currentTimeMillis();
    	
    	for (int i = 0; i < arraySize; i++) {
    		if(theArray[i] == searchValue) {
    			valueInArray = true;
    			indexWithValue += i + " ";
    		}
    	}
    	
    	System.out.println("Value found " + valueInArray);
    	endTime = System.currentTimeMillis();
    	System.out.println("Linear search took " + (endTime - startTime) + " milliseconds");
    }
    
    //O(N^2) (order of N squared), time to complete grows exponentially in proportion to array size
    public void bubbleSort() {
    	
    	startTime = System.currentTimeMillis();
    	
    	for (int i = arraySize - 1; i > 1; i--) { 
    		for(int j = 0; j < i; j++) {
    			if (theArray[j] > theArray[j+1]) {
    				swapValues(j, j+1);
    			}
    		}
    	}
    	
    	endTime = System.currentTimeMillis();
    	System.out.println("Bubble sort took " + (endTime - startTime) + " milliseconds");
    	
    }
    
    //O(logN) (order of log N), amount of data used decreases by 50% each runthrough
    public void binarySearch(int searchValue) {
    	
    	startTime = System.currentTimeMillis();
    	
    	int lowIndex = 0;
    	int highIndex = arraySize - 1;
    	int runthroughs = 0;
    	
    	while(lowIndex <= highIndex) {
    		int middleIndex = (highIndex + lowIndex) / 2; 
    		
    		if(theArray[middleIndex] < searchValue) {
    		lowIndex = middleIndex + 1;
    		}
    		
    		else if(theArray[middleIndex] > searchValue) {
    			highIndex = middleIndex - 1;
    		}
    		
    		else {
    			System.out.println("Found Match in index " + middleIndex);
    			lowIndex = highIndex + 1;
    		}
    		
    		runthroughs++;
    	}
    	
    	endTime = System.currentTimeMillis();
    	System.out.println("Binary search took " + (endTime - startTime) + " milliseconds");
    	System.out.println("Runsthroughs: " + runthroughs);
    }
    
    //O(nlogn) (order of n log n), quick sort, partitions into smaller arrays
    public void quickSort(int left, int right) {
    	if(right-left <= 0) {
    		return;
    	} else {
    		int pivot = theArray[right];
    		int pivotLocation = partitionArray(left, right, pivot);
    		quickSort(left, pivotLocation - 1);
    		quickSort(pivotLocation + 1, right); 

    	}
    }
    
    public int partitionArray(int left, int right, int pivot) {
    	int leftPointer = left - 1;
    	int rightPointer = right;
    	
    	while(true) {
    		while(theArray[++leftPointer] < pivot)
    			;
    		
    		while(rightPointer > 0 && theArray[--rightPointer] > pivot)
    			;
    		if(leftPointer >= rightPointer) {
    			break;
    		} else {
    			swapValues(leftPointer, rightPointer);
    		}
    		
    	}
    	swapValues(leftPointer, right);
    	return leftPointer;
    }
    
    BigONotation(int size) {
    	arraySize = size;
    	theArray = new int[size];
    }
	
	public void generateArray() {
		for (int i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 100) + 10;
		}
		
		itemsInArray = arraySize - 1;
	}
	
	public void swapValues(int indexOne, int indexTwo) {
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}
	
}