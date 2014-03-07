package com.test;

import java.util.Scanner;

public class TwentyQuestions {
	public static int search(int lo, int hi) {
		Scanner scanner=new Scanner(System.in);
        if ((hi - lo) == 1) return lo;
        int mid = lo + (hi - lo) / 2;
        System.out.printf("Is it less than %d?  ", mid);
        if (scanner.nextBoolean()) return search(lo, mid);
        else                     return search(mid, hi);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int N = (int) Math.pow(2, n);
        System.out.printf("Think of an integer between %d and %d\n", 0, N-1);
        int v = search(0, N);
        System.out.printf("Your number is %d\n", v);
    }
}
