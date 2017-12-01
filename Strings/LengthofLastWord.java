public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        StringBuilder str = new StringBuilder();
        boolean wordStart=false;
        int n = A.length();
        for(int i = n-1 ; i>=0;i--){
           if(A.charAt(i) ==' '){
                if(wordStart)
                    return str.toString().length(); 
                continue;
                   
           }
            else{
                str.append(A.charAt(i));
            }
            wordStart = true;
        }
        
        return str.toString().length();
    }
}