import java.util.Arrays;
import java.util.Scanner;

public class Solution_1256 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i<= iT; i++) {
			int c = sc.nextInt();
			String str = sc.next();
			
			String[] s = new String[str.length()];
			for (int j = 0; j < s.length; j++) {
				s[j] = str.substring(j, s.length);
			}
			Arrays.sort(s);
			if(c <= s.length) {
				System.out.printf("#%d %s\n",i,s[c-1]);
			}
			else {
				System.out.printf("#%d none",i);
			}
		}

	}

}
