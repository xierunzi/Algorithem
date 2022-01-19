package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/16
 */
public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            while (temp != null) {
                if (temp.val == current.val) {
                    temp = temp.next;
                } else {
                    break;
                }
            }
            current.next = temp;
            current = current.next;
        }
        return head;
    }

}
