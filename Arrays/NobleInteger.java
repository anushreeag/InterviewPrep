public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A);
        
        int n = A.length;
        for(int i = 0;i<A.length;i++){
            if(i+1<n && A[i]==A[i+1]) continue;
            if(A[i]==n-1-i)
             return 1;
        }
        
        return -1;
    }
}