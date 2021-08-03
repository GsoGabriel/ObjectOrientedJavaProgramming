package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	private int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{
		// TODO: Implement this method
		if (element == null){
			throw new NullPointerException();
		}
		LLNode<E> newNode = new LLNode<E>(element);
		if(this.head.next == null){
			head.next = newNode;
			tail.prev = newNode;
			newNode.setPrevNext(this.head, this.tail);
			this.size++;
		}
		else{
			LLNode<E> lastNode = this.tail.prev;
			lastNode.next = newNode;
			this.tail.prev = newNode;
			newNode.setPrevNext(lastNode, this.tail);
			this.size++;

		}
		return true;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.

		if (index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currNode = currNode(index);
		return currNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )
	{
		// TODO: Implement this method
		if (element == null){
			throw new NullPointerException();
		}
		else if (index < 0 || index > this.size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> currNode = currNode(index);
		currNode.prev.next = newNode;
		newNode.setPrevNext(currNode.prev, currNode);
		currNode.prev = newNode;
		this.size++;
	}

	private LLNode<E> currNode(int index){
		LLNode<E> currNode = this.head.next;
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		return currNode;
	}

	/** Return the size of the list */
	public int size()
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	public E remove(int index)
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currNode = currNode(index);
		currNode.prev.next = currNode.next;
		currNode.next.prev = currNode.prev;
		this.size--;
		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method
		if (element == null){
			throw new NullPointerException();
		}
		else if (index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currNode = currNode(index);
		E oldValue = currNode.data;
		currNode.data = element;
		return oldValue;
	}
}

class LLNode<E>
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e)
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public void setPrevNext(LLNode<E> newPrev, LLNode<E> newNext)
	{
		this.prev = newPrev;
		this.next = newNext;
	}

}
