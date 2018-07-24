package test;

import java.util.Arrays;

//creates a hash table of up to 30 items
//created originally by Derek Banas, recreated and tweaked here for slightly smaller array
//Original tutorial https://www.youtube.com/watch?v=B4vqVDeERhI&t=1s

public class HashFunction {
	
	String [] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	public static void main(String[] args) {
		
		HashFunction theFunc = new HashFunction(30); //creates array size 30
		
		String[] elementsToAdd = {"1", "5", "2", "23", "7", "9", "34", "49", "21", "80" };
	
		theFunc.hashfunction2(elementsToAdd, theFunc.theArray);
	}
	
	public void hashfunction2(String[] stringForArray, String[] theArray) {
		
		for(int n = 0; n < stringForArray.length; n++) {
			String newElementVal = stringForArray[n];
			
			//makes sure index is not more than 29, keeping array to 30 items 
			int arrayIndex = Integer.parseInt(newElementVal) % 29;
			System.out.println("Modulus Index= " + arrayIndex + " for value" + newElementVal);
			
			while (theArray[arrayIndex] != "-1") { 
				
				++arrayIndex;
				System.out.println("Collison Try " + arrayIndex + " Instead");
				arrayIndex %= arraySize;
			}
			
			theArray[arrayIndex] = newElementVal; // stores element at that index
		}
	}
	
	
	HashFunction(int size) {
			arraySize = size; 
			theArray = new String[size];
			Arrays.fill(theArray, "-1"); //makes initial value of all elements in array -1
		}
	
	
	}
