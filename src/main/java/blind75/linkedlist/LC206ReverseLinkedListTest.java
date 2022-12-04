package blind75.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/"> Reverse linked list </a>
 * <a href="https://www.youtube.com/watch?v=G0_I-ZF0S38&ab_channel=NeetCode"> Answer </a>
 */
public class LC206ReverseLinkedListTest {

    private static class ListNode {
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

        public static ListNode createListNode(int[] arr) {

            ListNode listNode = null;

            for (int i = arr.length - 1; i >= 0; i--) {
                listNode = new ListNode(arr[i], listNode);
            }

            return listNode;
        }

        public static void print(ListNode listNode) {
            ListNode temp = listNode;
            while (temp != null) {
                System.out.println(temp.val);
                temp = temp.next;
            }
        }

        public static int[] convertToArray(ListNode listNode) {
            List<Integer> list = new ArrayList<>();
            ListNode temp = listNode;
            while (temp != null) {
                list.add(temp.val);
                temp = temp.next;
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    @Test
    public void test() {
        // mock
        int[] head = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.createListNode(head);
        int[] expected = {5, 4, 3, 2, 1};

        // execute
        ListNode result = reverseList2(listNode);

        // assert
        Assertions.assertThat(ListNode.convertToArray(result)).isEqualTo(expected);
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode reversed = null;

        ListNode curr = head;
        while (curr != null) {
            reversed = new ListNode(curr.val, reversed);
            curr = curr.next;
        }

        return reversed;
    }

    public ListNode reverseList2(ListNode listNode) {

        if (listNode == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = listNode;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
