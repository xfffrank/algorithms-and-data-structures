class SeqStack {
	private int maxSize;
	private int top;
	private int[] array;

	public SeqStack (int size) {
		maxSize = size;
		array = new int [maxSize];
		top = -1;
	}

	public void push(int value) {
		if (! isFull()) {
			array[++top] = value;
		}
		else {
			System.out.println("The stack is full !");
		}
	}

	public int pop() {
		if(! isEmpty()) {
			return array[top--];
		}
		else {
			System.out.println("The stack is empty !");
			throw new IllegalArgumentException();
		}
	}

	public int top() {
		if (! isEmpty()) {
			return array[top];
		}
		else {
			System.out.println("The stack is empty !");
			throw new IllegalArgumentException();
		}
	}

	public boolean isFull() {
		return (top + 1 == maxSize);
	}

	public boolean isEmpty() {
		return (top + 1 == 0);
	}

	public void emptyStack() {
		top = -1;
	}

	public static void main(String[] args) {
		System.out.println("Initialize the stack with a max size of 3.");
		SeqStack s = new SeqStack(3);

		if(s.isEmpty()) {
			System.out.println("The stack is empty !");
		}

		System.out.println("push 2");
		s.push(2);
		System.out.println("push 5");
		s.push(5);
		System.out.println("push 3");
		s.push(3);
		System.out.println("push 6");
		s.push(6);

		System.out.println("The top value is " + s.top());

		System.out.println("popping...");
		int temp = s.pop();
		System.out.println("Now the top value is " + s.top());
		System.out.println("Now we make the stack empty.");
		s.emptyStack();
		System.out.println("Try getting the top value...");
		s.top();
	}
}