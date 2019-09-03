import java.util.Scanner;

public class Solution_7965 {
	static int prime = 1000000007;
	static long[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		int[] N = new int[iT+1];
		int max = 0;
		for(int i = 1; i<= iT ; i++) {
			N[i] = sc.nextInt();
			max = max > N[i] ? max : N[i];
		}
		res = new long[max+1];
		for (int i = 1; i <= max; i++) {
			res[i] += (res[i-1] + pow(i,i)) % prime;
		}
		
		for (int i = 1; i < N.length; i++) {
			System.out.println("#"+i+" "+res[N[i]]);
		}

	}
	public static long pow(long x, long y) {
		long cnt = 1L;
		x %= prime;
		
		while(y > 0) {
			if( y % 2 == 1 ) {
				cnt = (cnt * x) % prime;
			}
			y = y >> 1;
			x = (x * x) % prime;
		}
		return cnt;
	}
}
