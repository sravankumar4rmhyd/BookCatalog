package com.test;

public class QuickSort {
	 private static long comparisons = 0;
	    private static long exchanges   = 0;
	    public static void quicksort(double[] a) {
	        shuffle(a);
	        quicksort(a, 0, a.length - 1);
	    }
	    public static void quicksort(double[] a, int left, int right) {
	        if (right <= left) return;
	        int i = partition(a, left, right);
	        quicksort(a, left, i-1);
	        quicksort(a, i+1, right);
	    }

	    private static int partition(double[] a, int left, int right) {
	        int i = left - 1;
	        int j = right;
	        while (true) {
	            while (less(a[++i], a[right])) 
	                ;
	            while (less(a[right], a[--j]))
	                if (j == left) break;
	            if (i >= j) break;
	            exch(a, i, j);
	        }
	        exch(a, i, right);
	        return i;
	    }

	    private static boolean less(double x, double y) {
	        comparisons++;
	        return (x < y);
	    }

	    private static void exch(double[] a, int i, int j) {
	        exchanges++;
	        double swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }

	    private static void shuffle(double[] a) {
	        int N = a.length;
	        for (int i = 0; i < N; i++) {
	            int r = i + (int) (Math.random() * (N-i));
	            exch(a, i, r);
	        }
	    }
	    public static void main(String[] args) {
	        int N = Integer.parseInt(args[0]);
	        long start = System.currentTimeMillis();
	        double[] a = new double[N];
	        for (int i = 0; i < N; i++)
	            a[i] = Math.random();
	        long stop = System.currentTimeMillis();
	        double elapsed = (stop - start) / 1000.0;
	        System.out.println("Generating input:  " + elapsed + " seconds");

	        start = System.currentTimeMillis();
	        quicksort(a);
	        stop = System.currentTimeMillis();
	        elapsed = (stop - start) / 1000.0;
	        System.out.println("Quicksort:   " + elapsed + " seconds");

	        System.out.println("Comparisons: " + comparisons);
	        System.out.println("Exchanges:   " + exchanges);
	    }
}
