import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result  = new ArrayList<List<Integer>>();
    List<Integer> resultForNow = new ArrayList<Integer>();
    public List<List<Integer>> permute(int[] nums) {
        int size =nums.length;
        helper(0,nums,size,resultForNow,new boolean[size]);
        return result;
    }
    public void helper(int n, int[] nums, int size, List<Integer> resultForNow, boolean[] visited){
        if (n==size){
            if (n!=0){
                result.add(resultForNow);
            }
            return;
        }
        for (int i=0; i<size; i++){
            if (!visited[i]){
                boolean[] newVisited = new boolean[size];
                for (int j=0; j<size; j++){
                    newVisited[j]=visited[j];
                }
                newVisited[i]= true;
                List<Integer> resultForNext = new ArrayList<Integer>(resultForNow);
                resultForNext.add(nums[i]);
                helper(n+1,nums,size,resultForNext,newVisited);
            }
        }
    }
}
