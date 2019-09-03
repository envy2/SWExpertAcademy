import java.util.Arrays;
import java.util.Scanner;

public class Solution_3812 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (long i = 1; i <= iT; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			N = sc.nextInt();
			long[] res = new long[N];
			long[] result = new long[N];
			
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < y; k++) {
					res[((Math.abs(j-a)%N) + (Math.abs(k-b)%N)) % N]++;
				}
			}
			int up = z-c-1;
			int down = c;
			for (int k = 0; k < result.length; k++) {
				result[k] += down / N;
				result[k] += up / N;
			}
			down %= N;
			up %= N;
			
			for (int k = 0; k < result.length; k++) {
                result[k] += res[k];
                for (int j = 0; j < up; j++) {
                    result[k] += res[mod(k-1)];
                }
                for (int j = 0; j < down; j++) {
                    result[k] += res[mod(k-1)];
                }
            }
			//result[k] += res[k];
			System.out.print("#" + i +" ");
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[j]+" ");
			}
			System.out.println();
		}

	}
	public static int mod(int m) {
		if(N == 1) {
			return 0;
		}
		if(m < 0) {
			return (m % N) + N;
		}
		else {
			return m % N;
		}
	}
}
