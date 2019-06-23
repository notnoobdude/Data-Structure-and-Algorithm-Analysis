package coe20_LabExercises;

/*
 * FABRO, DAN NINO I.			BSCpE2A_C1				#11 Laboratory Exercise
 */

import java.util.NoSuchElementException;

public class Fabro_DLL {
	
	private Node head;    				//Marks the start of list.
	private Node tail;    				//Marks the end of list.
	private int size;
	
	
	public Fabro_DLL() {
		head = new Node(null, null, null);   			//Head is initialized as null.
		tail = new Node(null, head, null);   			//Tail connects to head.
		head.right = tail;         						//Head connects to tail.
		size = 0;
	}
	
	
	public int size() {									//Returns the list size.
		return size;
	}
	
	
	public boolean isEmpty() {							//Marks if the list is empty.
		return size == 0;
	}
	
	
	public FreshmanApplicant getFirst() {				//Returns the first applicant in the list.
		if(isEmpty())
			throw new NoSuchElementException("List is empty.");
		return head.right.info;
	}
	
	
	public FreshmanApplicant getLast() {				//Returns the last applicant in the list.
		if(isEmpty())
			throw new NoSuchElementException("List is empty.");
		return tail.left.info;
	}
	
	
	public void addFirst(FreshmanApplicant item) {		//Adds a new applicant at the first of the list.
		addBetween(item, head, head.right);
	}
	
	
	public void addLast(FreshmanApplicant item) {		//Adds a new applicant at the end of the list.
		addBetween(item, tail.left, tail);
	}
	
	
	public void addAt(int index, FreshmanApplicant item) {				//Adds a new applicant into a specific location in the list.
		if(index > size)
			throw new IndexOutOfBoundsException("Index exceeds: " + (index - size));
		if(index < 0)
			throw new IndexOutOfBoundsException("Index is negative: " + index);
		Node temp = head;   //Traversal node.
		for(int i = 0; i < index; i++)   //traverse node upto the item before the index.
			temp = temp.right;
		addBetween(item, temp, temp.right);
	}
	
	
	public FreshmanApplicant removeFirst() {			//Deletes and returns the first applicant in the list.
		if(isEmpty())
			throw new NoSuchElementException("List is empty.");
		return remove(head.right);
	}
	
	
	public FreshmanApplicant removeLast() {				//Deletes and returns the last applicant in the list.
		if(isEmpty())
			throw new NoSuchElementException("List is empty.");
		return remove(tail.left);
	}
	

	public FreshmanApplicant removeAt(int index) {			//Deletes and returns the applicant in a specific location in the list.
		if(isEmpty())
			throw new NoSuchElementException("List is empty.");
		if(index >= size)
			throw new IndexOutOfBoundsException("Index exceeds: " + (index - size + 1));
		if(index < 0)
			throw new IndexOutOfBoundsException("Index is negative: " + index);
		Node temp = head;   //Traversal node.
		for(int i = 0; i < index; i++)
			temp = temp.right;
		return remove(temp.right);
	}
	
	
	public FreshmanApplicant elementAt(int index) {			//Returns the element at the specified index.
		if(isEmpty())
			throw new NoSuchElementException("List is empty.");
		if(index >= size)
			throw new IndexOutOfBoundsException("Index exceeds: " + (index - size + 1));
		if(index < 0)
			throw new IndexOutOfBoundsException("Index is negative: " + index);
		Node temp = head;   
		for(int i = 0; i < index; i++)
			temp = temp.right;
		return temp.right.info;
	}
	
	
	public void swap(int pos1, int pos2) {
		Node node1, node2;      				//Nodes set to be traversal.
		node1 = node2 = head;  					//Both nodes are set as null via head node address.
		FreshmanApplicant temp; 				//Temporary info container
		for(int i = 0; i <= pos1; i++)			//With this for loop node 1 is traversed up to position 1
			node1 = node1.right;  
		temp = node1.info;     					//And is then stored to temp.
		for(int i = 0; i <= pos2; i++)			//This for loop traverses 2nd node up to position 2
			node2 = node2.right;  				
		node1.info = node2.info; 				//And is then stored into node 1
		node2.info = temp;        				//What was stored in temp will then be stored into node 2.
	}
	
	
	private void addBetween(FreshmanApplicant element, Node pred, Node succ) {
		Node newest = new Node(element, pred, succ);  				//A new node is created.
		pred.right = newest;       									 //Position the node to the right of the pre-node.
		succ.left = newest;           								 //Position the node to the left of the post-node.
		size++;   //update size
	}
	
	
	private FreshmanApplicant remove(Node node) {
		Node pred = node.left;  						//Gets the available left node.
		Node succ = node.right;    						//Gets the available right node.
		//connect left and right node to each other so that 'node' will node be referenced anymore.
		pred.right = succ;				//Left and right nodes are connected to each other so that particular node will not be pointed at,
		succ.left = pred;				//hence, removed.
		size--;   						//Size is updated.
		return node.info;  				//Data is returned.
	}
}
