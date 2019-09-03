import java.util.Scanner;

public class Solution_5684 {
	static int sum,cnt;
	static int[][] range;
	static boolean check;
	static StringBuilder str = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 0; i < iT; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			range = new int[N+1][N+1];
			for (int j = 0; j < M; j++) {
				range[sc.nextInt()][sc.nextInt()] = sc.nextInt();
			}
		}
		
	}
}
