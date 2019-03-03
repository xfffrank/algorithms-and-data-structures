class SinglyLinkedList<T> {
	private Node<T> head;
	public SinglyLinkedList() {
		head = null;
	}

	private class Node<T> {
		public T value;
		public Node<T> next;

		Node(T element) {
			this.value = element;
			this.next = null;
		}

		public T getValue() {
			return value;
		}
	}

	public void addNode(T value) {
		Node<T> newNode = new Node<>(value);

		if (head == null) {
			head = newNode;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
	}

	public int getLength() {
		Node<T> tmp = head;
		int len = 0;

		while (tmp != null) {
			len ++;
			tmp = tmp.next;
		}
		
		return len;
	}

	/*
	正序遍历
	*/
	public void traverseList() {
		Node<T> current = head;
		while(current != null) {
			System.out.print(current.getValue() + " ");
			current = current.next;
		}
		System.out.println();
	}

	/* 
	倒序遍历
	*/
	public void traverseListRev(Node<T> head) {
		if (head != null) {
			traverseListRev(head.next);
			System.out.print(head.getValue() + " ");
		}
	}

	public void deleteNode(int index) {
		if (index < 1 || index > getLength()) {
			return;
		}
		if (index == 1) {
			head = head.next;
			return;
		}
		int i = 2;
		Node<T> prev = head;
		Node<T> current = prev.next;
		while (i < index) {
			prev = current;
			current = current.next;
			i++;
		}
		prev.next = current.next;
	}

	public void reverseList() {
		if (head == null) {
			return;
		}
		else {
			Node<T> prev = null;
			Node<T> current = head;

			while (current != null) {
				//System.out.println(current.getValue());

				Node<T> nextNode = current.next;
				if (nextNode == null) {
					head = current;
				}

				current.next = prev;
				//nextNode.next = current;
				prev = current;

				current = nextNode;
			}

			System.out.println("单链表反转后正序遍历：");
			traverseList();
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
		l.addNode(3);
		l.addNode(5);
		l.addNode(4);
		l.addNode(8);

		System.out.println("正序遍历结果：");
		l.traverseList();

		System.out.println("倒序遍历结果：");
		l.traverseListRev(l.head);
		System.out.println();

		System.out.println("单链表长度为：" + l.getLength());

		l.deleteNode(4);
		System.out.println("删除第四个元素后，正序遍历结果为：");
		l.traverseList();
		

		l.reverseList();
	}
}