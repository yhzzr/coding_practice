public class WordDistance {
    
    Map<String, Map<String,Integer>> outerMap = new HashMap();
    String[] words;
    public WordDistance(String[] words) {
        this.words = words;
        for(int i=0; i<words.length; i++){
            Map<String,Integer> innerMap = new HashMap();
            if( !outerMap.containsKey(words[i]) )
                outerMap.put(words[i], innerMap);
        }
    }

    public int shortest(String word1, String word2) {
        Map<String,Integer> innerMap = outerMap.get(word1);
        if(innerMap.containsKey(word2)) 
            return innerMap.get(word2);
        else{
            int index = -1;
            int distance = words.length;
            for(int i=0; i< words.length;i++){
                if(words[i].equals(word1) || words[i].equals(word2)){
                    if(index < 0) index = i;
                    else if( !words[i].equals(words[index])) distance = Math.min(distance, i-index); 
                    index = i;
                }
            }
            innerMap.put(word2,distance);
            return distance;
        }
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");