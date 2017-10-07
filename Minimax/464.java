class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=1){
            return true;
        }
        if((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal){
            return false;
        }
        Boolean[] map = new Boolean[1<<maxChoosableInteger];
        return canWin(desiredTotal, maxChoosableInteger, 0, map);
    }
    
    public boolean canWin(int remain, int max, int state, Boolean[] map){
        if(map[state]!=null){
            return map[state];
        }
        
        for(int i=max;i>=1;i--){
            int bit = 1 << (i-1);
            if( (state & bit) == 0){
                if(i>=remain){
                    map[state] = true;
                    return true;
                }
                
                state ^= bit;
                boolean opWin = canWin(remain-i, max, state, map);
                state ^= bit;
                if(!opWin){
                    map[state] = true;
                    return true;
                }
            }
        }
        map[state] = false;
        return false;
    }
}