
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        int m = A.length();
        int n = B.length();
        if(n ==0) return 0;
        if(n>m) return -1;
        int diff = m-n;
        for(int i = 0 ;i<=m-n;++i){
            if(A.substring(i,i+n).equals(B))
                return i;
        }
        
        return -1;
    }
}