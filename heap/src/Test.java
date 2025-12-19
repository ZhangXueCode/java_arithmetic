import java.util.PriorityQueue;

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
}
