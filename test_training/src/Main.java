import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //Day 1
    //数字统计
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int l = in.nextInt(),r = in.nextInt();
//        int ret = 0;
//        for(int i = l;i <= r;i++) {
//            int tmp = i;
//            while(tmp != 0) {
//                if(tmp % 10 == 2) {
//                    ret++;
//                }
//                tmp /= 10;
//            }
//        }
//        System.out.println(ret);
//
//    }
    //两个数组的交集
    public ArrayList<Integer> intersection (ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        ArrayList<Integer> ret = new ArrayList<>();
        boolean[] check = new boolean[1001];
        for (int x : nums1) {
            check[x] = true;
        }
        for(int x : nums2) {
            if(check[x]) {
                ret.add(x);
                check[x] = false;
            }
        }
        return ret;
    }
    //点击消除
//    public static void main(String[] args) {
//        StringBuilder st = new StringBuilder();
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        char[] ss = s.toCharArray();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = ss[i];
//            if(!st.isEmpty() && ch == st.charAt(st.length() - 1)) {
//                //出栈
//                st.deleteCharAt(st.length() - 1);
//            }else {
//                //进栈
//                st.append(ch);
//            }
//        }
//        System.out.println(st.length() == 0 ? 0 : st.toString());
//    }
    //Day 02
    //牛牛的快递
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        double a = in.nextDouble();
//        char b = in.next().charAt(0);
//        int ret = 0;
//        if(a <= 1) {
//            ret = 20;
//        }
//        else {
//            //Math.ceil(a) 返回 >= a 的最小整数
//            ret = 20 + (int)Math.ceil(a - 1);
//        }
//        if(b == 'y') {
//            ret += 5;
//        }
//        System.out.println(ret);
//    }
    //最小花费爬楼梯
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] cost = new int[n];
//        for(int i = 0;i < n;i++) {
//            cost[i] = in.nextInt();
//        }
//        int[] dp = new int[n + 1];
//
//        if(n == 1) {
//            System.out.println(cost[0]);
//            return;
//        }
//
//        for(int i = 2;i <= n;i++) {
//            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
//        }
//        System.out.println(dp[n]);
//    }

    //数组中两个字符串的最小距离
    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        String s1 = str[0], s2 = str[1];
        int prev1 = -1, prev2 = -1, ret = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            if (s.equals(s1)) { // 去前⾯找最近的 s2
                if (prev2 != -1) {
                    ret = Math.min(ret, i - prev2);
                }
                prev1 = i;
            } else if (s.equals(s2)) {// 去前⾯找最近的 s1
                if (prev1 != -1) {
                    ret = Math.min(ret, i - prev1);
                }
                prev2 = i;
            }
        }
        System.out.println(ret == 0x3f3f3f3f ? -1 : ret);
    }

}
