import java.util.Scanner;

public class Solution_4796 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i<= iT ;i++) {
			int N = sc.nextInt();
			int[] DP = new int[N];
			int[] M = new int[N];
			int res = 0;
			
			for (int j = 0; j < N; j++) {
				M[j] = sc.nextInt();
			}
			
			int max = 0;
			for (int j = 1; j < M.length; j++) {
				if(M[j-1] < M[j]) {
					DP[j] = DP[j-1] + 1;
					max = DP[j];
				}
				else {
					res += max;
				}
			}
			System.out.printf("#%d %d\n",i,res);
		}

	}

}
