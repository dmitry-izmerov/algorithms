package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.linkedList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode pointer1 = root, pointer2 = root;
        for (int i = 1; i <= n + 1; i++) {
            pointer2 = pointer2.next;
        }

        while (pointer2 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer1.next = pointer1.next.next;

        return root.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            var text = "ListNode{val=" + val + "}";
            if (next == null) {
                return text;
            }

            return text + " => " + next;
        }
    }
}
