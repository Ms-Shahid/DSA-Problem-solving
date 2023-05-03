package dsa.intermediate.level_1.arrays;

public class PrefixAndSufix {

	public static void main (String[] args) {
		int arr[] = new int[]{9, 3, 5, 2, 7, 8};
		int queries[][] = {
				{0, 2}, {2, 4}, {1, 4}
		};
//		int[] values = solveEvenQueries(arr,queries);
		int[] values = prefixProductArray(arr);
		for(int v : values){
			System.out.println("V-> " + v);
		}

	}

	private static long[] prefixSum(int arr[]){

		long prefix[]  = new long[arr.length]; // starting prefix is at arr[0]
		prefix[0] = arr[0];

		for(int i = 1; i < arr.length; i++){
			prefix[i] = prefix[i+1] + arr[i];
		}

		return prefix;
	}

	private static int[] prefixCount(int arr[]){

		int[] prefixC = new int[arr.length];
		prefixC[0] = arr[0] % 2 == 0 ? 1 : 0;

		for(int i = 1; i < arr.length; i++){
			prefixC[i] = arr[i] % 2 == 0 ? prefixC[i-1] + 1 : prefixC[i-1];
		}
		return prefixC;
	}

	private static int[] solveEvenQueries(int[] arr, int[][] queries){
		/*
		* You are given an array A of length N and Q queries given by the 2D array B of size Q×2.

			Each query consists of two integers B[i][0] and B[i][1].

			For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].*/
		int[] prefixCount = prefixCount(arr);
		int evenCount[] = new int[queries.length];
		for(int i = 0; i < queries.length; i++){
			int leftCount = queries[i][0];
			int rightCount = queries[i][1];

			evenCount[i] = leftCount > 0 ? prefixCount[rightCount] - prefixCount[leftCount - 1] : prefixCount[rightCount];
		}
		return  evenCount;
	}

	private static int[] prefixProductArray(int arr[]){
		/*
		* Given an array of integers A,
		* find and return the product array of the same size
		* where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
		* 2 <= length of the array <= 1000
			1 <= A[i] <= 10*/
		int prefixProduct[] = new int[arr.length];
		int product = 1;
		for(int v : arr){
			product *= v;
		}

		prefixProduct[0] = product / arr[0];
		for(int i = 1; i < arr.length; i++){
			prefixProduct[i] = product / arr[i];
		}
		return prefixProduct;
	}

	private long[] rangeSum(int[] A, int[][] B) {

		/*
		* You are given an integer array A of length N.
		You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
		For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
		More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
		* */
		long result[] = new long[B.length];
		long pf[] = prefixSum(A);

		for(int i = 0; i < B.length; i++){
			int left = B[i][0];
			int right = B[i][1];

			result[i] = (left > 0) ? pf[right] - pf[left - 1] : pf[right];

		}
		return result;
	}

	public int equilibriumIndexOfArray(int[] A) {
		/*
		*   You are given an array A of integers of size N.

			Your task is to find the equilibrium index of the given array

			The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

			If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

		Note:
			Array indexing starts from 0.
			If there is no equilibrium index then return -1.
			If there are more than one equilibrium indexes then return the minimum index.
			A = [-7, 1, 5, 2, -4, 3, 0]
		*   output = 3
		* */
		int totalSum = arraySum(A);
		long[] prefix = prefixSum(A);

		int minimumIndex = -1;

		for(int i = 1; i < A.length - 1; i++){
			long leftSum = prefix[i-1];
			long rightSum = totalSum - prefix[i];

			if(leftSum == rightSum) //Inbetween 1 & last indicies
				minimumIndex = i;
		}
		if(prefix[A.length-1] - prefix[0] == 0) //zero-th index
			minimumIndex = 0;

		if(prefix[A.length - 2] == 0) //last index
			minimumIndex = A.length - 1;

		return minimumIndex;
	}

	public int arraySum(int[] arr){
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}
}
