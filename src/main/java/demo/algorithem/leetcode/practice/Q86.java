package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/31
 */
public class Q86 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(2);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        new Q86().partition(node1, 2);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode fake = new ListNode();
        fake.next = head;
        ListNode pre = fake;
        ListNode after = head;
        while (after != null) {
            if (after.val >= x) {
                break;
            }
            pre = after;
            after = after.next;
        }
        ListNode current = after;
        ListNode tempPre = pre;
        while (current != null) {
            if (current.val < x) {
                pre.next = current;
                pre = current;
                tempPre.next = current.next;
                current.next = after;
            }
            tempPre = current;
            current = current.next;
        }
        return fake.next;
    }
}
