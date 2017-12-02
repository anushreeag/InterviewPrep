public class Solution {
    public String longestCommonPrefix(String[] A) {
        StringBuffer common = new StringBuffer(A[0]);
        for(int i=1;i<A.length;i++){
            int len = Math.min(common.length(),A[i].length());
            StringBuffer newCommon = new StringBuffer();
            for(int j = 0 ; j<len;j++){
                if(common.charAt(j)!=A[i].charAt(j)){
                    break;
                }
                 else{
                    newCommon.append(common.charAt(j));
                }
            }
            common = newCommon;
        }
        
        return common.toString();
        
    }
}
