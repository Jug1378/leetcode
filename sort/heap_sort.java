class heap {
	public void heapsort(Comparable[] arr) {
		int N = arr.length;
		for(int k = N/2-1; k>=0; k--)
			sink(arr,k,N);
		while(N > 0) {
			exch(arr, 0, N-1);
			sink(arr, 0, --N);
		}
	}

	public void sink(Comparable[] arr, int k, int N) {
		while(2*k + 1 <= N - 1) {
			int j = 2*k+1;
			if(j < N-1 && arr[j].compareTo(arr[j+1]) < 0) j++;
			if(arr[k].compareTo(arr[j]) >= 0) break;
			exch(k, j);
			k = j;
		}
	}

	public void exch(Comparable[] arr, int i, int j) {
		Compareble tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}