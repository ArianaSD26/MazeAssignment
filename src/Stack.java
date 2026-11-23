
/**
 * Array Based Stack
 */
public class Stack implements StackInterface {
	/**
	 * Declares variable for top
	 */
	private Node top;
	
	/**
	 * Constructs a stack with a null top
	 */
	public Stack() {
		top = null;
	}
	
	/**
	 * Finds out if stack is empty
	 * @return true if stack is empty and false if not
	 */
	public boolean isEmpty() {
		return top == null;
	}
	
	/**
	 * Pushes item into stack
	 * @param the object item
	 */
	public void push(Object i) {
		top = new Node(i, top);
	}
	
	/**
	 * Pops an item at the top of the stack
	 */
	public Object pop() throws StackException {
		if(!isEmpty()) {
			Node temp = top;
			top = top.getNext();
			return temp.getItem();
		}
		else {
			throw new StackException("StackException on " + "pop: stack empty");
		}
	}
	
	/**
	 * Pops all items
	 */
	public void popAll() {
		top = null;
	}
	
	/**
	 * Peeks at the item at the top of the stack
	 */
	public Object peek() throws StackException {
		if(!isEmpty()) {
			return top.getItem();
		}
		else {
			throw new StackException("StackException on " + "peek: stack empty");
		}
	}
}