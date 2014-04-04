public class Solution {
	/*
	Combination Sum I, number can be used multiple times
	1)	when target < 0, should return, or would cause infinite loop
	2)	should have an argument to indicate the position, or would generate some subsets
		like [1,2] & [2,1], which are improper
	 */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combine(arr, temp, candidates, target, 0);
        return arr;
    }

    public void combine(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> temp, int[] cand, int target, int pos) {
    	if(target <= 0) {
    		if(target == 0)
    			arr.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	for(int i=pos; i<cand.length; i++) {
    		temp.add(cand[i]);
    		combine(arr, temp, cand, target-cand[i], i);
    		temp.remove(temp.size()-1);
    	}
    }


    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combine(arr, temp, candidates, target, 0);
        return arr;
    }
    /*
    Combination Sum I, number can only be used once
     */
    public void combine(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> temp, int[] cand, int target, int pos) {
    	if(target <= 0) {
    		if(target == 0)
    			arr.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	for(int i=pos; i<cand.length; i++) {
    		temp.add(cand[i]);
    		combine(arr, temp, cand, target-cand[i], i+1);
    		temp.remove(temp.size()-1);
    		while(i<cand.length-1 && cand[i]==cand[i+1]) i++; //avoid the same number
    	}
    }
}