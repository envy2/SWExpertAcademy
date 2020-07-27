import java.util.Scanner;

public class Solution_10200 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1 ; t <= tc ; t++) {
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int max = Math.min(A, B);
			int min = A + B - N > 0 ? A + B - N : 0;
			System.out.println("#"+ t + " " + max + " " + min);
		}
	}

}
