import java.util.Scanner;

public class Solution_8840 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int L = sc.nextInt();
			System.out.println("#"+i+" "+(long)Math.pow(L/2, 2));
		}

	}

}
