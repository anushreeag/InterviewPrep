public class Solution {
    public int coverPoints(int[] A, int[] B) {
        int steps = 0;
        for(int i = 0; i<A.length-1;i++ ){
            if(i+1<A.length)
                steps += distanceBtw2Pts(A[i],A[i+1],B[i],B[i+1]);
        }
        return steps;
    }
    
    
    // Since we can use diagonal paths here, no. of steps from one point to another will 
    //maximize on the diagonal path first and remaining steps on x or y direction.
    private int distanceBtw2Pts(int x1, int x2, int y1, int y2){
        return Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
        
    }
}
