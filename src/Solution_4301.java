import java.util.Arrays;
import java.util.Scanner;

public class Solution_4301 {
	static int[][] maps;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ;i <= iT ; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			maps = new int[M][N];
			result = 0;
			Plant();
			System.out.println("#"+i+" "+result);
		}
	}
	public static void Plant() {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				maps[i][j] = 1;
				result++;
				if(check(i,j)) {
					maps[i][j] = 0;
					result--;
				}
			}
		}
	}
	public static boolean check(int x,int y) {
		if(y-2 >= 0 && maps[x][y-2] == 1) {
			return true;
		}
		if(x-2 >= 0 && maps[x-2][y] == 1) {
			return true;
		}
		return false;
	}
}
