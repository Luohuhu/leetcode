import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        helper(0,0,"",n);
        return result;
    }
    public void helper(int left, int right, String resultForNow, int n){
        if (left==right&&right==n){
            result.add(resultForNow);
        }
        if (left<n){
            String resultForNext = resultForNow + "(";
            helper(left+1,right,resultForNext,n);
        }
        if (right<left){
            String resultForNext = resultForNow + ")";
            helper(left,right+1,resultForNext,n);
        }
    }
}
