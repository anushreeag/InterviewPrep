public class Solution {
    public String addBinary(String A, String B) {
		
		//Length of output string
        int resLength = Math.max(A.length(),B.length());
        int sum = 0, carry = 0;
        StringBuilder output = new StringBuilder();
        for(int i = 0;i<resLength;i++){
            sum = carry;
            if(i<A.length()) sum+=A.charAt(A.length()-1-i)-'0'; // Subtract by the ascii value of 0, since we need integer value
            if(i<B.length()) sum+=B.charAt(B.length()-1-i)-'0'; // Subtract by the ascii value of 0, since we need integer value
            
			// Binary addition
            output.append(sum%2); 
            carry = sum/2;
            
        }
        
        if(carry == 1)
             output.append(carry);
        
        return output.reverse().toString();
    }
}
