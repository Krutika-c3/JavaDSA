package com.gfg.dsa.practice.linkedList;

/**
 * This class implements a Circular Linked List.
 * In a Circular Linked List, the last node points to the first node, making the list circular.
 * The head points to the first node and the tail points to the last node.
 *
 * Properties:
 * - Each node has two fields: value and next (reference to the next node).
 * - The list is circular, meaning the tail's next reference points back to the head.
 * - The head and tail are only null if the list is empty.
 */
public class CircularLinkedList {

    Node head; // Head of the list
    Node tail; // Tail of the list

    public static void main(String[] args) {
        // Create a new circular linked list
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        // Insert elements at the start of the list
        circularLinkedList.insertAtStart(1);
        circularLinkedList.insertAtStart(7);
        circularLinkedList.insertAtStart(3);
        circularLinkedList.insertAtStart(9);

        // Display the circular linked list
        circularLinkedList.displayCircularLinkedList();

        // Delete a node with a specific value from the list
        circularLinkedList.deleteNodeWithValue(3);

        // Display the circular linked list again
        circularLinkedList.displayCircularLinkedList();
    }

    // Method to insert a new node at the start of the list
    private void insertAtStart(int value) {
        // Create a new node with the given value
        Node node = new Node(value);

        // If the list is empty (head and tail are null)
        if (head == null) {
            // Set both head and tail to the new node
            head = node;
            tail = node;
            // Set the tail's next reference to head to make the list circular
            tail.next = head;
        } else {
            // Otherwise, set the new node's next to the current head
            node.next = head;
            // Set the tail's next to the new node to keep the list circular
            tail.next = node;
            // Update the head to the new node
            head = node;
        }
    }

    // Method to display the circular linked list
    public void displayCircularLinkedList() {
        // Start from the head node
        Node node = head;
        // If the list is not empty
        if (head != null) {
            // Traverse the list and print each node's value
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            } while (node != head); // Continue until we reach the head again
        }
        // Print the head reference to indicate the circular nature
        System.out.println("HEAD");
    }

    // Method to delete a node with a specific value from the list
    private void deleteNodeWithValue(int value) {
        // If the list is empty, print a message and return
        if (head == null) {
            System.out.println("List is empty, hence nothing to delete");
            return;
        }

        // Start from the head node
        Node previousNode = head;

        // If the head node has the value to be deleted
        if (previousNode.value == value) {
            // Update the head to the next node
            head = head.next;
            // Update the tail's next reference to the new head to keep the list circular
            tail.next = head;
            return;
        }

        // Traverse the list to find the node with the specified value
        do {
            // Get the node to be deleted (the node after the previous node)
            Node nodeToDelete = previousNode.next;
            // If the node to be deleted has the specified value
            if (nodeToDelete.value == value) {
                // Update the previous node's next reference to skip the node to be deleted
                previousNode.next = nodeToDelete.next;
                // If the node to be deleted is the tail, update the tail to the previous node
                if (nodeToDelete == tail) {
                    tail = previousNode;
                }
                break;
            }
            // Move to the next node
            previousNode = previousNode.next;
        } while (previousNode != head); // Continue until we reach the head again
    }

    // Inner class to represent a node in the circular linked list
    private class Node {
        int value; // The value of the node
        Node next; // Reference to the next node

        public Node(int value) {
            this.value = value;
        }
    }
}