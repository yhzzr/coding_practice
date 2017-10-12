public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        search(res, new ArrayList<>(), 1, n,k);
        return res;
    }
    
    public static void search(List<List<Integer>> res, List<Integer> temp, int start, int n, int k){
        if(k==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=n;i++){
            temp.add(i);
            search(res, temp, i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }
}