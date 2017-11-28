public class Solution {
    public int[] getRow(int A) {
    int [] result = new int[0];
        if(A==0){
           result = new int[1];
            result[0]= 1;
        }

        int []prev = new int[2];
        prev[0] = prev[1] = 1; // Hardcode 2nd row elements to 1 
        for(int i = 1;i<=A+1;i++){
            result = new int[i];
			// Fill the 0th and last element of current row same as previous row
            result[0] = prev[0];
            result[i-1] = prev[prev.length-1];
            for(int j=1;j<i-1;j++){
                 result[j] = prev[j-1]+prev[j];
            }
            prev = result;
        }
        
        return result;

    }
}
