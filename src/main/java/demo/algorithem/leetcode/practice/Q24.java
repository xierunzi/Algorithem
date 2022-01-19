package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2021/12/27
 */
public class Q24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = new Q24().swapPairs(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prePre = null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode res = null;
        boolean swap = true;
        while (cur != null) {
            swap = !swap;
            if (swap) {
                pre.next = cur.next;
                cur.next = pre;
                if (prePre != null) {
                    prePre.next = cur;
                    prePre = cur;
                } else {
                    res = cur;
                }
                cur = pre.next;
            } else {
                prePre = pre;
                pre = cur;
                cur = cur.next;
            }
        }
        return res;
    }

}
