import java.util.Scanner;
import java.util.Stack;

public class Solution_1865 {
	static double res,max;
	static int[][] maps;
	static boolean[] visit1,visit2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ; i <= iT ; i++) {
			int N = sc.nextInt();
			
			maps = new int[N][N];
			Stack<Integer> arr = new Stack<>();
			visit1 = new boolean[N];
			visit2 = new boolean[N];
			for (int j = 0; j < maps.length; j++) {
				for (int j2 = 0; j2 < maps[0].length; j2++) {
					maps[j][j2] = sc.nextInt();
				}
			}
			res = 0;
			max = 0;
			dfs(0,1);
			System.out.printf("#%d %.6f\n",i,res * 100);
		}

	}
	public static void dfs(int depth,double result) {
		if(depth == maps.length) {
			res = Math.max(result, res);
			max = res;
			return;
		}
		for (int i = depth; i < maps.length; i++) {
			for (int j = 0; j < maps.length; j++) {
				if(!visit1[i] && !visit2[j]) {
					if(maps[i][j] != 0) {
						if(max < result) {
							result *= (maps[i][j] * 0.01);
							visit1[i] = true;
							visit2[j] = true;
							dfs(depth+1,result);
							visit2[j] = false;
							visit1[i] = false;
							result /= (maps[i][j] * 0.01);	
						}
					}
				}
			}
			
		}
	}
	
}
