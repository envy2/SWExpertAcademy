import java.util.Scanner;

public class Solution_3954 {
	static long[] sum = new long[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		setting();
		
		for(int i = 1 ; i<= iT ;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("#"+i+" "+(sum[b] - sum[a-1]));
		}
		sc.close();

	}
	public static void setting() {
		int[] phi = new int[1000001];
		boolean[] visit = new boolean[1000001];
		for (int i = 0; i < phi.length; i++) {
			phi[i] = i;
		}
		
		for (int i = 2; i < phi.length; i++) {
			if(visit[i]) {
				continue;
			}
			for (int j = i; j < phi.length; j+=i) {
				phi[j] = phi[j] / i * (i-1);
				visit[j] = true;
			}
		}
		
		for (int i = 1; i < phi.length; i++) {
			sum[i] = sum[i-1] + phi[i];
		}
	}
}
