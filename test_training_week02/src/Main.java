import java.io.*;
import java.util.Arrays;
import java.util.*;

public class Main {
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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arr = new int[6];
        for(int i = 0;i < t;i++) {
            for(int j = 0;j < 6;j++) {
                arr[j] = in.nextInt();
            }
            Arrays.sort(arr);
            if(arr[0] + arr[1] > arr[2] && arr[3] + arr[4] > arr[5] ||
                    arr[0] + arr[2] > arr[3] && arr[1] + arr[4] > arr[5] ||
                    arr[0] + arr[3] > arr[4] && arr[1] + arr[2] > arr[5] ||
                    arr[0] + arr[4] > arr[5] && arr[1] + arr[2] > arr[3]){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

}
