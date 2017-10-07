/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
        private int freqSumCnt = 0;
    private List<Integer> freqSums = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode r) {
        
        
        Map<Integer, Integer> cnt = new HashMap<>();
        worker(r, cnt);
        
        int[] re = new int[freqSums.size()];
        for(int i=0; i< freqSums.size(); i++)
        {
            re[i] = freqSums.get(i).intValue();
        }
        
        return re;
    }
    
    private int worker(TreeNode r, Map<Integer, Integer> cnt )
    {
        if(r==null)
        {
            return 0;
        }
        
        int c = r.val;
        c+=worker( r.left, cnt );
        c+=worker( r.right, cnt );
        
        int curCnt = 1;
        Integer savedCnt = cnt.get(c);
        if(savedCnt!=null)
        {
            curCnt+=savedCnt;
        }
        cnt.put(c, curCnt);
        
        if(curCnt>freqSumCnt)
        {
            freqSums.clear();
            freqSums.add(c);
            freqSumCnt = curCnt;
        }
        else if(curCnt==freqSumCnt)
        {
            freqSums.add(c);
        }
        
        return c;
    }
}