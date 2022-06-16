package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.design;

import java.util.ArrayDeque;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * Constraints:
 * -2^31 <= val <= 2^31-1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 */
public class MinStack {

    private ArrayDeque<Node> stack = new ArrayDeque<>();
    private int minValue = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
        if (val < minValue) {
            minValue = val;
        }
        stack.push(new Node(val, minValue));
    }

    public void pop() {
        stack.pop();
        if (!stack.isEmpty()) {
            minValue = getMin();
        } else {
            minValue = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().minValue;
    }

    private static class Node {
        int value;
        int minValue;

        public Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }
}
