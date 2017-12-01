public class Solution {
    public int firstMissingPositive(int[] A) {
        Arrays.sort(A);
        boolean flag = false;
        int n = A.length;
        int toFind = 1;
        for(int i = 0 ;i<A.length;i++){
            if(A[i]!=toFind){ 
                continue;
            }
            toFind++;
            
        }
        return toFind;
    }
}
