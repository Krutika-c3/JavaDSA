package com.gfg.dsa.practice.linkedList;

/*
    When to use Fast and Slow Pointer Approach:
    - Cycle detection (is cycle present or not/ no of elements in a cycle/…..)
    - Find a node (middle…), etc
 */
public class LeetcodeLLSlowAndFastPointer {

    // https://leetcode.com/problems/linked-list-cycle
    // Amazon and Microsoft
    // Cycle detection problem - use slow and fast pointer method
    // Time Complexity = O(n)
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        // loop continues until the fastPointer can no longer move two steps ahead.
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }

    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        // loop continues until the fastPointer can no longer move two steps ahead.
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                // calculate the length
                ListNode temp = slowPointer;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != fastPointer);
                return length;
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    // Time complexity: O(n)
    // Space complexity: O(1)
    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        // loop continues until the fastPointer can no longer move two steps ahead.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // Google: https://leetcode.com/problems/happy-number/
    /*
        If a number is not a happy number: it will form some kind of circle as shown in: 12IsNotAHappyNumber.png
     */
    public boolean isHappy(int n) {
        int slowPointer = n;
        int fastPointer = n;

        do {
            slowPointer = findSumOfSquareOfEachDigits(slowPointer); // move a step ahead
            fastPointer = findSumOfSquareOfEachDigits(findSumOfSquareOfEachDigits(fastPointer)); // because we want to move two steps ahead
        } while (slowPointer != fastPointer);

        if (slowPointer == 1) {
            return true;
        }
        return false;
    }

    private int findSumOfSquareOfEachDigits(int number) {
        //eg: number = 145
        int ans = 0;
        while (number > 0) {
            /*
                1. 5 is the remainder
                2. 4 is the remainder
                3. 1 is the remainder
             */
            int rem = number % 10;
            /*
                1. 5 * 5 = 25
                2. 25 + 4 * 4 = 41
                3. 41 + 1 * 1 = 42
             */
            ans += rem * rem;
            /*
                 1. number will now be 14
                 2. number will now be 1
                 3. number will now be 0
             */
            number /= 10;
        }
        return ans;
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

    // https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode last = prev;
            ListNode newEnd = current;

            // reverse between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            // skip the k nodes
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
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