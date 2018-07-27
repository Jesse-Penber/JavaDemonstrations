package test;

//demonstration of singly linked list, modified by Jesse Penber 7/20/2018
//based on template by Derek Banas at link: http://www.newthinktank.com/2013/03/linked-list-in-java/

public class Link { 

	public String bookName;
	public int millionsSold;

	public Link next;

	public Link(String bookName, int millionsSold) {

		this.bookName = bookName; 
		this.millionsSold = millionsSold;

	}

	public void display() {

		System.out.println(bookName + ": " + millionsSold + ",000,000 books sold");
	}

	public String toString() { //causes Next to return bookName string
		return bookName;
	}

	public static void main(String[] args) {

		LinkList theLinkedList = new LinkList();

		//add list items
		theLinkedList.insertFirstLink("The Last Unicorn", 250);
		theLinkedList.insertFirstLink("The Girl with All The Gifts", 440);
		theLinkedList.insertFirstLink("Furies of Calderon", 160);
		theLinkedList.insertFirstLink("The Plague Dogs", 380);	

		//theLinkedList.removeFirst(); //removes last item added
		//System.out.println(theLinkedList.find("The Last Unicorn").bookName + " was found \n"); //finds book
		theLinkedList.display(); //displays full list in console in order they were put in
	}
}

class LinkList {
	public Link firstLink; 

	LinkList() {
		firstLink = null; //first link in list always has value null
	}

	public boolean isEmpty() {
		return(firstLink == null);  //checks if firstLink is null
	}	

	public void insertFirstLink(String bookName, int millionsSold) {

		Link newLink = new Link(bookName, millionsSold);
		newLink.next = firstLink; //makes new link reference first link
		firstLink = newLink; //makes first link reference new link
	}

	public Link removeFirst() {
		Link linkReference = firstLink;

		if(!isEmpty()) { //checks that LinkList is not empty
			firstLink = firstLink.next; 
		} else {
			System.out.println("Empty LinkList");
		}

		return linkReference;
	}

	public void display( ) {

		Link theLink = firstLink;

		while(theLink != null) {

			theLink.display(); //prints out book name and millions sold
			System.out.println("Next Link: " + theLink.next); //prints next item in list
			theLink = theLink.next;
			System.out.println();
		}
	}

	public Link find(String bookName) { //searches for list item based on book name
		Link theLink = firstLink;

		if(!isEmpty() ) { //checks that LinkList is not empty
			while(theLink.bookName != bookName) {
				if(theLink.next == null) {
					return null;
				} else {
					theLink = theLink.next; //references Next method
				}
			}
		} else {
			System.out.println("Empty LinkList");
		}
		return theLink; //returns matched link
	}

	public Link removeLink(String bookName) {

		Link currentLink = firstLink;
		Link previousLink = firstLink;

		while(currentLink.bookName != bookName) {

			if(currentLink.next == null) { //checks if we're at final list item
				return null;
			} else {
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		if(currentLink == firstLink) {
			firstLink = firstLink.next; // removes currentLink from list
		} else {
			previousLink.next = currentLink.next; 
		}

		return currentLink;
	}
}
