import java.util.Arrays;

class SeqQueue {
    public int size;
    public int[] queue;
    public int front = 0;
    public int rear = 0;


    SeqQueue (int size) {
        this.size = size;
        this.queue = new int[size];
    }

    public void offer(int value) {
        if (isFull()) {
            System.out.println("The queue is full !");
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % size;
    }

    public int poll() {
        if (isEmpty()) {
            return -1;
        }

        int temp = queue[front];
        queue[front] = 0; // 没有实际意义，便于演示数据的理解
        front = (front + 1) % size;

        return temp;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isFull() {
        return ((this.rear + 1) % this.size == front);
    }

    public boolean isEmpty() {
        return (this.rear == this.front);
    }

    public static void main(String[] args) {
        SeqQueue test = new SeqQueue(4);

        for (int i = 1; i < 5; i++) {
            System.out.println("---offer " + String.valueOf(i) + "---");
            test.offer(i);
            System.out.println(Arrays.toString(test.queue));
        }

        for (int i = 1; i < 5; i++) {
            System.out.println("---poll---");
            int temp = test.poll();
            if (temp == -1) {
                System.out.println("The queue is empty");
            }
            else {
                System.out.print(temp);
                System.out.println(" is out of the queue.");
            }
        }

        for (int i = 1; i < 5; i++) {
            System.out.println("---offer " + String.valueOf(i) + "---");
            test.offer(i);
            System.out.println(Arrays.toString(test.queue));
            // System.out.println(test.front);
            // System.out.println(test.rear);
        }
    }

}