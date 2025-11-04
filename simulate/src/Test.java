public class Test {
    //替换所有的问号
    public String modifyString(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if(s[i] == '?') {
                for (char ch = 'a';ch <= 'z';ch++) {
                    if((i == 0 || ch != s[i - 1]) && (i == n - 1 || ch != s[i + 1])) {
                        s[i] = ch;
                        break;
                    }
                }
            }
        }
        return String.valueOf(s);

    }
    //提莫攻击
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ret = duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if(timeSeries[i + 1] - timeSeries[i] >= duration) {
                ret += duration;
            }else {
                ret += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return ret;

    }

}
