public class LinkedStackImproved<Item> {
    private Node first;
    private int N = 0;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        Item item = first.item;
        return item;
    }
    public static void main(String[] args) {
        LinkedStackImproved<Integer> stack = new LinkedStackImproved<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while(!stack.isEmpty()) {
            int i = stack.pop();
            System.out.println(i);
        }
    }

}