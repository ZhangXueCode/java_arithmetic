import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
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
    //N叉树的层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int c = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                Node a = queue.poll();
                tmp.add(a.val);
                for(Node child : a.children) {
                    if(child != null) {
                        queue.add(child);
                    }
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
    //二叉树的锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int h = 1;
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int c = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                TreeNode a = queue.poll();
                tmp.add(a.val);
                if(a.left != null) {
                    queue.add(a.left);
                }
                if(a.right != null) {
                    queue.add(a.right);
                }
            }
            if(h % 2 == 0) {
                Collections.reverse(tmp);
            }
            ret.add(tmp);
            h++;
        }
        return ret;
    }


}
