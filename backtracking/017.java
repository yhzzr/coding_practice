public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length() == 0) return list;
        String[] dic = { " ", "", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        String input = "";
        fillList(digits, list, dic, input);
        return list;
    }
    private void fillList(String digits, List<String> list, String[] dic, String input){
        if(digits.length() == 1){
            int index = Character.getNumericValue(digits.charAt(0));
            for(int i=0; i<dic[index].length();i++){
                list.add(input+ dic[index].charAt(i) );
            }
        }else{
            int index = Character.getNumericValue(digits.charAt(0));
            for(int i=0; i<dic[index].length();i++){
                fillList( digits.substring(1), list, dic, input+ dic[index].charAt(i));
            }
        }
    }
}