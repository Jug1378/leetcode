class Solution {
	/*
	care when converting int/Integer to String
	1)	String.valueOf(num)
	2)	Integer.toString(num)
	 */
	public ArrayList<String> serialize(TreeNode root) {
		ArrayList<String> arr = new ArrayList<String>();
		doSerialize(root, arr);
		return arr;
	}

	public void doSerialize(TreeNode root, ArrayList<String> arr) {
		if(root == null) {
			arr.add("#");
			return;
		}
		arr.add(Integer.toString(root.val));
		doSerialize(root.left, arr);
		doSerialize(root.right, arr);
	}

	/*
	care when converting String to int
	1)	Integer.valueOf(str) would return a instance of Integer 
	2)	Integer.parseInt(str) would return primitive int
	 */
	public TreeNode deserialize(String[] arr) {
		int[] n = new int[1];
		n[0] = -1;
		return doDeserialize(arr, n);
	}

	/*
	increase the index of array
	1)	we can pass an array with one element 
	2)	can create a private instance variable of the class
	 */
	public TreeNode doDeserialize(String[] arr, int[] n) {
		n[0]++;
		if(arr[n[0]] == "#")
			return null;
		TreeNode t = new TreeNode(Integer.parseInt(arr[n[0]]));
		t.left = doDeserialize(arr, n);
		t.right = doDeserialize(arr, n);
		return t;
	}
}