import java.util.Scanner;

public class Solution_8840 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			long L = sc.nextLong()/2;
			long result = L * L;
			System.out.println("#"+i+" "+result);
		}

	}

}
