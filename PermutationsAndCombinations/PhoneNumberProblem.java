package abc;
import java.util.*;
public class PhoneNumberProblem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] A = {5,6,8,9,7};
		Map<Character,String> phoneMap = new HashMap();
		int []selected = new int[3];
		String input = "123";
		phoneMap.put('1',"ABC");
		phoneMap.put('2',"DEF");
		phoneMap.put('3',"GHI");
		permutationsEx(0,phoneMap,input,selected);
		
		
	}
	
	// Here in Phone Number problem : 1 dash is fixed for 1 number
	// i,e 1 has to come first (ABC) , 2 has to come 2nd (DEF) and so on
	// so every dash has a option of 3 letters/ 4 letters which can be fetch from map
	// Selected - length is k dashes - indexed with position --> selected[pos] and not selected[i]
	// input array - n -- Here n is equal to k
	/*
	 * Generic algo 
	 * 	if(pos>=selected.length) {
			// means all positions are filled in selected
			// print and return 
		}
		for(int i=0;i<Options/Possibilies;i++){
			selected[pos] = i;
			permutationsEx(pos+1,phoneMap,input,selected); // Call for next position
		}
	 * 
	 */
	public static void permutationsEx(int pos, Map<Character,String> phoneMap, String input,int []selected){
		if(pos>=selected.length) {
			// means all positions are filled in selected
			// print and return 
			for(int i=0;i<selected.length;i++){
				System.out.print(" "+phoneMap.get(input.charAt(i)).charAt(selected[i]));
			}
			
			System.out.println();
			return;
			
		}
		for(int i=0;i<phoneMap.get(input.charAt(pos)).length();i++){
			selected[pos] = i;
			permutationsEx(pos+1,phoneMap,input,selected);
		}
		
		
	}
	
}


/*ans = Integer.max
if(A==null) return 0;
if(A.left null & A.right null) return 1;
if(A.left!= null) ans = Math.min(ans, 1+left);
if(A.right!= null) ans = Math.min(ans, 1+right);*/


