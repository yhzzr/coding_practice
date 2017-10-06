public class Solution {
    public int maxProduct(int[] nums) {
        int lmin=nums[0];
int lmax=lmin;
int gmax=lmax;

for( int i=1;i<nums.length;i++)
{
    int t1 = nums[i]*lmax;
    int t2 = nums[i]*lmin;

    lmax = Math.max( Math.max(t1,t2), nums[i] );
    lmin = Math.min( Math.min(t1,t2), nums[i]);
    gmax =Math.max(gmax, lmax);

}
return gmax;
    }
}