import java.util.Scanner;

public class Solution_4112 {

	static int ax, ay, bx, by, result;
	public static void init(Scanner sc) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		result = 0;
		int i = 0;
		int number = 1;
		
		while(number <= 10000) {
			for (int j = 0; j <= i; j++) {
				if(number == a) {
					ax = i;
					ay = j;
				}
				if(number == b) {
					bx = i;
					by = j;
				}
				number++;
				
			}
			i++;
			
		}
	}
	
	public static void solution() {
		int x = Math.abs(ax - bx);
		int y = Math.abs(ay - by);
		
		if( (ax > bx && ay < by) || (ax < bx && ay > by) ) {
			result = Math.min(x, y);
		}
		
		result += x < y ? y : x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc; t++) {
			init(sc);
			solution();
			System.out.println("#" + t + " " + result);
		}

	}

}
