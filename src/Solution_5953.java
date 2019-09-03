import java.util.Scanner;

public class Solution_5953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i<= iT ; i++) {
			String s = sc.next();
			int cnt = 0;
			System.out.println(Sum(s));
		}
		
	}
	public static long Sum(String s) { // 합이 17인 경우 16 까지의 모든 경우를 다 계산.
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		long result = 0L;
		for (int i = 0; i < sum; i++) {
			int a = i / 10;
			if( a > 0) {
				result += nHr(s.length(),i) - (nHr(s.length(),i-10) * nCr(s.length(),a)); //식이 틀림 합이 27이상일 경우 좀더 생각해봐야할듯
			}
			else {
				result += nHr(s.length(),i);
			}
		}
		return result;
	}
	public static long nHr(int n, int r) {
		return nCr(n+r-1,r);
	}
	public static long nCr(int n, int r) {
		long number = 1L;
		
		if(n < r*2) {
			for (int i = 0; i < n - r; i++) {
				number *= n-i;
				number /= i+1;
			}
		}
		else {
			for (int i = 0; i < r; i++) {
				number *= n-i;
				number /= i+1;
			}
		}
		return number;
	}
}
