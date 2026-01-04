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
    public static void main(String[] args) {
        StringBuilder st = new StringBuilder();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] ss = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = ss[i];
            if(!st.isEmpty() && ch == st.charAt(st.length() - 1)) {
                //出栈
                st.deleteCharAt(st.length() - 1);
            }else {
                //进栈
                st.append(ch);
            }
        }
        System.out.println(st.length() == 0 ? 0 : st.toString());
    }
}
