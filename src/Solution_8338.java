import java.util.Scanner;

public class Solution_8338 {
	static int[] tcase,result;
	static int plus, multi;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			tcase = new int[N];
			result = new int[N];
			
			for (int t = 0; t < tcase.length; t++) {
				tcase[t] = sc.nextInt();
			}
			plus = tcase[0];
			multi = tcase[0];
			result[0] = tcase[0];
			
			for (int t = 1; t < tcase.length; t++) {
				plus += tcase[t];
				multi *= tcase[t];
				result[t] = Math.max(plus, multi);
				plus = result[t];
				multi = result[t];
			}
			System.out.println("#"+i+" "+result[N-1]);
			
		}
	}

}
