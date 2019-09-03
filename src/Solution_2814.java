import java.util.Scanner;

public class Solution_2814 {
	static boolean[][] line;
	static boolean[] visit;
	static int depth;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1;i <= iT ; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			line = new boolean[N+1][N+1];
			visit = new boolean[N+1];
			
			for (int j = 0; j < M; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				line[a][b] = line[b][a] = true;
			}
			
			dfs(1,1);
			System.out.printf("#%d %d\n",i,depth+1);
		}

	}

	public static void dfs(int i,int d) {
		visit[i] = true;
		
		for (int j = 1; j < line[0].length; j++) {
			if(line[i][j] && !visit[j]) {
				depth = d;
				dfs(j,d+1);
			}
		}
		
		
	}
}
