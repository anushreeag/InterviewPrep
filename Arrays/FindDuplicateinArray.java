public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    Set<Integer> set = new HashSet<>();
	    for(int x : a){
	        if(set.contains(x))
	            return x;
	        else
	            set.add(x);
	    }
	    
	    return -1;

	}
}
