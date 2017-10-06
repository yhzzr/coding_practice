public class Solution {
    public List<Integer> getRow(int rowIndex) {
   List<Integer> result = new ArrayList<>();
    result.add(1);
    if(rowIndex<1) return result;
    for(int i=0;i<rowIndex;i++){
        int temp = (int) ((long)result.get(i)*(rowIndex-i)/(i+1));
        result.add(temp);
    }
    return result;

}
}