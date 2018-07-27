package test;

import java.util.Arrays;

// demonstration of stack creation and modification, modified by Jesse Penber 7-27-2018
// Source material: Derek Banas, https://www.youtube.com/watch?v=JvGZh_BdF-8&list=PLGLfVvz_LVvReUrWr94U-Zmy+gjYTQ538nT&t=0s&index=4

public class TheStack {
	
	public String[] stackArray;
	private int stackSize;
	private int topOfStack = -1; //symbolizes that stack is empty
	
	TheStack(int size) {
		stackSize = size; 
		stackArray = new String[size]; //creates Array
		Arrays.fill(stackArray, "-1"); //fills array with -1
	}
	
	public void push(String input) { //adds an item to stack
		if(topOfStack +1 < stackSize) { //checks to make sure there's room in stack
			topOfStack++; //increases stack size by 1
			stackArray[topOfStack] = input; //adds input to stack
		} else System.out.println("\nThe stack is full");
		
		System.out.println("\nPUSH " + input + " was added to the stack");
	}
	
	public void pushMultiple(String multipleValues) { //adds multiple items to stack
		String[] tempString = multipleValues.split(" "); //splits string into multiple strings with space between each
		for (int i = 0; i < tempString.length; i++) {
			push(tempString[i]);
		}
	}
	
	public String pop() { //removes most recent item from stack
		if(topOfStack >= 0) { //checks to make sure stack has item(s)
			System.out.println("\nPOP " + stackArray[topOfStack] + " was removed from the stack");
			stackArray[topOfStack] = "-1";
			return stackArray[topOfStack--]; //removes item from stack
		} else {
			System.out.println("\nThe stack is empty");
			return "-1";
		}
	}
	
	public void popAll() { //removes all items from stack
		for(int i=topOfStack; i>=0; i--) {
			pop();
		}
	}
	
	public String peek() { //looks at top item in stack, aka item most recently added
		if(topOfStack >= 0) {
		System.out.print("\nPEEK " + stackArray[topOfStack] + " is at the top of the stack");
		return stackArray[topOfStack];
	} else {
		System.out.println("\nThe stack is empty");
		return "-1";
		}
	}
	
	public static void main(String[] args) {
		TheStack theStack = new TheStack(10); //makes a stack of 10 item capacity
		theStack.push("A"); //adds A item to stack
		theStack.push("B"); //adds B item to stack
		theStack.push("C"); //adds C item to stack
		theStack.peek(); //shows item at top of stack, aka item last added
		theStack.pop(); //removes item at top of stack from stack
		theStack.peek(); //shows item at top of stack
		theStack.pushMultiple("D E F G"); //adds D E F G items to stack
		theStack.popAll(); //removes all items from stack
		theStack.peek(); //shows that stack is empty
	}

}
