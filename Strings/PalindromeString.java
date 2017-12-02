public class Solution {
    public int isPalindrome(String A) {
        int i = 0, j = A.length()-1;

        while(i<=j){
            char ch1 = A.charAt(i);
            char ch2 = A.charAt(j);
            if(!('a'<=ch1 && ch1<='z') && !('A'<=ch1 && ch1<='Z') && 
            !('0'<=ch1 && ch1<='9')){
                i++;
                continue;
            }
            
            
            if(!('a'<=ch2 && ch2<='z') && !('A'<=ch2 && ch2<='Z') && 
            !('0'<=ch2 && ch2<='9')){
                j--;
                continue;
            }
           
                
            if(Character.toLowerCase(ch1)!=Character.toLowerCase(ch2))
                return 0;
            
            i++;
            j--;
        }
        
        return 1;
    }
}
