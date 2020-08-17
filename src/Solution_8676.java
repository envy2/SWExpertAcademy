import java.util.Arrays;
import java.util.Scanner;

public class Solution_8676 {

	static String T = " SAMSUNG";
	static String S;
	static int MOD = 1000000007;
	static int[][] dp;
	
	public static void init(Scanner sc) {
		S = " " + sc.next();
		dp = new int[8][S.length()];
		
		Arrays.fill(dp[0], 1);
	}
	
	public static int solution() {
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(T.charAt(i) == S.charAt(j)) {
					dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
				}
				else {
					dp[i][j] = dp[i][j-1] % MOD ;
				}
			}
		}
		
		return dp[T.length() - 1][S.length() - 1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc ; t++) {
			init(sc);
			int result = solution();
			System.out.println("#" + t + " " + result);
		}

	}

}
