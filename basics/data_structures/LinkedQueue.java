class LinkedQueue {
    public Node front, rear;

    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front==null && rear==null;
    }

    public void offer(int element) {
        Node temp = new Node(element);

        if (isEmpty()) {
            front = rear = temp;
        }
        else {
            rear.next = temp;
            rear = temp;
        }
    }

    public void poll() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }

        System.out.println(String.valueOf(front.value) + " is out of the queue.");
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    public void clearQueue() {
        front = rear = null;
    }

    public int peek() {
        return front.value;
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        for(int i = 0; i < 3; i++) {
            System.out.println("Offering " + String.valueOf(i + 1));
            queue.offer(i + 1);
        }

        for(int i = 0; i < 4; i++) {
            System.out.println("Pulling");
            queue.poll();
        }
    }
}