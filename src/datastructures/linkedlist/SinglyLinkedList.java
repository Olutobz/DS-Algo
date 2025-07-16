package datastructures.linkedlist;

import org.w3c.dom.Node;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 16, July 2025
 * EMAIL: damexxey94@gmail.com
 */


public class SinglyLinkedList {

    ListNode head;

    private void append(int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    private static class ListNode {
        private int data;
        ListNode next;

        ListNode() {}

        ListNode(int data) {
            this.data = data;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}



