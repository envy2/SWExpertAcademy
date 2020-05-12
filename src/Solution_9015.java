import java.util.ArrayList;
import java.util.Scanner;

public class Solution_9015 {
	static ArrayList<Integer> numbers;
	static int result;
	
	public static void init(Scanner sc) {
		int n = sc.nextInt();
		numbers = new ArrayList<>();
		result = 1;
		
		for (int i = 0; i < n; i++) {
			numbers.add(sc.nextInt());
		}
		
		for (int i = 1; i < numbers.size(); i++) {
			if(numbers.get(i-1).intValue() == numbers.get(i).intValue()) {
				numbers.remove(i);
				i--;
			}
		}
	}
	
	public static void solution() {
		boolean up = true;
		boolean check = true;
		
		for (int i = 1; i < numbers.size(); i++) {
			int a = numbers.get(i-1);
			int b = numbers.get(i);
			
			if(check) {
				if(a < b) {
					up = true;
				}
				else {
					up = false;
				}
				check = false;
			}
			
			if((a < b && up) || (a > b && !up)) {
				continue;
			}
			else {
				result++;
				check = true;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			solution();
			System.out.println("#" + t + " " + result);
		}

	}

}
