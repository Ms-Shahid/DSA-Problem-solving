package dsa.intermediate.level_1.arrays;

public class Arrays2D {

	public static void main (String[] args) {
		int queries[][] = {
				{1,2,3,4}, {5,6,7,8}, {9,2,3,4}
		};
		int[] arr = columWise(queries);
		for(int v : arr){
			System.out.println(v);
		}
	}
	public static int[] rowWise(int[][] A) {
		/*
		* Problem Description
		You are given a 2D integer matrix A, return a 1D integer array containing row-wise sums of original matrix.
		* */
		int[] arr = new int[A.length];

		for(int row = 0; row < A.length; row++){
			for(int col = 0; col < A[row].length; col++){
				arr[row] += A[row][col];
			}
		}
		return arr;
	}
	public static int[] columWise(int[][] A) {
		/*
		* Problem Description
		You are given a 2D integer matrix A, return a 1D integer array containing row-wise sums of original matrix.
		* */
		int[] arr = new int[A[0].length];

		for(int col = 0; col < A[0].length; col++){
			for(int row = 0; row < A.length; row++){
				arr[col] += A[row][col];
			}
		}

		return arr;
	}
}
