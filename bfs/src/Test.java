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
}
