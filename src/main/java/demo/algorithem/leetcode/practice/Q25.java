package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2021/12/28
 */
public class Q25 {

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
        ListNode res = new Q25().reverseKGroup(node1, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode reverseHead = hasKElementsAndReturnHead(current, k);
            if (reverseHead == null) {
                return temp.next;
            }
            ListNode result = new ListNode();
            reverse(k - 1, reverseHead, reverseHead, pre, result);
            if (pre == null) {
                temp.next = result.next;
            } else {
                pre.next = result.next;
            }
            pre = reverseHead;
            current = reverseHead.next;
        }
        return temp.next;
    }

    private ListNode hasKElementsAndReturnHead(ListNode head, int k) {
        ListNode res = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
            if (i != k - 1 && head == null) {
                return null;
            }
        }
        return res;
    }

    private void reverse(int k, ListNode head, ListNode current, ListNode pre, ListNode result) {
        if (k != 0) {
            reverse(k - 1, head, current.next, current, result);
        }

        if (k == 0) {
            head.next = current.next;
            result.next = current;
        }
        if (current != head) {
            current.next = pre;
        }
    }

    public static class ListNode {
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
    }
}
