import java.util.*;

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
    //最大数
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = "" + nums[i];
        }
        Arrays.sort(s,(a,b) -> (b + a).compareTo(a + b));
        StringBuilder ret = new StringBuilder();
        for(String c : s) {
            ret.append(c);
        }
        if(ret.charAt(0) == '0') {
            return "0";
        }
        return ret.toString();

    }
    //摆动序列
    public int wiggleMaxLength(int[] nums) {
        int left = 0;
        int ret = 0;
        if(nums.length < 2) {
            return nums.length;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int right = nums[i + 1] - nums[i];
            if(right == 0) continue;
            if(left * right <= 0) {
                ret++;
                left = right;
            }
        }
        ret++;
        return ret;
    }
    //最长递增子序列
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ret = new ArrayList<>();
        int n = nums.length;
        ret.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if(nums[i] > ret.get(ret.size() - 1)) {
                ret.add(nums[i]);
            }else {
                int left = 0,right = ret.size() - 1;
                while (left < right) {
                    int mid = (right + left) / 2;
                    if(ret.get(mid) < nums[i]) {
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                ret.set(left,nums[i]);
            }
        }
        return ret.size();

    }
    //递增的三元子序列
    public boolean increasingTriplet(int[] nums) {
        int a = nums[0];
        int b = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > b) {
                return true;
            }else {
                if(nums[i] > a) {
                    b = nums[i];
                }else {
                    a = nums[i];
                }
            }
        }
        return false;
    }
    //最长连续递增子序列
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int i = 0,j = 1,ret = 1;
        if(n == 1) {
            return ret;
        }
        while (i < n && j < n) {
            if(nums[j - 1] < nums[j]) {
                j++;
                ret = Math.max(ret,j - i);
            }else {
                i = j;
                j++;
            }
        }
        return ret;

    }
    //买卖股票的最佳时期
    public int maxProfit1(int[] prices) {
        int ret = 0;
        for (int i = 0,prev = Integer.MAX_VALUE; i < prices.length; i++) {
            ret = Math.max(ret,prices[i] - prev);
            prev = Math.min(prev,prices[i]);
        }
        return ret;
    }
    //买卖股票的最佳时机Ⅱ
    public int maxProfit(int[] prices) {
        //拆分天数
        int ret = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                ret += prices[i + 1] - prices[i];
            }
        }
        return ret;
        //双指针
