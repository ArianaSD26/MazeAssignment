
public interface StackInterface {
	public boolean isEmpty();
	public void popAll();
	public void push(Object i) throws StackException;
	public Object pop() throws StackException;
	public Object peek() throws StackException;
}
