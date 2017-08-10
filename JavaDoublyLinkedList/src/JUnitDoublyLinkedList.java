import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitDoublyLinkedList {

	DoublyLinkedList intList = new DoublyLinkedList();
	DoublyLinkedList charList = new DoublyLinkedList();
	DoublyLinkedList floatList = new DoublyLinkedList();
	
	@Test
	public void testInsert() {
		for(int i = 0; i < 10; i++) intList.insert(i);
		for(float k = 0; k < 1; k += .1) floatList.insert(k);
		
		assertEquals(10, intList.size());
		assertEquals(10, floatList.size());
		
		for(int i = 0; i < 10; i++) {
			assertEquals(intList.get(i), i);
		}
		
	}
	
	@Test
	public void testDelete() {
		System.out.println("\n\ntestDelete");
		intList.insert(0);
		assertEquals(intList.size(), 1);
		intList.delete(1);
		assertEquals(intList.size(), 1);
		intList.delete(0);
		assertEquals(intList.size(), 0);
		intList.insert(1);
		intList.insert(2);
		intList.delete(2);
		assertEquals(intList.size(), 1);
		//
		intList.insert(3);
		intList.insert(4);
		intList.delete(1);
		assertEquals(intList.size(), 2);
		assertEquals(intList.get(0), 3);
		assertEquals(intList.get(1), 4);
		assertEquals(intList.get(5), null);
	}
	
	@Test
	public void testDelete2() {
		System.out.println("\n\ntestDelete2");

		intList.insert(1);
		intList.insert(3);
		intList.insert(4);
		intList.delete(1);
		assertEquals(intList.size(), 2);
		assertEquals(intList.get(0), 3);
		assertEquals(intList.get(1), 4);
		assertEquals(intList.get(5), null);
	}
	
	@Test
	public void testDeleteEnd() {
		System.out.println("\n\ntestDeleteEnd");
		intList.insert(1);
		intList.insert(2);
		intList.insert(3);
		
		assertEquals(intList.get(0), 1);
		assertEquals(intList.get(1), 2);
		assertEquals(intList.get(2), 3);
		intList.delete(3);
		
		assertEquals(intList.get(0), 1);
		assertEquals(intList.get(1), 2);
		assertEquals(intList.get(2), null);
	}
	
	@Test
	public void testDeleteFront() {
		System.out.println("\n\ntestDeleteFront");
		intList.delete(3);
		assertEquals(intList.size(), 0);
		intList.insert(9);
		intList.delete(9);
		assertEquals(intList.size(), 0);
		intList.insert(1);
		intList.insert(2);
		intList.insert(3);
		for(int i = 1, k = 2; i < 4; i++, k--) {
			intList.delete(i);
			assertEquals(intList.size(), k);
		}
	}

	@Test
	public void testDeleteMiddle() {
		System.out.println("\n\ntestDeleteMiddle");
		for(int i = 0; i < 5; i++) {
			intList.insert(i);
		}
		assertEquals(intList.size(), 5);
		for(int i = 1, k = 4
				; i < 4; i++, k--) {
			intList.delete(i);
			assertEquals(intList.size(), k);
		}
	}
	
	@Test
	public void testSort() {
		System.out.println("\n\ntestSort");
		for(int i = 10; i >= 0; i--) intList.insert(i);
		
		intList.printList();
		
		intList.sortAscending();
		System.out.println();
		intList.printList();
	}
	
	@Test
	public void testSort1() {
		System.out.println("\n\ntestSort1");
		intList.insert(9);
		intList.insert(2);
		intList.insert(11);
		intList.insert(1);
		intList.insert(7);
		intList.insert(8);
		intList.insert(6);
		intList.insert(3);
		intList.insert(4);
		
		
		//intList.insert(12);
		
		intList.printList();
		
		intList.sortAscending();
		System.out.println();
		intList.printList();
	}
	
}
