public class Main {
    void swap(int a,int b,int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
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

}
