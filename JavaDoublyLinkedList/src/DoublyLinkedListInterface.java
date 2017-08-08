
public interface DoublyLinkedListInterface<T> {
	
	boolean isEmpty();
	int size();
	T get(int index);
	void clear();
	
	void insert(T input);
	void delete(T input);
	
	void sortAscending();
	void sortDescending();
	

}
