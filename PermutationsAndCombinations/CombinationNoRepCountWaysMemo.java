package abc;
import java.util.*;
public class CombinationNoRepCountWaysMemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3, k= 2; // 3C2 ways f(n-1,k-1) + f(n-1,k)
		int[][]memo = new int[n+1][k+1]; // because it is from 0,0 - so we need to add +1
		for(int [] x : memo)
			Arrays.fill(x, -1);
		System.out.println(ways(n,k,memo));
		
		
	}
	/* PhoneNumber + Permutation + Order
	// n , k
	 */
	public static int ways(int n,int k,int [][]memo){
		if(n<0||k<0||n<k) return 0;
		if(memo[n][k]!=-1) return memo[n][k];
		if(k==0||n==k) return 1;
		if(n==0) return 0;
		int ans = 0;
		ans +=ways(n-1,k-1,memo); // n is taken
		ans +=ways(n-1,k,memo); // n is not taken
		
		return memo[n][k]=ans;
	}
	
}
