import java.util.Scanner;

public class Solution_6960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i=1 ; i<=iT ; i++) {
			int N = sc.nextInt();
			int[] solve = new int[N];
			int[] time = new int[N];
			int count = 0;
			
			for (int j = 0; j < N; j++) {
				int S = sc.nextInt();
				int F = sc.nextInt();
				if(S <= F) {
					solve[j] = S;
					time[j] = F;
				}
			}
			int mintime = Integer.MAX_VALUE;
			int mint = 0;
			int minsolve = Integer.MAX_VALUE;
			int mins = 0;
			
			
		}	
	}
	public static void solving(int s,int[] time) {
		for (int i = 0; i < time.length; i++) {
			time[i] -= s;
		}
	}
}
