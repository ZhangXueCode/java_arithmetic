import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                dp[i][j] = Math.min(dp[i + 1][j],dp[i][j + 1]) - d[i][j];
                dp[i][j] = Math.max(1,dp[i][j]);
            }
        }
        return dp[0][0];
    }
    //简单多状态dp问题
    //按摩师
    public int message(int[] num) {
        int n = num.length;
        if(n == 0) {
            return 0;
        }
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = num[0];
        for (int i = 1; i < n; i++) {
            f[i] = g[i - 1] + num[i];
            g[i] = Math.max(f[i - 1],g[i - 1]);
        }
        return Math.max(f[n - 1],g[n - 1]);
    }
    //打家劫舍
    public int robMax(int[] num) {
        int n = num.length;
        return Math.max(num[0] + rob1(num,2,n - 2),rob1(num,1,n - 1));
    }
    public int rob1(int[] num,int left,int right) {
        int n = num.length;
        if(left > right) {
            return 0;
        }
        int[] f = new int[n];
        int[] g = new int[n];
        f[left] = num[left];
        for(int i = left + 1;i <= right;i++) {
            f[i] = g[i - 1] + num[i];
            g[i] = Math.max(f[i - 1],g[i - 1]);
        }
        return Math.max(f[right],g[right]);
    }
    //删除并获得点数
    public int maxPoint(int[] num) {
        int t = num.length;
        if(t == 0) {
            return 0;
        }
        int n = 10001;
        int[] arr = new int[n];
        for(int x : num) {
            arr[x] += x;
        }
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = arr[0];
        for (int i = 1; i < n; i++) {
            f[i] = g[i - 1] + arr[i];
            g[i] = Math.max(f[i - 1],g[i - 1]);
        }
        return Math.max(f[n - 1],g[n - 1]);
    }
    //粉刷房子
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1],dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][2],dp[i - 1][0]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][1],dp[i - 1][0]) + costs[i - 1][2];
        }
        return Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]));
    }
    //卖卖股票最大利润 含冻结期
    public int maxProfit(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -price[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - price[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][2]);
            dp[i][2] =dp[i - 1][0] + price[i];
        }
        return Math.max(dp[n - 1][0],Math.max(dp[n - 1][1],dp[n - 1][2]));
    }
    //卖卖股票最大利润 含手续费
    public int maxProfit2(int[] price,int fee) {
        int n = price.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = -price[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1],g[i - 1] - price[i]);
            g[i] = Math.max(g[i - 1],f[i - 1] + price[i] - fee);

        }
        return Math.max(f[n - 1],g[n - 1]);
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
                f[i][j] = Math.max(f[i - 1][j],g[i - 1][j] - price[i]);
                g[i][j] = g[i - 1][j];
                if(j - 1 >= 0) {
                    g[i][j] = Math.max(g[i][j],f[i - 1][j - 1] + price[i]);
                }
            }
        }
        return Math.max(g[n - 1][0],Math.max(g[n - 1][1],g[n - 1][2]));

    }
    //买卖股票最佳时期 最多交易k次
    public int maxProfit4(int[] price,int k) {
        int n = price.length;
        k = Math.min(k,n / 2);
        int[][] f = new int[n][k + 1];
        int[][] g = new int[n][k + 1];
        f[0][0] = -price[0];
        for (int i = 1; i < k; i++) {
            f[0][i] = g[0][i] = -0x3f3f3f3f;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                f[i][j] = Math.max(f[i - 1][j],g[i - 1][j] - price[i]);
                g[i][j] = g[i - 1][j];
                if(j - 1 >= 0) {
                    g[i][j] = Math.max(g[i][j],f[i - 1][j - 1] + price[i]);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < k; i++) {
            ret = Math.max(ret,g[n - 1][i]);
        }
        return ret;
    }
    //子数组的最大值
    public int maxSubArray(int[] num) {
        int n = num.length;
        int[] dp = new int[n + 1];
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i - 1],num[i - 1]);
            ret = Math.max(ret,dp[i]);
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
            f[i] = Math.max(f[i - 1] + num[i - 1],num[i - 1]);
            ret = Math.max(ret,f[i]);
            g[i] = Math.min(g[i - 1] + num[i - 1],num[i - 1]);
            k = Math.min(g[i],k);
        }
        int t = sum - k;
        return k == sum ? ret : Math.max(t,ret);
    }
    //子数组最大乘积
    public int maxProduct(int[] num) {
        int n =num.length;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        f[0] = g[0] = 1;
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Math.max(num[i - 1],Math.max(f[i - 1] * num[i - 1],g[i - 1] * num[i - 1]));
            g[i] = Math.min(num[i - 1],Math.min(g[i - 1] * num[i - 1],f[i - 1] * num[i - 1]));
            ret = Math.max(ret,g[i]);
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
            if(num[i - 1] > 0) {
                f[i] = f[i - 1] + 1;
                g[i] = g[i - 1] < 0 ? 0 : g[i - 1] + 1;
            }else {
                f[i] = g[i - 1] < 0 ? 0 : g[i - 1] + 1;
                g[i] = f[i - 1] + 1;
            }
            ret = Math.max(ret,f[i]);

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
            if(num[i - 1] < num[i]) {
                f[i] = g[i - 1] + 1;
            }
            if(num[i - 1] > num[i]) {
                g[i] = f[i - 1] + 1;
            }
            ret = Math.max(f[i],g[i]);
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
                String a = s.substring(j,i + 1);
                if(dp[j - 1] && wordDict.contains(a)) {
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
            if(ss[i - 1] + 1 == ss[i] || ss[i - 1] == 'z' && ss[i] == 'a') {
                dp[i] += dp[i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            ch[ss[i] - 'a'] = Math.max(ch[ss[i] - 'a'],dp[i]);
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
                if(num[j] < num[i]) {
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
            ret = Math.max(ret,dp[i]);
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
                if(num[i] > num[j]) {
                    f[i] = Math.max(f[i],g[j] + 1);
                } else if (num[i] < num[j]) {
                    g[i] = Math.max(g[i],f[j] + 1);
                }
            }
            ret = Math.max(f[i],g[i]);
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
        int retLen = 1,retCount = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(num[i] > num[j]) {
                    if(len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    } else if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if(retLen == len[i]) {
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
        Arrays.sort(p,(a,b) -> a[0] - b[0]);
        int n = p.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int ret = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(p[j][1] < p[i][0]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }





}
