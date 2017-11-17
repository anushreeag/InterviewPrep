public class Solution {
    public int numRange(int[] a, int B, int C) {
        int count = 0;
        for(int i = 0;i<a.length;i++){
            int sum = a[i];
            if(a[i]>=B && a[i]<=C) count++;
            for(int j = i+1;j<a.length;j++){
                sum = sum +a[j];
                 if(sum>=B && sum<=C) count++;
                 if(sum>C) break;
            }
        }
        
        return count;
    }
}
