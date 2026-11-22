
public class Node {
	private Object item;
	private Node next;
	
	public Node(Object i) {
		item = i;
		next = null;
	}
	
	public Node(Object i, Node n) {
		item = i;
		next = n;
	}
	
	public Object getItem() {
		return item;
	}
	
	public void setItem(Object i) {
		item = i;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
}
