import java.util.Arrays;
import java.util.Scanner;

public class Solution_4408 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int[] room = new int[402];
			for (int j = 0; j < N; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a > b) {
					int t = a;
					a = b;
					b = t;
				}
				if(a % 2 == 0 && b % 2 == 0) {
					for (int j2 = a-1; j2 <= b; j2++) {
						room[j2]++;
					}
				}
				if(a % 2 == 1 && b % 2 == 0) {
					for (int j2 = a; j2 <= b; j2++) {
						room[j2]++;
					}
				}
				if(a % 2 == 0 && b % 2 == 1) {
					for (int j2 = a-1; j2 <= b+1; j2++) {
						room[j2]++;
					}
				}
				if(a % 2 == 1 && b % 2 == 1) {
					for (int j2 = a; j2 <= b+1; j2++) {
						room[j2]++;
					}
				}
				
				
			}
			Arrays.sort(room);
			System.out.printf("#%d %d\n",i,room[401]);
		}
		
	}

}