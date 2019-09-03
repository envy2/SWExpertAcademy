import java.util.Scanner;

public class Solution_3143 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ; i <= iT ; i++) {
			String a = sc.next();
			String b = sc.next();
			int count = 0;
			for (int j = 0; j < a.length()-b.length()+1; j++) {
				if(a.substring(j, j+b.length()).equals(b)) {
					count++;
					j += b.length()-1;
				}
			}
			int res = b.length()*count;
			System.out.printf("#%d %d\n",i,a.length() - res + count);
		}

	}

}
