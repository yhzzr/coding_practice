public class Solution {
    
    class Tuple{
        char c;
        int n;
        public Tuple(char c, int n){
            this.c = c;
            this.n = n;
        }
    }
    
    public String frequencySort(String s) {
        if(s.length()==0) return s;
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>(s.length(), new Comparator<Tuple>(){
            public int compare(Tuple a, Tuple b){
                return a.n - b.n;
            }
        });
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.containsKey(c)?map.get(c)+1:1);
        }
        
        for(Character key:map.keySet()){
            int n = map.get(key);
            queue.add(new Tuple(key, n));
        }
        
        StringBuilder sb = new StringBuilder();
        while(queue.size()!=0){
            Tuple tuple = queue.poll();
            for(int i=0;i<tuple.n;i++){
                sb.insert(0,tuple.c);
            }
        }
        return sb.toString();
    }
    
}