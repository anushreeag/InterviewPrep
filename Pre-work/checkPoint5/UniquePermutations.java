public class Solution {
    public int[][] permute(int[] A) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    permuteUnique(A, 0, result);
	    
	    int [][]ans = new int[result.size()][];
	    
	    for (int i=0; i < ans.length; i++)
        {
            ans[i] = new int[result.get(i).size()];
            for(int j = 0;j<ans[i].length;j++){
                ans[i][j] = result.get(i).get(j);
            }
        }
	    return ans;
    }
    
        private void permuteUnique(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
     
    	if (start >= num.length ) {
    		ArrayList<Integer> item = convertArrayToList(num);
    		result.add(item);
    	}
     
    	for (int j = start; j <= num.length-1; j++) {
    		if (containsDuplicate(num, start, j)) {
    			swap(num, start, j);
    			permuteUnique(num, start + 1, result);
    			swap(num, start, j);
    		}
    	}
    }
 
    private ArrayList<Integer> convertArrayToList(int[] num) {
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	for (int h = 0; h < num.length; h++) {
    		item.add(num[h]);
    	}
    	return item;
    }
 
    private boolean containsDuplicate(int[] arr, int start, int end) {
    	for (int i = start; i <= end-1; i++) {
    		if (arr[i] == arr[end]) {
    			return false;
    		}
    	}
    	return true;
    }
 
    private void swap(int[] a, int i, int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
}
