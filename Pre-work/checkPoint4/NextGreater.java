public class Solution {
    public int[] nextGreater(int[] A) {
        int [] result = new int[A.length];
        Arrays.fill(result, -1);
        for(int i = 0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[j]>A[i]){
                    result[i]=A[j];
                    break;
                }
            }
        }
        
        
        return result;
    }
}