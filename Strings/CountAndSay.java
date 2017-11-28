public class Solution {
    public String countAndSay(int A) {
        if(A==1)
            return "1";
        StringBuilder prev = new StringBuilder("1");
        StringBuilder result = new StringBuilder();;
        
        for(int i = 2; i<=A;i++){
            int count = 1; // Assign count to 1 since one element is present atleast once
            result = new StringBuilder();
            for(int j=0;j<prev.length();j++){
                if(j+1<prev.length() && prev.charAt(j) == prev.charAt(j+1))
                        count++;
                else{    
                    result.append(count).append(prev.charAt(j));
                    count = 1; // Reassign count to 1 after appending to output
                }
            }
            prev = new StringBuilder(result.toString());
        }
        return result.toString();
    }
}
