import java.util.Scanner;

public class Solution_2817 {
	static int K;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ;i <= iT ; i++) {
			int len = sc.nextInt();
			K = sc.nextInt();
			cnt = 0;
			int[] arr = new int[len];
			boolean[] use = new boolean[len];
			for (int j = 0; j < len; j++) {
				arr[j] = sc.nextInt();
			}
			dfs(arr,use,0);
			System.out.printf("#%d %d\n",i,cnt);
			
		}
		

	}
	public static void dfs(int[] arr, boolean[] use, int depth) {
		if(depth == use.length ) {
			int sum = 0;
			for (int i = 0; i < use.length; i++) {
				if(use[i]) {
					sum += arr[i];
				}
			}
			if(sum == K) {
				cnt++;
			}
			return;
		}
		
		
		use[depth] = true;
		dfs(arr,use,depth+1);
		use[depth] = false;
		dfs(arr,use,depth+1);
	}
}
