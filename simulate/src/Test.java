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

}
