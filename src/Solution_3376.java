import java.util.Scanner;

public class Solution_3376 {
	static long[] p = new long[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		padoban();
		for (int i = 1; i <= iT; i++) {
			System.out.printf("#%d %d\n",i,p[sc.nextInt()-1]);
		}

	}
	public static void padoban() {
		p[0] = 1;
		p[1] = 1;
		p[2] = 1;
		p[3] = 2;
		p[4] = 2;
		
		for (int i = 5; i < p.length; i++) {
			p[i] = p[i-1] + p[i-5];
		}
	}
}
