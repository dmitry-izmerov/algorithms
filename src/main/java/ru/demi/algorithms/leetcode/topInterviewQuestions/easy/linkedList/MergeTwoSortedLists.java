package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.linkedList;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var p1 = list1;
        var p2 = list2;
        ListNode root = new ListNode();
        ListNode p = root;
        while (p1 != null || p2 != null) {
            if (p2 == null || (p1 != null && p1.val < p2.val)) {
                p.next = p1;
                p = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }

        return root.next;
    }

    static class ListNode {
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
