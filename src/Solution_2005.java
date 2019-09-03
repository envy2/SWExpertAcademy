import java.util.Scanner;

public class Solution_2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = sc.nextInt();
		
		for (int i = 0; i < tcase; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N+1];
			
			System.out.printf("#%d\n",i+1);
			
			arr[0][1] = 1;
			
			for (int x = 1; x < arr.length; x++) {
				for (int y = 1; y < arr[0].length; y++) {
					arr[x][y] = arr[x-1][y-1] + arr[x-1][y];
				}
			}
			
			print(arr);
			
			
			
		}
	}
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] != 0) {
					System.out.printf("%d ",arr[i][j]);
				}
			}
			System.out.println();
		}
	}

}
