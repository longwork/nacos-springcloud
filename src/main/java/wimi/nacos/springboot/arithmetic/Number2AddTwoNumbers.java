package wimi.nacos.springboot.arithmetic;

/**
 * @author Long
 * @date 10:46 2020-04-23 周四
 */
public class Number2AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        ListNode listNode = new ListNode(val % 10);
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            val = l1.val + l2.val;
        }
        return listNode;
    }
}
