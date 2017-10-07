public class Solution {
    public String reverseWords(String s) {
        char[] input = s.toCharArray();
        int start = 0;
        for(int i=0;i<input.length;i++){
            if(input[i]==' '){
                swap(input, start, i-1);
                start = i+1;
            }
        }
        swap(input, start, input.length-1);
        return new String(input);
    }
    
    private void swap(char[] input, int start, int end){
        while(start<end){
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }
}