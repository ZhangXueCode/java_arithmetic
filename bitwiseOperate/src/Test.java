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
    //只出现一次的数字Ⅱ
    public int singleNum(int[] num) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for(int x : num) {
                if(((x >> i) & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            if(sum == 1) {
                ret |= 1 << i;
            }
        }
        return ret;
    }
    //消失的两个数
    public int[] missingTwo(int[] num) {
        int tmp = 0,n = 0;
        int a = 0,b = 0;
        //将所有数异或在一起
        for(int x : num) {
            tmp ^= x;
        }
        for (int i = 0; i <= num.length + 2; i++) {
            tmp ^= i;
        }
        //找出比特位=1的位置
        for (int i = 0; i < 32; i++) {
            if(((tmp >> i) & 1) == 1) {
                n = i;
                break;
            }
        }
        //将其分为两组 一组比特位为1异或在一起 另一组比特位为0异或在一起
        for (int i = 1; i <= num.length + 2; i++) {
            if(((i >> n) & 1) == 1) {
                a ^= i;
            }else {
                b ^= i;
            }
        }
        for(int x : num) {
            if(((x >> n) & 1) == 1) {
                a ^= x;
            }else {
                b ^= x;
            }
        }

        return new int[]{a,b};

    }
}
