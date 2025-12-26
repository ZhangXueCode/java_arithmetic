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
    //矩阵中的最长递增路径
    int m2;
    int n2;
    int[][] m;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int longestIncreasingPath(int[][] matrix) {
        m2 = matrix.length;
        n2 = matrix[0].length;
        m = new int[m2][n2];
        int ret = 0;
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                ret = Math.max(ret,dfs(matrix,i,j));
            }
        }
        return ret;

    }
    int dfs(int[][] matrix,int i,int j) {
        if(m[i][j] != 0) {
            return m[i][j];
        }
        int ret = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && x < m2 && y >= 0 && y < n2 && matrix[x][y] > matrix[i][j]) {
                ret = Math.max(ret,dfs(matrix,x,y) + 1);
            }
        }
        m[i][j] = ret;
        return ret;
    }
}
