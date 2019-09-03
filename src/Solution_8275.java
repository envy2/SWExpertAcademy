import java.util.Arrays;
import java.util.Scanner;

public class Solution_8275 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT; i++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int M = sc.nextInt();
			
			int[] prison = new int[N+1];
			Arrays.fill(prison, X);
			int[][] ham= new int[M][3];
			
			for (int x = 0; x < ham.length; x++) {
				for (int y = 0; y < ham[0].length; y++) {
					ham[x][y] = sc.nextInt();
				}
			}
			
			for (int p = 0; p < ham.length; p++) {
				
			}
		}
	}

}
