public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        
        if(n%2==1){
            helper(n-1, "0", res);
            helper(n-1, "1", res);
            helper(n-1, "8", res);
        }else{
            helper(n, "", res);
        }
        return res;
    }
    
    private void helper(int n, String s, List<String> res){
        if(n==0) {
            if(s.length()>1 && s.charAt(0)=='0') return;
            res.add(s);
            return;
        }
        helper(n-2, "0"+s+"0", res);
        helper(n-2, "1"+s+"1", res);
        helper(n-2, "6"+s+"9", res);
        helper(n-2, "9"+s+"6", res);
        helper(n-2, "8"+s+"8", res);
    }
}