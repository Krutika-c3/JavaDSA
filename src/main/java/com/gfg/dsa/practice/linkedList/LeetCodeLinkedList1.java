package com.gfg.dsa.practice.linkedList;

public class LeetCodeLinkedList1 {

    private Node head;
    private Node tail;
    private int size;

    public LeetCodeLinkedList1() {
        this.size = 0;
    }


    public static void main(String[] args) {
        LeetCodeLinkedList1 sortedWithDuplicates = new LeetCodeLinkedList1();
        sortedWithDuplicates.insertAtLastIndexUsingHead(1);
        sortedWithDuplicates.insertAtLastIndexUsingHead(1);
        sortedWithDuplicates.insertAtLastIndexUsingHead(4);
        sortedWithDuplicates.insertAtLastIndexUsingHead(6);
        sortedWithDuplicates.insertAtLastIndexUsingHead(6);
        sortedWithDuplicates.insertAtLastIndexUsingHead(10);
        sortedWithDuplicates.displayLinkedList();

        sortedWithDuplicates.removeDuplicates();
        sortedWithDuplicates.displayLinkedList();

        LeetCodeLinkedList1 firstList = new LeetCodeLinkedList1();
        firstList.insertAtLastIndexUsingHead(2);
        firstList.insertAtLastIndexUsingHead(5);
        firstList.insertAtLastIndexUsingHead(7);
        LeetCodeLinkedList1 secondList = new LeetCodeLinkedList1();
        secondList.insertAtLastIndexUsingHead(1);
        secondList.insertAtLastIndexUsingHead(4);
        secondList.insertAtLastIndexUsingHead(7);
        secondList.insertAtLastIndexUsingHead(9);

        LeetCodeLinkedList1 mergedList = LeetCodeLinkedList1.merge(firstList, secondList);
        mergedList.displayLinkedList();

        LeetCodeLinkedList1 list = new LeetCodeLinkedList1();
        for (int i = 7; i > 0; i--) {
            list.insertAtLastIndexUsingHead(i);
        }
        list.displayLinkedList();
        list.bubbleSortUsingRecursion();
        list.displayLinkedList();
    }

    // Method to insert a new node at the first index
    private void insertAtFirstIndex(int value) {
        // Create a new node with the given value
        Node node = new Node(value);
        // Set the new node's next to the current head
        node.next = head;
        // Update the head to the new node
        head = node;
        // If the tail is null (list is empty), set the tail to the head
        // When first element is added, tail is initialised with it - as tail should represent the last element in the list
        if (tail == null) {
            tail = head;
        }
    }

    private void insertAtLastIndexUsingHead(int value) {
        if (tail == null) {
            insertAtFirstIndex(value);
        } else {
            Node temp = head;
            // Traverse the list until the last node
            while (temp.next != null) {
                temp = temp.next;
            }
            Node node = new Node(value);
            // Set the last node's next to the new node
            temp.next = node;
            // Update the tail to the new node
            tail = node;
        }
    }

    private Node findNodeWithValue(int value) {
        // Start from the head of the list
        Node node = head;

        // Traverse the list until the end
        while (node != null) {
            // Check if the current node's value matches the desired value
            if (node.value == value) {
                // If a match is found, return the current node
                return node;
            }
            // Move to the next node in the list
            node = node.next;
        }

        // If the value is not found, return null
        return null;
    }


    // Method to display the linked list
    private void displayLinkedList() {
        // Temporary node to traverse the list
        Node temp = head;

        // Traverse and print the list elements
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        // Print the end of the list
        System.out.print("END");

        System.out.println();
        System.out.println("size: " + size);
        System.out.println("head: " + head.value);
        System.out.println("tail: " + tail.value);

    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list
    public void removeDuplicates() {
        Node node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    // Time complexity: O(m+n)
    public static LeetCodeLinkedList1 merge(LeetCodeLinkedList1 first, LeetCodeLinkedList1 second) {
        Node f = first.head;
        Node s = second.head;

        LeetCodeLinkedList1 ans = new LeetCodeLinkedList1();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertAtLastIndexUsingHead(f.value);
                f = f.next;
            } else {
                ans.insertAtLastIndexUsingHead(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertAtLastIndexUsingHead(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertAtLastIndexUsingHead(s.value);
            s = s.next;
        }

        return ans;
    }

    public void bubbleSortUsingRecursion() {
        bubbleSortUsingRecursion(size - 1, 0);
    }

    private void bubbleSortUsingRecursion(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = findNodeWithValue(col);
            Node second = findNodeWithValue(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = findNodeWithValue(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = findNodeWithValue(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSortUsingRecursion(row, col + 1);
        } else {
            bubbleSortUsingRecursion(row - 1, 0);
        }
    }

    // recursion reverse
    private void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    public void reverse() {
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
            size++;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
            size++;
        }
    }
}
