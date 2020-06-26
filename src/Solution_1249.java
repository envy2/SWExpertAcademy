import java.util.Scanner;

public class Solution_1249 {
	static int[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static char[][] map;
	static int minCost;
	
	public static void init(Scanner sc) {
		int N = sc.nextInt();
		map = new char[N][N];
		visit = new int[N][N];
		minCost = Integer.MAX_VALUE;
		
		for (int x = 0; x < map.length; x++) {
			map[x] = sc.next().toCharArray();
		}
		
		for (int x = 0; x < visit.length; x++) {
			for (int y = 0; y < visit[0].length; y++) {
				visit[x][y] = Integer.MAX_VALUE;
			}
		}
		
	}
	
	public static void DFS(int x, int y, int cost) {
		if(x == map.length - 1 && y == map[0].length - 1) {
			minCost = Math.min(minCost, cost);
			return;
		}
		
		if(visit[x][y] < cost || minCost < cost) {
			return;
		}
		
		visit[x][y] = cost;
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(Over(nx, ny)) {
				continue;
			}
			else {
				if(cost + (map[nx][ny] - '0') < visit[nx][ny]) {
					DFS(nx, ny, cost + (map[nx][ny] - '0'));
				}
			}
		}
	}
	
	public static boolean Over(int x, int y) {
		if(x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			DFS(0,0,0);
			
			System.out.println("#" + t + " " + minCost);
		}
		
	}
}
