package ru.demi.algorithms.leetcode.topInterviewQuestions.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.leetcode.topInterviewQuestions.easy.array.SingleNumber.getSingleNumber;

class SingleNumberTest {

    @Test
    void shouldReturnSingleNumber() {
        int singleNumber = getSingleNumber(new int[]{4,1,2,1,2});

        assertThat(singleNumber).isEqualTo(4);
    }

    @Test
    void shouldReturnSingleNegativeNumber() {
        int singleNumber = getSingleNumber(new int[]{-80,48,777,423,-435,349,-988,-379,-197,192,13,-496,-787,94,329,-490,-230,-929,457,591,75,-80,48,777,423,-435,349,-988,-379,-197,192,13,-496,-787,94,329,-490,-230,-929,457,591,75,-477});

        assertThat(singleNumber).isEqualTo(-477);
    }

    @Test
    void shouldReturnSingleNegativeNumber2() {
        int singleNumber = getSingleNumber(new int[]{-967,-590,980,-806,145,-881,357,-787,-592,859,627,-929,296,818,-194,586,-106,-479,967,132,-396,-692,464,726,-967,-590,980,-806,145,-881,357,-787,-592,859,627,-929,296,818,-194,586,-106,-479,967,132,-396,-692,464,726,-755});

        assertThat(singleNumber).isEqualTo(-755);
    }
}