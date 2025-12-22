import java.util.*;

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
    //最后一块石头的重量
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> h = new PriorityQueue<>((a,b) -> b - a);

        for(int x : stones) {
            h.offer(x);
        }
        while (h.size() >= 2) {
            int a = h.poll();
            int b = h.poll();
            if(a > b) {
                h.offer(a - b);
            }
        }
        if(h.isEmpty()) {
            return 0;
        }
        return h.poll();
    }
    //数据流中的第k大元素
    class KthLargest {
        PriorityQueue<Integer> h;
        int _k;
        public KthLargest(int k, int[] nums) {
            _k = k;
            h = new PriorityQueue<>();
            for(int x : nums) {
                h.offer(x);
                if(h.size() > _k) {
                    h.poll();
                }
            }
        }
        public int add(int val) {
            h.offer(val);
            if(h.size() > _k) {
                h.poll();
            }
            return h.peek();

        }
    }
    //前k个高频词
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hash = new HashMap<>();
        for(String s : words) {
            hash.put(s,hash.getOrDefault(s,0) + 1);
        }

        PriorityQueue<Pair<String,Integer>> h = new PriorityQueue<Pair<String, Integer>>(
                (a,b) -> {
                    if(a.getValue().equals(b.getValue())) {
                        return b.getKey().compareTo(a.getKey());
                    }
                    return a.getValue().compareTo(b.getValue());
                }
        );

        for(Map.Entry<String,Integer> e : hash.entrySet()) {
            h.offer(new Pair<>(e.getKey(),e.getValue()));
            if(h.size() > k) {
                h.poll();
            }
        }

        List<String> ret = new ArrayList<>();
        while (!h.isEmpty()) {
            ret.add(h.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;

    }
    //数据流的中位数
    class MedianFinder {
        //左边一个大根堆 右边一个小根堆维护中位数
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        public MedianFinder() {
            left = new PriorityQueue<>((a,b) -> b - a);
            right = new PriorityQueue<>();
        }
        public void addNum(int num) {
            if(left.size() == right.size()) {
                if(left.isEmpty() || num <= left.peek()) {
                    left.offer(num);
                }else {
                    right.offer(num);
                    left.offer(right.poll());
                }
            }else {
                if(num <= left.peek()) {
                    left.offer(num);
                    right.offer(left.poll());
                }else {
                    right.offer(num);
                }
            }

        }

        public double findMedian() {
            if(left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2;
            }else {
                return left.peek();
            }

        }
    }
}
