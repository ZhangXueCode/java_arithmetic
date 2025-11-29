import java.util.Scanner;

public class Test {
    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || ch != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
    //最长回文字串
    public String longestPalindrome(String s) {
        int begin = 0,len = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i,right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if(right - left - 1 > len) {
                begin = left + 1;
                len = right - left - 1;
            }
            left = i;
            right = left + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if(right - left - 1 > len) {
                begin = left + 1;
                len = right - left - 1;
            }
        }
        return s.substring(begin,len + begin);
    }
    //二进制求和
    public String addBinary(String a, String b) {
        int t = 0;
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1,j = b.length() - 1;
        while (i >= 0 || j >= 0 || t > 0) {
            if(i >= 0) {
                t += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                t += b.charAt(j--) - '0';
            }
            int k = t % 2;
            t = t / 2;
            s.append(k);
        }
        return s.reverse().toString();
    }


}
