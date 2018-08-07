package test;

//Demonstration of binary tree traversal, node location and node deletion
//Created based on tutorial by Derek Banas, modified to show all 3 traversal options and deletion by Jesse Penber 8-6-2018 

public class BinaryTreewithDelete {
	
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
		
	public boolean remove(int key) {
		Node focusNode = root;
		Node parent = root;
		
		boolean isRemovedNodeaLeftChild = true;
		while(focusNode.key != key) { //keep searching until matching key found
			parent = focusNode;
			if(key < focusNode.key) {
				isRemovedNodeaLeftChild = true;
				focusNode = focusNode.leftChild;
			} else {
				isRemovedNodeaLeftChild = false;
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null) {//if node not found
				return false; //ends method
			}
			
			if(focusNode.leftChild == null && focusNode.rightChild == null) { ///if focusNode doesn't have children
				if(focusNode == root) { 
				root = null;
			} else if(isRemovedNodeaLeftChild) { //if left child, delete it in its parent 
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
			
			}
			
			else if(focusNode.rightChild == null) { //if no right child
				
				if(focusNode == root) 
					root = focusNode.leftChild;
				
				else if(isRemovedNodeaLeftChild) 
					parent.leftChild = focusNode.leftChild;
				
				else parent.rightChild = focusNode.leftChild;
			}
			
			else if(focusNode.leftChild == null) { //if no left child
				
				if(focusNode == root) 
					root = focusNode.rightChild;
				
				else if(isRemovedNodeaLeftChild) 
					parent.leftChild = focusNode.rightChild;
				
				else parent.rightChild = focusNode.rightChild;
		}
			else {
				
				Node replacement = replaceNode(focusNode);
				if(focusNode == root) 
					root = replacement;
				 else if(isRemovedNodeaLeftChild) 
					parent.leftChild = replacement;
				 else 
					 parent.rightChild = replacement;
				
				 replacement.leftChild = focusNode.leftChild;
				}
			
			return true;
		}
		return isRemovedNodeaLeftChild;
	}
	
	public Node replaceNode(Node nodeToBeReplaced) {
		Node replacementParent = nodeToBeReplaced;
		Node replacement = nodeToBeReplaced;
		
		Node focusNode = nodeToBeReplaced.rightChild; //replace with right child
		
		while(focusNode != null) { //while there are children
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
			
		if(replacement != nodeToBeReplaced.rightChild) { 
			replacementParent.leftChild = replacementParent.rightChild;
			replacement.rightChild = nodeToBeReplaced.rightChild;
		}
		
	}
		return replacement;
}
	
	public static void  main(String[] args) { //traverses starting from root, then left children and their children, then right children
		BinaryTreewithDelete theTree = new BinaryTreewithDelete(); //creates tree
		
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
	
	System.out.println("Removing key 25");
	theTree.remove(25);
	theTree.preOrderTraversal(theTree.root);
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
}

