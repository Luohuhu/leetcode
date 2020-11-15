import java.lang.String;
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        int i=0;
        dp[0]=1;dp[1]=1;

        while(s.charAt(i)=='0'){

            if(i<s.length()-1){
                i++;
            }else {
                return 0;
            }dp[i]=0;

        }
        if(i>1){
            i++;
            dp[i]=1;
            dp[i-1]=1;
        }else{
            i=2;
        }
        //System.out.println(i+ " "+dp[i-1]+" "+dp[i-2]);
        for(i=i; i<s.length()+1; i++){
            //System.out.println(s.charAt(i-2) + " " +s.charAt(i-1));
            if(s.charAt(i-1)=='0'){
                if (s.charAt(i-2)>'2'||s.charAt(i-2)<'1'){
                    //System.out.println("1");
                    return 0;
                }else{
                    dp[i]=dp[i-2];
                }
            }else {
                if(s.charAt(i-2)=='0'){
                    dp[i]=dp[i-1];
                }else if((s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0')<=26){
                    dp[i]=dp[i-1]+dp[i-2];
                }else{
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution A = new Solution();
        System.out.println(A.numDecodings("00100"));

    }
}
