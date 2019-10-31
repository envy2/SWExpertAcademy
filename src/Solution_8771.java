import java.util.Scanner;

public class Solution_8771 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			long result = 0L;
			if(A <= B) {
				result = B-A;
				result *= N-2;
				result += 1;
			}
			if(N == 1 && A < B) {
				result = 0;
			}
			System.out.println("#"+i+" "+result);
		}

	}

}
