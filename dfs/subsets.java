public class Solution {
    /*
    Given a set of distinct integers, S, return all possible subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        arr.add(temp);
        Arrays.sort(S);
        find(S, temp, arr, 0);
        return arr;
    }
    
    public void find(int[] S, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> arr, int pos) {
        for(int i=pos; i<S.length; i++) {
            temp.add(S[i]);
            arr.add(new ArrayList<Integer>(temp));
            find(S, temp, arr, i+1);
            temp.remove(temp.size()-1);
        }
    }


    /*
    Given a collection of integers that might contain duplicates, S, return all possible subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        arr.add(temp);
        Arrays.sort(num);
        find(num, temp, arr, 0);
        return arr;
    }

    public void find(int[] num, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> arr, int pos) {
        for(int i=pos; i<num.length; i++) {
            temp.add(num[i]);
            arr.add(new ArrayList<Integer>(temp));
            find(num, temp, arr, i+1);
            temp.remove(temp.size()-1);
            while(i<num.length-1 && num[i] == num[i+1]) i++;
        }
    }
}