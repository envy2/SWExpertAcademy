import java.util.Scanner;

public class Solution_1952 {
	static int[] price = new int[4];
	static int[] month = new int[12];
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			for (int i = 0; i < price.length; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 0; i < month.length; i++) {
				month[i] = sc.nextInt();
			}
			
			min = Integer.MAX_VALUE;
			dfs(0,0);
			int year = 0;
			for (int i = 0; i < month.length; i++) {
				year += month[i];
			}
			if(year > 0) {
				min = min < price[3] ? min : price[3];
			}
			System.out.println("#"+tc+" "+min);
		}
	}
	public static void dfs(int sum, int depth) {
		if(depth > 12) {
			return;
		}
		if(depth == 12) {
			min = min < sum ? min : sum;
			return;
		}
		dfs(sum + (month[depth] * price[0]), depth+1);
		dfs(sum + price[1], depth+1);
		dfs(sum + price[2], depth+3);
		
	}
}
