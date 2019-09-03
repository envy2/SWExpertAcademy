import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4261 {
	static String S;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ; i++) {
			S = sc.next();
			int N = sc.nextInt();

			ArrayList<String> word = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				String str = sc.next();
				if(check(str)) {
					word.add(str);
				}
			}
			System.out.printf("#%d %d\n",i,word.size());
			
		}

	}
	public static boolean check(String s) {
		boolean LenCheck = false;
		boolean Matching = true;
		if(s.length() == S.length()) {
			LenCheck = true;
			for (int i = 0; i < s.length(); i++) {
				if(!Phone(S.charAt(i)).contains(s.charAt(i)+"")){
					Matching = false;
					break;
				}
			}
		}
		if(LenCheck && Matching) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public static String Phone(char number) {
		switch(number) {
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "pqrs";
		case '8':
			return "tuv";
		case '9':
			return "wxyz";
		}
		return "";
	}
}
