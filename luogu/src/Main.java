

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    //最少修改次数
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = " " + in.next();
//        String t = " " + in.next();
//        int m = s.length();
//        int n = t.length();
//        int[][] dp = new int[m][n];
//        for (int i = 1; i < n; i++) {
//            dp[0][i] = 0x3f3f3f;
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if(s.charAt(i) != t.charAt(j)) {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,dp[i][j]);
//                }else {
//                    dp[i][j] = Math.min(dp[i][j],dp[i - 1][j - 1]);
//                }
//            }
//        }
//        System.out.println(dp[m - 1][n - 1]);
//    }
    //特殊年份
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[] a = new int[5];
//        int ret = 0;
//        for (int i = 0; i < 5; i++) {
//            a[i] = in.nextInt();
//            String s = String.valueOf(a[i]);
//            if(s.charAt(0) == s.charAt(2) && (int) s.charAt(1) + 1 == (int)s.charAt(3)) {
//                ret++;
//            }
//        }
//        System.out.println(ret);
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        double d = in.nextDouble();
//
//        // 用BigDecimal保证精度，计算2^n * d
//        BigInteger base = BigInteger.valueOf(2).pow(n);
//        BigDecimal num = new BigDecimal(base).multiply(BigDecimal.valueOf(d));
//
//        // 四舍五入取整
//        BigDecimal ret = num.setScale(0, RoundingMode.HALF_UP);
//        System.out.println(ret);
//
//    }
    //铺地毯
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[][] a = new int[n][4];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 4; j++) {
//                a[i][j] = in.nextInt();
//            }
//        }
//        int x = in.nextInt();
//        int y = in.nextInt();
//        boolean flag = false;
//        for (int i = n - 1; i >= 0; i--) {
//            if(x >= a[i][0] && x <= a[i][0] + a[i][2] && y >= a[i][1] && y <= a[i][1] + a[i][3]) {
//                System.out.println(i + 1);
//                flag = true;
//                break;
//            }
//        }
//        if(!flag) {
//            System.out.println("-1");
//        }
//
//    }
    //好数
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int c = 0;
//        for (int i = 1; i <= n; i++) {
//            int num = i;
//            for (int j = 1; num >= 0; j++) {
//                if((j % 2) != (num % 10) % 2) {
//                    break;
//                }
//                num /= 10;
//            }
//            if(num == 0) {
//                c++;
//            }
//        }
//        System.out.println(c);
//
//
//    }
    //高精度除法
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        int c = in.nextInt();
//        int[] a = new int[(int)(1e6 + 10)];
//        int[] b = new int[(int)(1e6 + 10)];
//        for (int i = 0; i < s.length(); i++) {
//            a[s.length() - 1 - i] = s.charAt(i) - '0';
//        }
//        long t = 0;
//        int l = s.length();
//        for (int i = s.length() - 1; i >= 0; i--) {
//            t = t * 10 + a[i];
//            b[i] = (int) t / c;
//            t %= c;
//        }
//        while (l > 1 && b[l - 1] == 0) {
//            l--;
//        }
//        for (int j = l - 1; j >= 0; j--) {
//            System.out.print(b[j]);
//        }
//
//    }
    //高精度乘法
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        String c = in.next();
//        if(s.equals("0")|| c.equals("0")) {
//            System.out.print("0");
//            return;
//        }
//        int[] a = new int[(int)(1e6 + 10)];
//        int[] b = new int[(int)(1e6 + 10)];
//        int[] d = new int[(int)(1e6 + 10)];
//
//        for (int i = 0; i < s.length(); i++) {
//            a[s.length() - 1 - i] = s.charAt(i) - '0';
//        }
//        for (int i = 0; i < c.length(); i++) {
//            b[c.length() - 1 - i] = c.charAt(i) - '0';
//        }
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < c.length(); j++) {
//                d[i + j] += a[i] * b[j];
//            }
//        }
//        int l = s.length() + c.length() ;
//        for (int i = 0; i < l; i++) {
//            d[i + 1] += d[i] / 10;
//            d[i] %= 10;
//        }
//        while(l > 1 && d[l - 1] == 0) {
//            l--;
//        }
//
//        for (int j = l - 1; j >= 0; j--) {
//            System.out.print(d[j]);
//        }
//    }
    //高精度减法
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        String c = in.next();
//        int[] a = new int[(int)(1e6 + 10)];
//        int[] b = new int[(int)(1e6 + 10)];
//        int[] d = new int[(int)(1e6 + 10)];
//        if(s.length() < c.length()) {
//            String e = s;
//            s = c;
//            c = e;
//            System.out.print("-");
//        }else if(s.length() == c.length()){
//            if(s.compareTo(c) < 0) {
//                String e = s;
//                s = c;
//                c = e;
//                System.out.print("-");
//            }
//        }
//        for (int i = 0; i < s.length(); i++) {
//            a[s.length() - 1 - i] = s.charAt(i) - '0';
//        }
//        for (int i = 0; i < c.length(); i++) {
//            b[c.length() - 1 - i] = c.charAt(i) - '0';
//        }
//        int l = Math.max(s.length(),c.length());
//        for (int i = 0; i < l; i++) {
//            d[i] += a[i] - b[i];
//            if(d[i] < 0) {
//                d[i + 1] -= 1;
//                d[i] += 10;
//            }
//        }
//        while (l > 1 && d[l - 1] == 0) {
//            l--;
//        }
//        for (int i = l - 1; i >= 0; i--) {
//            System.out.print(d[i]);
//        }
//
//
//    }
    //高精度加法
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        String c = in.next();
//        int[] a = new int[505];
//        int[] b = new int[505];
//        int[] d = new int[505];
//        for (int i = 0; i < s.length(); i++) {
//            a[s.length() - 1 - i] = s.charAt(i) - '0';
//        }
//        for (int i = 0; i < c.length(); i++) {
//            b[c.length() - 1 - i] = c.charAt(i) - '0';
//        }
//        int l = Math.max(s.length(),c.length());
//        for (int i = 0; i < l; i++) {
//            d[i] += a[i] + b[i];
//            d[i + 1] += d[i] / 10;
//            d[i] %= 10;
//        }
//        if(d[l] != 0) {
//            l++;
//        }
//        for (int i = l - 1; i >= 0; i--) {
//            System.out.print(d[i]);
//        }
//
//    }
    //飞机降落
//    static class Plane{
//        int t;
//        int d;
//        int l;
//    }
//
//    static int t;
//    static int n;
//    static Plane[] a;
//    static int[] bk;
//    static boolean dfs(int deep, int time) {
//        if(deep > n) {
//            return true;
//        }
//        for (int i = 1; i <= n; i++) {
//            if(bk[i] == 1 || (a[i].t + a[i].d) < time) {
//                continue;
//            }
//            bk[i] = 1;
//            if(dfs(deep + 1,Math.max(time,a[i].t) + a[i].l)) {
//                return true;
//            }
//            bk[i] = 0;
//        }
//        return false;
//    }
//
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        t = in.nextInt();
//        while (t > 0) {
//            n = in.nextInt();
//            for (int i = 1; i <= n; i++) {
//                a[i] = new Plane();
//                a[i].t = in.nextInt();
//                a[i].d = in.nextInt();
//                a[i].l = in.nextInt();
//            }
//            Arrays.fill(bk,0);
//            if(dfs(1,0)) {
//                System.out.println("YES");
//            }else {
//                System.out.println("NO");
//            }
//            t--;
//        }
//        in.close();
//
//    }
}
