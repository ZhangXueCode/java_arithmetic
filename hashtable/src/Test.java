import java.util.HashMap;
import java.util.Map;

public class Test {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = target - nums[i];
            if(!hash.containsKey(a)) {
                hash.put(nums[i], i);
            }else {
                return new int[]{i,hash.get(a)};
            }
        }
        return new int[]{};
    }
}
