import java.util.Scanner;
import java.util.Stack;

public class Solution_1218 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int b_num = Integer.parseInt(sc.nextLine());
			String line = sc.nextLine();
			Stack<Character> s = new Stack<>();
			int count = 1;
			for (int i = 0; i < b_num; i++) {
				if(line.charAt(i) == '{' || line.charAt(i) == '[' || line.charAt(i) == '(' || line.charAt(i) == '<') {
					s.push(line.charAt(i));
				
				}
				else if(mirror(s.peek()) == line.charAt(i)) {
					s.pop();
					
				}
				else {
					count = 0;
					break;
				}
				
			}
			
			System.out.printf("#%d %d\n",t,count);
			
			
		}

	}
	public static char mirror(char c) {
		char m = '\0';
		if(c == '(') {
			m = ')';
		}
		else if( c == '{') {
			m = '}';
		}
		else if( c == '<') {
			m = '>';
		}
		else {
			m = ']';
		}
		return m;
	}

}
