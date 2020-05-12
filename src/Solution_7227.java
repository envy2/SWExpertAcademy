import java.util.Scanner;

public class Solution_7227 {
	static int[][] worm;
	static boolean[] visit;
	static long result;
	
	public static void init(Scanner sc) {
		int N = sc.nextInt();
		worm = new int[N][2];
		visit = new boolean[N];
		result = Long.MAX_VALUE;
		
		for (int i = 0; i < worm.length; i++) {
			worm[i][0] = sc.nextInt();
			worm[i][1] = sc.nextInt();
		}
		
	}
	
	public static void DFS(int depth, int select) {
		if(depth == worm.length / 2) {
			Matching();
			return;
		}
		
		for (int i = select; i < visit.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				DFS(depth+1, i+1);
				visit[i] = false;
			}
		}
	}
	
	public static void Matching() {
		long x = 0;
		long y = 0;
		
		for (int i = 0; i < visit.length; i++) {
			if(visit[i]) {
				x += worm[i][0];
				y += worm[i][1];
			}
			else {
				x -= worm[i][0];
				y -= worm[i][1];
			}
		}
		
		result = Math.min(result, x*x + y*y);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			DFS(0,0);
			
			System.out.println("#"+ t + " " + result);
		}

	}

}
