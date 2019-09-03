import java.util.Scanner;

public class Solution_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = Integer.parseInt(sc.nextLine());
		
		for(int i = 0 ;i<tcase ;i++) {
			int size = Integer.parseInt(sc.nextLine());
			int[][] farm = new int[size][size];
			
			for (int x = 0; x < farm.length; x++) {
				String str = sc.nextLine();
				for (int y = 0; y < farm[0].length; y++) {
					farm[x][y] = str.charAt(y) - '0';
				}
			}
			int value = 0;
			for (int x = 0; x < farm.length/2 +1; x++) {
				for (int y = farm.length/2 - x; y <= farm.length/2 +x; y++) {
					value += farm[x][y];
				}
			}
			for (int x = farm.length/2 + 1; x < farm.length; x++) {
				int a = farm.length - x - 1;
				for (int y = farm.length/2 - a; y <= farm.length/2 +a; y++) {
					value += farm[x][y];
				}
			}
			
			System.out.printf("#%d %d\n",i+1,value);
		}
	}

}
