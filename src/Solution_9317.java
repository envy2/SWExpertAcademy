import java.util.Scanner;

public class Solution_9317 {
	
	public static int solve(Scanner sc) {
		int N = sc.nextInt();
		
		char[] workbook = sc.next().toCharArray();
		char[] sukchan = sc.next().toCharArray();
		
		int result = 0;

		for (int i = 0; i < N; i++) {
			if(workbook[i] == sukchan[i]) {
				result++;
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int result = solve(sc);
			System.out.println("#"+t+" "+result);
		}
	}
	
}
