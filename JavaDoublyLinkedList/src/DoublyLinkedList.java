
public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T>{

	private int size;
	private Node head;
	private Node tail;
	
	/**
	 * Class constructor
	 */
	DoublyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	@Override
	/**
	 * function to check if Linked List is empty
	 * 
	 * O(1)
	 */
	public boolean isEmpty() {
		return (this.size == 0) ? true : false;
	}

	@Override
	/**
	 * function to get size of Linked List
	 * 
	 * O(1)
	 */
	public int size() {
		return this.size;
	}

	@Override
	/**
	 * function to get element at specified index
	 * 
	 * O(n)
	 */
	public T get(int index) throws IndexOutOfBoundsException{
		
		if(index < 0 || index > this.size - 1) { // return null if index out of bounds
			throw new IndexOutOfBoundsException();
		}
	
		Node curr = this.head; // curr node starts at head
		int counter = 0; // counter for iterating to destination
		
		while(counter < index) { //iterate to index
			curr = curr.next;
			counter++;
		}
		
		return (T) curr.data;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * function to insert at end of linked list
	 * 
	 * O(1)
	 * @param input
	 */
	public void insert(T input) {
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
	/**
	 * function for deleting a node in LL
	 * 
	 * O(n)
	 */
	public void delete(T input) {

		// if LL has no elements
		if(this.size == 0) return;
		
		Node curr = this.head;
		
		// if LL has 1 element
		if(this.size == 1) {
			if(this.head.data.equals(input)) { // if element matches
				curr.next = null;
				curr.prev = null;
				
				this.head = null;
				this.tail = null;
				this.size = 0;
				return;
			}
			return;
		}
		// if LL has 2 elements
		
		
		// all other cases
	}

	@Override
	/**
	 * function to sort linked list from smallest to greatest
	 * 
	 * O(n2)
	 */
	public void sortAscending() {
		
	}
	
	
	@Override
	/**
	 * function to sort linked list from greatest to smallest
	 * 
	 * O(n2)
	 */
	public void sortDescending() {
		
	}
	class Node<T> implements Comparable {
		protected T data;
		protected Node next;
		protected Node prev;
		
		protected Node(T input) { // creates an instance of node
			this.data = input;
			this.next = null;
			this.prev = null;
		}

		T getData() {
			return this.data;
		}
		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
}
