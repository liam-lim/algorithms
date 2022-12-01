package blind75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/"> Contains duplicate </a>
 * <a href="https://www.youtube.com/watch?v=3OamzN90kPg&list=PLot-Xpze53ldVwtstag2TL4HQhAnC8ATf&index=5&ab_channel=NeetCode"> Answer </a>
 */
public class LC121BuySellStockTest {

    @Test
    public void test() {
        // mock
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;

        // execute
        int result = maxProfit(prices);

        // assert
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_2() {
        // mock
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;

        // execute
        int result = maxProfit(prices);

        // assert
        Assertions.assertThat(result).isEqualTo(expected);
    }

    public int maxProfit(int[] prices) {

        int left = 0;
        int right = 1;

        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
