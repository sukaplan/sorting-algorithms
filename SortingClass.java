package assignment1;

import java.util.Random;

public class SortingClass {

	// QUICKSORT
	void firstElement_Sort(int[] array, int p, int r) {

		if (p < r) {
			int q = PartitionFirstElement(array, p, r);
			firstElement_Sort(array, p, q - 1);
			firstElement_Sort(array, q + 1, r);
		}
	}

	void randomElement_Sort(int[] array, int p, int r) {
		
		if (p < r) {

			int q = PartitionRandomized(array, p, r);
			randomElement_Sort(array, p, q - 1);
			randomElement_Sort(array, q + 1, r);
		}
	}

	void midofFirstMidLastElement_Sort(int[] array, int p, int r) {

		if (p < r) {
			int q = MidofFirstMidLastElement(array, p, r);
			midofFirstMidLastElement_Sort(array, p, q - 1);
			midofFirstMidLastElement_Sort(array, q + 1, r);
		}
	}

	private int PartitionFirstElement(int[] array, int p, int r) {

		int x = array[p];
		int i = p; // leftmost
		for (int j = p + 1; j <= r; j++) {
			if (array[j] <= x) {
				i++;
				swap(array, i, j);

			}

		}
		swap(array, i, p);

		return i;
	}

	private int PartitionRandomized(int[] array, int p, int r) {

		Random random = new Random();
		int i = random.nextInt((r - p) + 1) + p;

		swap(array, i, r);

		return Partition(array, p, r);

	}

	// quick sort last element partition
	private int Partition(int[] array, int p, int r) {

		int x = array[r]; //first element
		int i = p - 1; // leftmost
		for (int j = p; j < r; j++) {
			if (array[j] <= x) {
				i++;
				swap(array, i, j);
			}

		}
		swap(array, i + 1, r);

		return i + 1;
	}

	private int MidofFirstMidLastElement(int[] array, int p, int r) {
		int mid = array[p]; // first element
		int index_Middle = 0;  //to find the index of the middle 
		if (mid >= array[r / 2 + 1]) { // first vs mid 
			if (mid <= array[r]) {  // mid vs last
				index_Middle = p;
			} else if (mid >= array[r]) {  
				if (array[r / 2 + 1] > array[r]) {
					index_Middle = r / 2 + 1;
				} else
					index_Middle = r;
			}

		} else if (mid <= array[r / 2 + 1]) { 
			if (mid > array[r]) {
				index_Middle = p;
			} else if (mid <= array[r]) {
				if (array[r / 2 + 1] > array[r]) {
					index_Middle = r;
				} else {
					index_Middle = r / 2 + 1;
				}
			}
		} 

		swap(array, index_Middle, r);  //swaping mid element with last elemet 
		return Partition(array, p, r);  

	}

	private void swap(int[] array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	void DualPivotSort(int[] array, int left, int right) {

		if (left <= right) {
			if (array[left] > array[right]) {
				swap(array, left, right);
			}
			int lp = PartitionFirstElement(array, left, right);
			int rp = Partition(array, left, right);

			DualPivotSort(array, left, lp - 1);
			DualPivotSort(array, lp + 1, rp - 1);
			DualPivotSort(array, rp + 1, right);

		}
	}
	// END OF THE QUICKSORT

	// HEAPSORT
	private void MaxHeapify(int[] array, int i, int size) {

		int largest = i;

		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < size && array[l] > array[i])
			largest = l;
		else
			largest = i;

		if (r < size && array[r] > array[largest])
			largest = r;

		if (largest != i) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;

			MaxHeapify(array, largest, size);
		}
	}

	private void BuildMaxHeap(int[] array, int n) {

		for (int i = (n / 2) - 1; i >= 0; i--) {
			MaxHeapify(array, i, n);
		}
	}

	void heapSort(int[] array) {

		int n = array.length;

		BuildMaxHeap(array, n);

		for (int i = n - 1; i >= 0; i--) {

			swap(array, 0, i);

			n = n - 1;

			MaxHeapify(array, 0, i);
		}
	}
	// END OF THE HEAPSORT

	// INTROSORT
	void introSort(int[] array) {

		int maxdepth = (int) (Math.log(array.length) * 2);
		sort(array, maxdepth, 0, array.length - 1);
	}

	private void sort(int[] array, int depth, int left, int right) {


		int len = right - left + 1;

		if (len <= 1) {
			return;
		} else if (depth == 0) {
			heapSort(array);
		} else {
			if (left >= right)
				return;

			int pivot = Partition(array, left, right);
			sort(array, depth - 1, 0, pivot);
			sort(array, depth - 1, pivot + 1, right);
		}
	}
	// END OF THE INTROSORT

	void display(int[] array) {
		
		System.out.println("first 10 elements : ");

		for (int i = 0; i < 10; i++) {
			
			System.out.print(" " + array[i]);
		}

	}

}
