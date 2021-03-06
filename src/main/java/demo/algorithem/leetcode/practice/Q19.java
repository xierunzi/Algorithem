package demo.algorithem.leetcode.practice;

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

}
