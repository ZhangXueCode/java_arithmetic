import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
    //归并排序
    int[] tmp;
    void merge(int left,int right,int[] nums) {
        if(left >= right) {
            return;
        }
        int mid = (right + left) / 2;
        merge(left,mid,nums);
        merge(mid + 1,right,nums);
        int cur1 = left,cur2 = mid + 1,i = 0;
        while (cur1 <= mid && cur2 <= right) {
            tmp[i++] = nums[cur1] <= nums[cur2] ? nums[cur1++] : nums[cur2++];
        }
        while (cur1 <= mid) {
            tmp[i++] = nums[cur1++];
        }
        while (cur2 <= right) {
            tmp[i++] = nums[cur2++];
        }
        for (int j = left; j <= right; j++) {
            nums[j] = tmp[j - left];
        }

    }
    public int[] sortArray1(int[] nums) {
        int n = nums.length;
        tmp = new int[n];
        merge(0,nums.length - 1,nums);
        return nums;
    }
    //数组中的逆序对
    int[] t;
    int mergeSort(int[] record,int left,int right) {
        if(left >= right) {
            return 0;
        }
        int ret = 0;
        int mid = (left + right) / 2;
        ret += mergeSort(record,left,mid);
        ret += mergeSort(record,mid + 1,right);
        int cur1 = left,cur2 = mid + 1,i = 0;
        while (cur1 <= mid && cur2 <= right) {
            if(record[cur1] <= record[cur2]) {
                t[i++] = record[cur1++];
            }else {
                ret += mid - cur1 + 1;
                t[i++] = record[cur2++];
            }
        }
        while (cur1 <= mid) {
            t[i++] = record[cur1++];
        }
        while (cur2 <= right) {
            t[i++] = record[cur2++];
        }
        for (int j = left; j <= right; j++) {
            record[j] = t[j - left];
        }
        return ret;
    }
    public int reversePairs(int[] record) {
        int n = record.length;
        t = new int[n];
        return mergeSort(record,0,n - 1);
    }
    //计算右侧小于当前元素的个数
    int[] t1;
    int[] t2;
    int[] index;
    int[] ret;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        t1 = new int[n];
        t2 = new int[n];
        ret = new int[n];
        index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        ms(nums,0,n - 1);
        List<Integer> l = new ArrayList<>();
        for(int x : ret) {
            l.add(x);
        }
        return l;

    }
    void ms(int[] nums,int left,int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        ms(nums,left,mid);
        ms(nums,mid + 1,right);
        int cur1 = left,cur2 = mid + 1,i = 0;
        while (cur1 <= mid && cur2 <= right) {
            if(nums[cur1] <= nums[cur2]) {
                t2[i] = index[cur2];
                t1[i++] = nums[cur2++];
            }else {
                ret[index[cur1]] += right - cur2 + 1;
                t2[i] = index[cur1];
                t1[i++] = nums[cur1++];
            }
        }
        while (cur1 <= mid) {
            t2[i] = index[cur1];
            t1[i++] = nums[cur1++];
        }
        while (cur2 <= right) {
            t2[i] = index[cur2];
            t1[i++] = nums[cur2++];
        }
        for (int j = left; j <= right; j++) {
            nums[j] = t1[j - left];
            index[j] = t2[j - left];
        }

    }

}
