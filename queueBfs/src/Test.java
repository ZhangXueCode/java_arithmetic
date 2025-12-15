import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
};
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

}
