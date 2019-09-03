import java.util.Scanner;

public class Solution_4014 {
	static int[][] maps;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			
			count = 0;
			maps = new int[N][N];
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps.length; y++) {
					maps[x][y] = sc.nextInt();
				}
			}
			col(X);
		
		}

	}
	public static void col(int road) {
		for (int x = 0; x < maps.length; x++) {
			for (int y = 1; y < maps.length; y++) {
				if(maps[x][y-1] == maps[x][y]) {
					continue;
				}
				else if(maps[x][y] + 1 == maps[x][y-1]) {
					
				}
				else {
					
				}
			}
		}
	}
	
}
