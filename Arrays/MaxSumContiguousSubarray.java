public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        // Using Kadane Algorithm
        int maxSumsoFar = A[0],maxSumEndingHere = A[0] ;
        for(int i = 1 ;i<A.length;i++){
            maxSumEndingHere = Math.max(A[i],A[i]+maxSumEndingHere);
            maxSumsoFar = Math.max(maxSumEndingHere,maxSumsoFar);
        }
        
        return maxSumsoFar;
    }
}
