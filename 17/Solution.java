import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result = new ArrayList<String>();
    String[] match = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return null;
        }
        helper(0,"",digits);
        return result;
    }

    public void helper(int n, String a, String digits){
        if (n==digits.length()){
            result.add(a);
            return;
        }
        int cur = Integer.parseInt(String.valueOf(digits.charAt(n)))-2;
        for (int i=0; i<match[cur].length(); i++){
            String newA =a;
            newA += match[cur].charAt(i);
            helper(n+1,newA,digits);
        }
    }
}
