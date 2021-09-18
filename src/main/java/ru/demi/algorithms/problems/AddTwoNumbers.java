package ru.demi.algorithms.problems;

import java.math.BigInteger;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = toNumber(l1);
        BigInteger num2 = toNumber(l2);
        return toListNode(num1.add(num2));
    }

    private BigInteger toNumber(ListNode node) {
        BigInteger total = BigInteger.ZERO;
        int i = 0;
        for (ListNode next = node; next != null; next = next.next, ++i) {
            BigInteger degree = BigInteger.valueOf(10).pow(i);
            total = total.add(degree.multiply(BigInteger.valueOf(next.val)));
        }
        return total;
    }

    private ListNode toListNode(BigInteger number) {
        ListNode first = new ListNode();
        ListNode prev = null;
        ListNode cur = first;
        for (BigInteger left = number; !BigInteger.ZERO.equals(left); cur = new ListNode()) {
            int right = left.mod(BigInteger.TEN).intValue();
            left = left.divide(BigInteger.TEN);
            cur.val = right;

            if (prev != null) {
                prev.next = cur;
            }
            prev = cur;
        }
        return first;
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

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (ListNode cur = this; cur != null; cur = cur.next) {
                sb.append(cur.val);
            }
            return sb.toString();
        }
    }
}
