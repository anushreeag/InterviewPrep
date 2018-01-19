package abc;
import java.util.*;
public class CombinationNoRepCountWaysMemoBottomTop {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3, k= 2; // 3C2 ways f(n-1,k-1) + f(n-1,k)
		int[][]memo = new int[n+1][k+1]; // because it is from 0,0 - so we need to add +1
		// Fill first column with 1's because nC0 is 1 and 
		//and first row except(0,0) with 0  - 0Ck is 0 but 0C0 is 1
		// matrix will look like - n rows and k cols
		// 1 0 0 0
		// 1 x x x
		// 1 x x x
		// 1 x x x 
		Arrays.fill(memo[0], 0);
		for(int i=0;i<=n;i++){
			memo[i][0]=1;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=k;j++){
				//f(n,k) = f(n-1,k-1) + f(n-1,k)
				memo[i][j]= memo[i-1][j-1]+memo[i-1][j];
			}
		}
		
		System.out.println(memo[n][k]);
		
		
	}

	
}
