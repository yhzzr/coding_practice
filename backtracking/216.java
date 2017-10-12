public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> templist, int k, int sum, int start){
        if(sum==0){
            if(k==0) res.add(new ArrayList(templist));
            else return;
        }else if(sum < 0){
            return;
        }else{
            if(k<=0) return;
        }
        for(int i=start;i<10;i++){
            templist.add(i);
            backtrack(res, templist, k-1, sum-i, i+1);
            templist.remove(templist.size()-1);
        }
    }
}