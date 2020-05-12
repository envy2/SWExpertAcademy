import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_9839 {
	static Integer[] numbers;
	
	public static void init(Scanner sc) {
		int N = sc.nextInt();
		numbers = new Integer[N];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		Arrays.sort(numbers, Collections.reverseOrder());
	}
	
	public static int solution() {
		int max = -1;
		int tmp = 0;
		
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				tmp = numbers[i] * numbers[j];
				
				if(max > tmp) {
					break;
				}
				
				if(InARow(Integer.toString(tmp))) {
					max = tmp;
				}
			}
		}
		
		return max;
	}
	
	public static boolean InARow(String tmp) {
		for (int i = 1; i < tmp.length(); i++) {
			if(tmp.charAt(i) - tmp.charAt(i-1) != 1) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			init(sc);
			int result = solution();
			
			System.out.println("#"+ t + " " + result);
		}

	}

}
