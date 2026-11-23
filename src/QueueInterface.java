
/**
 * Queue interface operations
 */
public interface QueueInterface {
	/**
	 * Finds out if queue is empty
	 * @return true if queue is empty and false if not
	 */
	public boolean isEmpty();
	
	/**
	 * Enqueues item
	 * @param the object item
	 */
	public void enqueue(Object i) throws QueueException;
	
	/**
	 * Dequeues item at the front
	 */
	public Object dequeue() throws QueueException;
	
	/**
	 * Dequeues all items
	 */
	public void dequeueAll();
	
	/**
	 * Peeks at the item at the front of the queue
	 */
	public Object peek() throws QueueException;
}
