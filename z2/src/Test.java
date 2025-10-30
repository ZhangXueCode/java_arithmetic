//动态规划
public class Test {
    //第n个泰波那契数
    public int add(int n) {
        //1.创建dp数组
        //2.初始化
        //3.填表
        //4.返回值
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
    //优化空间
    public int add2(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int a = 0,b = 1,c = 1,d = 0;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
    //三步走法
    public int waysToStep(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;dp[2] = 2;dp[3] = 4;
        int MON = (int)1e9 + 7;
        for (int i = 4; i <= n ; i++) {
            dp[n] = ((dp[n - 1] + dp[n - 2]) % MON + dp[n - 3]) % MON;
        }
        return dp[n];
    }
    //爬楼梯到楼顶的最小花费
    public int minCost(int[] cost) {
        //状态表示：以i位置为结尾 到达i位置的最小花费 此时求的i就得是楼顶
        int i = cost.length;
        int[] dp = new int[i + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int j = 2; j <= i ; j++) {
            dp[j] = Math.min(dp[j - 1] + cost[j - 1],dp[j - 2] + cost[j - 2]);
        }
        return dp[i];
    }
    public int minCost2(int[] cost) {
        //状态表示：以i位置为起点到达楼顶的最小花费
        int n = cost.length;
        int[] dp = new int[n];
        dp[n - 1] = cost[n - 1];
        dp[n - 2] = cost[n - 2];
        for (int i = n - 3; i >=0 ; i--) {
            dp[i] = Math.min(dp[i + 1] + cost[i],dp[i + 2] + dp[i]);
        }
        return Math.min(dp[0],dp[1]);
    }
    //解密方法的总数
    public int num(String s) {
        int n = s.length();
        int[] dp = new int[n];
        char[] ch = s.toCharArray();
        if(ch[0] != '0') {
            dp[0] = 1;
        }
        if(n == 1) {
            return dp[0];
        }
        if(ch[0] != '0' && ch[1] != '0') {
            dp[1] +=1;
        }
        int t = (ch[0] - '0') * 10 + ch[1] - '0';
        if(t >= 10 && t <= 26) {
            dp[1] +=1;
        }
        for (int i = 2; i < n; i++) {
            if(ch[i] != '0') {
                dp[i] +=dp[i - 1];
            }
            int t2 = (ch[i - 1] - '0') * 10 + ch[i] - '0';
            if(t2 >= 10 && t2 <= 26) {
                dp[i] +=dp[i - 2];
            }
        }
        return dp[n - 1];

    }
    //从【0，0】位置走到【m,n】位置一共多少方法
    public int uniquePath(int m,int n) {
        int [][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] +dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
    //从【0，0】位置走到【m,n】位置一共多少方法 有障碍物的位置为1 其余为0
    public int uniquePath2(int[][] num) {
        int m = num.length,n = num[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(num[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i][j - 1] +dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
    //每个位置有价值 走到【m,n】时的最大价值是多少
    public int maxValue(int[][] num) {
        int m = num.length;
        int n = num[0].length;
        int [][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]) +num[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
    //下降路径最小和
    public int minFall(int[][] m) {
        int n = m.length;
        int[][] dp = new int[n + 1][n + 2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i][n + 1] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i - 1][j - 1],dp[i - 1][j +1])) +m[i - 1][j - 1];
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            ret = Math.min(ret,dp[n][i]);
        }
        return ret;
    }
    //最小路径和
    public int minPath(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[1][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + g[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

}
