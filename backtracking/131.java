public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        build(res, new ArrayList<>(), s, 0);
        return res;
    }
    public void build(List<List<String>> res, List<String> templist, String s, int start){
        if(start >= s.length()){
            res.add(new ArrayList<>(templist));
            return;
        }
        for(int i=start; i<s.length();i++){
            if( isPalindrome(s, start, i)){
                templist.add(s.substring(start,i+1) );
                build(res, templist, s, i+1);
                templist.remove(templist.size()-1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
	    while(l<r){
	        if(str.charAt(l)!=str.charAt(r)) return false;
	        l++;r--;
	    }
	    return true;
    }
}