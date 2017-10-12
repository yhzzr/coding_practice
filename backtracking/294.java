public class Solution {
    public boolean canWin(String s) {
        boolean isA = true;
        return canDone(s, isA);
    }
    private List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        for(int i=0; i< s.length()-1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == s.charAt(i))
                result.add(s.substring(0,i)+"--"+ s.substring(i+2) );
        }
        return result;
    }
    private boolean canDone(String s, boolean isA){
        List<String> list = generatePossibleNextMoves(s);
        if(isA){
            for(String a:list)
                if(canDone(a, !isA) == true) 
                    return true;
            return false;
        }else{
            for(String a:list)
                if(canDone(a, !isA) == false)
                    return false;
            return true;
        }
    }
}