package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.linkedList;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Constraints:
 * - The number of the nodes in the list is in the range [0, 104].
 * - -105 <= Node.val <= 105
 * - pos is -1 or a valid index in the linked-list.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
