import java.util.Scanner;

public class Solution_3993 {
	static long[][][] pole = new long[21][21][21];
	
	public static void init() {
		pole[1][1][1] = 1L;
		for (int i = 2; i < pole.length; i++) {
			for (int l = 1; l <= i; l++) {
				for (int r = 1; r <= i; r++) {
					pole[i][l][r] = pole[i-1][l-1][r] + pole[i-1][l][r-1] + (pole[i-1][l][r] * (i-2));
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		init();
		for(int i =1 ;i <= iT ;i++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int R = sc.nextInt();
			
			System.out.println("#"+i+" "+pole[N][L][R]);
		}
	}

}
