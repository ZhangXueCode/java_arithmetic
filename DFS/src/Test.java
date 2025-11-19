import java.util.List;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
}

public class Test {
    //汉诺塔
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        dfs(A,B,C,n);

    }
    public void dfs(List<Integer> A, List<Integer> B, List<Integer> C,int n) {
        if(n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        dfs(A,C,B,n - 1);
        C.add(A.remove(A.size() - 1));
        dfs(B,A,C,n - 1);

    }
    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list2.next,list1);
            return list2;
        }
    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tmp = swapPairs(head.next.next);
        ListNode ret = head.next;
        head.next.next = head;
        head.next = tmp;
        return ret;
    }
    //快速幂
    public double myPow(double x, int n) {
        return n < 0 ? 1.0 / pow(x,-n) :pow(x,n);
    }
    public double pow(double x,int n) {
        if(n == 0) return 1.0;
        double tmp = pow(x,n / 2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
    //计算布尔二叉树的值
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null) {
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if(root.val == 2) {
            return left | right;
        }else {
            return left & right;
        }

    }







}
