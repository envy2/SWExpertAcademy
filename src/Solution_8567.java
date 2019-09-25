import java.util.Scanner;

public class Solution_8567 {
	static int[] maxnum, factor;
	public static void init() {
		maxnum = new int[100001];
		factor = new int[100001];
		
		for (int i = 1; i <= 100000; i++) {
			for (int j = 1; j <= 100000 / i; j++) {
				factor[i*j]++;
			}
		}
		for (int i = 1; i < factor.length; i++) {
			if(factor[i] >= factor[i-1]) {
				maxnum[i] = i;
			}
			else {
				factor[i] = factor[i-1];
				maxnum[i] = maxnum[i-1];
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		init();
		
		for(int i = 1 ; i <= iT ;i++) {
			int N = sc.nextInt();
			System.out.println("#"+i+" "+maxnum[N]);
		}

	}
}
