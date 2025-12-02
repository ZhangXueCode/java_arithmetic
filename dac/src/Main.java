import java.util.Arrays;


public class Main {
    //颜色划分
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = -1,i = 0,right = n;
        while (i < right) {
            if(nums[i] < 1) {
                swap(++left,i++,nums);
            } else if (nums[i] == 1) {
                i++;
            }else {
                swap(--right,i,nums);
            }
        }
    }
    //排序数组
    void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    void quick_sort(int left, int right, int[] nums) {
        if(left >= right) {
            return;
        }
        int k =(int) (Math.random() * (right - left + 1)) + left;
        int t = nums[k];
        int l = left - 1,i = left,r = right + 1;
        while (i < right) {
            if(nums[i] < t) {
                swap(++l,i++,nums);
            } else if (nums[i] == t) {
                i++;
            }else {
                swap(--r,i,nums);
            }
        }
        quick_sort(left,l,nums);
        quick_sort(r,right,nums);
    }
    public int[] sortArray(int[] nums) {
        quick_sort(0, nums.length - 1, nums);
        return nums;
    }

}
