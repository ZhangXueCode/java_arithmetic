import java.util.HashMap;
import java.util.Map;

public class Test {
    //替换所有的问号
    public String modifyString(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (s[i] == '?') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if ((i == 0 || ch != s[i - 1]) && (i == n - 1 || ch != s[i + 1])) {
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
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                ret += duration;
            } else {
                ret += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return ret;

    }

    //N字形变换
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.length(), d = 2 * numRows - 2;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < n; i += d) {
            ret.append(s.charAt(i));
        }
        for (int k = 1; k < numRows - 1; k++) {
            for (int i = k, j = d - k; i < n || j < n; i += d, j += d) {
                if (i < n) {
                    ret.append(s.charAt(i));
                }
                if (j < n) {
                    ret.append(s.charAt(j));
                }
            }
        }
        for (int i = numRows - 1; i < n; i += d) {
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }

    //外观数列
    public String countAndSay(int n) {
        String ret = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            int len = ret.length();
            for (int left = 0, right = 0; right < len; ) {
                while (right < len && ret.charAt(left) == ret.charAt(right)) {
                    right++;
                }
                tmp.append(Integer.toString(right - left));
                tmp.append(ret.charAt(left));
                left = right;
            }
            ret = tmp.toString();
        }
        return ret;
    }

    //数青蛙 解法一
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> hash = new HashMap<>();
        hash.put('c', 0);
        hash.put('r', 0);
        hash.put('o', 0);
        hash.put('a', 0);
        hash.put('k', 0);
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            if (croakOfFrogs.charAt(i) == 'c' && hash.get('k') != 0) {
                hash.put('k', hash.get('k') - 1);
                hash.put('c', hash.get('c') + 1);
            } else if (croakOfFrogs.charAt(i) == 'c' && hash.get('k') == 0) {
                hash.put('c', hash.get('c') + 1);
            }
            if (croakOfFrogs.charAt(i) == 'r' && hash.get('c') != 0) {
                hash.put('c', hash.get('c') - 1);
                hash.put('r', hash.get('r') + 1);
            } else if (croakOfFrogs.charAt(i) == 'r' && hash.get('c') == 0) {
                return -1;
            }
            if (croakOfFrogs.charAt(i) == 'o' && hash.get('r') != 0) {
                hash.put('r', hash.get('r') - 1);
                hash.put('o', hash.get('o') + 1);
            } else if (croakOfFrogs.charAt(i) == 'o' && hash.get('r') == 0) {
                return -1;
            }
            if (croakOfFrogs.charAt(i) == 'a' && hash.get('o') != 0) {
                hash.put('o', hash.get('o') - 1);
                hash.put('a', hash.get('a') + 1);
            } else if (croakOfFrogs.charAt(i) == 'a' && hash.get('o') == 0) {
                return -1;
            }
            if (croakOfFrogs.charAt(i) == 'k' && hash.get('a') != 0) {
                hash.put('a', hash.get('a') - 1);
                hash.put('k', hash.get('k') + 1);
            } else if (croakOfFrogs.charAt(i) == 'k' && hash.get('a') == 0) {
                return -1;
            }
        }
        if (hash.get('c') != 0 || hash.get('r') != 0 || hash.get('o') != 0 || hash.get('a') != 0) {
            return -1;
        }
        return hash.get('k');

    }

    //解法二
    public int minNumberOfFrogs2(String croakOfFrogs) {
        String s = "croak";
        int n = s.length();
        char[] c = croakOfFrogs.toCharArray();
        int[] hash = new int[n];
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(s.charAt(i), i);
        }
        for (char ch : c) {
            if (ch == s.charAt(0)) {
                if (hash[n - 1] != 0) {
                    hash[n - 1]--;
                }
                hash[0]++;
            } else {
                int k = index.get(ch);
                if (hash[k - 1] != 0) {
                    hash[k - 1]--;
                    hash[k]++;
                } else {
                    return -1;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (hash[i] != 0) {
                return -1;
            }
        }
        return hash[n - 1];
    }
}
