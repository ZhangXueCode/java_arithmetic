import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    //柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for(int x : bills) {
            if(x == 5) {
                five++;
            } else if (x == 10) {
                ten++;
                if(five > 0) {
                    five--;
                }else {
                    return false;
                }
            }else {
                if(five != 0 && ten != 0) {
                    five--;
                    ten--;
                }else {
                    if(five >= 3) {
                        five -= 3;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;

    }
    //将数组和减半至少操作次数
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        double sum = 0.0;
        int c = 0;
        for(int x : nums) {
            heap.offer((double)x);
            sum += x;
        }
        sum /= 2.0;
        while (sum > 0) {
            double a = heap.poll() / 2.0;
            sum -= a;
            c++;
            heap.offer(a);
        }
        return c;
    }
    //最大数
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = "" + nums[i];
        }
        Arrays.sort(s,(a,b) -> (b + a).compareTo(a + b));
        StringBuilder ret = new StringBuilder();
        for(String c : s) {
            ret.append(c);
        }
        if(ret.charAt(0) == '0') {
            return "0";
        }
        return ret.toString();

    }
    //摆动序列
    public int wiggleMaxLength(int[] nums) {
        int left = 0;
        int ret = 0;
        if(nums.length < 2) {
            return nums.length;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int right = nums[i + 1] - nums[i];
            if(right == 0) continue;
            if(left * right <= 0) {
                ret++;
                left = right;
            }
        }
        ret++;
        return ret;
    }
    //最长递增子序列
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ret = new ArrayList<>();
        int n = nums.length;
        ret.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if(nums[i] > ret.get(ret.size() - 1)) {
                ret.add(nums[i]);
            }else {
                int left = 0,right = ret.size() - 1;
                while (left < right) {
                    int mid = (right + left) / 2;
                    if(ret.get(mid) < nums[i]) {
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                ret.set(left,nums[i]);
            }
        }
        return ret.size();

    }
    //递增的三元子序列
    public boolean increasingTriplet(int[] nums) {
        int a = nums[0];
        int b = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > b) {
                return true;
            }else {
                if(nums[i] > a) {
                    b = nums[i];
                }else {
                    a = nums[i];
                }
            }
        }
        return false;
    }
    //最长连续递增子序列
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int i = 0,j = 1,ret = 1;
        if(n == 1) {
            return ret;
        }
        while (i < n && j < n) {
            if(nums[j - 1] < nums[j]) {
                j++;
                ret = Math.max(ret,j - i);
            }else {
                i = j;
                j++;
            }
        }
        return ret;

    }
    //买卖股票的最佳时期
    public int maxProfit1(int[] prices) {
        int ret = 0;
        for (int i = 0,prev = Integer.MAX_VALUE; i < prices.length; i++) {
            ret = Math.max(ret,prices[i] - prev);
            prev = Math.min(prev,prices[i]);
        }
        return ret;
    }
    //买卖股票的最佳时机Ⅱ
    public int maxProfit(int[] prices) {
        //拆分天数
        int ret = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                ret += prices[i + 1] - prices[i];
            }
        }
        return ret;
        //双指针
//        int ret = 0;
//        for (int i = 0; i < prices.length; i++) {
//            int j = i;
//            while (j + 1 < prices.length && prices[j + 1] > prices[j]) {
//                j++;
//            }
//            ret += prices[j] - prices[i];
//            i = j;
//        }
//        return ret;
    }
    //k次取反后最大化的数组和
    public int largestSumAfterKNegations(int[] nums, int k) {
        int m = 0,n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int x : nums) {
            if(x < 0) {
                m++;
            }
            min = Math.min(min,Math.abs(x));
        }
        int ret = 0;
        if(m > k) {
            Arrays.sort(nums);
            for (int i = 0; i < k; i++) {
                ret += -nums[i];
            }
            for (int i = k; i < n; i++) {
                ret += nums[i];
            }
        }else {
            int a = k - m;
            for(int x : nums) {
                ret += Math.abs(x);
            }
            if(a % 2 != 0) {
                ret -= 2 * min;
            }
        }
        return ret;
    }
    //按身高排序
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index,(i,j) -> {
            return heights[j] - heights[i];
        });
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            ret[i] = names[index[i]];
        }
        return ret;
    }
    //优势洗牌
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length;
        int[] ret = new int[n];
        Integer[] index = new Integer[m];
        for (int i = 0; i < m; i++) {
            index[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(index,(i,j) -> {
            return nums2[i] - nums2[j];
        });

        int left = 0,right = m - 1;
        for(int x : nums1) {
            if(x <= nums2[index[left]]) {
                ret[index[right]] = x;
                right--;
            }else {
                ret[index[left]] = x;
                left++;
            }
        }
        return ret;

    }


}
