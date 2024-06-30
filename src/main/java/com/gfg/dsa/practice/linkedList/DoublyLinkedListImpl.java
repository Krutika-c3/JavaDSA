package com.gfg.dsa.practice.linkedList;

/**
 * This class implements a Doubly Linked List.
 * In a Doubly Linked List, each node contains a reference to both the next and the previous node.
 * This allows traversal of the list in both directions, making certain operations more efficient.
 *
 * Properties:
 * - Each node has three fields: value, next (reference to the next node), and prev (reference to the previous node).
 * - The head of the list points to the first node.
 * - The size variable keeps track of the number of nodes in the list.
 */
public class DoublyLinkedListImpl {

    private Node head; // Head of the list

    public static void main(String[] args) {
        DoublyLinkedListImpl doublyLinkedList = new DoublyLinkedListImpl();

        doublyLinkedList.insertAtFirstIndex(8);
        doublyLinkedList.insertAtFirstIndex(2);
        doublyLinkedList.insertAtFirstIndex(4);
        doublyLinkedList.insertAtFirstIndex(7);

        doublyLinkedList.displayDoublyLinkedList();
        doublyLinkedList.displayDoublyLinkedListInReverse();

        doublyLinkedList.insertAtLastIndex(100);
        doublyLinkedList.displayDoublyLinkedList();

        doublyLinkedList.insertAfterValue(2, 1111);
        doublyLinkedList.displayDoublyLinkedList();

        doublyLinkedList.deleteAfterValue(7);
        doublyLinkedList.displayDoublyLinkedList();
    }

    // Method to get the last node in the list
    private static Node getLastNode(Node head) {
        // Start from the head node
        Node lastNode = head;
        // Traverse to the end of the list
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        // Return the last node
        return lastNode;
    }

    // Method to insert a new node at the first index
    private void insertAtFirstIndex(int value) {
        // Create a new node with the given value
        Node node = new Node(value);
        // Set the new node's next to the current head
        node.next = head;
        // Set the new node's prev to null as it will be the new head
        node.prev = null;
        // If the list is not empty, set the current head's prev to the new node
        if (head != null) {
            head.prev = node;
        }
        // Update the head to the new node
        head = node;
    }

    // Method to insert a new node at the last index
    private void insertAtLastIndex(int value) {
        // Create a new node with the given value
        Node node = new Node(value);
        // Set the new node's next to null as it will be the new tail
        node.next = null;
        // Get the last node in the list
        Node lastNode = getLastNode(head);
        // Set the new node's prev to the last node
        node.prev = lastNode;
        // If the list is not empty, set the last node's next to the new node
        if (lastNode != null) {
            lastNode.next = node;
        } else {
            // If the list was empty, set the head to the new node
            head = node;
        }
    }

    // Method to insert a new node after a node with a specific value
    private void insertAfterValue(int afterValue, int value) {
        // Create a new node with the given value
        Node node = new Node(value);
        // Find the node with the specified value
        Node previousNode = findNode(afterValue);
        // If the node is not found, print a message and return
        if (previousNode == null) {
            System.out.println("Node does not exist!");
            return;
        }
        // Get the node after the node with the specified value
        Node afterNode = previousNode.next;
        // Set the new node's prev to the previous node
        node.prev = previousNode;
        // Set the new node's next to the after node
        node.next = afterNode;
        // Set the previous node's next to the new node
        previousNode.next = node;
        // If the after node is not null, set its prev to the new node
        if (afterNode != null) {
            afterNode.prev = node;
        }
    }

    // Method to find a node with a specific value
    private Node findNode(int value) {
        // Start from the head node
        Node currentNode = head;
        // Traverse the list until the node with the specified value is found
        while (currentNode != null && currentNode.value != value) {
            currentNode = currentNode.next;
        }
        // Return the node, or null if not found
        return currentNode;
    }

    // Method to display the linked list from head to tail
    private void displayDoublyLinkedList() {
        // Start from the head node
        Node node = head;
        // Traverse the list and print each node's value
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        // Print the end of the list
        System.out.println("END");
    }

    // Method to display the linked list from tail to head
    private void displayDoublyLinkedListInReverse() {
        // Get the last node in the list
        Node lastNode = getLastNode(head);
        // Traverse the list in reverse and print each node's value
        while (lastNode != null) {
            System.out.print(lastNode.value + " -> ");
            lastNode = lastNode.prev;
        }
        // Print the start of the list
        System.out.println("START");
    }

    // Method to delete the node after a node with a specific value
    private void deleteAfterValue(int value) {
        // Find the node with the specified value
        Node prevNode = findNode(value);
        // If the node is not found, print a message and return
        if (prevNode == null) {
            System.out.println("Node with value " + value + " does not exist!");
            return;
        }
        // Get the node to be deleted (the node after the found node)
        Node nodeToDelete = prevNode.next;
        // If there is no node to delete, print a message and return
        if (nodeToDelete == null) {
            System.out.println("No node exists after the node with value " + value + "!");
            return;
        }
        // Get the node after the node to be deleted
        Node nextNode = nodeToDelete.next;
        // Set the prev node's next to the next node
        prevNode.next = nextNode;
        // If the next node is not null, set its prev to the prev node
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
    }

    private class Node {
        private int value; // The value of the node
        private Node next; // Reference to the next node
        private Node prev; // Reference to the previous node

        public Node(int value) {
            this.value = value;
        }
    }
}