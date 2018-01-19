package abc;
import java.util.*;
public class CombinationRepAllowedCharacters {
	static int lastIndex = 0; // Repeatition is allowed, so choose 0th element for next k-1 position
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k= 2; // f(n,k-1) + f(n-1,k) //n+r-1Cr possibilities
		String input = "abcd";
		int []selected = new int[k];
		int []disabled = new int[input.length()];

		permutationsEx(0,lastIndex,input,selected,disabled);
		
		
	}
	// PhoneNumber + Permutation + Order (To avoid permutation) + repeatition allowed
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
	public static void permutationsEx(int pos,int lastIndex, String input,int []selected, int[] disabled){
		if(pos>=selected.length) {
			// means all positions are filled in selected
			// print and return 
			for(int i=0;i<selected.length;i++){
				System.out.print(" "+input.charAt(selected[i]));
			}
			
			System.out.println();
			return;
			
		}
		for(int i=lastIndex;i<input.length();i++){
			//if(disabled[i]==1) continue;
			selected[pos] = i;
			//disabled[i]=1;
			lastIndex = i; // Update the lastIndex
			permutationsEx(pos+1,lastIndex,input,selected,disabled);
			//disabled[i] = 0;
		}
		
		
	}
	
}





