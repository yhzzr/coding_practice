public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;
        int test;
        if(word.charAt(0) > 'Z'){
            if(word.charAt(1)>'Z' ) test =1;//first letter is lowercase and second letter is lowercase
            else return false; //first letter is lowercase and second letter is uppercase
        }
        else{
            if(word.charAt(1)>='A' && word.charAt(1)<='Z') test = 2; //first letter is uppercase and second letter is uppercase
            else test = 3;                                         //first is upper and second is lower
        }
        for(int i=2;i<word.length();i++){
            if((test==1 || test==3) && (word.charAt(i)>='A' && word.charAt(i)<='Z')) return false;
            if(test==2 && (word.charAt(i) > 'Z')) return false;
        }
        return true;
    }
}