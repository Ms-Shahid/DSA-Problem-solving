package dsa.intermediate.level_1.arrays;

public class Arrays2D {
/*
* [[47,-59,20,33,20,-47,-87,-59,85],
* [8,-67,48,-10,-23,-68,-28,62,-94],
* [-50,77,-39,-57,15,71,44,13,-53],
* [-30,43,-92,-94,42,37,95,7,19],
* [-1,92,-85,20,-53,-16,31,-95,4],
* [-62,49,0,53,-93,-61,-49,86,97],
* [62,-26,-1,-38,59,-93,-93,12,-90],
* [78,85,90,89,-65,5,48,40,-86],
* [-79,-68,-89,90,-40,47,68,-25,92]]
* */
	public static void main (String[] args) {
		int queries[][] = {
				{47,-59,20,33,20,-47,-87,-59,85},
				{8,-67,48,-10,-23,-68,-28,62,-94},
				{-50,77,-39,-57,15,71,44,13,-53},
				{-30,43,-92,-94,42,37,95,7,19},
				{-1,92,-85,20,-53,-16,31,-95,4},
				{-62,49,0,53,-93,-61,-49,86,97},
				{62,-26,-1,-38,59,-93,-93,12,-90},
				{78,85,90,89,-65,5,48,40,-86},
				{-79,-68,-89,90,-40,47,68,-25,92}
		};
//		for(int i = 0; i < queries.length;i++){
//			System.out.println("len-> " + queries[i].length);
//		}
		int arr[][] = {
				{1, -2, -3},{-4, 5, -6},{-7, -8, 9}
		};
		System.out.println(minorDiagonalSum(arr));

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

	public static int[][] transposeOfMatrix (int[][] A) {
		int[][] transpose = new int[A[0].length][A.length];

		for(int row = 0; row < A.length; row++){

			for(int col = 0; col < A[row].length; col++){
				transpose[col][row] = A[row][col];
			}
		}
		return transpose;
	}

	public static int diagonalSum(int[][] A) {
		int sum = 0;
		int col = 0;
		int row = 0;
		while ( row < A.length ){
			if(row == col)
			System.out.println("A-> " + A[row][col] + " sum-> " + sum);
				sum += A[row][col];
			col++; row++;

		}

		return sum;
	}

	public static int minorDiagonalSum( int[][] A) {
		int sum = 0;
		int size = A.length;
		int col = size - 1;
		int row = 0;

		for(int i = 0; i < size; i++){
			sum += A[row][col];
			col--;
			row++;
		}

		return sum;
	}

	public int[][] diagonal(int[][] A) {
		/*
		* Give a N * N square matrix A, return an array of its anti-diagonals. .*/
		int rows = A.length;
		int cols = A[0].length;
		int antiDiagonal[][] = new int[A.length][A[0].length];
		for(int gap = 0; gap < A.length; gap++){
			int i = 0;
			int j = A.length - 1;
			while( i < A.length ){
				antiDiagonal[i][j] = A[i][j];
				i++;
				j--;
			}

		}
	}


}

