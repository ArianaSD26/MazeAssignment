
/**
 * Stack interface operations
 */
public interface StackInterface {
	
	/**
	 * Finds out if stack is empty
	 * @return true if stack is empty and false if not
	 */
	public boolean isEmpty();
	
	/**
	 * Pops all items
	 */
	public void popAll();
	
	/**
	 * Pushes item into stack
	 * @param the object item
	 */
	public void push(Object i) throws StackException;
	
	/**
	 * Pops an item at the top of the stack
	 */
	public Object pop() throws StackException;
	
	/**
	 * Peeks at the item at the top of the stack
	 */
	public Object peek() throws StackException;
}
