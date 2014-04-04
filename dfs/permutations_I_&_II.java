public class Solution {
	/*
	distinct numbers
	 */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean[] t = new boolean[num.length];
        Arrays.sort(num);
        dfs(arr, temp, num, 0, t);
        return arr;
    }

    public void dfs(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> temp, int[] num, int k, boolean[] t) {
    	if(k == num.length)
    		arr.add(new ArrayList<Integer>(temp));
    	for(int i=0; i<num.length; i++) {
    	    if(t[i]) continue;
    		temp.add(num[i]);
    		t[i] = true;
    		dfs(arr, temp, num, k+1, t);
    		temp.remove(temp.size()-1);
    		t[i] = false;
    	}
    }

    /*
    contain duplicate numbers
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean[] t = new boolean[num.length];
        Arrays.sort(num);
        dfs2(arr, temp, num, 0, t);
        return arr;
    }

    public void dfs2(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> temp, int[] num, int k, boolean[] t) {
    	if(k == num.length)
    		arr.add(new ArrayList<Integer>(temp));
    	for(int i=0; i<num.length; i++) {
    	    if(t[i]) continue;
    		temp.add(num[i]);
    		t[i] = true;
    		dfs2(arr, temp, num, k+1, t);
    		temp.remove(temp.size()-1);
    		t[i] = false;
    		while(i < num.length-1 && num[i] == num[i+1]) i++;
    	}
    }
}