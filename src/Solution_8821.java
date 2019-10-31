import java.util.Scanner;

public class Solution_8821 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT; i++) {
			String input = sc.next();
			int[] number = new int[10];
			int result = 0;
			for (int s = 0; s < input.length(); s++) {
				number[input.charAt(s) - '0']++;
			}
			for (int n = 0; n < number.length; n++) {
				if(number[n] % 2 == 1) {
					result++;
				}
			}
			System.out.println("#"+i+" "+result);
		}

	}

}
