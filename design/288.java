public class ValidWordAbbr {
    HashMap<String, String> hm = new HashMap<String, String>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s: dictionary){
            String key = doAbbr(s);
            if(hm.containsKey(key)){
                if(!hm.get(key).equals(s))
                    hm.put(key, "");
            }
            else
                hm.put(key, s);
        }
    }
    public boolean isUnique(String word) {
            String key = doAbbr(word);
            return !hm.containsKey(key) || hm.get(key).equals(word);
    }
    private String doAbbr(String s){
        StringBuilder sb = new StringBuilder();
        if(s.length() <= 2)
            sb.append(s);
        else
            sb.append(s.charAt(0)).append(s.length()-2).append(s.charAt(s.length()-1));
        return sb.toString();
    }
}



// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");