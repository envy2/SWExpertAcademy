import java.util.Scanner;

public class Solution_8659 {
	
	public static void main(String[] args) {
		long[] A = new long[100];
		long[] B = new long[100];
		
		A[0] = 1;
		B[0] = 1;
		
		for (int i = 1; i < B.length; i++) {
			B[i] = A[i-1];
			A[i] = B[i] + B[i-1];
		}
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int K = sc.nextInt();
			System.out.println("#"+i+" "+A[K]+ " "+ B[K]);
			
		}

	}

}
