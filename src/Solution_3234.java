import java.util.Scanner;

public class Solution_3234 {
	static int[] weight;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int N = sc.nextInt();
			weight = new int[N];
			result = 0;
			for (int j = 0; j < weight.length; j++) {
				weight[j] = sc.nextInt();
			}
			mix(0);
			System.out.println("#"+i+" "+result);
		}

	}
	public static void swap(int a, int b) {
		int t = weight[a];
		weight[a] = weight[b];
		weight[b] = t;
	}
	public static void mix(int depth) {
		if(depth == weight.length) {
			dfs(0,0,0);
			return;
		}
		for (int i = depth; i < weight.length; i++) {
			swap(i,depth);
			mix(depth+1);
			swap(i,depth);
		}
	}
	public static void dfs(int l, int r, int depth) {
		if(check(l,r)) {
			return;
		}
		if(depth == weight.length) {
			result++;
			return;
		}
		
		dfs(l + weight[depth],r,depth+1);
		dfs(l,r + weight[depth],depth+1);
			
	}
	public static boolean check(int l, int r) {
		if(l < r) {
			return true;
		}
		return false;
	}
}
