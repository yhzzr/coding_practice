class Solution {
    public int smallestFactorization(int a) {
        if (a == 1) return 1;
        
        int div = 9;
        int ret = 0;
        int mul = 1;
        while (div > 1 && a > 1) {
            if (a % div == 0) {
                // check overflow
                if ((Integer.MAX_VALUE - ret) / mul > div || Integer.MAX_VALUE == ret + mul * div) {
                    ret += mul * div;
                    mul *= 10;
                    a /= div;
                } else {
                    return 0;
                }
            } else {
                div--;
            }
        }
        
        if (div == 1) {
            return 0;
        }
        
        return ret;
    }
}