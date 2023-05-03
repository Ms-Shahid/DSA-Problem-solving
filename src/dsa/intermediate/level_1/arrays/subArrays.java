package dsa.intermediate.level_1.arrays;

public class subArrays {
	public static void main (String[] args) {
		int arr[] = new int[]{ 2, 9, 5 };
		System.out.println(
				//maximumSumOfSubArray(arr,5,12) + "\n" +
						subArraySum(arr)

		);

	}

	private static int maximumSumOfSubArray(int arr[], int size, int lastValue){
		/*
		* You are given an integer array arr of size .
		* Now you need to find a subarray (contiguous elements)
		* so that the sum of contiguous elements is maximum.
		* But the sum must not exceed lastValue.

		*   1 <= size <= 10^3
			1 <= lastValue <= 10^9
			1 <= arr[i] <= 106

			* Example
			* size = 5
			lastValue = 12
			arr = [2, 1, 3, 4, 5]
			* output -> 12
		* */

		int max = 0;

		for(int start = 0; start < size; start++){
			int sum = 0;
			for(int e = start; e < size; e++){
				sum += arr[e];
				if(sum <= lastValue)
					max = Math.max(max,sum);
			}
		}
		return max;
	//TC : O(N^2); SC : O(1)
	}

	private static long subArraySum(int[] A) {
		/*
		* You are given an integer array A of length N.
		You have to find the sum of all subArray sums of A.
		* Constrains
		* 1 <= N <= 10^5
			1 <= A[i] <= 10^4
		* Example
		* A = [1, 2, 3]
		* output - 20
		* */
		long sum = 0;

		return sum;
	}


}
