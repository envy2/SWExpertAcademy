import java.util.Scanner;

public class Solution_8744 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ;i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for(int m = 0 ; m < M ; m++) {
				sc.nextInt();
				sc.nextInt();
			}
			
			int result = (N * (N-1) / 2) - M;
			int min = ( (N-1) / 2 ) * ( (N+1) / 2 );
			if(N % 2 == 1) {
				min -= 1;
			}
			result -= min;
			System.out.println("#"+i+" "+result);
		}

	}

}
