package demo.algorithem.leetcode.practice;

import java.util.Stack;

/**
 * @author xierz
 * @date 2022/2/4
 */
public class Q92 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new Q92().reverseBetween(node1, 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null) {
            return head;
        }
        ListNode start = head;
        ListNode result = null;
        for (int i = 1; i < left; i++) {
            result = start;
            start = start.next;
        }
        Stack<ListNode> nodes = new Stack<>();
        ListNode temp = start;

        for (int i = 0; i <= right - left; i++) {
            nodes.push(temp);
            temp = temp.next;
        }
        ListNode end = temp;
        ListNode current = result;
        if (result == null) {
            current = new ListNode();
        }
        ListNode first = null;
        while (!nodes.isEmpty()) {
            if (first == null) {
                first = nodes.peek();
            }
            current.next = nodes.pop();
            current = current.next;
            if (nodes.isEmpty()) {
                current.next = end;
            }
        }
        if (result != null) {
            return head;
        } else {
            return first;
        }
    }
}
