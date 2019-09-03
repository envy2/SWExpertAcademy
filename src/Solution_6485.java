import java.util.Scanner;

public class Solution_6485 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int[] busstop = new int[5001];
			int N = sc.nextInt();
			for (int j = 0; j < N; j++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				
				for (int k = s; k <= e; k++) {
					busstop[k]++;
				}
			}
			int P = sc.nextInt();
			System.out.print("#"+i);
			
			for (int j = 0; j < P; j++) {
				System.out.print(" "+busstop[sc.nextInt()]);
			}
			System.out.println();
		}

	}

}
