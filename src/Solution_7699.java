import java.util.Arrays;
import java.util.Scanner;

public class Solution_7699 {
	static char[][] maps;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC; tc++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			sc.nextLine();
			
			maps = new char[R][C];
			for (int i = 0; i < maps.length; i++) {
				maps[i] = sc.nextLine().toCharArray();
			}
			result = 0;
			dfs(maps[0][0]+"",0,0);
			
			System.out.println("#"+ tc + " "+result);
		}

	}
	public static void dfs(String load,int x,int y) {
		result = result > load.length() ? result : load.length();
		
		for (int i = 0; i < dx.length; i++) {
			if(!over(x +dx[i],y +dy[i]) && load.indexOf(maps[x+dx[i]][y+dy[i]]+"") == -1) {
				dfs(load + maps[x+dx[i]][y+dy[i]], x + dx[i], y + dy[i]);
			}
		}
	}
	public static boolean over(int x, int y) {
		if(x >= maps.length || x < 0 || y >= maps[0].length || y < 0) {
			return true;
		}
		return false;
	}
}
