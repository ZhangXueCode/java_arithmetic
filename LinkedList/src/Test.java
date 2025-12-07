import java.util.PriorityQueue;

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
    //合并k个有序链表
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1,v2) -> v1.val - v2.val);
        for(ListNode head : lists) {
            if(head != null) {
                heap.offer(head);
            }
        }
        ListNode ret = new ListNode();
        ListNode pre = ret;
        while (!heap.isEmpty()) {
            ListNode t = heap.poll();
            pre.next = t;
            pre = t;
            if(t.next != null) {
                heap.offer(t.next);
            }
        }
        return ret.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        return merge(lists,0,n - 1);

    }
    ListNode merge(ListNode[] lists,int left,int right) {
         if(left > right) {
             return null;
         }
         if(left == right) {
             return lists[left];
         }
         int mid = (left + right) / 2;

         ListNode l1 = merge(lists,left,mid);
         ListNode l2 = merge(lists,mid + 1,right);

         return mergeTwoList(l1,l2);

    }
    ListNode mergeTwoList(ListNode l1,ListNode l2) {
        ListNode head = new ListNode();
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }

        if(l1 != null) {
            pre.next = l1;
        }
        if(l2 != null) {
            pre.next = l2;
        }

        return head.next;
    }
    //k个一组反转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode newHead = new ListNode();
        ListNode cur = head;
        ListNode pre = newHead;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = n / k;
        cur = head;
        for (int i = 0; i < n; i++) {
            ListNode tmp = cur;
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = next;
            }
            pre = tmp;
        }
        pre.next = cur;
        return newHead.next;
    }


}
