class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] taskNum = new int[26];
        int[] cooldown = new int[26];
        
        int todo = 0;
        int res = 0;
        
        //go throught the tasks array, put everything into taskNum;
        for(char c:tasks){
            taskNum[c-'A']++;
            todo++;
        }
        
        while(todo>0){
            int high = 0;
            int cur = -1;
            for(int i=0;i<26;i++){
                if(cooldown[i]==0){
                    if(taskNum[i]>high){ 
                        high = taskNum[i];
                        cur = i;
                    }
                }else{
                    cooldown[i]--;
                }
            }
            //if we have some task to do, decrease taskNum, decrease todo, add cooldown to that task
            if(cur!=-1){
                taskNum[cur]--;
                todo--;
                cooldown[cur]+=n;
            }
            res++;
        }
        
        return res;
    }
}