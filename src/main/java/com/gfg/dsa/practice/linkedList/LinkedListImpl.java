package com.gfg.dsa.practice.linkedList;

/*
    Every Node has a value and a next variable that will have a reference (point) to the next object.
    Head should always point to the first element in the list.
    Tail should always point to the last element in the list.
    Size keeps track of the number of elements in the list.
 */
public class LinkedListImpl {

    private Node head;
    private Node tail;
    private int size;

    public LinkedListImpl() {
        this.size = 0;
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.insertAtFirstIndex(1);
        linkedList.insertAtFirstIndex(3);
        linkedList.insertAtFirstIndex(2);
        linkedList.displayLinkedList();

        linkedList.insertAtLastIndexUsingTail(5);
        linkedList.insertAtLastIndexUsingTail(10);
        linkedList.displayLinkedList();

        linkedList.insertAtLastIndexUsingHead(15);
        linkedList.insertAtLastIndexUsingHead(20);
        linkedList.displayLinkedList();

        // indexing starts from 0
        linkedList.insertAfterIndex(3, 100);
        linkedList.displayLinkedList();

        linkedList.deleteFromFirstIndex();
        linkedList.displayLinkedList();

        linkedList.deleteFromLastIndex();
        linkedList.displayLinkedList();

        // indexing starts from 0
        linkedList.deleteAfterIndex(3);
        linkedList.displayLinkedList();

        Node node = linkedList.findNodeWithValue(100);
        if(node != null) {
            System.out.println("Node: value " + node.value + " next " + node.next.value);
        }
        linkedList.displayLinkedList();

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

    private void insertAtLastIndexUsingTail(int value) {
        // If the tail is null, the list is empty, insert at the first index
        if (tail == null) {
            insertAtFirstIndex(value);
        } else {
            // Create a new node with the given value
            Node node = new Node(value);
            // Set the current tail's next to the new node
            tail.next = node;
            // Update the tail to the new node
            tail = node;
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

    private void insertAfterIndex(int index, int value) {
        // If index is 0, insert the new node at the first index
        if (index == 0) {
            insertAtFirstIndex(value);
            return;
        }
        // If index is equal to the size of the list, insert the new node at the last index using the tail
        else if (index == size) {
            insertAtLastIndexUsingTail(value);
        }
        // Otherwise, insert the new node after the specified index
        else {
            Node temp = head;
            for (int element = 1; element < index; element++) {
                // this will point to given index i.e. 1
                temp = temp.next;
            }
            // Create a new node with the given value and the next node reference i.e. 100 -> 5
            Node node = new Node(value, temp.next);
            // Set the next reference of the node at the specified index to the new node i.e. 1 -> 100
            temp.next = node;
        }
    }

    private void deleteFromFirstIndex() {
        // Move the head pointer to the next node
        head = head.next;
        // If the list is now empty, also set the tail to null
        if (head == null) {
            tail = null;
        }
        // Decrease the size of the list by one
        size--;
    }

    private void deleteFromLastIndex() {
        // If there's only one item in the list, delete from the first index
        if (size <= 1) {
            deleteFromFirstIndex();
            return;
        }

        // Get the second last node in the list
        Node secondLastNode = getIndexValue(size - 2);
        // Update the tail to be the second last node
        tail = secondLastNode;
        // Remove the reference to the last node, effectively deleting it
        tail.next = null;
        // Decrement the size of the list
        size--;
    }

    public void deleteAfterIndex(int index) {
        // If the index is the first element, delete from the first index
        if (index == 0) {
            deleteFromFirstIndex();
            return;
        }
        // If the index is the last element, delete from the last index
        if (index == size - 1) {
            deleteFromLastIndex();
            return;
        }

        // Get the node before the one to be deleted
        Node prev = getIndexValue(index - 1);
        // Update the previous node's next reference to skip the deleted node
        prev.next = prev.next.next;
        // Decrement the size of the list
        size--;
    }

    private Node getIndexValue(int index) {
        // Start from the head of the list
        Node node = head;
        // Traverse the list to get to the desired index
        for (int element = 0; element < index; element++) {
            node = node.next;
        }
        // Return the node at the specified index
        return node;
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
