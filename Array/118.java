public class Solution {
    public List<List<Integer>> generate(int numRows) {
   List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(numRows == 1){
            result.add(Arrays.asList(1));
        }else if(numRows >= 2){
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1,1));
            
            for(int i=3; i <=numRows; i++){
                List<Integer> toAdd = new ArrayList();
                List<Integer> last = result.get(i-2);
                toAdd.add(1);
                for(int j=0; j<last.size()-1;j++)
                    toAdd.add(last.get(j)+last.get(j+1));
                toAdd.add(1);
                result.add(toAdd);
            }
        }
        
        return result;
    }
}