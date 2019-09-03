import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_7250 {
	static char[][] maps, copymaps;
	static Queue<Scott> q1;
	static Queue<Venom> q2;
	static Scott s;
	static Venom v;
	static boolean[][] visit1, visit2;
	static int res1,res2;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			K = sc.nextInt();
			
			maps = new char[N][M];
			copymaps = new char[N][M];
			visit1 = new boolean[N][M];
			visit2 = new boolean[N][M];
			res1 = Integer.MAX_VALUE;
			res2 = Integer.MAX_VALUE;
			for (int x = 0; x < maps.length; x++) {
				String str = sc.next();
				for (int y = 0; y < maps[0].length; y++) {
					char c = str.charAt(y);
					maps[x][y] = c;
					copymaps[x][y] = c;
					if(c == 'S') {
						s = new Scott(x, y, K, 0);
						maps[x][y] = 'A';
						copymaps[x][y] = 'A';
					}
					if(c == 'V') {
						v = new Venom(x, y, 0);
						maps[x][y] = 'A';
						copymaps[x][y] = 'A';
					}
				}
			}
			
			bfs1(); 
			bfs2();
			
			if(res1 < res2) {
				System.out.printf("#%d %d\n",i,res1);
			}
			else if(res1 == Integer.MAX_VALUE) {
				System.out.printf("#%d -1\n",i);
			}
			else {
				System.out.printf("#%d -1\n",i);
			}
		}
	}
	public static void bfs1() {
		q1 = new LinkedList<>();
		q1.add(s);
		visit1[s.x][s.y] = true;
		while(!q1.isEmpty()) {
			Scott start = q1.poll();
			if(maps[start.x][start.y] == 'W' ) {
				visit1[start.x][start.y] = false; 
			}
			if(maps[start.x][start.y] == 'E') {
				res1 = start.dis;
				break;
			}
			Moving1(start);
			
		}
	}
	
	public static void bfs2() {
		q2 = new LinkedList<>();
		q2.add(v);
		visit2[v.x][v.y] = true; 
		while(!q2.isEmpty()) {
			Venom start = q2.poll();
			if(maps[start.x][start.y] == 'E') {
				res2 = start.dis;
				break;
			}
			Moving2(start);
			
		}
	}
	public static void FireOn(int i) {
		for(int t = 0 ; t <= i ; t++) {
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps[0].length; y++) {
					if(maps[x][y] == 'F') {
						if(x - 1 >= 0 && maps[x-1][y] == 'A') {
							maps[x-1][y] = 'F';
						}
						if(x + 1 < maps.length && maps[x+1][y] == 'A') {
							maps[x+1][y] = 'F';
						}
						if(y - 1 >= 0 && maps[x][y-1] == 'A') {
							maps[x][y-1] = 'F';
						}
						if(y + 1 < maps.length && maps[x][y+1] == 'A') {
							maps[x][y+1] = 'F';
						}
					}
				}
			}
		}
	}
	public static void FireOff() {
		maps = copymaps;
	}
	public static void Moving1(Scott s) {
		FireOn(s.dis);
		if(s.x - 1 >= 0 && !visit1[s.x-1][s.y] && (maps[s.x-1][s.y] == 'A' || maps[s.x-1][s.y] == 'E')) {
			q1.add(new Scott(s.x-1,s.y,K,s.dis+1));
			visit1[s.x-1][s.y] = true;
		}
		if(s.x - 1 >= 0 && !visit1[s.x-1][s.y] && (maps[s.x-1][s.y] == 'W' && s.k > 0)) {
			q1.add(new Scott(s.x-1,s.y,s.k-1,s.dis+1));
			visit1[s.x-1][s.y] = true;
		}
		
		if(s.x + 1 < maps.length && !visit1[s.x+1][s.y] && (maps[s.x+1][s.y] == 'A' || maps[s.x+1][s.y] == 'E')) {
			q1.add(new Scott(s.x+1,s.y,K,s.dis+1));
			visit1[s.x+1][s.y] = true;
		}
		if(s.x + 1 < maps.length && !visit1[s.x+1][s.y] && (maps[s.x+1][s.y] == 'W' && s.k > 0)) {
			q1.add(new Scott(s.x+1,s.y,s.k-1,s.dis+1));
			visit1[s.x+1][s.y] = true;
		}
		
		if(s.y - 1 >= 0 && !visit1[s.x][s.y-1] && (maps[s.x][s.y-1] == 'A' || maps[s.x][s.y-1] == 'E')) {
			q1.add(new Scott(s.x,s.y-1,K,s.dis+1));
			visit1[s.x][s.y-1] = true;
		}
		if(s.y - 1 >= 0 && !visit1[s.x][s.y-1] && (maps[s.x][s.y-1] == 'W' && s.k > 0)) {
			q1.add(new Scott(s.x,s.y-1,s.k-1,s.dis+1));
			visit1[s.x][s.y-1] = true;
		}
		
		if(s.y + 1 < maps[0].length && !visit1[s.x][s.y+1] && (maps[s.x][s.y+1] == 'A' || maps[s.x][s.y+1] == 'E')) {
			q1.add(new Scott(s.x,s.y+1,K,s.dis+1));
			visit1[s.x][s.y+1] = true;
		}
		if(s.y + 1 < maps[0].length && !visit1[s.x][s.y+1] && (maps[s.x][s.y+1] == 'W' && s.k > 0)) {
			q1.add(new Scott(s.x,s.y+1,s.k-1,s.dis+1));
			visit1[s.x][s.y+1] = true;
		}
		FireOff();
	}
	
	public static void Moving2(Venom v) {
		if(v.x - 1 >= 0 && !visit2[v.x-1][v.y] && (maps[v.x-1][v.y] == 'A' || maps[v.x-1][v.y] == 'E' || maps[v.x-1][v.y] == 'F')) {
			q2.add(new Venom(v.x-1,v.y,v.dis+1));
			visit2[v.x-1][v.y] = true; 
		}
		if(v.x + 1 < maps.length && !visit2[v.x+1][v.y] && (maps[v.x+1][v.y] == 'A' || maps[v.x+1][v.y] == 'E' || maps[v.x+1][v.y] == 'F')) {
			q2.add(new Venom(v.x+1,v.y,v.dis+1));
			visit2[v.x+1][v.y] = true; 
		}
		if(v.y - 1 >= 0 && !visit2[v.x][v.y-1] && (maps[v.x][v.y-1] == 'A' || maps[v.x][v.y-1] == 'E' || maps[v.x][v.y-1] == 'F')) {
			q2.add(new Venom(v.x,v.y-1,v.dis+1));
			visit2[v.x][v.y-1] = true; 
		}
		if(v.y + 1 < maps[0].length && !visit2[v.x][v.y+1] && (maps[v.x][v.y+1] == 'A' || maps[v.x][v.y+1] == 'E' || maps[v.x][v.y+1] == 'F')) {
			q2.add(new Venom(v.x,v.y+1,v.dis+1));
			visit2[v.x][v.y+1] = true; 
		}
	}
	static class Scott{
		int x,y,k,dis;
		public Scott(int x, int y, int k , int d) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.dis = d;
		}
	}
	static class Venom{
		int x,y,dis;
		public Venom(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.dis = d;
		}
	}
}
