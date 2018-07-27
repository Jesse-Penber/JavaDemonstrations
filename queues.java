package test;

import java.util.Arrays;

//demonstration of queue array, modified by Jesse Penber 7/27/2018
//based on template by Derek Banas at link: http://www.newthinktank.com/2013/03/stacks-and-queues/

public class TheQueue {
	
	private String[] queueArray;
	private int queueSize; 
	private int front, rear, numberOfItems = 0; 
	
	TheQueue(int size) {
		queueSize = size;
		queueArray = new String[size]; //creates array
		Arrays.fill(queueArray, "-1"); //fills array with -1
	}
	
	public void insert(String input) {
		if (numberOfItems +1 <= queueSize) {
			queueArray[rear] = input; //adds item to rear array
			rear++; //increases rear position counter
			numberOfItems++; //increases number of items counter
			System.out.println("\nINSERT " +input + " was added to the queue");
		} else {
			System.out.println("\nThe queue is full");
		}
	}
	
	public void remove() {
		if(numberOfItems > 0) {
			System.out.println("\nREMOVE " + queueArray[front] + " was removed");
			queueArray[front] = "-1"; //makes front value inaccessible
			front++; //increases front position counter
			numberOfItems--; //decreases number of items counter
		} else {
			System.out.println("\nThe queue is empty");
		}
	}
	
	public void peek() { //shows first and last item in array
		System.out.println("\nThe first element is " + queueArray[front]);
	}
	
	public void priorityInsert(String input) { //adds items from high to low
		int i;
		if(numberOfItems == 0) {
			insert(input); 
		} else {
			for(i = numberOfItems-1; i>=0; i--) {
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])) { //checks if input > first item in queue
					queueArray[i+1] = queueArray[i]; //moves already-present item further down queue
					} else break;
			}
			queueArray[i+1] = input;
			rear++;
			numberOfItems++;
		}
	}
	
	public static void main(String[] args) {
		
		TheQueue theQueue = new TheQueue(10); //makes array that can hold 10 items
		theQueue.insert("21"); //adds item to queue
		theQueue.insert("34"); //adds item to queue
		theQueue.insert("29"); //adds item to queue
		theQueue.remove(); //removes first item from queue
		theQueue.peek(); //shows first item in queue
	}
}
