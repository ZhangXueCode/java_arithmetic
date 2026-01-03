import com.sun.jdi.connect.spi.TransportService;

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
    //为高尔夫比赛砍树
    int m4;
    int n4;
    public int cutOffTree(List<List<Integer>> forest) {
        m4 = forest.size();
        n4 = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m4; i++) {
            for (int j = 0; j < n4; j++) {
                if(forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i,j});
                }
            }
        }
        Collections.sort(trees,(a,b) -> {
            return forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]);
        });
        int ret = 0;
        int bx = 0,by = 0;
        for(int[] tree : trees) {
            int x = tree[0],y = tree[1];
            int a = bfs(forest,bx,by,x,y);
            if(a == -1) {
                return -1;
            }
            ret += a;
            bx = x;
            by = y;
        }
        return ret;

    }
    int bfs(List<List<Integer>> forest,int bx,int by,int ex,int ey) {
        if(bx == ex && by == ey) {
            return 0;
        }
        boolean[][] vis = new boolean[m4][n4];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{bx,by});
        vis[bx][by] = true;
        int ret = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            ret++;
            while (l-- > 0) {
                int[] t = q.poll();
                int a = t[0],b = t[1];
                for (int i = 0; i < 4; i++) {
                    int x = a + dx[i];
                    int y = b + dy[i];
                    if(x >= 0 && x < m4 && y >= 0 && y < n4 && forest.get(x).get(y) != 0 && !vis[x][y]) {
                        if(x == ex && y == ey) {
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
    //01矩阵
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        for(int[] x : dist) {
            Arrays.fill(x,-1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        //由于dist已经存着层数 不需要step与len来记录是多少层了
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && dist[x][y] == -1) {
                    dist[x][y] = dist[a][b] + 1;
                    q.add(new int[]{x,y});
                }
            }
        }
        return dist;

    }
    //飞地的数量
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if(grid[i][0] == 1) {
                q.add(new int[]{i,0});
                grid[i][0] = 2;
            }
            if(grid[i][n - 1] == 1) {
                q.add(new int[]{i,n - 1});
                grid[i][n - 1] = 2;
            }
        }
        for (int j = 0; j < n; j++) {
            if(grid[0][j] == 1) {
                q.add(new int[]{0,j});
                grid[0][j] = 2;
            }
            if(grid[m - 1][j] == 1) {
                q.add(new int[]{m - 1,j});
                grid[m - 1][j] = 2;
            }
        }
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    q.add(new int[]{x,y});
                    grid[x][y] = 2;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    ret++;
                }
            }
        }
        return ret;

    }
    //地图中的最高点
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ret = new int[m][n];
        for(int[] x : ret) {
            Arrays.fill(x,-1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    ret[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && ret[x][y] == -1) {
                    ret[x][y] = ret[a][b] + 1;
                    q.add(new int[]{x,y});
                }
            }
        }
        return ret;

    }
    //地图分析
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ret = new int[m][n];
        for (int[] x : ret) {
            Arrays.fill(x,-1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    q.add(new int[]{i,j});
                    ret[i][j] = 0;
                }
            }
        }
        int tmp = 0;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && ret[x][y] == -1) {
                    ret[x][y] = ret[a][b] + 1;
                    q.add(new int[]{x,y});
                    tmp = Math.max(tmp,ret[x][y]);
                }
            }
        }
        return tmp == 0 ? -1 : tmp;


    }
    //课程表
    public boolean canFinish(int n, int[][] p) {
        //统计入度
        int[] in = new int[n];
        //存连接关系
        Map<Integer,List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            //b -> a
            int a = p[i][0],b = p[i][1];
            if(!hash.containsKey(b)) {
                hash.put(b,new ArrayList<>());
            }
            hash.get(b).add(a);
            in[a]++;
        }
        //拓扑排序
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            for(int x : hash.getOrDefault(t,new ArrayList<>())) {
                in[x]--;
                if(in[x] == 0) {
                    q.add(x);
                }
            }
        }
        for(int x : in) {
            if(x != 0) {
                return false;
            }
        }
        return true;

    }
    //课程表Ⅱ
    public int[] findOrder(int n, int[][] p) {
        int[] in = new int[n];
        Map<Integer,List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            int a = p[i][0],b = p[i][1];
            if(!hash.containsKey(b)) {
                hash.put(b,new ArrayList<>());
            }
            hash.get(b).add(a);
            in[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }
        int[] ret = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int t = q.poll();
            ret[index++] = t;
            for(int x : hash.getOrDefault(t,new ArrayList<>())) {
                in[x]--;
                if(in[x] == 0) {
                    q.add(x);
                }
            }
        }
        if(index == n) {
            return ret;
        }
        return new int[0];

    }
    //火星词典
    Map<Character,Set<Character>> hash = new HashMap<>();
    Map<Character,Integer> in = new HashMap<>();
    boolean check;
    public String alienOrder(String[] words) {
        for(String s : words) {
            for(char c : s.toCharArray()) {
                if(!in.containsKey(c)) {
                    in.put(c,0);
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String a = words[i],b = words[j];
                add(a,b);
                if(check) {
                    return "";
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for(Character c : in.keySet()) {
            if(in.get(c) == 0) {
                q.add(c);
            }
        }
        StringBuilder s = new StringBuilder();
        while (!q.isEmpty()) {
            char t = q.poll();
            s.append(t);
            if(!hash.containsKey(t)) {
                continue;
            }
            for(Character c : hash.get(t)) {
                in.put(c,in.get(c) - 1);
                if(in.get(c) == 0) {
                    q.add(c);
                }
            }
        }
        for(char c : in.keySet()) {
            if(in.get(c) != 0) {
                return "";
            }
        }
        return s.toString();

    }
    void add(String a,String b) {
        int n = Math.min(a.length(),b.length());
        int i = 0;
        for (;i < n;i++) {
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(i);
            if(ch1 != ch2) {
                if(!hash.containsKey(ch1)) {
                    hash.put(ch1,new HashSet<>());
                }
                if(!hash.get(ch1).contains(ch2)) {
                    hash.get(ch1).add(ch2);
                    in.put(ch2,in.get(ch2) + 1);
                }
                break;
            }
        }
        if(i == b.length() && i < a.length()) {
            check = true;
        }
    }

}
