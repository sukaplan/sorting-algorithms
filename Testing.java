package assignment1;

import java.util.Random;

public class Testing {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 
		 * decreasing int j = 0; for(int i = n - 1; i >= 0; i--) { array[i] = j; j++; }
		 * 
		 * increasing for(int i = 0; i < n; i++){ array[i] = i; }
		 * 
		 * equal int: for(int i = 0; i < n; i++){ array[i] = 215; }
		 * 
		 * random: Random rnd = new Random(); for(int i = 0; i < n; i++){ array[i] =
		 * rnd.nextInt(1000);
		 * 
		 * } System.out.println("start"); long startTime = System.nanoTime();
		 * 
		 * 
		 * long endTime = System.nanoTime(); System.out.println("end");
		 * 
		 * System.out.println("time = " + (endTime - startTime) / 1000000 + " " +
		 * (endTime - startTime) + " ns");
		 * 
		 * 
		 * 
		 */

		int n = 100000;
		int array[] = new int[n];
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			array[i] = 5;
		}

		SortingClass sortingClass = new SortingClass();
		
		System.out.println("start");
		long startTime = System.nanoTime();
		sortingClass.DualPivotSort(array, 0, array.length - 1); //(array, 0, array.length - 1);
		long endTime = System.nanoTime();
		System.out.println("end");
		
		System.out.println("time in ms = " + (endTime - startTime) / 1000000 + " ms  time in ns =  " + (endTime - startTime) + " ns");
		sortingClass.display(array);

	}

}
