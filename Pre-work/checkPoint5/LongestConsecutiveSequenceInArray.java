public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        int count = 0,max=0;
        Set<Integer> set = new HashSet();
        
        if(A.length == 0) return 0;
        if(A.length == 1) return 1;
        for(int i = 0;i<A.length;i++)
        {
            set.add(A[i]);
        }
        
        for(int x : A){
            int left = x-1;
            int right = x+1;
            count = 1;
            while(set.contains(left)){
                count ++;
                set.remove(left);
                left--;
            }
            while(set.contains(right)){
                count ++;
                set.remove(right);
                right++;
            }
            
            max = Math.max(count,max);
        }
        
        return max;
        
        
    }
}