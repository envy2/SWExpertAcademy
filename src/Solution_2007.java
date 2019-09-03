import java.util.Scanner;

public class Solution_2007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i <= iT ; i++) {
			StringBuilder s = new StringBuilder(sc.next());
			String ss = s.charAt(0) + "";
			for (int j = 1; j < s.length()/2; j++) {
				if(!ss.equals(s.substring(j+1, j+ss.length()+1))) {
					ss += s.charAt(j);
				}
				else {
					ss += s.charAt(j);
					break;
				}
			}
			System.out.printf("#%d %d\n",i,ss.length());
		}
	}

}
