package ru.demi.algorithms.leetcode.topInterview150.linkedList;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of
 * the list from position left to position right, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class ReverseLinkedList2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode prev = null;
        var cur = head;
        ListNode beforeStart = null;
        ListNode tail = head;
        for (var i = 1; i <= right; i++) {
            if (i < left) {
                prev = cur;
                cur = cur.next;
                continue;
            }

            if (i == left) {
                beforeStart = prev;
                tail = cur;
            }

            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        if (beforeStart == null) {
            head = prev;
        } else {
            beforeStart.next = prev;
        }
        tail.next = cur;

        return head;
    }
}
