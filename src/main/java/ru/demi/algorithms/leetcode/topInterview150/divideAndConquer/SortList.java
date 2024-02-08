package ru.demi.algorithms.leetcode.topInterview150.divideAndConquer;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 10^4].
 * -10^5 <= Node.val <= 10^5
 */
public class SortList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        var mid = getMid(head);
        var left = sortList(head);
        var right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode node1, ListNode node2) {
        var sentinel = new ListNode();
        var cur = sentinel;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                cur = node1;
                node1 =  node1.next;
            } else {
                cur.next = node2;
                cur = node2;
                node2 = node2.next;
            }
        }
        cur.next = node1 != null ? node1 : node2;
        return sentinel.next;
    }

    ListNode getMid(ListNode head) {
        ListNode prevMid = null;
        while (head != null && head.next != null) {
            prevMid = prevMid == null ? head : prevMid.next;
            head = head.next.next;
        }
        var mid = prevMid.next;
        prevMid.next = null;
        return mid;
    }

}
