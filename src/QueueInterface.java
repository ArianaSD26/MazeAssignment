
public interface QueueInterface {
	public boolean isEmpty();
	public void enqueue(Object i) throws QueueException;
	public Object dequeue() throws QueueException;
	public void dequeueAll();
	public Object peek() throws QueueException;
}
