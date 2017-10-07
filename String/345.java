public class Solution {
    public String reverseVowels(String s) {
char[] ch = s.toCharArray();
    
    char tmp;
    int p1 = 0 , p2 = s.length()-1;
    
    loop: 
    while(p1 < p2){
        while(ch[p1] != 'a' && ch[p1] != 'e' && ch[p1] != 'i' && ch[p1] != 'o' && ch[p1] != 'u' && ch[p1] != 'A' && ch[p1] != 'E' && ch[p1] != 'I' && ch[p1] != 'O' && ch[p1] != 'U'){
            p1 ++;
            if(p1 >= p2)
                break loop;
        }
        
        while(ch[p2] != 'a' && ch[p2] != 'e' && ch[p2] != 'i' && ch[p2] != 'o' && ch[p2] != 'u' && ch[p2] != 'A' && ch[p2] != 'E' && ch[p2] != 'I' && ch[p2] != 'O' && ch[p2] != 'U'){
            p2 --;
            if(p1 >= p2)
                break loop;
        }
            
        tmp = ch[p1];
        ch[p1] = ch[p2];
        ch[p2] = tmp;
        
        p1 ++;
        p2 --;
    }
    
        
    return new String(ch);
    }
}