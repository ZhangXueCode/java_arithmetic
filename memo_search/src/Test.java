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
}
