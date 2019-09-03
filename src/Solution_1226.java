import java.util.Arrays;
import java.util.Scanner;

public class Solution_1226 {
	static int[][] maze = new int[16][16];
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			int iT = Integer.parseInt(sc.nextLine());
			int startx = 0;
			int starty = 0;
			
			for (int x = 0; x < 16; x++) {
				String str = sc.nextLine();
				for (int y = 0; y < 16; y++) {
					maze[x][y] = str.charAt(y) - '0';
					if(maze[x][y]==2) {
						startx = x;
						starty = y;
						maze[x][y] = 0;
					}
				}
			}
			result = 0;
			dfs(startx,starty);
			System.out.println("#"+iT+" "+result);
		}
	}
	public static void dfs(int x ,int y) {
		if(maze[x][y] == 3) {
			result = 1;
		}
		if(maze[x][y] == 0) {
			maze[x][y] = 1;
			if(maze[x+1][y] == 0 || maze[x+1][y] == 3) {
				dfs(x+1,y);
			}
			if(maze[x][y+1] == 0 || maze[x][y+1] == 3) {
				dfs(x,y+1);
			}
			if(maze[x][y-1] == 0 || maze[x][y-1] == 3) {
				dfs(x,y-1);
			}
			if(maze[x-1][y] == 0 || maze[x-1][y] == 3) {
				dfs(x-1,y);
			}
			
			maze[x][y] = 0;
		}
		
		
	}
}
