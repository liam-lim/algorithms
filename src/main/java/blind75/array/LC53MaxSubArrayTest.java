package blind75.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/"> Maximum sub-array sum </a>
 * <a href="https://www.youtube.com/watch?v=5WZl3MMT0Eg&ab_channel=NeetCode"> Answer </a>
 */
public class LC53MaxSubArrayTest {
    @Test
    public void test() {
        // mock
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;

        // execute
        int result = maxSubArray(arr);

        // assert
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test2() {
        // mock
        int[] arr = {1};
        int expected = 1;

        // execute
        int result = maxSubArray(arr);

        // assert
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test3() {
        // mock
        int[] arr = {5, 4, -1, 7, 8};
        int expected = 23;

        // execute
        int result = maxSubArray(arr);

        // assert
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test4() {
        // mock
        int[] arr = {-5, -3, -8, -1};
        int expected = -1;

        // execute
        int result = maxSubArray(arr);

        // assert
        Assertions.assertThat(result).isEqualTo(expected);
    }

    public int maxSubArray(int[] arr) {

        int max = arr[0];
        int current = 0;
        for (int j : arr) {
            current = Math.max(0, current);
            current = current + j;
            max = Math.max(max, current);
        }

        return max;
    }

}
