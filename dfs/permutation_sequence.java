public class Solution {
	/*
	ArrayList can remove target item with changing sequence of array index in right order
	 */
    public String getPermutation(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        StringBuffer sb = new StringBuffer();
        int fact = 1;
        int selected = 0;
        for(int i=0; i<n; i++) {
        	arr.add(i+1);
        	fact *= i+1;
        }
        k--;
        for(int i=0; i<n; i++) {
        	fact = fact / (n-i);
        	selected = k / fact;
        	k = k % fact;
        	sb.append(arr.get(selected));
        	arr.remove(selected);
        }
        return sb.toString();
    }
}