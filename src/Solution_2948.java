import java.util.HashSet;
import java.util.Scanner;

public class Solution_2948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			HashSet<String> h = new HashSet<>();
			
			for (int j = 0; j < a; j++) {
				h.add(sc.next());
			}
			for (int j = 0; j < b; j++) {
				h.add(sc.next());
			}
			System.out.printf("#%d %d\n",i,a+b-h.size());
		}

	}

}
