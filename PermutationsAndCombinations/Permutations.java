package abc;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] A = {5,6,8,9,7}; // nPk
		
		permutationsEx();
		
		
	}
	

	static void permutationsEx(){
	    int []input = new int[3];
	    input[0] = 1;
	    input[1] = 2;
	    input[2] = 3;
	    int selected[] = new int[input.length];
	    int disabled[] = new int[input.length];
	    func(0,selected,disabled,input);
	      
	    
	  }
	
	// Phone Number problem + Disabled array 
	// Selected[] - based on position - selected[pos]
	// Disabled [] - based on i which is same as input array 
	  
	  static void func(int pos, int [] selected, int []disabled, int [] input){

	      if(pos>=selected.length){
	        for(int i=0;i<selected.length;i++)
	          System.out.print(" "+selected[i]);
	        System.out.println();
	        return;
	      }
	        
	        else{
	          for(int i=0;i<input.length;i++){
	            if(disabled[i]==1) continue;
	            else{
	              selected[pos] = input[i];
	              disabled[i] = 1;
	              func(pos+1,selected,disabled,input);
	              disabled[i] = 0;
	            }
	          }
	        }
	  }
	
	  
	 /* static void generateSubString(String s, int start, StringBuilder str){
		    if(start >= s.length()){
		        System.out.println(" "+str);
		        return;
		    }
		     else {
		        for(int i=start;i<s.length();i++){
		          str.append(str.charAt(i));
		          generateSubString(s,i+1,str);
		        }
		     }   
		    
		  }*/
	
}
