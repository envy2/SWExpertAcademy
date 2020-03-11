import java.util.Arrays;
import java.util.Scanner;

public class Solution_9611 {
	static boolean[] numbers;
	static int[][] questions;
	static String[] think;
	
	public static void init(Scanner sc) {
		int N = sc.nextInt();
		
		questions = new int[N][5];
		think = new String[N];
		
		for (int x = 0; x < questions.length; x++) {
			for (int y = 0; y < questions[0].length - 1; y++) {
				questions[x][y] = sc.nextInt();
			}
			questions[x][4] = 10;
			Arrays.sort(questions[x]);
			think[x] = sc.next();
		}
		
		
		numbers = new boolean[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = true;
		}
	}
	
	public static void Question() {
		for (int x = 0; x < think.length; x++) {
			int idx = 0;
			if(think[x].equals("YES")) {
				for (int i = 0; i < numbers.length; i++) {
					if(questions[x][idx] == i) {
						idx++;
						continue;
					}
					else {
						numbers[i] = false;
					}
				}
			}
			else {
				for (int y = 0; y < questions[x].length - 1; y++) {
					numbers[questions[x][y]] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			Question();
			
			for (int i = 0; i < numbers.length; i++) {
				if(numbers[i]) {
					System.out.println("#" + t + " " + i);
				}
			}
		}

	}

}
