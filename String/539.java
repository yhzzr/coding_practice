public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size()*2;
        //Build the time array
        int[] times = new int[len];
        int i = 0;
        for(String tp:timePoints){
            int hour = (tp.charAt(0)-'0')*10+(tp.charAt(1)-'0');
            int minute = (tp.charAt(3)-'0')*10+(tp.charAt(4)-'0');
            times[i++]=hour*60+minute;
            times[i++]=hour*60+minute+1440;
        }
        Arrays.sort(times);
        int res = 1440;
        for(int j=1;j<len;j++){
            res = Math.min(res, times[j]-times[j-1]);
        }
        return res==1440?0:res;
    }
}