import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3459 {
	static ArrayList<Long> l;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		l = new ArrayList<>();
		Winner();
		
		for (int i = 1; i <= iT; i++) {
			long N = sc.nextLong();
			int count = 0;
			for(Long a : l) {
				count++;
				if(N < a) {
					break;
				}
			}
			if(count % 2 == 1) {
				System.out.println("#" + i +" Alice");
			}
			else {
				System.out.println("#" + i +" Bob");
			}
		}
	}
	public static void Winner() {
		long i = 0;
		for (int j = 0; j < 31; j++) {
			for (int j2 = 0; j2 < 2; j2++) {
				i += Math.pow(4, j);
				l.add(i);
			}
		}
	}
}
