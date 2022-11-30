package blind75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/"> Two Sum </a>
 * <a href="https://www.youtube.com/watch?v=KLlXCFG5TnA&list=PLot-Xpze53ldVwtstag2TL4HQhAnC8ATf&ab_channel=NeetCode"> Answer </a>
 */

public class TwoSumTest {

    @Test
    public void test() {
        int[] numArr = {3, 2, 4};
        int target = 6;

        int[] result = twoSum(numArr, target);

        int[] expected = {1, 2};

        Assertions.assertThat(result).isEqualTo(expected);
    }

    public int[] twoSum(int[] numArr, int target) {

        int[] indices = new int[2];
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < numArr.length; i++) {
            int pair = target - numArr[i];

            if (valueToIndex.containsKey(pair)) {
                indices[0] = valueToIndex.get(pair);
                indices[1] = i;
                break;
            }

            valueToIndex.put(numArr[i], i);
        }

        return indices;
    }
}
