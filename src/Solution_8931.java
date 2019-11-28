import java.util.Scanner;
import java.util.Stack;

public class Solution_8931 {
	static int result;
	public static void init(Scanner sc) {
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
			if(num != 0) {
				stack.add(num);
			}
			else {
				stack.pop();
			}
		}
		result = 0;
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			result += stack.pop();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc; t++) {
			init(sc);
			System.out.println("#"+t+" "+result);
		}
		
		
	}

}
