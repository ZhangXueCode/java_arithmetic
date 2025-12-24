import java.util.LinkedList;
import java.util.Queue;

public class Test {
    //图像渲染
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int pre = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        if(pre == color) {
            return image;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            image[a][b] = color;
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && image[x][y] == pre) {
                    q.offer(new int[]{x,y});
                }
            }
        }
        return image;

    }
    //岛屿数量
    int m;
    int n;
    boolean[][] v;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        v = new boolean[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !v[i][j]) {
                    ret++;
                    bfs(i,j,grid);
                }
            }
        }
        return ret;
    }
    void bfs(int i,int j,char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        v[i][j] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k];
                int y = b + dy[k];
                if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && !v[x][y]) {
                    q.add(new int[]{x,y});
                    v[x][y] = true;
                }
            }
        }
    }
}
