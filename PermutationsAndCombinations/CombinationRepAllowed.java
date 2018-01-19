package abc;
import java.util.*;
public class CombinationRepAllowed {
	static int lastIndex = 1; // Repeatition is allowed, so choose n element again for next k positions
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3, k= 2; // f(n,k-1) + f(n-1,k) 
		//n+r-1Cr possibilities
		int []selected = new int[k];
		

		permutationsEx(0,lastIndex,n,selected);
		
		
	}
	// PhoneNumber + Permutation + Order (To avoid permutation)
	// n , k
	// Selected - length is k dashes - indexed with position --> selected[pos] and not selected[i]
	// input array - n -- Here n is equal to k
	/*
	 * Generic algo 
	 * 	if(pos>=selected.length) {
			// means all positions are filled in selected
			// print and return 
		}
		i<Options/Possibilities - Here it is n
		for(int i=lastIndexSelected;i<Options/Possibilies;i++){
			selected[pos] = i;
			Update lastIndex
			permutationsEx(pos+1,phoneMap,input,selected); // Call for next position
		}
	 * 
	 */
	public static void permutationsEx(int pos,int lastIndex, int n,int []selected){
		if(pos>=selected.length) {
			// means all positions are filled in selected
			// print and return 
			for(int i=0;i<selected.length;i++){
				System.out.print(" "+selected[i]);
			}
			
			System.out.println();
			return;
			
		}
		for(int i=lastIndex;i<=n;i++){
			selected[pos] = i;
			lastIndex = i; // Update the lastIndex
			permutationsEx(pos+1,lastIndex,n,selected);
		}
		
		
	}
	
}


