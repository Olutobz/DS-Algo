package other;


import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(14);
        list.addLast(40);
        System.out.println(list.contains(14));
        int index = list.indexOf(40);
        System.out.println("The index of 40 is: " + index);
        System.out.println(list.isEmpty());
        list.removeFirst();
        list.removeLast();
    }

    private boolean isEmpty() {
        return head == null;
    }

    // O(1)
    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    // O(1)
    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node pointer = head.next;
        head.next = null;
        head = pointer;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = getPreviousNode(tail);
        if (tail != null) {
            tail.next = null;
        }
    }

    private Node getPreviousNode(Node node) {
        Node current = head;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // O(n)
    public int indexOf(int item) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (item == current.data) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    private static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

}
