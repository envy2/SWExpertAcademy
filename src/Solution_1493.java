import java.util.Scanner;

public class Solution_1493 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int[] pxy = board(p);
			int[] qxy = board(q);
			int sumx = pxy[0] + qxy[0];
			int sumy = pxy[1] + qxy[1];
			
			System.out.printf("#%d %d\n",i+1,board(sumx,sumy));
			
			
		}

	}
	public static int board(int x , int y) {
		int number = (x*(x+1)/2) + (x*(y-1)) + ((y-2)*(y-1)/2) ; 
		return number;
	}

	public static int[] board(int p) {
		int[] x = new int[2];
		
		for (int i = 1; i < 10000; i++) {
			for (int j = 1; j < 10000; j++) {
				if(board(i,j) ==p) {
					x[0] = i;
					x[1] = j;
					return x;
				}
			}
		}
		
		return x;
	}
}
