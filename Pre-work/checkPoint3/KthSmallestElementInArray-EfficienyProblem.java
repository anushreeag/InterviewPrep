public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int index = 0;
        for(int i = 0;i<A.length;i++){
            //index = 0 ;
            int count = 0;
            for(int j = 0; j<A.length;j++){
                if(i==j) continue;
                if(A[j]<=A[i]) count ++;
                if(A[j]==A[i])index = j; 
            }

            
            if(count == B-1) return A[i];
            if(count == B && i!=index && A[index] == A[i]) return A[i]; // Repeating elements
        }
        
        return 0;
    }
}