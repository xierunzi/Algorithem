package demo.algorithem.leetcode.practice;


import java.util.Stack;

/**
 * @author xierz
 * @date 2022/1/19
 */
public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode();
        temp.next = head;

        Stack<ListNode> nodes = new Stack<>();
        ListNode current = head;
        while (current != null) {
            nodes.push(current);
            current = current.next;
        }

        k %= nodes.size();

        for (int i = 0; i < k; i++) {
            ListNode last = nodes.pop();
            nodes.peek().next = null;
            last.next = temp.next;
            temp.next = last;
        }

        return temp.next;
    }
}
