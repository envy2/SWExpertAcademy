import java.math.BigInteger;
import java.util.Scanner;

public class Solution_4259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ;i <=iT; i++) {
			int n = sc.nextInt();
			BigInteger res = new BigInteger("0");
			BigInteger a = new BigInteger("0");
			for (int j = 0; j < n; j++) {
				String str = sc.next();
				String front = str.substring(0,str.length()-1);
				int back = str.charAt(str.length()-1) -'0';
			
				a = new BigInteger(front);
				BigInteger b = a;
				for (int k = 1; k < back; k++) {
					a = a.multiply(b);
				}
				
				res = res.add(a);
			}
			System.out.println("#"+i+" "+res);
		}

	}

}
