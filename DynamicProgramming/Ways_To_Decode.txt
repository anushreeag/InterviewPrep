public class Solution {
    public int numDecodings(String A) {
        int n = A.length();
        int []memo = new int[n+1];
        memo[n]=1; // if anything is greater we are returning : 1
        //empty string can be decoded in 1 way
        
        for(int i=n-1;i>=0;i--){
            memo[i]=0;
            if(i<n){  
                memo[i]+=check(A.substring(i,i+1))*memo[i+1];
            }
            if(i+1<n) memo[i]+=check(A.substring(i,i+2))*memo[i+2];
        }

        return memo[0];
    }
	
	int check(String X){
        if(X.charAt(0)=='0') return 0;
        int value= Integer.parseInt(X);
        // there is only one way to do: thats why return 1 in valid case
        return (0<value && value<27)?1:0;
    }
}