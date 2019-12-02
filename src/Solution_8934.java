import java.util.Arrays;
import java.util.Scanner;

public class Solution_8934 {
	static int[] word;
	
	public static void init(Scanner sc) {
		word = new int[3];
		
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			word[str.charAt(i) - '0' - 49]++;
		}
		
	}
	
	public static boolean solution() {
		Arrays.sort(word);
		int min_value = word[0];
		
		for (int i = 0; i < word.length; i++) {
			word[i] -= min_value;
			if(word[i] > 1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc; t++) {
			init(sc);
			if(solution()) {
				System.out.println("#"+t+" YES");
			}
			else {
				System.out.println("#"+t+" NO");
			}
		}

	}

}
