import java.util.Arrays;
import java.util.Scanner;

public class Solution_5213 {
	static long[] p = new long[1000001];
	static long[] Di = new long[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		Di();
		SumDi();
		for(int i = 1; i <= iT; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long res = 0;
			res = Di[b] - Di[a-1];
			System.out.printf("#%d %d\n",i,res);
		}

	}
	public static void Di() {
		for (int i = 1; i < p.length; i+=2) {
			for (int j = 1; j*i < p.length; j++) {
				p[i*j] += i;
			}
		}
	}
	public static void SumDi() {
		for (int i = 1; i < p.length; i++) {
			Di[i] = Di[i-1] + p[i];
		}
	}
}
