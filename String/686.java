class Solution {
    public int repeatedStringMatch(String A, String B) {
        
        for(int i=0;i<A.length();i++){
            int res = helper(A, B, i);
            if(res!=-1)
                return res;
        }
        return -1;
    }
    
    public int helper(String A, String B, int cur){
        
        int count = 1;
        for(int i=0;i<B.length();i++){
            if( A.charAt(cur)!= B.charAt(i)) return -1;
            cur++;
            if(i!=B.length()-1 && cur==A.length()){
                cur=0;
                count++;
            }
        }
        return count;
    }
}