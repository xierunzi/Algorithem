package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2021/12/25
 */
public class Q21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        ListNode pre = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current = list1;
                list1 = list1.next;
            } else {
                current = list2;
                list2 = list2.next;
            }
            if (head == null) {
                head = current;
            }
            if (pre != null) {
                pre.next = current;
            }
            pre = current;
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return head;
    }

}
