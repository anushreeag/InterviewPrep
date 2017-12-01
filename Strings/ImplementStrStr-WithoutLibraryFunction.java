public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        int m = A.length();
        int n = B.length();
        if(n ==0) return 0;
        if(n>m) return -1;
        for(int i = 0 ;i<m;i++){
            for(int j = 0;j<n && i+j<m;j++){
                if(A.charAt(i+j)!=B.charAt(j))
                    break;
                if(j==n-1)
                    return i;
            }
            
        }
        
        return -1;
    }
}