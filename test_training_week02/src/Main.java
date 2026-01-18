import java.io.*;
import java.util.Arrays;
import java.util.*;

public class Main {
    //Day-07
    //找出字符串中连续的最长字符
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new
//                InputStreamReader(System.in));
//        char[] c = br.readLine().toCharArray();
//        int len = 0,bl = 0;
//        for(int i = 0;i < c.length;i++) {
//            if(c[i] >= '0' && c[i] <= '9') {
//                int j = i;
//                while(j < c.length && c[j] >= '0' && c[j] <= '9') {
//                    j++;
//                }
//                if(j - i > len) {
//                    bl = i;
//                    len = j - i;
//                }
//                i = j;
//            }
//        }
//        for(int i = bl;i < bl + len;i++) {
//            System.out.print(c[i]);
//        }

//    }
    //岛屿数量
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] v;
    int m;
    int n;
    public int solve (char[][] grid) {
        int ret = 0;
        m = grid.length;
        n = grid[0].length;
        v = new boolean[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == '1' && !v[i][j]) {
                    dfs(grid,i,j);
                    ret++;
                }
            }
        }

        return ret;
    }
    void dfs(char[][] grid,int i,int j) {
        v[i][j] = true;
        for(int k = 0;k < 4;k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && !v[x][y]) {
                dfs(grid,x,y);
            }
        }
    }
    //拼三角
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        int[] arr = new int[6];
//        for(int i = 0;i < t;i++) {
//            for(int j = 0;j < 6;j++) {
//                arr[j] = in.nextInt();
//            }
//            Arrays.sort(arr);
//            if(arr[0] + arr[1] > arr[2] && arr[3] + arr[4] > arr[5] ||
//                    arr[0] + arr[2] > arr[3] && arr[1] + arr[4] > arr[5] ||
//                    arr[0] + arr[3] > arr[4] && arr[1] + arr[2] > arr[5] ||
//                    arr[0] + arr[4] > arr[5] && arr[1] + arr[2] > arr[3]){
//                System.out.println("Yes");
//            }else {
//                System.out.println("No");
//            }
//        }
//    }
    //Day-08
    //求最小公倍数
//    static int gcd(int a,int b) {
//        if(b == 0) {
//            return a;
//        }
//        return gcd(b,a % b);
//
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        int b = in.nextInt();
//        System.out.print(a * b / gcd(a,b));
//    }
    //数组中最长连续子序列(1,2,3...)
    public int MLS (int[] arr) {
        Arrays.sort(arr);
        int ret = 1;
        int i = 0;
        while(i < arr.length) {
            int j = i + 1,count = 1;
            while(j < arr.length) {
                if(arr[j] - 1 == arr[j - 1]) {
                    count++;
                    j++;
                }else if(arr[j] == arr[j - 1]) {
                    j++;
                }else {
                    break;
                }
            }
            ret = Math.max(ret,count);
            i = j;
        }
        return ret;
    }
    //字母收集
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        char[][] a = new char[n][m];
//        for (int i = 0; i < n; i++) {
//            char[] s = in.next().toCharArray();
//            for (int j = 0; j < m; j++) {
//                a[i][j] = s[j];
//            }
//        }
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (a[i - 1][j - 1] == 'l') {
//                    dp[i][j] = 4;
//                } else if (a[i - 1][j - 1] == 'o') {
//                    dp[i][j] = 3;
//                } else if (a[i - 1][j - 1] == 'v') {
//                    dp[i][j] = 2;
//                } else if (a[i - 1][j - 1] == 'e') {
//                    dp[i][j] = 1;
//                }
//                dp[i][j] += Math.max(dp[i - 1][j],dp[i][j - 1]);
//            }
//        }
//        System.out.print(dp[n][m]);
//    }

}
