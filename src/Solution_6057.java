import java.util.Scanner;

public class Solution_6057 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean[][] edge = new boolean[n][n];
			
			for (int j = 0; j < m; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				edge[x-1][y-1] = true;
				edge[y-1][x-1] = true;
			}
			int triangle = 0;
			for (int a = 0; a < edge.length; a++) {
				for (int b = a+1; b < edge.length; b++) {
					for (int c = b+1; c < edge.length; c++) {
						if(edge[a][b] && edge[b][c] && edge[c][a]) {
							triangle++;
						}
					}
					
				}
			}
			System.out.printf("#%d %d\n",i+1,triangle);
			
		}

	}

}
