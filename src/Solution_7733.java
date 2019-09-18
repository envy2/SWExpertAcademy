import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7733 {
	static int[][] cheese;
	static int max,maxday;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void eat(int day) {
		boolean[][] visit = new boolean[cheese.length][cheese.length];
		
		for (int x = 0; x < cheese.length; x++) {
			for (int y = 0; y < cheese.length; y++) {
				if(cheese[x][y] <= day) {
					visit[x][y] = true;
				}
			}
		}
		
		chunk(visit);
	}
	public static void chunk(boolean[][] visit) {
		int chunkOfCheese = 0;
		for (int x = 0; x < visit.length; x++) {
			for (int y= 0; y < visit.length; y++) {
				if(!visit[x][y]) {
					chunkOfCheese++;
					visit[x][y] = true;
					deep(visit,x,y);
				}
			}
		}
		max = max > chunkOfCheese ? max : chunkOfCheese;
	}
	public static void deep(boolean[][] visit, int x, int y) {
		for (int d = 0; d < dx.length; d++) {
			if(!over(x+dx[d], y+dy[d]) && !visit[x+dx[d]][y+dy[d]]) {
				visit[x+dx[d]][y+dy[d]] = true;
				deep(visit,x+dx[d],y+dy[d]);
			}
		}
	}
	public static boolean over(int x, int y) {
		if(x < 0 || x >= cheese.length || y < 0 || y >= cheese.length) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ;i <= iT ; i++) {
			int N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			max = 1;
			maxday = 0;
			
			for (int x = 0; x < cheese.length; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int y = 0; y < cheese.length; y++) {
					cheese[x][y] = Integer.parseInt(st.nextToken());
					maxday = maxday > cheese[x][y] ? maxday : cheese[x][y];
				}
			}
			for (int e = 1; e < maxday; e++) {
				eat(e);
			}
			
			System.out.println("#"+i+ " "+ max);
		}
	}
}
