
public interface DoublyLinkedListInterface<T> {
	
	boolean isEmpty();
	int size();
	T get(int index);
	void clear();
	
	void delete(T input);
	
	void sortAscending();
	void sortDescending();
	void insert(Comparable input);
	

}
