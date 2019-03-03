class LinkedStack <T> {
	private Node<T> top;
	private int maxSize;
	private int count;

	public LinkedStack(int size) {
		maxSize = size;
		top = null;
		count = 0;
	}

	public void push(T element) {
		if (top == null) {
			top = new Node<T> (element);
			count ++;
		}
		else if (!isFull()) {
			Node<T> node = new Node<T> (element);
			node.next = top;
			top = node;
			count ++;
		}
		else {
			System.out.println("The stack is full ! You can't push.");
		}

	}

	public T pop() {

		if (!isEmpty()) {
			T temp = top.getValue();
			top = top.next;
			count--;

			return temp;
		}
		else {
			System.out.println("The stack is empty ! You can't pop.");
			throw new IllegalArgumentException();
		}

	}

	public T getTop() {
		if(!isEmpty()) {
			return top.getValue();
		}
		else {
			System.out.println("The stack is empty !");
			throw new IllegalArgumentException();
		}
		
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public boolean isFull() {
		return (count == maxSize);
	}

	public void emptyStack() {
		top = null;
		count = 0;
	}

	private class Node<T> {
		private T value;
		public Node<T> next;

		public Node(T element) {
			value = element;
			next = null;
		} 

		public T getValue() {
			return value;
		}
	}

	public static void main(String[] args) {
		int maxSize = 3;
		LinkedStack<Integer> s = new LinkedStack<> (maxSize);

		System.out.println("pushing 2");
		s.push(2);
		System.out.println("pushing 5");
		s.push(5);
		System.out.println("pushing 3");
		s.push(3);
		System.out.println("pushing 6");
		s.push(6);

		System.out.println("The top value is " + s.getTop());
		System.out.println("popping...");
		int temp = s.pop();
		System.out.println("Now the top value is " + s.getTop());

		System.out.println("Now we make the stack empty.");
		s.emptyStack();
		System.out.println("Try getting the top value...");
		System.out.println(s.getTop());
	}
}

