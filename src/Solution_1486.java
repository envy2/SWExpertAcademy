import java.util.Scanner;

public class Solution_1486 {
	static boolean[] use;
	static int[] height;
	static int rule,min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i <= iT ; i++) {
			int N = sc.nextInt();
			rule = sc.nextInt();
			min = Integer.MAX_VALUE;
			height = new int[N];
			use = new boolean[N];
			
			for (int j = 0; j < height.length; j++) {
				height[j] = sc.nextInt();
			}
			
			powerSet(0,use);
			System.out.printf("#%d %d\n",i,min);
		}
	}
	public static void powerSet(int depth,boolean[] use) {
		if(depth == use.length) {
			int sum = 0;
			for (int i = 0; i < use.length; i++) {
				if(use[i]) {
					sum += height[i];
				}
			}
			if(sum >= rule) {
				min = min < sum-rule ? min : sum-rule;
			}
			return;
		}

		use[depth] = true;
		powerSet(depth+1,use);
		use[depth] = false;
		powerSet(depth+1,use);
	}
	
}
