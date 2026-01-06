import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Read{ //⾃定义快读 Read
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException {
        while(!st.hasMoreTokens()){
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException
    {
        return bf.readLine();
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
}
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
//    public static void main(String[] args) throws Throwable {
//        BufferedReader reader = new BufferedReader(new
//                InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        String[] str = reader.readLine().split(" ");
//        String s1 = str[0], s2 = str[1];
//        int prev1 = -1, prev2 = -1, ret = 0x3f3f3f3f;
//        for (int i = 0; i < n; i++) {
//            String s = reader.readLine();
//            if (s.equals(s1)) { // 去前⾯找最近的 s2
//                if (prev2 != -1) {
//                    ret = Math.min(ret, i - prev2);
//                }
//                prev1 = i;
//            } else if (s.equals(s2)) {// 去前⾯找最近的 s1
//                if (prev1 != -1) {
//                    ret = Math.min(ret, i - prev1);
//                }
//                prev2 = i;
//            }
//        }
//        System.out.println(ret == 0x3f3f3f3f ? -1 : ret);
//    }
    //Day 03
    //简写单词
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        StringBuilder ss = new StringBuilder();
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNext()) { // 注意 while 处理多个 case
//            String s = in.next();
//            ss.append(s.toUpperCase().charAt(0));
//        }
//        System.out.print(ss.toString());
//    }
    //dd爱框框
//    public static void main(String[] args) throws IOException {
//        Read in = new Read();
//        int n = in.nextInt(),x = in.nextInt();
//        int[] a = new int[n + 1];
//        for(int i = 1;i <= n;i++) {
//            a[i] = in.nextInt();
//        }
//        int sum = 0;
//        int left = 1,right = 1,retL = 0, retR = 0,ret = n;
//        while(right <= n) {
//            sum += a[right];
//            while(sum >= x) {
//                if(right - left + 1 < ret) {
//                    ret = right - left + 1;
//                    retL = left;
//                    retR = right;
//                }
//                sum -= a[left];
//                left++;
//            }
//            right++;
//        }
//        System.out.println(retL + " " + retR);
//    }
    //除2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),k = in.nextInt();
        long sum = 0;
        PriorityQueue<Integer> h = new PriorityQueue<>((a,b) -> {
            return b - a;
        });
        for(int i = 0;i < n;i++) {
            long a = in.nextLong();
            sum += a;
            if(a % 2 == 0) {
                h.add((int)a);
            }
        }
        while(!h.isEmpty() && k-- > 0) {
            long t = h.poll() / 2;
            sum -= t;
            if(t % 2 == 0) {
                h.add((int)t);
            }
        }
        System.out.print(sum);
    }




}
