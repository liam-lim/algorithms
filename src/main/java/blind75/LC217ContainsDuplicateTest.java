package blind75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/"> Contains duplicate </a>
 * <a href="https://www.youtube.com/watch?v=3OamzN90kPg&list=PLot-Xpze53ldVwtstag2TL4HQhAnC8ATf&index=4&ab_channel=NeetCode"> Answer </a>
 */
public class LC217ContainsDuplicateTest {
    @Test
    public void test() {
        // mock
        int[] arr = new int[]{1, 2, 3, 1};

        // execute
        boolean result = containsDuplicate2(arr);

        // assert
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void test_2() {
        // mock
        int[] arr = new int[]{1, 2, 3, 4};

        // execute
        boolean result = containsDuplicate2(arr);

        // assert
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void test_3() {
        // mock
        int[] arr = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        // execute
        boolean result = containsDuplicate2(arr);

        // assert
        Assertions.assertThat(result).isTrue();
    }

    public boolean containsDuplicate(int[] arr) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int i : arr) {

            if (!count.containsKey(i)) {
                count.put(i, 1);
                continue;
            }

            count.put(i, count.get(i) + 1);

            if (count.get(i) == 2) {
                return true;
            }

        }

        return false;
    }

    public boolean containsDuplicate2(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            boolean add = set.add(i);
            if (!add) {
                return true;
            }
        }

        return false;
    }
}
