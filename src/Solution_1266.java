import java.util.Scanner;

public class Solution_1266 {
	static int[] prime = {2,3,5,7,11,13,17};
	static long[] factorial = new long[19];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		Factorial();
		for (int i = 1; i <= iT; i++) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double suma = 0;
			double sumb = 0;
			
			for (int j = 0; j < prime.length; j++) {
				suma += nCr(18,prime[j]) * (Math.pow(a/100, prime[j]) * Math.pow((100-a)/100, 18-prime[j]));
				sumb += nCr(18,prime[j]) * (Math.pow(b/100, prime[j]) * Math.pow((100-b)/100, 18-prime[j]));
				
			}
			double sum = suma + sumb -(suma*sumb);
			
			System.out.printf("#%d %.6f",i,sum);
		}

	}

	public static void Factorial() {
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = factorial[i-1] * i;
		}
	}
	
	public static long nCr(int n,int r) {
		long res = 0L;
		res = factorial[n] / (factorial[n-r] * factorial[r]);
		return res;
	}
}
