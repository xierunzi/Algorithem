package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/29
 */
public class Q82 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        new Q82().deleteDuplicates(node1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fake = new ListNode();
        fake.next = head;
        ListNode pre = fake;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            if (temp == null) {
                break;
            }
            if (temp.val != current.val) {
                pre = current;
                current = temp;
            } else {
                ListNode start = current;
                ListNode end = current;
                while (end != null) {
                    if (end.val == start.val) {
                        end = end.next;
                    } else {
                        break;
                    }
                }
                pre.next = end;
                current = end;
            }
        }
        return fake.next;
    }
}
