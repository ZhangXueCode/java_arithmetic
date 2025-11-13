
//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Test {
    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode pre = newHead;
        int t = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null || cur2 != null || t != 0) {
            if(cur1 != null) {
                t += cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null) {
                t += cur2.val;
                cur2 = cur2.next;
            }
            int a = t % 10;
            ListNode cur = new ListNode(a);
            pre.next = cur;
            pre = cur;
            t /= 10;
        }
        return newHead.next;
    }
    //两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        if(head == null) {
            return null;
        }
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode nnext = next.next;
            pre.next = next;
            next.next = cur;
            cur.next = nnext;
            pre = cur;
            cur = nnext;
        }
        return newHead.next;

    }


}
