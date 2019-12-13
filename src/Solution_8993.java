import java.util.Scanner;

public class Solution_8993 {

	public static boolean collatz(Scanner sc) {
		long N = sc.nextLong();
		
		while(N > 1) {
			if(N % 2 == 0) {
				N /= 2;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for(int t = 1 ; t <= tc; t++) {
			if(collatz(sc)) {
				System.out.println("#"+t+" YES");
			}
			else {
				System.out.println("#"+t+" NO");
			}
		}
	}

}
