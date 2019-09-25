import java.util.Scanner;

public class Solution_4038 {
	static long[] d = new long[100001];
	static long prime = 2147483647L;
	static int p = 257;
	
	public static void pretreatment() {
		d[0] = 1;
		for (int i = 1; i < d.length; i++) {
			d[i] = d[i-1] * p % prime;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = Integer.parseInt(sc.next());
		
		pretreatment();
		for(int i = 1 ; i <= iT ;i++) {
			String book = sc.next();
			String keyword = sc.next();
			
			long key_hash = 0L;
			long book_hash = 0L;

			for (int k = 0; k < keyword.length(); k++) {
				key_hash += keyword.charAt(k) * d[keyword.length() - k - 1];
			}
			key_hash %= prime;
			
			int cnt = 0;
			for (cnt = 0;  cnt < keyword.length(); cnt++) {
				book_hash += book.charAt(cnt) * d[keyword.length() - cnt - 1];
			}
			book_hash %= prime;
			
			int result = 0;
			if(book_hash == key_hash) {
				result++;
			}
			while(cnt < book.length()) {
				book_hash = (book_hash * p) + book.charAt(cnt);
				book_hash %= prime;
				book_hash = book_hash - (book.charAt(cnt - keyword.length()) * d[keyword.length()]);
				if(book_hash < 0) {
					book_hash %= prime;
					book_hash += prime;
				}
				else {
					book_hash %= prime;
				}
				if(book_hash == key_hash) {
					result++;
				}
				cnt++;
				
			}
			System.out.println("#"+i+" "+result);
			
		}
		sc.close();
	}

	
}
