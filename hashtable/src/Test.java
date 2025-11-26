import java.util.*;

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
    //存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!hash.contains(nums[i])) {
                hash.add(nums[i]);
            }else {
                return true;
            }
        }
        return false;
    }
    //存在重复元素Ⅱ
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i]) && (i - hash.get(nums[i]) <= k)) {
                return true;
            }
            hash.put(nums[i], i);
        }
        return false;

    }
    //字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hash = new HashMap<>();
        for(String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            if(!hash.containsKey(key)) {
                hash.put(key,new ArrayList<>());
            }
            hash.get(key).add(s);
        }
        return new ArrayList<>(hash.values());

    }



}
