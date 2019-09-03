import java.util.Scanner;

public class Solution_6782 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			long n = sc.nextLong();
			long x = 0;
			long y = 0;
			int cnt = 0;
			while(n != 2) {
				x = (long)Math.sqrt(n);
				y = (long)Math.pow(x+1, 2);
				if(x == Math.sqrt(n)) { 
					cnt++;
					n = x;
				}
				else {
					cnt += y - n;
					n = y;
				}
			}
			System.out.printf("#%d %d\n",i,cnt);
		}

	}

}
