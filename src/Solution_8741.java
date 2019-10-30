import java.util.Scanner;

public class Solution_8741 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ;i++) {
			String result = "";
			String word;
			for (int w = 0; w < 3; w++) {
				word = sc.next();
				result += (char)(word.charAt(0) - 32);
			}
			System.out.println("#"+i+" "+result);
		}

	}

}
