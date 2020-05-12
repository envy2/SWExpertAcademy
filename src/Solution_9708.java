import java.util.Arrays;
import java.util.Scanner;

public class Solution_9708 {
	static int[] len = new int[1000001];
	static int result;
	
	public static void init(Scanner sc) {
		int N = sc.nextInt();
		int[] numbers = new int[N];
		result = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
			len[numbers[i]] = 1;
		}
		
		Arrays.sort(numbers);
		solve(numbers);
	}
	
	public static void solve(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 2; j * numbers[i] <= numbers[numbers.length - 1]; j++) {
				if(len[j * numbers[i]] == 0) {
					continue;
				}
				else {
					if(len[j * numbers[i]] <= len[numbers[i]] + 1) {
						len[j * numbers[i]] = len[numbers[i]] + 1;
					}
				}
			}
		}

		for (int i = 0; i < len.length; i++) {
			result = Math.max(len[i], result);
			len[i] = 0;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			init(sc);
			System.out.println("#"+ t + " " + result);
		}
	}

}
