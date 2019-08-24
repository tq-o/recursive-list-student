package structures;

import java.util.Iterator; // Is it true?


public class RecursiveList<T> implements ListInterface<T>{
	private int size; // !!! remember to update every time
	private LLNode<T> head;
	
	public RecursiveList() {
		size = 0;
		head = null;
	}
	
//	public RecursiveList(LLNode<T> head, int size) {
//		this.size = size;
//		this.head = head;
//	}
	
	public int size() {
		return size;
	}
	
	//Insert first element
	public ListInterface<T> insertFirst(T elem) throws NullPointerException{
		
		if (elem == null) throw new NullPointerException();
		
		else {
			LLNode<T> newhead = new LLNode<T>(elem);
			newhead.link = head;
			head = newhead;
			size++;
		//RecursiveList<T> iter = new RecursiveList<T>(head,size);
		return this;
		}
	}
	
	// Insert last
	public ListInterface<T> insertLast(T elem){
		if (elem==null) throw new NullPointerException();
		else {
			if (head==null) {
				head = new LLNode<T> (elem);
				size++;
				return this;
			}
			else {
			LLNode<T> cur = head;
			return insertLastHelper(cur, elem, size);
			}
		}	
	}
	
	//HELPER
	public ListInterface<T> insertLastHelper(LLNode<T> cur, T elem,int index){
	if (index == 1) { 
		cur.link = new LLNode<T>(elem);
		size ++; 
		return this;
	}
	
	else {
		return insertLastHelper(cur.link,elem,index-1);
		
	}
	}
		
	//Insert at element
	public ListInterface<T> insertAt(int index, T elem){
		if (elem==null) throw new NullPointerException();
		if (index<0 || index >size) throw new IndexOutOfBoundsException();
		if (index == 0) return insertFirst(elem);
		if (index == size) return insertLast(elem);
		else {
			LLNode<T> cur = head;
			return insertAtHelper(cur, index, elem);
		}
		
	}
	
	//HELPER method
	public ListInterface<T> insertAtHelper(LLNode<T> cur, int index, T elem){
		if (index == 1) { 
			LLNode<T> Node1 = cur;
			LLNode<T> Node2 = cur.link;
			LLNode<T> Node3 = new LLNode<T>(elem);
			Node1.link = Node3;
			Node3.link = Node2;
			size++;
			return this;
		}
		
		else {
			return insertAtHelper(cur.link,index-1,elem);
			//return this;
		}
	}
	
	
	//remove first element
	public T removeFirst() throws IllegalStateException {
		if (head == null) throw new IllegalStateException();
		
		else {
			T first = head.info;
			head = head.link;
			size --;
			return first;
		}
	}
	
	//remove Last
	public T removeLast() throws IllegalStateException{
		if (size==0) throw new IllegalStateException();
		else {
			LLNode<T> cur = head;
			return removeLastHelper(cur, size);
		}
	}
	
	//HELPER
	public T removeLastHelper(LLNode<T> cur, int i) { //i: index
		if (i==1) {
			T deletenode = cur.info;
			cur = null;
			head = null;
			size--;
			return deletenode;
		}
		if (i==2) {
			T deletenode = cur.link.info;
			cur.link = null;
			size--;
			return deletenode;
		}
		else {
			return removeAtHelper(cur.link, i-2); 
		
		}
	}
	
	
	//remove at index

	public T removeAt(int i) throws IndexOutOfBoundsException {	
		if (i>=size || i<0) throw new IndexOutOfBoundsException(); 
		if (i == 0) return removeFirst();
		if (i == size - 1) return removeLast();
		else {
			LLNode<T> cur = head;
			
			return removeAtHelper(cur, i);
		}
	}
	//Helper for removeLast
	public T removeAtHelper(LLNode<T> cur, int i) { //i: index
		if (i==1) {
			T deletenode = cur.link.info;
			cur.link = cur.link.link;
			size--;
			return deletenode;
		}
		else {
			return removeAtHelper(cur.link, i-1); 
			 
		}
	}
	
	//get the first element
	public T getFirst() throws IllegalStateException{
		if (head == null) throw new IllegalStateException();
		
		else 
			return head.info;
	
	}
	
	//get the last one
	public T getLast() {
		if (head==null || size ==0) throw new IllegalStateException();
		else {
			LLNode<T> cur = head;
			return getLastHelper(cur, size);	
		}
	}
	
	//Helper
	public T getLastHelper(LLNode<T> cur, int i) { //i: index
		if (i==1) {
			T node = cur.info;
			return node;
		}
		else {
			return getLastHelper(cur.link, i-1); 
			
		}
	}
	
	//
	public T get(int i) {
		if (i>=size || i<0) throw new IndexOutOfBoundsException(); 
		if (i==0) return getFirst();
		if (i == size-1) return getLast();
		else {
			LLNode<T> cur = head;
			return getHelper(cur, i);	
		}
	}
	
	public T getHelper(LLNode<T> cur, int i) { //i: index
		if (i==0) {
			T node = cur.info;
			return node;
		}
		else {
			return getHelper(cur.link, i-1); 
			
		}
	}
	
	//
	public boolean remove(T elem) throws NullPointerException {
		if (elem==null) throw new NullPointerException();
		else {
			int a = indexOf(elem);
			if(a == -1) 
				return false;
			if (removeAt(a)!=null)
				return true;
			else 
				return false;
		}
		
	}
	//
	public int indexOf(T elem) {
		if (elem == null) throw new NullPointerException();
		else {
			LLNode<T> cur = head;
			return indexOfHelper(elem, 0, cur);
		}
	}
	
	//Helper
	private int indexOfHelper(T elem, int index, LLNode<T> cur){
		if (cur==null) return -1;
		if (cur.info.equals(elem)) return index;
		else {
			return indexOfHelper(elem, index+1, cur.link);
		
		}
	}
	//
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Iterator<T> iterator() { //Create Iterator class?
		// TODO Auto-generated method stub
	 return new LinkedNodeIterator<T>(this.head);
	}
}


class LLNode<T> {
	public T info;
	public LLNode<T> link;
	public LLNode (T info) {
		this.info = info;
		link = null;
	}
}


class LinkedNodeIterator<T> implements Iterator<T> {
   
  public LLNode<T> iter;

  public LinkedNodeIterator(LLNode<T> head) {
     	  iter = head;
  }

  @Override
  public boolean hasNext() {


	  return (iter!=null);
  }

  @Override
  public T next() {
	if (!hasNext())
		return null;
	T i = iter.info;
	iter = iter.link;
	return i;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}