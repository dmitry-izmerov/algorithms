package ru.demi.algorithms.problems;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.demi.algorithms.problems.AddTwoNumbers.ListNode;

class AddTwoNumbersTest {

    @Test
    void addTwoNumbers() {
        var listNode1 = new ListNode(9);
        var listNode2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

        var instance = new AddTwoNumbers();
        var result = instance.addTwoNumbers(listNode1, listNode2);

        Assertions.assertThat(result.toString()).isEqualTo("00000000001");
    }
}