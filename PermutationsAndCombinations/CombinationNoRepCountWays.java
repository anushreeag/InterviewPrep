package abc;
import java.util.*;
public class CombinationNoRepCountWays {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3, k= 2; // 3C2 ways f(n-1,k-1) + f(n-1,k)
		System.out.println(ways(n,k));
		
		
	}
	/* PhoneNumber + Permutation + Order
	// n , k
	 */
	public static int ways(int n,int k){
		if(n<0||k<0||n<k) return 0;
		if(k==0||n==k) return 1;
		if(n==0) return 0;
		int ans=0;
		ans +=ways(n-1,k-1); // n is taken
		ans +=ways(n-1,k); // n is not taken
		
		return ans;
	}
	
}
