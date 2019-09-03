import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4581 {
	static String sb;
	static String s;
	static ArrayList<Character> str;
	static String res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ; i++) {
			s = sc.next();
			sb = "";
			str = new ArrayList<>();
			
			for (int j = 0; j < s.length(); j++) {
				str.add(s.charAt(j));
			}
			
			dfs();
		}

	}
	public static void dfs() {
		int len = str.size();
		if(len == 0) {
			//System.out.println(sb.toString());
			return;
		}
		for (int j = 0; j < len; j++) {
			System.out.println(sb);
			if(str.get(0) == str.get(str.size()-1)) {
				char a = removeLast();
				dfs();
				str.add(a);
				sb = sb.substring(0, sb.length()-1);
				removeFirst();
				dfs();
			}
			else if(str.get(0) > str.get(str.size()-1)) {
				removeLast();
			}
			else {
				removeFirst();
			}
		}
	}
	public static Character removeFirst() {
		sb = sb + str.get(0);
		return str.remove(0);
	}
	public static Character removeLast() {
		sb = sb + str.get(str.size()-1);
		return str.remove(str.size()-1);
	}
}
