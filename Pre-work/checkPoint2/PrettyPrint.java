public class Solution {
    public int[][] prettyPrint(int A) {
        int n = 2*(A-1) + 1;
        int a[][] = new int[n][n];
        int j = 0;
        for(int i = A;i>=1;i--){
            fill(a, i , n,j);
            j++;
                
        } 
        
        return a;
    }
    
    
    public void fill(int a[][],int A,int n, int k) {
        for(int i = k;i<n-k;){
            for(int j = k ;j<n-k;j++){
                if(i==k || i==n-1-k || j==k || j==n-1-k){
                    a[i][j] = A;
                }
                
            }
            
            
           i = i+n-1-k;
                
        } 
    }
}
