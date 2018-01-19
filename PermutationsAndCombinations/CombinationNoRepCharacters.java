package abc;
import java.util.*;
public class CombinationNoRepCharacters {
	static int lastIndex = -1; // Because it is String, we have to start from lastIndex+1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcd" ;
		int k= 2; //  n= 4 C2 ways f(n-1,k-1) + f(n-1,k)-- 12/2 - 6 ways
		int []selected = new int[k];
		int disabled[] = new int[input.length()];

		permutationsEx(0,lastIndex,input,selected, disabled);
		
		
	}
	// PhoneNumber + Permutation + Order
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
		for(int i=lastIndexSelected+1;i<Options/Possibilies;i++){
			selected[pos] = i;
			Update lastIndex
			permutationsEx(pos+1,phoneMap,input,selected); // Call for next position
		}
	 * 
	 */
	public static void permutationsEx(int pos,int lastIndex, String input,
			int []selected, int[]disabled){
		if(pos>=selected.length) {
			// means all positions are filled in selected
			// print and return 
			for(int i=0;i<selected.length;i++){
				System.out.print(" "+input.charAt(selected[i]));
			}
			
			System.out.println();
			return;
			
		}
		for(int i=lastIndex+1;i<input.length();i++){
			if(disabled[i]==1) continue;
			selected[pos] = i;
			disabled[i] = 1;
			lastIndex = i; // Update the lastIndex
			permutationsEx(pos+1,lastIndex,input,selected,disabled);
			disabled[i] = 0;
		}
		
		
	}
	
}



