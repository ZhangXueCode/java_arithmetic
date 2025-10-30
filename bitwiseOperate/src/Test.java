public class Test {
    //消失的数
    public int miss(int[] num) {
        int ret = 0;
        for(int x : num) {
            ret ^= x;
        }
        for (int i = 0; i <= num.length; i++) {
            ret ^= i;
        }
        return ret;
    }
}
