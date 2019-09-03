import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_1221 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			String tc = sc.next();
			int len = sc.nextInt();
			
			ArrayList<String> p = new ArrayList<>();
			for (int j = 0; j < len; j++) {
				p.add(sc.next());
			}
			p.sort(new SSort());
			
			System.out.println(tc);
			for(String s:p) {
				System.out.print(s+" ");
			}
		}

	}
	static class SSort implements Comparator<String>{
		public int compare(String o1, String o2) {
			if( GNS(o1) > GNS(o2) ) {
				return 1;
			}
			else if(GNS(o1) == GNS(o2)) {
				return 0;
			}
			else {
				return -1;
			}
		}
	} 
	public static int GNS(String s) {
		switch(s) {
		case "ZRO":
			return 0;
		case "ONE":
			return 1;
		case "TWO":
			return 2;
		case "THR":
			return 3;
		case "FOR":
			return 4;
		case "FIV":
			return 5;
		case "SIX":
			return 6;
		case "SVN":
			return 7;
		case "EGT":
			return 8;
		case "NIN":
			return 9;
		default:
			return -1;
		}
	}
}
