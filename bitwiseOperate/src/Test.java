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
    //判断字符是否唯一
    public boolean isUnique(String astr) {
        if(astr.length() > 26) {
            return false;
        }
        int bitMap = 0;
        for (int i = 0; i < astr.length(); i++) {
            int x = astr.charAt(i) - 'a';
            if(((bitMap >> x) & 1) == 1) {
                return false;
            }
            bitMap |= 1 << x;
        }
        return true;
    }
    //两数相加
    public int sum(int a,int b) {
        while (b != 0) {
            int x = a ^ b;
            int c = (a & b) << 1;
            a = x;
            b = c;
        }
        return a;
    }
}
