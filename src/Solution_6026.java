import java.util.Scanner;

public class Solution_6026 {
	static long prime = 1000000007;
	static long[] factorial = new long[101];
	
	public static void main(String[] args) {
		Factorial();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (long i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int count = 0;
			long number = 0L;
			long under = m;
			for (long j = 0; j < m; j++) {
				if(count % 2 == 0) {
					number += (Math_pow(under--, n) * nCr(m,count++)) % prime;
				}
				else {
					number -= (Math_pow(under--, n) * nCr(m,count++)) % prime;
				}
			}
			
			long result = number%prime;
			
			if(result < 0) {
				result += prime;
			}
			
			System.out.print("#"+(i+1)+" "+(result)+"\n");
		}
		

	}

	public static long nCr(int n, int r) {
		long num = 0L;
		long up = factorial[n];
		long down = factorial[r];
		long down2 = factorial[n-r];
 
		num = (up * Math_pow(down,prime-2)) % prime * Math_pow(down2,prime-2) % prime;
		
		return num % prime;
	}
	public static void Factorial() {
		factorial[0] = 1L;
		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = factorial[i-1] * i % prime;
		}
		
	}
	
	
	public static long Math_pow(long front,long back) {
		long res = 1L; 
	      
        front = front % prime;
              
        while (back > 0) {    
            if (back % 2 == 1) 
                res = (res * front) % prime; 
            back = back >> 1; 
            front = (front * front) % prime; 
        } 
        return res% prime;
	}
}
