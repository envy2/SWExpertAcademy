import java.util.Scanner;
import java.util.Stack;

public class Solution_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < tcase; i++) {
			String line = sc.nextLine();
			
			Stack<Integer> bracket = new Stack<>();
			int top = 1;
			int laser = 1;
			int stick = 0;
			int result = 0;
			int index_start = 0;
			int index_end = 0;
			boolean[] start = new boolean[100];
			for (int j = 0; j < line.length(); j++) {
				if(line.charAt(j) =='(' && line.charAt(j+1) == ')') {
					result += stick;
					j++;
				
				}
				else if(line.charAt(j) == '(' && line.charAt(j+1) == '(') {
					bracket.push(1);
					stick = bracket.size();
				}
				else if(line.charAt(j) == ')') {
					result += 1;
					bracket.pop();
					stick = bracket.size();
				
				}
			}
			
			System.out.printf("#%d %d\n",i+1,result);
			
		}

	}

}
