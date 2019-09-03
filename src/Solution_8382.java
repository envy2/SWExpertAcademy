import java.util.Scanner;

public class Solution_8382 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int x = Math.abs(x1 - x2);
			int y = Math.abs(y1 - y2);
			int cnt = 0;
			int result = 0;
			if(x > y) {
				cnt = x - y;
				if(cnt % 2 == 1) {
					result += y * 2;
					result += (cnt - 1) * 2 + 1;
				}
				else {
					result += x * 2;
				}
			}
			else {
				cnt = y - x;
				if(cnt % 2 == 1) {
					result += x * 2;
					result += (cnt - 1) * 2 + 1;
				}
				else {
					result += y * 2;
				}
			}
			
			System.out.println("#"+i+" "+result);
		}
	}
}
