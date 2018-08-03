package test;

//Demonstration of binary tree traversal and node location
//Created based on tutorial by Derek Banas, modified to show 3 traversal options and additional comment explanation by Jesse Penber 8-3-2018 

public class BinaryTree {
	
	Node root; //every tree has root value
	
	public void addNode(int key, String name) {
		
		Node newNode = new Node(key, name); //constructs node
		
		if(root == null) { //checks if node is actual top root
			root = newNode;
		} else {
			Node focusNode = root; //focuses on top root 
			Node parent;
			while(true) {
				parent = focusNode;
				if (key < focusNode.key) { //checks if new node should go on left 
					focusNode = focusNode.leftChild; 
					if(focusNode == null) { //if no children, places new node on left of parent
						parent.leftChild = newNode;
						return;
					}
					} else {
						focusNode = focusNode.rightChild;
						if(focusNode == null) { //if no children, place new node on right of parent
							parent.rightChild = newNode;
							return;
						}
					}
				}
			}
		} 
	
	public void inOrderTraversal(Node focusNode) {
		if(focusNode != null) {
			inOrderTraversal(focusNode.leftChild); //traverses left child
			System.out.println(focusNode);
			inOrderTraversal(focusNode.rightChild); //traverses right child
		}
	}
	
	public void preOrderTraversal(Node focusNode) { //traverses starting from smallest child
		if(focusNode != null) {
			System.out.println(focusNode);
			preOrderTraversal(focusNode.leftChild); //traverses left child
			preOrderTraversal(focusNode.rightChild); //traverses right child
		}
	}
	
	public void postOrderTraversal(Node focusNode) { //traverses starting from children of root, then their children, then root last
		if(focusNode != null) {
			preOrderTraversal(focusNode.leftChild); //traverses left child
			preOrderTraversal(focusNode.rightChild); //traverses right child
			System.out.println(focusNode);
		}
	}
	
	public Node findNode(int key) { //finds value at key specified
		Node focusNode = root;
		while(focusNode.key != key) { //looks at left children of root
			if (key < focusNode.key) { 
				focusNode = focusNode.leftChild;
		} else { //looks at right children of root
			focusNode = focusNode.rightChild; 
		}
			
			if(focusNode == null) //if node wasn't found, returns null
				return null;
		}
		return focusNode;
	}
		
	
	public static void  main(String[] args) { //traverses starting from root, then left children and their children, then right children
		BinaryTree theTree = new BinaryTree(); //creates tree
		
		theTree.addNode(50, "Carnivora");
		theTree.addNode(25, "Canoidea");
		theTree.addNode(20, "Feloidea");
		theTree.addNode(30, "Mustelidae");
		theTree.addNode(70, "Mephitis");
		theTree.addNode(85, "Lutra");
	
	theTree.inOrderTraversal(theTree.root);
	theTree.preOrderTraversal(theTree.root);
	theTree.postOrderTraversal(theTree.root);
	
	System.out.println("Searching for the value at node 30");
	System.out.println(theTree.findNode(30));
}
}

class Node {
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name) {
		this.key = key; 
		this.name = name;
	}
	
	public String toString( ) {
		return name + " has a key " + key;
	}
}
