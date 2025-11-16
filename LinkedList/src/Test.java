
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
    //重排链表
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode head2 = new ListNode(0);
        while (cur != null) {
            ListNode next1 = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur =  next1;
        }
        ListNode cur1 = head,cur2 = head2.next;
        ListNode ret = new ListNode(0);
        ListNode pre = ret;
        while (cur1 != null) {
            pre.next = cur1;
            pre = cur1;
            cur1 = cur1.next;
            if(cur2 != null) {
                pre.next = cur2;
                pre = cur2;
                cur2 = cur2.next;
            }
        }
    }


}
