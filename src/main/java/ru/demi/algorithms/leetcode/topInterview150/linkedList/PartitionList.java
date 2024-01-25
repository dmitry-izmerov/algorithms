package ru.demi.algorithms.leetcode.topInterview150.linkedList;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater
 * than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class PartitionList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        var beforeHead = new ListNode();
        var before = beforeHead;
        var afterHead = new ListNode();
        var after = afterHead;
        for (var cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                before.next = cur;
                before = cur;
            } else {
                after.next = cur;
                after = cur;
            }
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
