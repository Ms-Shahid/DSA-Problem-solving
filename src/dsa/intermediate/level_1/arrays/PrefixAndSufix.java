package dsa.intermediate.level_1.arrays;

public class PrefixAndSufix {

	public static void main (String[] args) {

	}

	private static int countPrefix(int arr[]){
		int count = 0;
		int prefix[]  = new int[arr.length]; // starting prefix is at arr[0]
		prefix[0] = arr[0];

		for(int i = 1; i < arr.length; i++){
			prefix[i] = prefix[i+1] + arr[i];
		}

		return count;
	}
}
