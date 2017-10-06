public class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int num1 = 1;
        int num2 = 2;
        int result = 0;
        for(int i=3; i<=n; i++){
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }
}