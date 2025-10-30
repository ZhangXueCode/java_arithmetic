public class Test {
    //最小覆盖字串 滑动窗口
    public String minSub(String ss,String tt) {
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        int[] hash1 = new int[128];
        int kind = 0;
        for(char ch : t) {
            if(hash1[ch] == 0) {
                kind++;
            }
            hash1[ch]++;
        }
        int[] hash2 = new int[128];
        int begin = -1;
        int minLen = Integer.MAX_VALUE;
        for (int left = 0,right = 0,count = 0;right < s.length;right++) {
            char in = s[right];
            hash2[in]++;
            if(hash2[in] == hash1[in]) {
                count++;
            }
            while (count == kind) {
                begin = left;
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                char out = s[left];
                if(hash2[out] == hash1[out]) {
                    count--;
                }
                hash2[out]--;
                left++;
            }
        }
        if(begin == -1) {
            return new String();
        }else {
            return ss.substring(begin,begin + minLen);
        }
    }
    //二分查找
    public int search(int[] num,int t) {
        int left = 0,right = num.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;//防溢出
            if(num[mid] < t) {
                left = mid + 1;
            } else if (num[mid] > t) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    //查找元素的第一个位置和最后一个位置
    public int[] search2(int[] num,int t) {
        int n = num.length;
        if(n == 0) {
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if(num[mid] < t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int first = left;
        left = 0;
        right = n - 1;
        while (left < right) {
            int mid = left + (right - left + 1)/2;
            if(num[mid] > t) {
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        int last = right;
        return new int[]{first,last};
    }
    //x的平方根
    public int pox(int x) {
        if(x < 1) {
            return 0;
        }
        long left = 1;
        long right = x;
        while (left < right) {
            long mid = left + (right - left + 1)/2;
            if(mid*mid <= x) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return (int)left;
    }
    //搜索查找位置
    public int searchInt(int[] num,int t) {
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(num[mid] >= t) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        //插入到数组最后一个位置的后面
        if(num[left] < t) {
            return left + 1;
        }
        return left;
    }
    //返回山峰数组中最大值的索引
    public int peakIndex(int[] num) {
        int left = 1;
        int right = num.length - 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if(num[mid] < num[mid + 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    //返回峰值的索引
    public int peakMaxIndex(int[] num) {
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(num[mid] > num[mid + 1]) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    //返回旋转后数组的最小值
    public int findMin(int[] num) {
        int left = 0;
        int n = num.length;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(num[mid] > num[n - 1]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return num[left];
    }
    //0~n-1中缺失的数据
    public int miss(int[] num) {
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(num[mid] == mid) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if(left == num[left]) {
            return left + 1;
        }
        return left;
    }


}
