package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.linkedList;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode end = reverseList(middle.next);

        ListNode p1 = head;
        ListNode p2 = end;
        boolean result = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        reverseList(end);
        return result;
    }

    private ListNode findMiddle(ListNode node) {
        ListNode p1 = node;
        ListNode p2 = node;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static class ListNode {
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
}
