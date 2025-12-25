import java.util.Arrays;

public class Test {
    //不同路径
    int[][] a;
    public int uniquePaths(int m, int n) {
        a = new int[m + 1][n + 1];
        return dfs(m,n);
    }
    int dfs(int i,int j) {
        if(a[i][j] != 0) {
            return a[i][j];
        }
        if(i == 0 || j == 0) {
            return 0;
        }
        if(i == 1 && j == 1) {
            a[1][1] = 1;
            return 1;
        }
        a[i][j] = dfs(i - 1,j) + dfs(i,j - 1);
        return a[i][j];
    }
    //最长递增子序列
    int[] arr;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        int ret = 1;
        for (int i = 0; i < nums.length; i++) {
            ret = Math.max(dfs(i,nums),ret);
        }
        return ret;

    }
    int dfs(int pose,int[] nums) {
        if(arr[pose] != 0) {
            return arr[pose];
        }
        int ret = 1;
        for (int i = pose + 1; i < nums.length; i++) {
            if(nums[i] > nums[pose]) {
                ret = Math.max(dfs(i,nums),ret) + 1;
            }
        }
        arr[pose] = ret;
        return ret;
    }
    //猜数字大小Ⅱ
    int[][] memo;
    public int getMoneyAmount(int n) {
        memo = new int[n + 1][n + 1];
        return dfs1(1,n);
    }
    int dfs1(int i,int j) {
        if(i >= j) {
            return 0;
        }
        if(memo[i][j] != 0) {
            return memo[i][j];
        }
        int ret = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int x = dfs1(i,k-1);
            int y = dfs1(k + 1,j);
            ret = Math.min(ret,Math.max(x,y) + k);
        }
        memo[i][j] = ret;
        return ret;
    }
}
