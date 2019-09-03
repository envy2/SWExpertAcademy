import java.util.Scanner;

public class Solution_1219 {
	static boolean[][] maps;
	static boolean res;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int iT = sc.nextInt();
			int len = sc.nextInt();
			maps = new boolean[100][100];
			res = false;
			for (int j = 0; j < len; j++) {
				maps[sc.nextInt()][sc.nextInt()] = true;
			}
			
			dfs(0);
			if(res) {
				System.out.println("#"+iT+" 1");
			}
			else {
				System.out.println("#"+iT+" 0");
			}
		}

	}
	public static void dfs(int a) {
		if(a == 99) {
			res = true;
			return;
		}
		for (int i = 0; i < maps.length; i++) {
			if(maps[a][i]) {
				dfs(i);
			}
			
		}
	}
}
