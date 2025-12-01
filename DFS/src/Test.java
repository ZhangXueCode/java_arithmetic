import java.util.*;

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
    //求根节点到叶子节点数字之和
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int preSum) {
        int sum = preSum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return sum;
        }
        if(root.left != null && root.right != null) {
            return dfs(root.left,sum) + dfs(root.right,sum);
        }
        if(root.left != null) {
            return dfs(root.left,sum);
        }
        return dfs(root.right,sum);
    }
    //二叉树剪枝
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
    //验证二叉搜索树
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        boolean cur = false;
        if(root.val > pre) {
            cur = true;
        }
        pre = root.val;
        boolean right = isValidBST(root.right);
        return left && cur && right;
    }
    //二叉搜索树中第k小的元素
    int ret;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return ret;
    }
    public void dfs(TreeNode root) {
        if(root == null || count == 0) {
            return;
        }
        dfs(root.left);
        count--;
        if(count == 0) {
            ret = root.val;
            return;
        }
        dfs(root.right);
    }
    //二叉树的所有路径
    List<String> ret1;
    public List<String> binaryTreePaths(TreeNode root) {
        ret1 = new ArrayList<>();
        dfs(root,new StringBuffer());
        return ret1;
    }
    void dfs(TreeNode root,StringBuffer _path) {
        StringBuffer path = new StringBuffer(_path);
        if(root == null) {
            return;
        }
        path.append(root.val);
        if(root.left == null && root.right == null) {
            ret1.add(path.toString());
            return;
        }
        path.append("->");
        dfs(root.left,path);
        dfs(root.right,path);
    }
    //全排列
    List<List<Integer>> ret2;
    List<Integer> path;
    boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        ret2 = new ArrayList<>();
        path = new ArrayList<>();
        check = new boolean[nums.length];
        dfs(nums);
        return ret2;
    }
    void dfs(int[] nums) {
        int n = nums.length;
        if(path.size() == n) {
            ret2.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!check[i]) {
                path.add(nums[i]);
                check[i] = true;
                dfs(nums);
                check[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    //子集
    List<List<Integer>> ret3;
    List<Integer> path1;
    public List<List<Integer>> subsets(int[] nums) {
        ret3 = new ArrayList<>();
        path1 = new ArrayList<>();
        dfs1(nums,0);
        return ret3;
    }
    public void dfs1(int[] nums,int pose) {
        ret3.add(new ArrayList<>(path1));
        for (int i = pose; i < nums.length; i++) {
            path1.add(nums[i]);
            dfs1(nums,i + 1);
            path1.remove(path1.size() - 1);
        }
    }
    public void dfs(int[] nums, int i) {
        if(i == nums.length) {
            ret3.add(new ArrayList<>(path1));
            return;
        }
        path1.add(nums[i]);
        dfs(nums,i + 1);
        path1.remove(path1.size() - 1);
        dfs(nums,i + 1);
    }
    //找出所有子集的异或总和再求和
    int path3;
    int tmp;
    public int subsetXORSum(int[] nums) {
        dfs2(nums,0);
        return tmp;
    }
    public void dfs2(int[] nums,int pose) {
        tmp += path3;
        for (int i = pose; i < nums.length; i++) {
            path3 ^= nums[i];
            dfs2(nums,i + 1);
            path3 ^= nums[i];
        }
    }
    //全排列Ⅱ
    List<List<Integer>> ret4;
    List<Integer> path2;
    boolean[] check2;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ret4 = new ArrayList<>();
        path2 = new ArrayList<>();
        check2 = new boolean[nums.length];
        Arrays.sort(nums);
        dfs3(nums);
        return ret4;
    }
    void dfs3(int[] nums) {
        if(path2.size() == nums.length) {
            ret4.add(new ArrayList<>(path2));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!check2[i] && (i == 0 || nums[i] != nums[i - 1] || check2[i - 1])) {
                path2.add(nums[i]);
                check2[i] = true;
                dfs3(nums);
                check2[i] =false;
                path2.remove(path2.size() - 1);
            }
        }
    }
    //电话号码的字母组合
    List<String> ret5;
    StringBuilder path4;
    String[] hash = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        ret5 = new ArrayList<>();
        path4 = new StringBuilder();
        dfs(digits,0);
        return ret5;
    }
    void dfs(String digits,int pose) {
        if(pose == digits.length()) {
            ret5.add(path4.toString());
            return;
        }
        int a = digits.charAt(pose) - '0';
        String s = hash[a];
        for (int i = 0; i < s.length(); i++) {
            path4.append(s.charAt(i));
            dfs(digits,pose + 1);
            path4.deleteCharAt(path4.length() - 1);
        }
    }
    //括号生成
    List<String> ret6;
    StringBuilder path5;
    int left;
    int right;
    int n;
    public List<String> generateParenthesis(int _n) {
        n = _n;
        ret6 = new ArrayList<>();
        path5 = new StringBuilder();
        dfs();
        return ret6;
    }
    void dfs() {
        if(right == n) {
            ret6.add(String.valueOf(path5));
            return;
        }
        if(left < n) {
            path5.append("(");
            left++;
            dfs();
            path5.deleteCharAt(path5.length() - 1);
            left--;
        }
        if(right < left) {
            path5.append(")");
            right++;
            dfs();
            path5.deleteCharAt(path5.length() - 1);
            right--;
        }
    }








}
