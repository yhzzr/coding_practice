public class Solution {
  public List<List<String>> groupStrings(String[] strings) {
        List result = new ArrayList();
        if(strings==null || strings.length==0){
            return result;
        }
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(String str:strings){
            String mask = getMask(str);
            if(map.containsKey(mask)){
                map.get(mask).add(str);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(mask,list);
            }
        }// hashmap initializaiton done here

        // iterate through value set
        for(List mylist:map.values()){
            Collections.sort(mylist);
            result.add(mylist);
        }
        return result;
    }
    public String getMask(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int offset = 0;
        if(chars.length==1){
            sb.append(0);
            return sb.toString();
        }
        for(int i=1;i<chars.length;i++){
            offset = chars[i]-chars[i-1];
            if(offset<0) offset+=26;
            sb.append(offset).append("/");
        }
        return sb.toString();
    }
}