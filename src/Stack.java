
public class Stack implements StackInterface {
	private Node top;
	
	public Stack() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(Object i) {
		top = new Node(i, top);
	}
	
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
	
	public void popAll() {
		top = null;
	}
	
	public Object peek() throws StackException {
		if(!isEmpty()) {
			return top.getItem();
		}
		else {
			throw new StackException("StackException on " + "peek: stack empty");
		}
	}
}