package abc;

public class PermutationsWithRepeatitions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] A = {1,2,3}; // n^k 
		
		permutationsEx(A);
		
		
	}
	

	static void permutationsEx(int []input){
	    int selected[] = new int[input.length];
	    func(0,selected,input);
	      
	    
	  }
	
	// Phone Number problem //No disabled array
	// Selected[] - based on position - selected[pos]
	// Disabled [] - based on i which is same as input array 
	  
	  static void func(int pos, int [] selected,int [] input){

	      if(pos>=selected.length){
	        for(int i=0;i<selected.length;i++)
	          System.out.print(" "+selected[i]);
	        System.out.println();
	        return;
	      }
	        
	        else{
	          for(int i=0;i<input.length;i++){
	              selected[pos] = input[i];
	              func(pos+1,selected,input);
	            }
	          }
	        }
	  }

