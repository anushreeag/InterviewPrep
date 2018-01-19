package abc;
import java.util.*;
public class CombinationRepAllowedCountWaysMemo {
	
	// Repeatition is allowed, so choose n element again for next k positions
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3, k= 2; // f(n,k-1) + f(n-1,k) //n+r-1Cr possibilities
		int [][]memo = new int[n+1][k+1]; // n starts from 1 and k start 1 - so n+1, k+1
		// but matrix starts from 0,0
		for(int [] x : memo)
			Arrays.fill(x,-1);
		System.out.println(ways(n,k,memo));
		
	}
	/* PhoneNumber + Permutation + Order (To avoid permutation) + Repeatition allowed
	// n , k
	
	 */
	public static int ways(int n,int k, int[][] memo){
		if(n<0||k<0||n<k) return 0;
		if(memo[n][k]!=-1) return memo[n][k];
		if(k==0||n==k) return 1;
		if(n==0) return 0;
		int ans = 0;
		ans+=ways(n-1,k,memo); // n is not taken
		ans+=ways(n,k-1,memo); // n is taken
		return memo[n][k]=ans;
	}
	
}



