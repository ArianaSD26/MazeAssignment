/**
 * A node in a data structure
 */
public class Node {
	/**
	 * Declares variables for item and next node
	 */
	private Object item;
	private Node next;
	
	/**
	 * Constructs a node with a specified item and next reference
	 * @param i
	 */
	public Node(Object i) {
		item = i;
		next = null;
	}
	
	/**
	 * Constructs a node with a specified item and next reference
	 * @param i
	 * @param n
	 */
	public Node(Object i, Node n) {
		item = i;
		next = n;
	}
	
	/**
	 * Gets item object
	 * @return the item object
	 */
	public Object getItem() {
		return item;
	}
	
	/**
	 * Sets item object
	 * @param i takes in object
	 */
	public void setItem(Object i) {
		item = i;
	}
	
	/**
	 * Gets the next node
	 * @return the next node
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * Sets the next node
	 * @param n takes in the next node
	 */
	public void setNext(Node n) {
		next = n;
	}
	
}
