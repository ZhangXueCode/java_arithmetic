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

class Pair<K, V> {
    private final K key;
    private final V value;

    // 构造方法
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // 静态工厂方法，简化创建
    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    // get方法
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
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
    //二叉树的最大宽度
    public int widthOfBinaryTree(TreeNode root) {
        int ret = 0;
        List<Pair<TreeNode,Integer>> q = new ArrayList<>();
        q.add(new Pair<TreeNode,Integer>(root,1));
        while (!q.isEmpty()) {
            Pair<TreeNode,Integer> t1 = q.get(0);
            Pair<TreeNode,Integer> t2 = q.get(q.size() - 1);
            ret = Math.max(ret,t2.getValue() - t1.getValue() + 1);
            List<Pair<TreeNode,Integer>> tmp = new ArrayList<>();
            for(Pair<TreeNode,Integer> t : q) {
                TreeNode node = t.getKey();
                int index = t.getValue();
                if(node.left != null) {
                    tmp.add(new Pair<TreeNode,Integer>(node.left,index * 2));
                }
                if(node.right != null) {
                    tmp.add(new Pair<TreeNode,Integer>(node.right,index * 2 + 1));
                }
            }
            q = tmp;
        }
        return ret;

    }


}
