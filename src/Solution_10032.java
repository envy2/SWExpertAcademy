import java.util.Scanner;

public class Solution_10032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			if(N % K == 0) {
				System.out.println("#"+ t + " 0");
			}
			else {
				System.out.println("#"+ t + " 1");
			}
		}
	}

}
