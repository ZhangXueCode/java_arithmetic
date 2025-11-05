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
    //N字形变换
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int n = s.length(),d = 2 * numRows - 2;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < n; i+=d) {
            ret.append(s.charAt(i));
        }
        for (int k = 1;k < numRows - 1;k++) {
            for (int i = k,j = d - k;i < n || j < n;i+=d,j+=d) {
                if(i < n) {
                    ret.append(s.charAt(i));
                }
                if(j < n) {
                    ret.append(s.charAt(j));
                }
            }
        }
        for (int i = numRows - 1; i < n; i+=d) {
            ret.append(s.charAt(i));
        }
        return ret.toString();
        

    }


}
