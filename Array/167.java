public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {0,0};
        int head = 0;
        int left = head;
        int right = numbers.length-1;
        int mid = (right+left)/2;
        while(head<numbers.length){
            if(numbers[head] + numbers[mid] == target){
                result[0] = head + 1;
                result[1] = mid  + 1;
                break;
            }else if(numbers[head] + numbers[mid] > target){
                right = mid-1;
                mid = (right+left)/2;
            }else if(numbers[head] + numbers[mid] < target){
                left = mid+1;
                mid = (right+left)/2;
            }
            if(left>right){
                head++;
                left = head;
                right = numbers.length-1;
                continue;
            }
        }
        return result;
    }
}