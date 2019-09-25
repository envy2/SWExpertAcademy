import java.util.Scanner;

public class Solution_3998 {
	static int inversion;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ;i++) {
			int N = sc.nextInt();
			int[] numbers = new int[N];
			
			for (int j = 0; j < numbers.length; j++) {
				numbers[j] = sc.nextInt();
			}
			inversion = 0;
			merge(numbers);
			System.out.println("#"+i+" "+inversion);
			
		}
		sc.close();
	}
	public static void merge(int[] arr) {
		int n = arr.length;
		
		if(n == 1) return;
		
		int[] left = new int[n/2];
		int[] right = new int[n - n/2];
		
		System.arraycopy(arr, 0, left, 0, left.length);
		System.arraycopy(arr, left.length, right, 0, right.length);
		
		merge(left);
		merge(right);
		
		merge_sort(left,right,arr);
	}
	
	public static void merge_sort(int[] left, int[] right, int[] result) {
		int idxA = 0;
		int idxB = 0;
		int idxC = 0;
		
		while(idxA < left.length) {
			if(idxB < right.length) {
				if(left[idxA] < right[idxB]) {
					result[idxC] = left[idxA];
					idxA++;
					inversion += idxB;
				}
				else {
					result[idxC] = right[idxB];
					idxB++;
				}
				idxC++;
			}
			else {
				result[idxC++] = left[idxA++];
				inversion += idxB;
			}
		}
		while(idxB < right.length) {
			result[idxC++] = right[idxB++];
		}
	}
}
