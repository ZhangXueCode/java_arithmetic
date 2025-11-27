import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public class Test {
    //地下城
    public int min(int[][] d) {
        int m = d.length;
        int n = d[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[m][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - d[i][j];
                dp[i][j] = Math.max(1, dp[i][j]);
            }
        }
        return dp[0][0];
    }

    //简单多状态dp问题
    //按摩师
    public int message(int[] num) {
        int n = num.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = num[0];
        for (int i = 1; i < n; i++) {
            f[i] = g[i - 1] + num[i];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        return Math.max(f[n - 1], g[n - 1]);
    }

    //打家劫舍
    public int robMax(int[] num) {
        int n = num.length;
        return Math.max(num[0] + rob1(num, 2, n - 2), rob1(num, 1, n - 1));
    }

    public int rob1(int[] num, int left, int right) {
        int n = num.length;
        if (left > right) {
            return 0;
        }
        int[] f = new int[n];
        int[] g = new int[n];
        f[left] = num[left];
        for (int i = left + 1; i <= right; i++) {
            f[i] = g[i - 1] + num[i];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        return Math.max(f[right], g[right]);
    }

    //删除并获得点数
    public int maxPoint(int[] num) {
        int t = num.length;
        if (t == 0) {
            return 0;
        }
        int n = 10001;
        int[] arr = new int[n];
        for (int x : num) {
            arr[x] += x;
        }
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = arr[0];
        for (int i = 1; i < n; i++) {
            f[i] = g[i - 1] + arr[i];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        return Math.max(f[n - 1], g[n - 1]);
    }

    //粉刷房子
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i - 1][2];
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }

    //卖卖股票最大利润 含冻结期
    public int maxProfit(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -price[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - price[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + price[i];
        }
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    //卖卖股票最大利润 含手续费
    public int maxProfit2(int[] price, int fee) {
        int n = price.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = -price[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], g[i - 1] - price[i]);
            g[i] = Math.max(g[i - 1], f[i - 1] + price[i] - fee);

        }
        return Math.max(f[n - 1], g[n - 1]);
    }

    //买卖股票最佳时期 最多交易两次
    public int maxProfit3(int[] price) {
        int n = price.length;
        int[][] f = new int[n][3];
        int[][] g = new int[n][3];
        f[0][0] = -price[0];
        f[0][1] = f[0][2] = -0x3f3f3f3f;
        g[0][1] = g[0][2] = -0x3f3f3f3f;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] = Math.max(f[i - 1][j], g[i - 1][j] - price[i]);
                g[i][j] = g[i - 1][j];
                if (j - 1 >= 0) {
                    g[i][j] = Math.max(g[i][j], f[i - 1][j - 1] + price[i]);
                }
            }
        }
        return Math.max(g[n - 1][0], Math.max(g[n - 1][1], g[n - 1][2]));

    }

    //买卖股票最佳时期 最多交易k次
    public int maxProfit4(int[] price, int k) {
        int n = price.length;
        k = Math.min(k, n / 2);
        int[][] f = new int[n][k + 1];
        int[][] g = new int[n][k + 1];
        f[0][0] = -price[0];
        for (int i = 1; i < k; i++) {
            f[0][i] = g[0][i] = -0x3f3f3f3f;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                f[i][j] = Math.max(f[i - 1][j], g[i - 1][j] - price[i]);
                g[i][j] = g[i - 1][j];
                if (j - 1 >= 0) {
                    g[i][j] = Math.max(g[i][j], f[i - 1][j - 1] + price[i]);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < k; i++) {
            ret = Math.max(ret, g[n - 1][i]);
        }
        return ret;
    }

    //子数组的最大值
    public int maxSubArray(int[] num) {
        int n = num.length;
        int[] dp = new int[n + 1];
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i - 1], num[i - 1]);
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    //环形子数组最大值
    public int maxSubArrayCircle(int[] num) {
        int n = num.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        int ret = Integer.MIN_VALUE;
        int k = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            f[i] = Math.max(f[i - 1] + num[i - 1], num[i - 1]);
            ret = Math.max(ret, f[i]);
            g[i] = Math.min(g[i - 1] + num[i - 1], num[i - 1]);
            k = Math.min(g[i], k);
        }
        int t = sum - k;
        return k == sum ? ret : Math.max(t, ret);
    }

    //子数组最大乘积
    public int maxProduct(int[] num) {
        int n = num.length;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        f[0] = g[0] = 1;
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Math.max(num[i - 1], Math.max(f[i - 1] * num[i - 1], g[i - 1] * num[i - 1]));
            g[i] = Math.min(num[i - 1], Math.min(g[i - 1] * num[i - 1], f[i - 1] * num[i - 1]));
            ret = Math.max(ret, g[i]);
        }
        return ret;

    }

    //子数组乘积为正数的最大长度
    public int getMaxLen(int[] num) {
        int n = num.length;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (num[i - 1] > 0) {
                f[i] = f[i - 1] + 1;
                g[i] = g[i - 1] < 0 ? 0 : g[i - 1] + 1;
            } else {
                f[i] = g[i - 1] < 0 ? 0 : g[i - 1] + 1;
                g[i] = f[i - 1] + 1;
            }
            ret = Math.max(ret, f[i]);

        }
        return ret;
    }

    //等差数列的划分
    public int number(int[] num) {
        int n = num.length;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = (num[i] - num[i - 1]) == (num[i - 1] - num[i - 2]) ? dp[i - 1] + 1 : 0;
            sum += dp[i];
        }
        return sum;
    }

    //最长湍流子数组
    public int MaxTurbulence(int[] num) {
        int n = num.length;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        f[0] = g[0] = 1;
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = g[i] = 1;
            if (num[i - 1] < num[i]) {
                f[i] = g[i - 1] + 1;
            }
            if (num[i - 1] > num[i]) {
                g[i] = f[i - 1] + 1;
            }
            ret = Math.max(f[i], g[i]);
        }
        return ret;
    }

    //单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        s = "1" + s;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                String a = s.substring(j, i + 1);
                if (dp[j - 1] && wordDict.contains(a)) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    //环绕字符串中唯一子字符串
    public int findAround(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int[] dp = new int[n];
        int[] ch = new int[26];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            if (ss[i - 1] + 1 == ss[i] || ss[i - 1] == 'z' && ss[i] == 'a') {
                dp[i] += dp[i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            ch[ss[i] - 'a'] = Math.max(ch[ss[i] - 'a'], dp[i]);
        }
        int sum = 0;
        for (int x : ch) {
            sum += x;
        }
        return sum;
    }

    //最长递增子序列
    public int lengthOfLis(int[] num) {
        int n = num.length;
        int[] dp = new int[n];
        int ret = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    //摆动序列
    public int wiggleMaxLen(int[] num) {
        int n = num.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = g[0] = 1;
        int ret = 1;
        for (int i = 1; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    f[i] = Math.max(f[i], g[j] + 1);
                } else if (num[i] < num[j]) {
                    g[i] = Math.max(g[i], f[j] + 1);
                }
            }
            ret = Math.max(f[i], g[i]);
        }
        return ret;
    }

    //最长递增子序列的个数
    public int findNumberOfLIS(int[] num) {
        int n = num.length;
        int[] len = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = count[i] = 1;
        }
        int retLen = 1, retCount = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    if (len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    } else if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (retLen == len[i]) {
                retCount += count[i];
            } else if (retLen < len[i]) {
                retLen = len[i];
                retCount = count[i];

            }
        }
        return retCount;
    }

    //最长数对链
    public int findLongestChain(int[][] p) {
        Arrays.sort(p, (a, b) -> a[0] - b[0]);
        int n = p.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int ret = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (p[j][1] < p[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    //最长定差子序列
    public int LongestSubsequence(int[] arr, int d) {
        Map<Integer, Integer> hash = new HashMap<>();
        int ret = 1;
        for (int x : arr) {
            //此处会直接覆盖掉之前出现的x-d值 保证这里拿到的会是最后的值
            hash.put(x, hash.getOrDefault(x - d, 0) + 1);
            ret = Math.max(ret, hash.get(x));
        }
        return ret;
    }

    //最长斐波那契子序列
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> hash = new HashMap<>();
        int n = arr.length;
        int[][] dp = new int[n][n];
        int ret = 2;
        for (int i = 0; i < n; i++) {
            hash.put(arr[i], i);
            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        for (int j = 2; j < n; j++) {
            for (int i = 1; i < j; i++) {
                int a = arr[j] - arr[i];
                if (a < arr[i] && hash.containsKey(a)) {
                    int k = hash.get(a);
                    dp[i][j] = dp[k][i] + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        if (ret == 2) {
            return 0;
        }
        return ret;

    }

    //最长等差数列
    public int longestArithSeqLength(int[] num) {
        Map<Integer, Integer> hash = new HashMap<>();
        int n = num.length;
        int[][] dp = new int[n][n];
        int ret = 2;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 2;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2;
                int a = 2 * num[i] - num[j];
                if (hash.containsKey(a)) {
                    int k = hash.get(a);
                    dp[i][j] = dp[k][i] + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }
            hash.put(num[i], i);
        }
        return ret;

    }

    //等差序列划分
    public int numberOfArithmeticSlices(int[] num) {
        int n = num.length;
        Map<Long, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long tmp = (long) num[i];
            if (!hash.containsKey(tmp)) {
                hash.put(tmp, new ArrayList<>());
            }
            hash.get(tmp).add(i);
        }
        int[][] dp = new int[n][n];
        int sum = 0;
        for (int j = 2; j < n; j++) {
            for (int i = 1; i < j; i++) {
                long a = 2L * num[i] - num[j];
                if (hash.containsKey(a)) {
                    for (int x : hash.get(a)) {
                        if (x < i) {
                            dp[i][j] += dp[x][i] + 1;
                        } else {
                            break;
                        }
                    }
                }
                sum += dp[i][j];
            }
        }
        return sum;

    }

    //回文子串
    public int countSubstrings(String ss) {
        int n = ss.length();
        char[] s = ss.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (s[i] != s[j]) {
                    dp[i][j] = false;
                } else {
                    if (i == j || i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    sum++;
                }
            }
        }
        return sum;

    }

    //最长回文子串
    public String longestPalindrome(String ss) {
        int n = ss.length();
        char[] s = ss.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int sum = 1, begin = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (s[i] != s[j]) {
                    dp[i][j] = false;
                } else {
                    if (i == j || i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > sum) {
                    sum = j - i + 1;
                    begin = i;
                }
            }
        }
        return ss.substring(begin, begin + sum);

    }

    //回文串分割Ⅳ
    public boolean checkPartitioning(String ss) {
        int n = ss.length();
        char[] s = ss.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (s[i] != s[j]) {
                    dp[i][j] = false;
                } else {
                    if (i == j || i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n - 1; j++) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    //分割回文串Ⅱ
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] dp2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 1 >= j ? true : dp[i + 1][j - 1];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            dp2[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                dp2[i] = 0;
            } else {
                for (int j = 1; j <= i; j++) {
                    if (dp[j][i]) {
                        dp2[i] = Math.min(dp2[j - 1] + 1, dp2[i]);
                    }
                }
            }
        }
        return dp2[n - 1];
    }

    //最长回文子序列
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }

            }
        }
        return dp[0][n - 1];

    }

    //让字符串成为回文串的最小插入次数
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[0][n - 1];

    }

    //最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        text1 = " " + text1;
        text2 = " " + text2;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //不相交的线
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    //不同的子序列
    public int numDistinct(String s, String t) {
        s = " " + s;
        t = " " + t;
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

    //通配符匹配
    public boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            if (p.charAt(i) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];

    }

    //正则表达式匹配
    public boolean isMatch2(String s, String p) {
        s = " " + s;
        p = " " + p;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                if (p.charAt(i) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j - 2] || (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) && dp[i - 1][j];
                } else {
                    dp[i][j] = (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];

    }
    //交错字符串
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()) {
            return false;
        }
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if(s1.charAt(i) == s3.charAt(i)) {
                dp[i][0] = true;
            }else {
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(s2.charAt(i) == s3.charAt(i)) {
                dp[0][i] = true;
            }else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = ((s1.charAt(i) == s3.charAt(i + j)) && dp[i - 1][j])
                        || ((s2.charAt(j) == s3.charAt(i + j)) && dp[i][j - 1]);
            }
        }
        return dp[m][n];

    }
    //两个字符串的最小ASCII删除值
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int [][] dp = new int[m + 1][n + 1];
        int sum = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1] + s1.charAt(i - 1));
                }
            }
        }
        for(char ch : s1.toCharArray()) {
            sum += ch;
        }
        for(char ch : s2.toCharArray()) {
            sum += ch;
        }
        return sum - 2 * dp[m][n];

    }
    //最长重复子数组
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int ret = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ret = Math.max(ret,dp[i][j]);
                }

            }
        }
        return ret;
    }
    //01背包问题
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int V = in.nextInt();
        int[] Vi = new int[n + 1];
        int[] Wi = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Vi[i] = in.nextInt();
            Wi[i] = in.nextInt();
        }
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= Vi[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j - Vi[i]] + Wi[i]);
            }
        }
        System.out.println(dp[V]);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                dp[j] = 0;
            }
        }
        for (int i = 1; i <= V; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= Vi[i]; j--) {
                if(dp[j - Vi[i]] != -1) {
                    dp[j] = Math.max(dp[j],dp[j - Vi[i]] + Wi[i]);
                }
            }
        }
        System.out.println(dp[V] == -1 ? 0 : dp[V]);
    }
    //分割等和子集
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum % 2 ==1) {
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = sum / 2;j >= nums[i - 1];j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[sum / 2];
    }
    //目标和
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int x : nums) {
            sum += x;
        }
        int a = (sum + target) / 2;
        if(a < 0 || (sum + target) % 2 == 1) {
            return 0;
        }
        int[] dp = new int[a + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = a; j >= nums[i - 1]; j--) {
                dp[j] += dp[j - nums[i - 1]];
            }
        }
        return dp[a];
    }
    //最后一块石头的重量
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length,sum = 0;
        for(int x : stones) {
            sum += x;
        }
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - 2 * dp[n][sum / 2];

    }
    //完全背包
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int V = in.nextInt();
        int[] Vi = new int[n + 1];
        int[] Wi = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Vi[i] = in.nextInt();
            Wi[i] = in.nextInt();
        }
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                if(j >= Vi[i]) {
                    dp[j] = Math.max(dp[j],dp[j - Vi[i]] + Wi[i]);
                }
            }
        }
        System.out.println(dp[V]);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                dp[j] = 0;
            }
        }
        for (int i = 1; i <= V; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                if(j >= Vi[i]) {
                    if(dp[j - Vi[i]] != -1) {
                        dp[j] = Math.max(dp[j],dp[j - Vi[i]] + Wi[i]);
                    }
                }
            }
        }
        System.out.println(dp[V] == -1 ? 0 : dp[V]);

    }











}
