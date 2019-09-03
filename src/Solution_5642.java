import java.util.Scanner;

public class Solution_5642 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i<= iT ;i++) {
			int N = sc.nextInt();
			int[] save = new int[N+1];
			int[] DP = new int[N+1];
			
			for (int j = 1; j < save.length; j++) {
				save[j] = sc.nextInt();
			}
			
			for (int j = 1; j < DP.length; j++) {
				DP[j] = DP[j-1] + save[j];
			}
			
			int max = Integer.MIN_VALUE;
			int maxIndex = 0;
			for (int j = 1; j < DP.length; j++) {
				if(max < DP[j]) {
					max = DP[j];
					maxIndex = j;
				}
			}
			for (int j = maxIndex-1; j >= 1; j--) {
				if(DP[j] < 0){
					max -= DP[j];
					break;
				}
			}
			//1 2 -33 10 5 틀린코드
			System.out.printf("#%d %d\n",i,max);
		}

	}

}
