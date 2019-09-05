import java.util.Scanner;

public class Solution_8457 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			
			int B = sc.nextInt();
			int E = sc.nextInt();
			
			int result = 0;
			
			for (int j = 0; j < N; j++) {
				int clock = sc.nextInt();
				int count = 0;
				while(true) {
					count++;
					if(clock * count > B+E) {
						break;
					}
					if( clock * count >= B-E && clock * count <= B+E ) {
						result++;
						break;
					}
				}
			}
			System.out.println("#"+i+" "+result);
			
			
		}
	}

}
