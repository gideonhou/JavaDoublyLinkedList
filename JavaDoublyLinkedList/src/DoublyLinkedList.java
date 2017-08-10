
public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T>{

	private int size;
	private Node head;
	private Node tail;
	
	/** DONE
	 * Class constructor
	 */
	DoublyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	@Override
	/** DONE
	 * function to check if Linked List is empty
	 * 
	 * O(1)
	 */
	public boolean isEmpty() {
		return (this.size == 0) ? true : false;
	}

	@Override
	/** DONE
	 * function to get size of Linked List
	 * 
	 * O(1)
	 */
	public int size() {
		return this.size;
	}

	@Override
	/** DONE
	 * function to get element at specified index
	 * 
	 * O(n)
	 */
	public T get(int index) throws IndexOutOfBoundsException{
		
		if(index < 0 || index > this.size - 1) { // return null if index out of bounds
			return null;
		}
	
		Node curr = this.head; // curr node starts at head
		int counter = 0; // counter for iterating to destination
		
		while(counter < index) { //iterate to index
			curr = curr.next;
			counter++;
		}
		//System.out.print(curr.data);
		return (T) curr.data;
	}

	@Override
	/**
	 * DONE
	 * This method deletes every node from LL
	 * 
	 * O(n)
	 */
	public void clear() {
		Node curr = this.head;
		Node toDel = this.head;
		
		do { // 1. iterate to next node 2. remove pointers on present node
			curr = curr.next;
			toDel.next = null;
			toDel.prev = null;
		} while(curr != null); // go through each node and remove their pointers

		this.head = null;
		this.tail = null;
		this.size = 0;
		
		return;
	}

	@Override
	/**
	 * function to insert at end of linked list
	 * 
	 * O(1)
	 * @param input
	 */
	public void insert(Comparable input) {
		Node toAdd = new Node(input);
		if(this.size == 0) { // if size is zero
			this.head = toAdd;
			this.tail = toAdd;
			this.size++;
			return;
		}
		this.tail.next = toAdd; // put new node at end of linked list
		toAdd.prev = this.tail; // have new node's prev pointer point to tail
		
		this.tail = toAdd; // set the tail pointer to added node
		
		this.size++;
		return;
	}

	@Override
	/** DONE
	 * function for deleting the first occurrence a node in LL
	 * 
	 * O(n)
	 */
	public void delete(T input) {

		// if LL has no elements
		if(this.size == 0) {
			//System.out.println("no elements in list");

			return;
		}
		
		Node curr = this.head;
		
		// if LL has 1 element
		if(this.size == 1) {
			if(this.head.data.equals(input)) { // if element matches
				curr.next = null;
				curr.prev = null;
				
				this.head = null;
				this.tail = null;
				this.size = 0;
				//System.out.println("1 element found and deleted");
				return;
			}
			//System.out.println("1 element not deleted");
			return;
		}		
		
		// if the first element is target
		if(this.head.data.equals(input)) {
			
			// remove pointers to head
			//System.out.println(curr.data);
			this.head = curr.next;
			curr = curr.next;
			curr.prev = null;
			//System.out.println(curr.data);
			//this.head.prev = null;
			
			//this.head = curr.next;
			
			//this.head.prev = null; 
			
			//curr.next = null;
			size--;
			//System.out.println("first element found and deleted");
			return;
		}
		// all other cases
		while(curr != null) { //iterate to the end of the LL to find element
			if(curr.data.equals(input)) { // if the element is found
				
				
				curr.prev.next = curr.next; // set curr's previous node to point to curr's next node
				if(curr.next == null) { // if the node found is at end of list
					this.tail = curr.prev;
					curr.prev = null;
					this.size--;
					//System.out.println("last element deleted");
					return;
				}
				curr.next.prev = curr.prev; // set curr's next node to point to curr's prev node
				
				this.size--; // decrement size of LL
				curr.next = null;
				curr.prev = null;
				//System.out.println("element found and deleted");
				return;
			}
			curr = curr.next; // go to next node
		}
		//System.out.println("element not found");
		return; // node not found
	}

	@Override
	/**
	 * function to sort linked list from smallest to greatest
	 * 
	 * Insertion sort
	 * O(n2)
	 */
	public void sortAscending() {
		if(this.size == 1) return;
		
		Node sortEnd = this.head;
		Node toMove = sortEnd.next;
		Node it;
		while(toMove != null) { // start sorting at the second element
			it = sortEnd;
			
			if(toMove.compareTo(this.head) < 0) { // if toMove is less than the head of list, move it
				// set pointers for toMove before insert
				toMove.prev.next = toMove.next;
				if(toMove.next != null) toMove.next.prev = toMove.prev;
				
				// set pointers for toMove
				toMove.next = this.head;
				toMove.prev = this.head.prev;
				
				
				// set pointers around toMove after insert
				this.head.prev = toMove;
				
				this.head = toMove;
				
				toMove= sortEnd.next;
			} else if (toMove.compareTo(sortEnd) < 0 ){ // if toMove is less than the node behind it
				while (toMove.compareTo(it) < 0 && it != null) { // 
					it = it.prev;
				}
				// set pointers for toMove before insert
				toMove.prev.next = toMove.next;
				if(toMove.next != null) toMove.next.prev = toMove.prev;
				
				// set toMove pointers
				toMove.prev = it;
				toMove.next = it.next;
			
				// set pointers of nodes around toMove
			
				it.next = toMove;
				it.next.prev = toMove;
				
				// continue
				//sortEnd = sortEnd.next;
				toMove = sortEnd.next;
			} else { // move on			
				sortEnd = sortEnd.next;
				toMove = sortEnd.next;
			}
			
		}
		this.tail = sortEnd;
		return;
	}
	
	public void printList() {
		Node curr = this.head;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		
	}
	@Override
	/**
	 * function to sort linked list from greatest to smallest
	 * 
	 * O(n2)
	 */
	public void sortDescending() {
		
	}
	class Node<T extends Comparable<T>> {
		protected Comparable<T> data;
		protected Node next;
		protected Node prev;
		
		protected Node(Comparable<T> input) { // creates an instance of node
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		
		public int compareTo(Node arg0) {
			return this.data.compareTo((T) arg0.data);
		}
	}
}
