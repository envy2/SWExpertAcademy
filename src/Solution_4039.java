import java.util.Scanner;

public class Solution_4039 {
	static int result, L;
	static String str;
	static int prime = 10000007;
	static int d = 257;
	static int[] pow = new int[200000];
	static int[] hash_table = new int[10000007];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		init();
		for(int i = 1 ; i<= iT ;i++) {
			L = sc.nextInt();
			str = sc.next();
			result = 0;
			
			binary(0,L-1);
			System.out.println("#"+i+" "+result);
		}
	}
	public static void init() {
		pow[0] = 1;
		for (int i = 1; i < pow.length; i++) {
			pow[i] = pow[i-1] * d;
			pow[i] %= prime;
		}
	}
	public static int first(String s) {
		int l = 0;
		for (int i = 0; i < s.length(); i++) {
			l += s.charAt(i) * pow[s.length()-i-1]; 
			l %= prime;
		}
		return l;
	}
	public static void binary(int left, int right) {
		if(left == right) {
			result = left;
			return;
		}
		int mid = (left + right) / 2 + 1;
		boolean check = false;
		
		for (int i = 0; i < hash_table.length; i++) {
			hash_table[i] = 0;
		}
		int hash = first(str.substring(0,mid));
		hash_table[hash]++;
		
		for (int i = 1; i < str.length() - mid + 1; i++) {
			hash = (hash * d) + str.charAt(i-1+mid);
			hash %= prime;
			hash = hash - (str.charAt(i-1) * pow[mid]);
			if(hash < 0) {
				hash %= prime;
				hash += prime;
			}
			else {
				hash %= prime;
			}
			hash_table[hash]++;
			if(hash_table[hash] > 1) {
				check = true;
				break;
			}
		}

		
		if(check) {
			binary(mid, right);
		}
		else {
			binary(left, mid-1);
		}
	}
}
