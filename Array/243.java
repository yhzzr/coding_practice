public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index = -1;
        int distance = words.length;
        for(int i=0; i< words.length;i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                if(index < 0) index = i;
                else if( !words[i].equals(words[index])) distance = Math.min(distance, i-index); 
                index = i;
            }
        }
        return distance;
    }
}