import java.util.Scanner;

public class Solution_4672 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ;i++) {
			String str = sc.next();
			int[] alpabet = new int[26];
			for (int j = 0; j < str.length(); j++) {
				alpabet[str.charAt(j) - 'a']++;
			}
			int result = 0;
			for (int j = 0; j < alpabet.length; j++) {
				result += (alpabet[j] * (alpabet[j]+1))/2;
			}
			System.out.println("#"+i+" "+result);
		}
	}
}
