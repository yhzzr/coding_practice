public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] index = new int[primes.length];
        Arrays.fill(index, 0);
        int[] factors = new int[primes.length];
        for(int i=0;i<factors.length;i++){
            factors[i]=primes[i];
        }
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int factor:factors){
               min = (min<factor)?min:factor; 
            }
            ugly[i] = min;
            for(int j=0;j<primes.length;j++){
                if(factors[j]==min){
                    factors[j]=primes[j]*ugly[++index[j]];
                }
            }
        }
        return ugly[n-1];
    }
}