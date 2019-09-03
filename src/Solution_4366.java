import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4366 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			String A = sc.next();
			String B = sc.next();
			
			long res = 0;
			
			for (int j = 0; j < A.length(); j++) {
				for (int k = 0; k < B.length(); k++) {
					for (int l = 0; l < 2; l++) {
						if( Long.valueOf(Bchange(A,j),2) == Long.valueOf(Tchange(B,k,l),3)) {
							res = Long.valueOf(Bchange(A,j),2);
							break;
						}
					}
					if(res != 0) {
						break;
					}
				}
				if(res != 0) {
					break;
				}
			}
			System.out.println("#"+i+" "+res);
			
			
			
		}

	}
	public static String Bchange(String str,int i) {
		char[] c = str.toCharArray();
		if(c[i] == '1') {
			c[i] = '0';
		}
		else {
			c[i] = '1';
		}
		return C_S(c);
	}
	public static String Tchange(String str,int i,int k) {
		char[] c = str.toCharArray();
		if(c[i] == '0' && k == 0) {
			c[i] = '1';
		}
		else if(c[i] == '0' && k == 1) {
			c[i] = '2';
		}
		else if(c[i] == '1' && k == 0) {
			c[i] = '0';
		}
		else if(c[i] == '1' && k == 1) {
			c[i] = '2';
		}
		else if(c[i] == '2' && k == 0) {
			c[i] = '0';
		}
		else {
			c[i] = '1';
		}
		return C_S(c);
	}
	public static String C_S(char[] c) {
		String s = "";
		for (int i = 0; i < c.length; i++) {
			s += c[i];
		}
		return s;
	}
}
