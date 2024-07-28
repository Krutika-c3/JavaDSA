package com.gfg.dsa.practice.linkedList;

public class LeetCodeLinkedList2 {

    // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    // https://youtu.be/ugQ2DVJJroc?si=vjDMAuwQss7puqrp
    // Time complexity - O(n)
    // Space complexity - O(1)
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode present = head;

        while (present != null) {
            ListNode next = present.next; // move by 1 step
            present.next = prev; // break link to next - now current will be linked(next) to previous
            prev = present; // move by 1 step
            present = next; // move by 1 step
        }
        return prev; // return head i.e. first element
    }

    // Google, Microsoft, Facebook: https://leetcode.com/problems/reverse-linked-list-ii/
    // https://youtu.be/oDL8vuu2Q0E?si=wUoix1gAw4VqhQdp
    // Time complexity: O(n)
    // Space complexity: O(1)
    ListNode reverseBetween(ListNode head, int left, int right) {
        // create a dummy  ListNode to mark the head of this list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // make markers for currentNode and for the ListNode before reversing
        ListNode leftPre = dummy;
        ListNode currNode = head;

        for (int i = 0; i < left - 1; i++) { // iterate till the elemenet sub list that needs to be reversed
            leftPre = leftPre.next; // move by 1 step
            currNode = currNode.next; // move by 1 step
        }
        // leftPre will now point to  ListNode before which we want to reverse

        // subListHead will point to where we will start reversing from
        ListNode subListHead = currNode;

        ListNode preNode = null;
        for (int i = 0; i < right - left + 1; i++) { // iterate through the sub list which needs to be reversed
            ListNode next = currNode.next; // move by 1 step
            currNode.next = preNode; // break link to next - now current will be linked (next) to previous
            preNode = currNode; // move by 1 step
            currNode = next; // move by 1 step
        }
        // preNode will now point to last element of sublist
        // currNode will now point to  ListNode after sublist

        // Join the pieces
        leftPre.next = preNode; // leftPre ( ListNode before which we want to reverse) will be linked (next) to last element of sublist
        subListHead.next = currNode; // subListHead (start of sub list) will be linked (next) to currNode ( ListNode after sublist)

        return dummy.next; // return the head  ListNode
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/
    /*
        Slow pointer covers half the distance of the fast pointer
     */
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        // loop continues until the fastPointer can no longer move two steps ahead.
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // move by 1 step
            fastPointer = fastPointer.next.next; // move by 2 step
        }
        return slowPointer; // when fast will be at the last index, slow will reach the middle
    }

    // linkedin, google, facebook, microsoft, amazon, apple
    // https://leetcode.com/problems/palindrome-linked-list/
    /*
        1. Find middle
        2. Reverse the second half
        3. Compare first and second half
        4. Re-reverse the second half to return the orignal list
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecondHalf = reverseList(mid); // reverse second half of the list
        ListNode rereverseHead = headSecondHalf;
        // rereverseHead will now have lastNode

        // compare both the halves
        while (head != null && headSecondHalf != null) {
            if (head.val != headSecondHalf.val) {
                break; // meaning the list is not pallindrome - break from loop
            }
            head = head.next; // move by 1 step to comapre next elements
            headSecondHalf = headSecondHalf.next; // move by 1 step to comapre next elements
        }
        // re-reverse list
        reverseList(rereverseHead);
        return head == null || headSecondHalf == null;
    }

    // https://leetcode.com/problems/reorder-list/
    // Google, Facebook
    /*
        1. Find middle
        2. Reverse the second half
        3. Take first element from the start
        4. Take first element from the middle
        5. Move both start and middle to next pointer
        keep repeating 3 and 4
        Time Complexity: O(n)

     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) { // no elements in list
            return;
        }

        ListNode middleNode = middleNode(head);

        ListNode headFirst = head;
        ListNode headSecondHalf = reverseList(middleNode);

        // rearrange elements
        while (headFirst != null && headSecondHalf != null) { // iterate till the list is over
            ListNode temp = headFirst.next;
            headFirst.next = headSecondHalf; // connect hs with hf
            headFirst = temp; // move hf to previous next

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirst; // connect hs to previous new hf
            headSecondHalf = temp; // move hs to previous next
        }

        // connect next of tail to null
        if (headFirst != null) {
            headFirst.next = null;
        }
    }

    // google, amazon, facebook, microsoft: https://leetcode.com/problems/reverse-nodes-in-k-group/
    /*
        Similary to reverseBetween()

     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // If the list is empty or k is 1, no need to reverse, just return the head
        if (head == null || k == 1) {
            return head;
        }

        // Create a dummy node to handle edge cases easily (e.g., reversing the first k nodes)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode curr = dummy, next = dummy, prev = dummy;
        int count = 0;

        // Count the total number of nodes in the linked list
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Loop until we have fewer than k nodes remaining
        while (count >= k) {
            curr = prev.next; // The first node of the current group
            next = curr.next; // The second node of the current group
            // Reverse the nodes within the group
            for (int i = 1; i < k; i++) {
                curr.next = next.next; // Point current node to the node after next
                next.next = prev.next; // Move next node to the beginning of the reversed part
                prev.next = next;      // Update prev to point to the new beginning of the reversed part
                next = curr.next;      // Move next to the next node to be processed
            }
            prev = curr; // Move prev to the end of the reversed part
            count -= k;  // Reduce the count by k as we have processed k nodes
        }

        // Return the new head, which is the next node of the dummy node
        return dummy.next;
    }

    private int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    // FaceBook, Twitter, Google: https://leetcode.com/problems/rotate-list/
    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        // calculate total length of the list

        last.next = head; // connect last element with the orignal first element
        int rotations = k % length; // calculate how many elements are to be rotated
        int skip = length - rotations; // jump length-rotation times to get to last k nodes
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) { // iterate an element before we want to skip
            newLast = newLast.next;
        }
        // newLast will now point to element before last k nodes
        head = newLast.next; // head will now point to first element of k nodes
        newLast.next = null; // make the new last element have next as null

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}