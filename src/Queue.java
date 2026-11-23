
/**
 * Array Based Queue
 */
public class Queue implements QueueInterface{
	/**
	 * Declares variables for maximum queue size, items, front and back of the queue and count
	 */
	private final int MAX_QUEUE = 1000000;
	private Object[] items;
	private int front, back, count;
	
	/**
	 * Constructs the queue with items, front, back and count
	 */
	public Queue() {
		items = new Object[MAX_QUEUE];
		front = 0;
		back = MAX_QUEUE-1;
		count = 0;
	}
	
	/**
	 * Finds out if queue is empty
	 * @return true if queue is empty and false if not
	 */
	public boolean isEmpty() {
		return count == 0;
	}
	
	/**
	 * Finds out of queue is full
	 * @return true if queue is full and false if not
	 */
	public boolean isFull() {
		return count == MAX_QUEUE;
	}
	
	/**
	 * Enqueues item
	 * @param the object item
	 */
	public void enqueue(Object i) {
		if(!isFull()) {
			back = (back+1) % (MAX_QUEUE);
			items[back] = i;
			++count;
		}
		else {
			throw new QueueException("QueueException on enqueue: " + "Queue full");
		}
	}
	
	/**
	 * Dequeues item at the front
	 */
	public Object dequeue() throws QueueException {
		if(!isEmpty()) {
			Object queueFront = items[front];
			front = (front+1) % (MAX_QUEUE);
			--count;
			return queueFront;
		}
		else {
			throw new QueueException("QueueException on dequeue: " + "Queue empty");
		}
	}
	
	/**
	 * Dequeues all items
	 */
	public void dequeueAll() {
		items = new Object[MAX_QUEUE];
		front = 0;
		back = MAX_QUEUE-1;
		count = 0;
	}
	
	/**
	 * Peeks at the item at the front of the queue
	 */
	public Object peek() throws QueueException {
		if(!isEmpty()) {
			return items[front];
		}
		else {
			throw new QueueException("Queue exception on peek: " + "Queue empty");
		}
	}
}
