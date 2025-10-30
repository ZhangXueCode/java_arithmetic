import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    //零移动
    public void zeroMove(int[] nums) {
        int cur = 0;
        int dest = -1;
        for(cur=0;cur< nums.length;cur++) {
            if(nums[cur] != 0) {
                dest++;
                swap(dest,cur,nums);
            }
        }
    }
    public void swap(int i,int j,int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    //复写零
    public void duplicateZeros(int[] nums) {
        //1.找出最后一个复写的位置cur
        int dest = -1;
        int cur = 0;
        for(;dest< nums.length;cur++) {
            if(nums[cur] == 0) {
                dest += 2;
            }else {
                dest++;
            }
        }
        //2.处理越界的可能
        dest = nums.length - 1;
        //3.从后往前开始遍历
        for(;cur >= 0;cur--) {
            if(nums[cur] == 0) {
                nums[dest] = 0;
                nums[dest-1] = 0;
                dest -= 2;
            }else {
                nums[dest] = nums[cur];
                dest--;
            }
        }
    }
    //快乐数
    public int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int t = n % 10;
            sum += t * t;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sum(n);
        while (slow != fast) {
            slow = sum(n);
            fast = sum(sum(n));
        }
        return slow == 1;
    }
    //盛最多水的容器
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int ret = 0;
        while (left < right) {
            int v = (right - left) * Math.min(height[left],height[right]);
            ret = Math.max(ret,v);
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return ret;
    }
    //有效三角形的个数
    public int triangleNum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        //1.给数组排序
        Arrays.sort(nums);
        //2.固定一个最大值
        for (int i = n-1; i > 1 ; i--) {
            int left = 0;
            int right = i-1;
            while (left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    sum += (right - left);
                    right--;
                }else {
                    left++;
                }
            }
        }
        return sum;
    }
    //和为s的两个值
    public int[] twoSum(int[] num,int target) {
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            if(num[left] +num[right] < target) {
                left++;
            } else if (num[left] +num[right] > target) {
                right--;
            }else {
                return new int[]{num[left],num[right]};
            }
        }
        return new int[]{0};
    }
    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n;) {
            if(nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                List<Integer> set = new ArrayList<>();
                if(nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                }else {
                    set.add(nums[left]);
                    set.add(nums[i]);
                    set.add(nums[right]);
                    left++;
                    right--;
                    lists.add(set);
                    //去重left right
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                }
            }
            //去重i
            i++;
            while (i < n && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return lists;
    }
    //四数之和
    public List<List<Integer>> fourSum(int[] nums,int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> set = new ArrayList<>();
        for (int i = 0; i < n; ) {
            for (int j = i+1; j < n; ) {
                List<Integer> list = new ArrayList<>();
                long sum1 = nums[i] + nums[j];
                int left = j + 1;
                int right = n - 1;
                long sum = nums[left] + nums[right];
                long target1 = target - sum1;
                while (left < right) {
                    if(sum < target1) {
                        left++;
                    } else if (sum > target1) {
                        right--;
                    }else {
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[left]);list.add(nums[right]);
                        left++;
                        right--;
                        while (nums[left] == nums[left - 1] && left < right) {
                            left++;
                        }
                        while (nums[right] == nums[right - 1] && left < right) {
                            right--;
                        }
                    }
                }
                set.add(list);
                j++;
                while (nums[j] == nums[j - 1] && j < n) {
                    j++;
                }
            }
            i++;
            while (nums[i] == nums[i - 1] && i < n) {
                i++;
            }
        }
        return set;
    }

}
