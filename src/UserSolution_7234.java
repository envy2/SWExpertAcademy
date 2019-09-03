import java.util.Scanner;

public class UserSolution_7234 {
	static int[] x = {0,0,-1,1};
	static int[] y = {-1,1,0,0};
	static int[] x2 = {0,0,-2,2};
	static int[] y2 = {-2,2,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			int N = sc.nextInt();
			int safety = sc.nextInt();
			
			int[][] maps = new int[N][N];
			int res = 0;
			
			for (int j = 0; j < safety; j++) {
				int basex = sc.nextInt() - 1;
				int basey = sc.nextInt() - 1;
				maps[basex][basey]++;
			
				for (int k2 = 0; k2 < 4; k2++) {
					try {
					maps[basex+x[k2]][basey+y[k2]]++;
					}
					catch(Exception e) {}
				}
				for (int k2 = 0; k2 < 4; k2++) {
					try {
					maps[basex+x2[k2]][basey+y2[k2]]++;
					}
					catch(Exception e) {}
				}
			}
			
			for (int j = 0; j < maps.length; j++) {
				for (int j2 = 0; j2 < maps.length; j2++) {
					res = res > maps[j][j2] ? res : maps[j][j2];
				}
			}
			System.out.printf("#%d %d\n",i,res);
		}
	}
}
