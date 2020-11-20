import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result = new ArrayList<String>();
    String smallResult = "";
    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12){
            return result;
        }
        int n = s.length();
        helper(0,0,s,smallResult,n);
        return result;
    }
    void helper(int cur,int num, String s, String smallResult, int n){
        System.out.println(smallResult +" "+ num);
        if (cur==n){
            if (num == 4) {
                smallResult = smallResult.substring(0,smallResult.length()-1);
                result.add(new String(smallResult));
            }
            return;
        }
        if (cur<n&&s.charAt(cur)=='0'){
            smallResult += "0.";
            helper(cur+1,num+1,s,smallResult, n);
        }else {
            for (int i = 1; i <= 3 && cur + i <= n; i++) {
                String sub = s.substring(cur, cur + i);
                if (Integer.parseInt(sub) <= 255) {
                    //System.out.println(sub+" "+cur+" "+(cur+i));
                    helper(cur + i, num + 1, s, smallResult+sub + ".", n);
                }else {
                    return;
                }
            }
        }
    }
    public static void main(String arg[]){
        System.out.println(new Solution().restoreIpAddresses("0000"));
    }
}
