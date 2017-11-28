public class Solution {
    public int[] plusOne(int[] A) {
        int n = A.length;
        int carry = 0;
        int count=0;

        for(int i=n-1;i>=0;i--){
            if(A[i]<9){
                A[i] = A[i]+1;
                for(int j =0;j<n;j++){
                    if(A[j]!=0) break;
                    count++;
                }
                int [] B = new int[n-count];
                  for(int k = count ; k<n ; k++ ) 
                   B[k-count] = A[k];
                return B;    
            }
            
			// If A[i] = 9 , then put A[i]=0 and proceed with next digit
            A[i] = 0;
            
        }
		// If all digits are 9 , then just return the output with 1 at MSB
        int [] result1 = new int[n-count+1];
        result1[0] = 1;
        return result1;
        
        
        
    }
}
