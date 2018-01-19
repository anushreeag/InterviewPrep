package abc;
import java.util.*;
public class CombinationRepAllowedCountWaysMemo2Rows {
	
	// Repeatition is allowed, so choose n element again for next k positions
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3, k= 2; // f(n,k-1) + f(n-1,k) //n+r-1Cr possibilities
		int [][]memo = new int[2][k+1]; // n starts from 1 and k start 1 - so n+1, k+1
		// but matrix starts from 0,0
		Arrays.fill(memo[0],0);
		for(int i=0;i<2;i++){
			memo[i][0] = 1;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=k;j++){
				//f(n,k) f(n,k-1) + f(n-1,k) 
				memo[i%2][j] = memo[i%2][j-1]+memo[(i-1)%2][j];
			}
		}
		System.out.println(memo[n%2][k]);
		
	}
	
}




