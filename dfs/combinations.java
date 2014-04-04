public class Solution {
	/*
	combinations
	 */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        find(arr, temp, n, k, 1);
        return arr;
    }

    public void find(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> temp, int n, int k, int p) {
    	if(k == 0) {
    		arr.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	for(int i=p; i<=n; i++) {
    		temp.add(i);
    		find(arr, temp, n, k-1, i+1); // take care, can not use k-- for the argument!!
    		temp.remove(temp.size()-1);
    	}
    }
}