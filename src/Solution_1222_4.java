import java.util.Scanner;
import java.util.Stack;

public class Solution_1222_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1 ; t <= 10 ; t++) {
			int len = Integer.parseInt(sc.nextLine());
			char[] str = new char[len];
			str = sc.nextLine().toCharArray();
			Stack<Character> operator = new Stack<>();
			String postFix = "";
			
			for (int i = 0; i < str.length; i++) {
				switch(str[i]) {
				case '+': 
					if(operator.isEmpty() || operator.peek() == '(') {
						operator.push(str[i]);
					}
					else {
						while(!operator.isEmpty()) {
							postFix += operator.pop();
						}
						operator.push(str[i]);
					}
				
					break;
				case '-':
					if(operator.isEmpty() || operator.peek() == '(') {
						operator.push(str[i]);
					}
					else {
						while(!operator.isEmpty()) {
							postFix += operator.pop();
						}
						operator.push(str[i]);
					}
				
					break;
				case '*':
					if(operator.isEmpty() || operator.peek() == '(' || operator.peek() == '+' || operator.peek() == '-') {
						operator.push(str[i]);
					}
					else {
						while(!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
							postFix += operator.pop();
						}
						operator.push(str[i]);
					}
				
					break;
				case '/':
					if(operator.isEmpty() || operator.peek() == '(' || operator.peek() == '+' || operator.peek() == '-') {
						operator.push(str[i]);
					}
					else {
						while(!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
							postFix += operator.pop();
						}
						operator.push(str[i]);
					}
				
					break;
				case '(': operator.push(str[i]);
					break;
				case ')':
					while(!(operator.peek() == '(')) {
						postFix += operator.pop();
					}
					operator.pop();
				
					
					break;
				case '^':
					if(operator.isEmpty() || operator.peek() == '(' || operator.peek() == '+' || operator.peek() == '-' || operator.peek() == '*' || operator.peek() == '/') {
						operator.push(str[i]);
					}
					else {
						while(!operator.isEmpty() && operator.peek() == '^') {
							postFix += operator.pop();
						}
						operator.push(str[i]);
					}
					break;
				default: postFix += str[i];
					break;
				}
	
			}
			while(!operator.isEmpty()) {
				postFix += operator.pop();
			}
			
			
		System.out.println(postFix);
			Stack<Integer> number = new Stack<>();
			
			for (int j = 0; j < postFix.length(); j++) {
				char ch = postFix.charAt(j);
				
				
				if(ch>='0' && ch <= '9') {
					number.push(ch - '0');
				}
				else if(ch == '+'){
					int n1 = number.pop();
					int n2 = number.pop();
					number.push(n2 + n1);
				}
				else if(ch == '-') {
					int n1 = number.pop();
					int n2 = number.pop();
					number.push(n2 - n1);
				}
				else if(ch == '*') {
					int n1 = number.pop();
					int n2 = number.pop();
					number.push(n2 * n1);
				}
				else if(ch == '/'){
					int n1 = number.pop();
					int n2 = number.pop();
					number.push(n2 / n1);
				}
				else {
					int n1 = number.pop();
					int n2 = number.pop();
					number.push((int)Math.pow(n2,n1));
				}
				
			}
			System.out.printf("#%d %d\n",t,number.pop());
		}
	}

}
