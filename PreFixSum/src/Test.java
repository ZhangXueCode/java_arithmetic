import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
//    public static void main(String[] args) {
//        //一维前缀和模板
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(),q = in.nextInt();
//        int[] arr = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            arr[i] = in.nextInt();
//        }
//        int[] dp = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            dp[i] = dp[i - 1] + arr[i];
//        }
//        while (q < 0) {
//            int l = in.nextInt(),r = in.nextInt();
//            System.out.println(dp[r] - dp[l - 1]);
//            q--;
//        }
//
//
//    }

//    public static void main(String[] args) {
//        //二维前缀和模板
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(),m = in.nextInt(),q = in.nextInt();
//        int[][] arr = new int[n + 1][m + 1];
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                arr[i][j] = in.nextInt();
//                dp[i][j] = dp[i - 1][j] +dp[i][j - 1] + arr[i][j] - dp[i - 1][j - 1];
//            }
//        }
//        while (q < 0) {
//            int x1 = in.nextInt(),y1 = in.nextInt(),x2 = in.nextInt(),y2 = in.nextInt();
//            System.out.println(dp[x2][y2] - dp[x1 -1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]);
//            q--;
//        }
//
//    }
    //
    //返回一个索引 使这个索引左边值的和=右边的和
    public int pivotIndex(int[] num) {
        int n = num.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + num[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            g[i] = g[i + 1] + num[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if(f[i] == g[i]) {
                return i;
            }
        }
        return -1;
    }
    //除自身以外其余值的乘积
    public int[] productExceptSelf(int[] num) {
        int n = num.length;
        int[] f = new int[n];
        int[] g = new int[n];
        int[] ret = new int[n];
        f[0] = g[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * num[i - 1];
        }
        for (int i = n - 2; i >= 0 ; i--) {
            g[i] = g[i + 1] * num[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ret[i] = f[i] * g[i];
        }
        return ret;
    }
    //子数组和为k的个数
    public int SubArraySum(int[] num,int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int sum = 0,ret = 0;
        for (int x : num) {
            sum += x;
            ret += hashMap.getOrDefault(sum - k,0);
            hashMap.put(sum,hashMap.getOrDefault(sum,0) + 1);
        }
        return ret;
    }
    //子数组和能被k整除的个数
    public int subArrayDivByk(int[] num,int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,1);
        int sum = 0,ret = 0;
        for(int x : num) {
            sum += x;
            int t = (sum % k + k) % k;
            ret += hash.getOrDefault(t,0);
            hash.put(t,ret + 1);
        }
        return ret;
    }
    //连续数组
    public int MaxLen(int[] num) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,-1);
        int sum = 0,ret = 0;
        for (int i = 0; i < num.length; i++) {
            sum += (num[i] == 0 ? -1 : 1);
            if(hash.containsKey(sum)) {
                ret = Math.max(ret,i - hash.get(sum));
            }else {
                hash.put(sum,i);
            }
        }
        return ret;
    }
    //矩阵区域和
    public int[][] blockSum(int[][] mat,int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = Math.max(0,i - k) + 1,y1 = Math.max(0,j - k) + 1,x2 = Math.min(m - 1,i + k) + 1,y2 = Math.min(n - 1,j + k);
                ret[i][j] = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            }
        }
        return ret;
    }



}
