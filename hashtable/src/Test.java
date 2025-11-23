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
    //判断是否为字符重排
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int[] hash = new int[26];
        for(char ch : s1.toCharArray()) {
            hash[ch - 'a']++;
        }
        for(char ch : s2.toCharArray()) {
            hash[ch - 'a']--;
            if(hash[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