//        int ret = 0;
//        for (int i = 0; i < prices.length; i++) {
//            int j = i;
//            while (j + 1 < prices.length && prices[j + 1] > prices[j]) {
//                j++;
//            }
//            ret += prices[j] - prices[i];
//            i = j;
//        }
//        return ret;
    }
    //k次取反后最大化的数组和
    public int largestSumAfterKNegations(int[] nums, int k) {
        int m = 0,n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int x : nums) {
            if(x < 0) {
                m++;
            }
            min = Math.min(min,Math.abs(x));
        }
        int ret = 0;
        if(m > k) {
            Arrays.sort(nums);
            for (int i = 0; i < k; i++) {
                ret += -nums[i];
            }
            for (int i = k; i < n; i++) {
                ret += nums[i];
            }
        }else {
            int a = k - m;
            for(int x : nums) {
                ret += Math.abs(x);
            }
            if(a % 2 != 0) {
                ret -= 2 * min;
            }
        }
        return ret;
    }
    //按身高排序
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index,(i,j) -> {
            return heights[j] - heights[i];
        });
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            ret[i] = names[index[i]];
        }
        return ret;
    }
    //优势洗牌
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length;
        int[] ret = new int[n];
        Integer[] index = new Integer[m];
        for (int i = 0; i < m; i++) {
            index[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(index,(i,j) -> {
            return nums2[i] - nums2[j];
        });

        int left = 0,right = m - 1;
        for(int x : nums1) {
            if(x <= nums2[index[left]]) {
                ret[index[right]] = x;
                right--;
            }else {
                ret[index[left]] = x;
                left++;
            }
        }
        return ret;

    }
    //最长回文串
    public int longestPalindrome(String s) {
        int ret = 0;
        int[] hash = new int[127];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            hash[c[i]]++;
        }
        for(int x : hash) {
            ret += x / 2 * 2;
        }
        if(ret < s.length()) {
            ret += 1;
        }
        return ret;


    }
    //增减字符串匹配
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ret = new int[n + 1];
        int left = 0,right = n;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == 'I') {
                ret[i] = left;
                left++;
            }else {
                ret[i] = right;
                right--;
            }
        }
        ret[n] = left;
        return ret;
    }
    //分发饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0;
        while (j < s.length && i < g.length) {
            if(s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
    //最优除法
    public String optimalDivision(int[] nums) {
        StringBuilder s = new StringBuilder();
        int n = nums.length;
        if(n == 1) {
            s.append(nums[0]);
        } else if(n == 2) {
            s.append(nums[0]).append("/").append(nums[1]);
        }else {
            s.append(nums[0]).append("/").append("(").append(nums[1]);
            for (int i = 2; i < n; i++) {
                s.append("/").append(nums[i]);
            }
            s.append(")");
        }
        return s.toString();

    }
    //跳跃游戏Ⅱ
    public int jump(int[] nums) {
        int left = 0,right = 0;
        int ret = 0;
        while (right < nums.length - 1) {
            int m = 0;
            for (int i = left; i <= right; i++) {
                m = Math.max(nums[i] + i, m);
            }
            left = right + 1;
            right = m;
            ret++;
        }
        return ret;
    }
    //跳跃游戏
    public boolean canJump(int[] nums) {
        int left = 0,right = 0;
        while (right < nums.length - 1) {
            if(left > right) {
                return false;
            }
            int m = 0;
            for (int i = left; i <= right; i++) {
                m = Math.max(nums[i] + i, m);
            }
            left = right + 1;
            right = m;
        }
        return true;
    }
    //加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int rest = 0;
            int step = 0;
            for (; step < n; step++) {
                int index = (i + step) % n;
                rest = rest + gas[index] - cost[index];
                if(rest < 0) {
                    break;
                }
            }
            if(rest >= 0) {
                return i;
            }
            i = i + step;
        }
        return -1;

    }
    //单调递增的数字
    public int monotoneIncreasingDigits(int n) {
        String ss = String.valueOf(n);
        char[] s = ss.toCharArray();
        int i = 0,m = s.length;
        while (i + 1 < m && s[i] <= s[i + 1]) {
            i++;
        }
        if(i == m - 1) {
            return n;
        }
        while (i >= 1 && s[i] == s[i - 1]) {
            i--;
        }
        s[i]--;
        for (int j = i + 1; j < m; j++) {
            s[j] = '9';
        }
        return Integer.parseInt(new String(s));

    }
    //坏了的计算器
    public int brokenCalc(int startValue, int target) {
        int ret = 0;
        while (target > startValue) {
            if(target % 2 == 0) {
                target /= 2;
            }else {
                target += 1;
            }
            ret++;
        }
        ret += startValue - target;
        return ret;

    }
    //合并区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1,v2) -> {
            return v1[0] - v2[0];
        });
        int left = intervals[0][0],right = intervals[0][1];
        List<int[]> ret = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if(a <= right) {
                right = Math.max(b,right);
            }else {
                ret.add(new int[]{left,right});
                left = a;
                right = b;
            }
        }
        ret.add(new int[]{left,right});
        return ret.toArray(new int[0][]);
    }
    //无重叠区间
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(v1,v2) -> {
            return v1[0] - v2[0];
        });
        int ret = 0;
        int left = intervals[0][0],right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if(a < right) {
                ret++;
                right = Math.min(right,b);
            }else {
                right = b;
            }
        }
        return ret;

    }
    //用最少数量的箭引爆气球
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(v1,v2) -> {
            return v1[0] > v2[0] ? 1 : -1;
        });
        int right = points[0][1],n = points.length;
        int ret = 1;
        for (int i = 1; i < n; i++) {
            int a = points[i][0];
            int b = points[i][1];
            if(a <= right) {
                right = Math.min(right,b);
            }else {
                ret++;
                right = b;
            }
        }
        return ret;
    }
    //整数替换
    HashMap<Long,Integer> hash;
    public int integerReplacement1(int n) {
        hash = new HashMap<>();
        return dfs(n);
    }
    int dfs(long n) {
        if(n == 1) {
            return 0;
        }
        if(hash.containsKey(n)) {
            return hash.get(n);
        }
        if(n % 2 == 0) {
            hash.put(n,dfs(n / 2) + 1);
        }else {
            int t = Math.min(dfs(n - 1),dfs(n + 1));
            hash.put(n,t + 1);
        }
        return hash.get(n);
    }
    public int integerReplacement(int n) {
        int ret = 0;
        while (n > 1) {
            if(n % 2 == 0) {
                n /= 2;
                ret++;
            }else {
                if(n == 3) {
                    ret += 2;
                    n = 1;
                } else if (n % 4 == 1) {
                    n /= 2;
                    ret += 2;
                }else {
                    n = n / 2 + 1;
                    ret += 2;
                }
            }
        }
        return ret;

    }
    //俄罗斯套娃信封
    public int maxEnvelopes1(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes,(v1,v2) -> {
            return v1[0] - v2[0];
        });
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int ret = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ret = Math.max(ret,dp[i]);
        }
        return ret;

    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(v1,v2) -> {
            return v1[0] == v2[0] ? v2[1] - v1[1] : v1[0] - v2[0];
        });
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            int b = envelopes[i][1];
            if(b > ret.get(ret.size() - 1)) {
                ret.add(b);
            }else {
                int left = 0,right = ret.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if(ret.get(mid) >= b) {
                        right = mid;
                    }else {
                        left = mid + 1;
                    }
                }
                ret.set(left,b);
            }
        }
        return ret.size();
    }





}
