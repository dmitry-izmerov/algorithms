package ru.demi.algorithms.leetcode.yandex;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode left = head;
        ListNode right = head.next;
        head = reverseListRecursive(head.next);

        left.next = null;
        right.next = left;

        return head;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode next = null;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            ListNode node = new ListNode(cur.val);
            node.next = next;
            next = node;
        }

        return next;
    }
}
