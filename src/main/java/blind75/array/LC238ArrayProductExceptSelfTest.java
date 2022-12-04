package blind75.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/"> Product of array except self </a>
 * <a href="https://www.youtube.com/watch?v=bNvIQI2wAjk&ab_channel=NeetCode"> Answer </a>
 */
public class LC238ArrayProductExceptSelfTest {

    @Test
    public void test() {
        // mock
        int[] arr = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};

        // execute
        int[] result = productExceptSelf3(arr);

        // assert
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_2() {
        // mock
        int[] arr = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};

        // execute
        int[] result = productExceptSelf3(arr);

        // assert
        Assertions.assertThat(result).isEqualTo(expected);
    }

    public int[] productExceptSelf(int[] arr) {

        int[] container = new int[arr.length];
        container[0] = 1;

        int currentProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            currentProduct = currentProduct * arr[i];
            if (i + 1 < arr.length) {
                container[i + 1] = currentProduct;
            }
        }

        currentProduct = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            currentProduct = currentProduct * arr[i];
            if (i - 1 >= 0) {
                container[i - 1] = container[i - 1] * currentProduct;
            }
        }

        return container;
    }

    public int[] productExceptSelf2(int[] arr) {

        int[] container = new int[arr.length];
        container[0] = 1;

        int currentProduct = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            currentProduct = currentProduct * arr[i];
            container[i + 1] = currentProduct;
        }

        currentProduct = 1;
        for (int i = arr.length - 1; i >= 1; i--) {
            currentProduct = currentProduct * arr[i];
            container[i - 1] = container[i - 1] * currentProduct;
        }

        return container;
    }

    public int[] productExceptSelf3(int[] arr) {

        int[] container = new int[arr.length];
        container[0] = 1;
        container[1] = arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            container[i + 1] = arr[i] * container[i];
        }

        int currentProduct = 1;
        for (int i = arr.length - 1; i >= 1; i--) {
            currentProduct = currentProduct * arr[i];
            container[i - 1] = container[i - 1] * currentProduct;
        }

        return container;
    }
}
