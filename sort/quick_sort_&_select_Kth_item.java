public class Solution {
	/*
	quick sort is in-place but not stable
	time complexity O(NlogN) on average (with shuffling)
					O(N^2) worst case (sorted or reverse-sorted already)
	 */
	public void quicksort(Comparable[] a) {
		randomizeArray(a);
		sort(a, 0, a.length - 1);
	}

	/*
	given an array of N items, find a Kth smallest item
	Ex. Min(k = 0), Max(k = N -1), Median(k = N/2)
	time complextity is linear time O(N) on average
	if not shuffle, is O(N^2)
	 */
	public Comparable selectKth(Comparable[] a, int k) {
		shuffleArray(a);
		int l = 0, h = a.length - 1;
		while (l < h) {
			int j = partition(a, l, h);
			if(j > k) h = j - 1;
			else if (j < k) l = j + 1;
			else return a[k];
		}
		return a[k];
	}

	/*
	shuffling the array
	 */
	private void randomizeArray(Comparable[] a) {
		Random rgen = new Random();

		for(int i=0; i<a.length; i++) {
			int pos = rgen.nextInt(a.length);
			Comparable temp = a[i];
			a[i] = a[pos];
			a[pos] = temp;
		}
	}
	/*
	another way to shuffle an array
	 */
	private void shuffleArray(Comparable[] a) {
		Collections.shuffle(Arrays.asList(a));
		/*
		can not use primitive array like int[] array = new int[] {1,2,3,4};
		should use Integer[] array = new Integer[] {1,2,3,4}, then use the 
		above Collections.shuffle(Arrays.asList(array)).
		 */
	}

	public void sort(Comparable[] a, int l, int h) {
		if(l >= h) return;
		int j = partition(a, l, h);
		sort(a, l, j-1);
		sort(a, j+1, h);
	}

	public int partition(Comparable[] a, int l, int h) {
		int i = l;
		int j = h + 1;
		while(true) {
			while(less(a[++i], a[l]))
				if(i == h) break;
			while(less(a[l], a[--j]))
				if(j == l) break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, l, j);
		return j;
	}

	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}