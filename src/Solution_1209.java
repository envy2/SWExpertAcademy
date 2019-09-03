import java.util.Scanner;

public class Solution_1209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int x = 0 ;x< 10; x++) {
			int t = sc.nextInt();
			int max = 0 ;
			int[][] arr = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			for (int i = 0; i < arr.length; i++) {
				int sum1 = 0;
				int sum2 = 0;

				for (int j = 0; j < arr[0].length; j++) {
					sum1 += arr[i][j];
					sum2 += arr[j][i];
					
				}
				max = max > sum1 ? max : sum1;
				max = max > sum2 ? max : sum2;
			}
			int sum3 = 0;
			int sum4 = 0;
			for (int i = 0; i < arr.length; i++) {
				sum3 += arr[i][i];
				sum4 += arr[i][arr.length-i-1];
			}
			max = max > sum3 ? max : sum3;
			max = max > sum4 ? max : sum4;
			
			System.out.printf("#%d %d\n",t,max);
		}
	}
	
}
