package ru.demi.algorithms.leetcode.topInterview150.linkedList;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 */
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        var n = 1;
        var end = head;
        for (; end.next != null; n++) {
            end = end.next;
        }
        end.next = head;

        var tail = head;
        for (var i = 0; i < n - k % n - 1; i++) {
            tail = tail.next;
        }

        var newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
