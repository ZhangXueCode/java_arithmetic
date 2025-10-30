import com.sun.xml.internal.ws.server.ServerRtException;

import java.util.*;

//滑动窗口（同向双指针）
public class Test {
    //找出和为target的最小长度
    public int minSubArray(int target,int[] num) {
        int left = 0,right = 0,sum = 0,len = Integer.MAX_VALUE;
        int n = num.length;
        for (; right < n; right++) {
            sum += num[right];
            while (sum >= target) {
                left++;
                len = Math.min(len,right - left + 1);
                sum -= num[left - 1];
            }
        }
        //如果整个数组加起来都没有target就返回0
        return len == Integer.MAX_VALUE ? 0 : len ;
    }
    //找出不重复的子字符串的最大长度
    public int maxSubString(String a) {
        char[] s = a.toCharArray();
        int[] hash = new int[128];
        int left = 0,right = 0,ret = 0,n = a.length();
        while (right < n) {
            hash[s[right]]++;
            while (hash[s[right]] > 1) {
                hash[s[left]]--;
                left++;
            }
            ret = Math.max(ret,right - left + 1);
            right++;
        }
        return ret;
    }
    //找出反转k个0后连续1最多的子数组的长度
    public int longestOnes(int[] num,int k) {
        int n = num.length;
        int count = 0;
        int ret = 0;
        for (int left = 0,right = 0;right < n;right++) {
            if(num[right] == 0) {
                count++;
            }
            while (count > k) {
                if(num[left] == 0) {
                    count--;
                }
                left++;
            }
            ret = Math.max(ret,right - left + 1);
        }
        return ret;
    }
    //将x减到0的最小操作数
    public int minOperation(int[] num,int x) {
        int n = num.length;
        int target = Arrays.stream(num).sum() - x;
        int sum = 0;
        int len = -1;
        if (target < 0) {
            return -1;
        }
        for (int left = 0, right = 0; right < n; right++) {
            sum += num[right];
            while (sum > target) {
                sum -= num[left];
                left++;
            }
            if (sum == target) {
                len = Math.max(len, right - left + 1);
            }
        }
        if (len == -1) {
            return len;
        }else {
            return n - len;
         }
    }
    //摘两种水果 能摘的树的最大个数
    public int maxFruitTree(int[] f) {
        int n = f.length;
        int[] hash = new int[n + 1];
        int ret = 0;
        for (int left = 0,right = 0,kinds = 0;right < n;right++) {
            if(hash[f[right]] == 0) {
                kinds++;
            }
            hash[f[right]]++;
            while (kinds > 2) {
                hash[f[left]]--;
                if(hash[f[left]] == 0) {
                    kinds--;
                }
            }
            ret = Math.max(ret,right - left + 1);
        }
        return ret;
    }
    //找出异位词
    public List<Integer> find(String ss,String pp) {
        List<Integer> ret = new ArrayList<>();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for (char ch:p) {
            hash1[ch - 'a']++;
        }
        for(int left = 0,right = 0,count = 0;right < s.length;right++) {
            hash2[s[right] - 'a']++;
            if(hash2[s[right] - 'a'] <= hash1[s[right] - 'a']) {
                count++;
            }

            if(right - left + 1 > p.length) {
                if(hash2[s[left] - 'a'] <= hash1[s[left] - 'a']) {
                    count--;
                }
                hash1[s[left]]--;
                left++;
            }
            if(count == p.length) {
                ret.add(left);
            }
        }
        return ret;
    }
    //串联所有单词的字串
    public List<Integer> findSubString(String s,String[] words) {
        List<Integer> ret = new ArrayList<>();
        HashMap<String,Integer> hash1 = new HashMap<>();
        for(String str:words) {
            hash1.put(str,hash1.getOrDefault(str,0) + 1);
        }
        int len = words[0].length();
        int m = words.length;
        for (int i = 0; i < len; i++) {
            HashMap<String,Integer> hash2 = new HashMap<>();
            for(int left = i,right = i,count = 0;right + len <= s.length();right+=  len) {
                String in = s.substring(right,right + len);
                hash2.put(in,hash2.getOrDefault(in,0) + 1);
                if(hash2.get(in) <= hash1.getOrDefault(in,0)) {
                    count++;
                }
                if(right - left + 1 > m * len) {
                    String out = s.substring(left,left + len);
                    if(hash2.get(out) <= hash1.getOrDefault(out,0)) {
                        count--;
                    }
                    hash2.put(out,hash2.get(out) - 1);
                    left += len;
                }
                if(m == count) {
                    ret.add(left);
                }
            }
        }
        return ret;
    }
}
