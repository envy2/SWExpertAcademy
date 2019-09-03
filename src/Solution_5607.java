import java.util.Scanner;

public class Solution_5607 {
	static int prime = 1234567891;
	static long[] factorial = new long[1000001];
	public static void main(String[] args) {

		Factorial();
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 0; i < iT; i++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			
			long re = nCr(n,r);
			
			if ( re < 0) {
				re += prime;
			}
			System.out.printf("#%d %d\n",i+1,re);
		}
	}
	public static long nCr(int n, int r) {
		long result = 0L;
		result = factorial[n] * Math_pow(factorial[n-r],prime-2) % prime * Math_pow(factorial[r],prime-2) % prime;
		return result % prime;
	}

	public static long Math_pow(long x,long y) {
		long cnt = 1L; 
	      
        x = x % prime;
              
        while (y > 0) {    
            if (y % 2 == 1) {
            	cnt = (cnt * x) % prime; 
            }
            y = y >> 1; 
            x = (x * x) % prime; 
        } 
        return cnt % prime;
	}
	
	public static void Factorial() {
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = factorial[i-1] * i % prime;
		}
	}
}
