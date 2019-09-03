import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249 {
	static Point[][] point;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= iT ;i++) {
			N = Integer.parseInt(br.readLine());
			point = new Point[N][N];
			
			for (int j = 0; j < point.length; j++) {
				String str = br.readLine();
				for (int j2 = 0; j2 < point.length; j2++) {
					point[j][j2] = new Point(j,j2,str.charAt(j2) - '0');
				}
			}
			
			BFS();
		}

	}
	public static void BFS() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		q.add(point[0][0]);
		while(!q.isEmpty()) {
			Point a = q.poll();
			visit[a.x][a.y] = true;
			
			
		}
	}
}
class Point{
	int x,y;
	int time;
	public Point(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.time = t;
	}
}