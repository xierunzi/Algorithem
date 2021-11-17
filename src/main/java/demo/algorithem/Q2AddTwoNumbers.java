package demo.algorithem;

/**
 * @author xierz
 * @date 2021/11/15
 */
public class Q2AddTwoNumbers {
    static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current;
        ListNode preNode = head;
        int plusOneFlag = 0;
        while (l1 != null || l2 != null) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;

            int newVal = value1 + value2 + plusOneFlag;
            plusOneFlag = newVal >= 10 ? 1 : 0;
            newVal %= 10;

            current = new ListNode(newVal);
            preNode.next = current;
            preNode = current;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (plusOneFlag != 0) {
            preNode.next = new ListNode(1);
        }
        return head.next;
    }
}
