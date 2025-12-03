import java.util.PriorityQueue;

public class Test {
    //柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for(int x : bills) {
            if(x == 5) {
                five++;
            } else if (x == 10) {
                ten++;
                if(five > 0) {
                    five--;
                }else {
                    return false;
                }
            }else {
                if(five != 0 && ten != 0) {
                    five--;
                    ten--;
                }else {
                    if(five >= 3) {
                        five -= 3;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;

    }
    //将数组和减半至少操作次数
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        double sum = 0.0;
        int c = 0;
        for(int x : nums) {
            heap.offer((double)x);
            sum += x;
        }
        sum /= 2.0;
        while (sum > 0) {
            double a = heap.poll() / 2.0;
            sum -= a;
            c++;
            heap.offer(a);
        }
        return c;
    }
}
