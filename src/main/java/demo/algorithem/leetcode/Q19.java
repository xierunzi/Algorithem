package demo.algorithem.leetcode;

/**
 * 快慢指针
 *
 * @author xierz
 * @date 2021/12/22
 */
public class Q19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode result = null;
        ListNode fast = head;
        ListNode slow = null;
        for (int i = 1; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        while (fast.next != null) {
            if (result == null) {
                result = head;
            }
            slow = slow == null ? head : slow.next;
            fast = fast.next;
        }
        if (slow == null) {
            return head.next;
        }
        slow.next = slow.next.next;
        return result;
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
