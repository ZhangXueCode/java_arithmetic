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
    void swap(int left, int right, int[] nums) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    void quick_sort(int left, int right, int[] nums) {
        if(left >= right) {
            return;
        }
        int k =(int) (Math.random() * (right - left + 1)) + left;
        int t = nums[k];
        int l = left - 1,i = left,r = right + 1;
        while (i < r) {
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
    //数组中第k大的元素
    int quick(int l,int r,int[] nums,int k) {
        if(l >= r) {
            return nums[l];
        }
        int key = nums[(int) (Math.random() * (r - l + 1)) + l];
        int left = l - 1,i = l,right = r + 1;
        while (i < right) {
            if(nums[i] < key) {
                swap(++left,i++,nums);
            } else if (nums[i] > key) {
                swap(--right,i,nums);
            }else {
                i++;
            }
        }
        int b = right - left - 1;
        int c = r - right + 1;
        if(c >= k) {
            return quick(right,r,nums,k);
        } else if (c + b >= k) {
            return key;
        }else {
            return quick(l,left,nums,k - b - c);
        }

    }
    public int findKthLargest(int[] nums, int k) {
        return quick(0, nums.length - 1,nums, k);
    }
    //最小的k个数
    void qsort(int l,int r,int[] nums,int k) {
        if(l >= r) {
            return;
        }
        int key = nums[(int) (Math.random() * (r - l + 1)) + l];
        int left = l - 1,i = l,right = r + 1;
        while (i < right) {
            if(nums[i] < key) {
                swap(++left,i++,nums);
            } else if (nums[i] > key) {
                swap(--right,i,nums);
            }else {
                i++;
            }
        }
        int a = left - l + 1;
        int b = right - left - 1;
        if(a > k) {
            qsort(l,left,nums,k);
        } else if (a + b >= k) {
            return;
        }else {
            qsort(right,r,nums,k - a - b);
        }
    }
    public int[] smallestK(int[] arr, int k) {
        qsort(0,arr.length - 1,arr,k);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

}
