import java.util.*;

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
    //岛屿的最大面积
    int m1;
    int n1;
    int c;
    boolean[][] vi;
    public int maxAreaOfIsland(int[][] grid) {
        m1 = grid.length;
        n1 = grid[0].length;
        vi = new boolean[m1][n1];
        int ret = 0;
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                if(grid[i][j] == 1 && !vi[i][j]) {
                    c = 0;
                    bfs(grid,i,j);
                    ret = Math.max(c,ret);
                }
            }
        }
        return ret;
    }
    void bfs(int[][] grid,int i,int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        c++;
        vi[i][j] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k];
                int y = b + dy[k];
                if(x >= 0 && x < m1 && y >= 0 && y < n1 && grid[x][y] == 1 && !vi[x][y]) {
                    q.add(new int[]{x,y});
                    c++;
                    vi[x][y] = true;
                }
            }
        }
    }
    //被围绕的区域
    int m2;
    int n2;
    public void solve(char[][] board) {
        m2 = board.length;
        n2 = board[0].length;
        for (int i = 0; i < m2; i++) {
            if(board[i][0] == 'O') {
                bfs(board,i,0);
            }
            if(board[i][n2 - 1] == 'O') {
                bfs(board,i,n2 - 1);
            }
        }
        for (int j = 0; j < n2; j++) {
            if(board[0][j] == 'O') {
                bfs(board,0,j);
            }
            if(board[m2 - 1][j] == 'O') {
                bfs(board,m2 - 1,j);
            }
        }
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                if(board[i][j] == '.') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    void bfs(char[][] board,int i,int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        board[i][j] = '.';
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k];
                int y = b + dy[k];
                if(x >= 0 && x < m2 && y >= 0 && y < n2 && board[x][y] == 'O') {
                    board[x][y] = '.';
                    q.offer(new int[]{x,y});
                }
            }
        }
    }
    //迷宫中距离入口最近的出口
    int m3;
    int n3;
    boolean[][] vis;
    public int nearestExit(char[][] maze, int[] entrance) {
        m3 = maze.length;
        n3 = maze[0].length;
        vis = new boolean[m3][n3];
        int x = entrance[0],y = entrance[1];
        return bfs1(maze,x,y);
    }
    int bfs1(char[][] maze,int i,int j) {
        int ret = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j] = true;
        while (!q.isEmpty()) {
            int l = q.size();
            ret++;
            for (int k = 0; k < l; k++) {
                int[] t = q.poll();
                int a = t[0],b = t[1];
                for (int o = 0; o < 4; o++) {
                    int x = a + dx[o];
                    int y = b + dy[o];
                    if(x >= 0 && x < m3 && y >= 0 && y < n3 && !vis[x][y] && maze[x][y] == '.') {
                        if(x == 0 || x == m3 - 1 || y == 0 || y == n3 - 1) {
                            return ret;
                        }
                        q.add(new int[]{x,y});
                        vis[x][y] = true;
                    }
                }
            }

        }
        return -1;
    }
    //最小基因变化

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> vis = new HashSet<>();
        char[] a = { 'A', 'C', 'G', 'T' };
        Set<String> hash = new HashSet<>(Arrays.asList(bank));
        if (startGene.equals(endGene)) {
            return 0;
        }
        if (!hash.contains(endGene)) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        vis.add(startGene);
        int ret = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            ret++;
            for (int i = 0; i < l; i++) {
                String s = q.poll();
                for (int j = 0; j < 8; j++) {
                    char[] ss = s.toCharArray();
                    for (char c : a) {
                        ss[j] = c;
                        String tmp = new String(ss);
                        if (hash.contains(tmp) && !vis.contains(tmp)) {
                            if (tmp.equals(endGene)) {
                                return ret;
                            }
                            vis.add(tmp);
                            q.add(tmp);
                        }
                    }

                }
            }
        }
        return -1;
    }
    //单词接龙
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hash = new HashSet<>(wordList);
        Set<String> vis = new HashSet<>();
        if(beginWord.equals(endWord)) {
            return 1;
        }
        if(!hash.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vis.add(beginWord);
        int ret = 1;
        while (!q.isEmpty()) {
            int l = q.size();
            ret++;
            while (l-- > 0) {
                String t = q.poll();
                int len = t.length();
                for (int i = 0; i < len; i++) {
                    char[] s = t.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        s[i] = j;
                        String tmp = new String(s);
                        if(hash.contains(tmp) && !vis.contains(tmp)) {
                            if(tmp.equals(endWord)) {
                                return ret;
                            }
                            vis.add(tmp);
                            q.add(tmp);
                        }

                    }
                }
            }
        }
        return 0;

    }

}
