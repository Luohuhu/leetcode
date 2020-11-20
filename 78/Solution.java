import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> result1 = new ArrayList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(0, result1, nums.length, nums);
        return result;
    }
    void helper(int cur, List<Integer> result1, int n, int[] nums){
        if(cur==n){
            result.add(new ArrayList<Integer>(result1));
        }
        result1.add(nums[cur]);
        helper(cur+1, result1, n, nums);
        result1.remove(result1.size()-1);
        helper(cur+1, result1, n, nums);
    }
}
