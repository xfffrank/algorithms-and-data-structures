import java.util.*;

class BinarySearchTree<T extends Comparable> {
	public Node<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	private class Node<T> {
		public Node<T> left;
		public Node<T> right;
		private T value;

		public Node(T value) {
			this.value = value;
			left = null;
			right = null;
		}

		public T getValue() {
			return this.value;
		}

		public boolean isLeaf() {
			return (this.left == null && this.right == null);
		}

		public boolean hasOneChild() {
				return ((this.left == null && this.right != null) || (this.right == null && this.left != null));
		}
	}

	public void insert(Node<T> node, T value) {
		if (root == null) {
			root = new Node<T> (value);
			//System.out.println("test");
		}
		else {
			//System.out.println("123");
			int comResult = value.compareTo(node.getValue());

			if (comResult < 0) {
				if (node.left == null) {
					node.left = new Node<T> (value);
				}
				else {
					insert(node.left, value);
				}
			}
			else if (comResult > 0) {
				if (node.right == null) {
					node.right = new Node<T> (value);
				}
				else {
					insert(node.right, value);
				}
			}
			else {
				System.out.println("The element with the value of " + String.valueOf(value) +  " exists.");
			}
		}	
	}

	public void preorderTraversal(Node<T> root) {
		if (root != null) {
			System.out.println(root.getValue());
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	public void inorderTraversal(Node<T> root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.println(root.getValue());
			inorderTraversal(root.right);
		}
	}

	public void postorderTraversal(Node<T> root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.println(root.getValue());
		}
	}

	public void preOrderTraversal(Node<T> root) {
		Stack<Node> stack = new Stack<>();
		if (root == null) {
			return;
		}
		stack.push(root);
		while(!stack.isEmpty()) {
			Node<T> node = stack.pop();
			if (node != null) {
				System.out.println(node.getValue());
				stack.push(node.right);
				stack.push(node.left);
			}
		}
	}

	public void inOrderTraversal(Node<T> root) {
		Stack<Node> stack = new Stack<>();
		List<T>list = new ArrayList<T>();
		Node<T> current = root;

		while(current != null || !stack.empty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			list.add(current.getValue());
			current = current.right;
		}

		System.out.println(list);
	}

	public void postOrderTraversal(Node<T> root) {
		Stack<Node> stack = new Stack<>();
		List<T>list = new ArrayList<T>();
		Node<T> current = root;
		Node<T> lastVisit = null;

		while(current != null) {
			stack.push(current);
			current = current.left;
		}

		while(!stack.empty()) {
			current = stack.pop();

			if (current.right != null && current.right != lastVisit) {
				stack.push(current);
				current = current.right;

				while(current != null) {
					stack.push(current);
					current = current.left;
				}
			}
			else {
				list.add(current.getValue());
				lastVisit = current;
			}
		}

		System.out.println(list);
	}


	public void levelOrderTraversal(Node<T> root) {
		Queue<Node> queue = new LinkedList<Node>();

		if (root == null) {
			return;
		}

		queue.offer(root);
		List<T>resultList = new ArrayList<T>();

		while(!queue.isEmpty()) {
			// int levelSize = queue.size();
			if (queue.peek().left != null) {
				queue.offer(queue.peek().left);
			}
			if (queue.peek().right != null) {
				queue.offer(queue.peek().right);
			}
			
			Node<T> temp = queue.poll();
			resultList.add(temp.getValue());
			// System.out.println(queue.poll().getValue());
		}
		System.out.println(resultList);
	}

	public void deleteNode(T value) {
		Node<T> current = root;
		Node<T> pre = root;
		// 判断当前节点是不是其父节点的左孩子
		Boolean leftChild = false;


		while(current !=null && current.getValue() != value) {
			int comResult = value.compareTo(current.getValue());
			pre = current;

			if (comResult < 0) {
				current = current.left;
				leftChild = true;
			}
			else if (comResult > 0) {
				current = current.right;
			}
		}
		// 找不到值
		if (current == null) {
			System.out.println("Cannot match the value !");
			return;
		}

		// 若待删除的数是叶子节点
		if(current.isLeaf()) {
			if (leftChild == true) {
				pre.left = null;
			}
			else {
				pre.right = null;
			}
		}
		// 若待删除的节点仅有一个孩子节点
		else if(current.hasOneChild()) {
			if (leftChild == true) {
				if (current.left == null) {
					pre.left = current.right;
				}
				else {
					pre.left = current.left;
				}
			}
			else {
				if (current.left == null) {
					pre.right = current.right;
				}
				else {
					pre.right = current.left;
				}
			}
		}
		// 若待删除的节点有两个孩子节点
		else {
			//先找到右子树的最小节点
			Node<T> parentOfMinNode = current;
			Node<T> minNode = current.right;
			while(minNode.left != null) {
				parentOfMinNode = minNode;
				minNode = minNode.left;
			}
			// 将最小节点的值赋给当前节点
			current.value = minNode.value;
			// 删除最小节点，即将父节点指向子节点的指针置为空
			if (parentOfMinNode.left == minNode) {
				parentOfMinNode.left = null;
			}
			else if(parentOfMinNode.right == minNode) {
				parentOfMinNode.right = null;
			}
		}
		System.out.println("The node with the value of " + String.valueOf(current.getValue()) + " has been deleted");
		System.out.println("----preorder----");
		preorderTraversal(root);
	}


	public static void main(String[] args) {
		BinarySearchTree<Integer> bst  = new BinarySearchTree<>();

		int[] arr = {6, 4, 5, 2, 9, 7, 11, 11};
		for(int i = 0; i < arr.length; i++) {
			bst.insert(bst.root, arr[i]);
		}

		System.out.println("---Recursive Traversal---");

		System.out.println("1)preorder");
		bst.preorderTraversal(bst.root);

		System.out.println("2)inorder");
		bst.inorderTraversal(bst.root);

		System.out.println("3)postorder");
		bst.postorderTraversal(bst.root);

		System.out.println("---Non-recursive Traversal---");

		System.out.println("1)preorder");
		bst.preOrderTraversal(bst.root);

		System.out.println("2)inorder");
		bst.inOrderTraversal(bst.root);

		System.out.println("2)postorder");
		bst.postOrderTraversal(bst.root);

		System.out.println("---Level Order Traversal---");
		bst.levelOrderTraversal(bst.root);

		System.out.println("---Delete '11', it has no children---");
		bst.deleteNode(11);

		System.out.println("---Delete '9', it has one child---");
		bst.deleteNode(9);

		System.out.println("---Delete '6', it has two children---");
		bst.deleteNode(6);

		System.out.println("---Delete '12', it doesn't exist in the tree---");
		bst.deleteNode(12);
	}



}