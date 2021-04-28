package com.crystalsantos.coding.stacks.queues;

public class MyCircularQueue {
	int[] queue;
	int head, tail;

	public MyCircularQueue(int k) {
		queue = new int[k];
		head = 0;
		tail = -1;
	}

	public boolean enQueue(int value) {

		if (isFull()) {
			return false;
		}
		
		tail = (tail + 1) % (queue.length);
		queue[tail] = value;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) { // empty queue
			return false;
		}

		if (head == tail) { // one element
			head = 0;
			tail = -1;
			return true;
		}
		queue[head] = -1;
		head = (head + 1) % (queue.length);
		return true;
	}

	public int Front() {
		if (isEmpty()) {
			return -1;
		} else {
			return queue[head];
		}
	}

	public int Rear() {
		if (isEmpty()) {
			return -1;
		} else {
			return queue[tail];
		}
	}

	public boolean isEmpty() {
		return tail == -1;
	}

	public boolean isFull() {
		if(isEmpty()) {
			return false;
		}
		
		return (tail + 1) % (queue.length) == head;
	}
	
	public static void main(String[] args) {
		MyCircularQueue queue = new MyCircularQueue(1);
		System.out.println(queue.enQueue(1));
		System.out.println(queue.enQueue(2));
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */