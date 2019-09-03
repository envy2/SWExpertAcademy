import java.util.Scanner;

public class Solution_3752 {
	static boolean[] use;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i<= iT;i++) {
			int N = sc.nextInt();
			arr = new int[N+1];
			
			int sum = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			use = new boolean[sum+1];
			use[0] = true;
			int res = 0;
			
			for (int x = 0; x < arr.length; x++) {
				for (int y = sum; y >= 0; y--) {
					if(!use[y] && y >= arr[x]) {
						use[y] = use[y-arr[x]];
					}
				}
			}
			for(boolean a : use) {
				if(a) {
					res++;
				}
			}
			System.out.printf("#%d %d\n",i,res);
		}
	}
	
}
