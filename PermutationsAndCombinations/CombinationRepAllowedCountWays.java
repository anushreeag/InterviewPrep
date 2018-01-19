package abc;
import java.util.*;
public class CombinationRepAllowedCountWays {
	
	// Repeatition is allowed, so choose n element again for next k positions
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3, k= 2; // f(n,k-1) + f(n-1,k) //n+r-1Cr possibilities
		System.out.println(ways(n,k));
		
	}
	/* PhoneNumber + Permutation + Order (To avoid permutation) + Repeatition allowed
	// n , k
	
	 */
	public static int ways(int n,int k){
		
		if(n<0||k<0||n<k) return 0;
		if(k==0||n==k) return 1;
		if(n==0) return 0;
		int ans = 0;
		ans+=ways(n-1,k); // n is not taken
		ans+=ways(n,k-1); // n is taken
		return ans;
	}
	
}




