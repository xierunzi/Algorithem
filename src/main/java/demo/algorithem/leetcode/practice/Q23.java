package demo.algorithem.leetcode.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xierz
 * @date 2021/12/28
 */
public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                nodes.offer(list);
            }
        }
        ListNode fake = new ListNode();
        ListNode current = fake;
        while (!nodes.isEmpty()) {
            ListNode node = nodes.poll();
            current.next = node;
            if (node.next != null) {
                nodes.offer(node.next);
            }
            current = current.next;
        }
        return fake.next;
    }

}
