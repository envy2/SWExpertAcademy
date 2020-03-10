import java.util.HashSet;
import java.util.Scanner;

public class Solution_9480 {
	static HashSet<Character> over_check;
	static int result;
	
	public static void init(Scanner sc) {
		int N = sc.nextInt();
		String[] words = new String[N];
		boolean[] visit = new boolean[N];
		result = 0;
		
		for (int i = 0; i < words.length; i++) {
			words[i] = sc.next();
		}
		
		powerSet(words, visit, 0);
	}
	
	public static void powerSet(String[] words, boolean[] visit, int depth) {
		
		
		if(depth == visit.length) {
			String sentence = "";
			for (int i = 0; i < visit.length; i++) {
				if(visit[i]) {
					sentence += words[i];
				}
			}
			overCheck(sentence);
			return;
		}
		
		visit[depth] = false;
		powerSet(words, visit, depth + 1);
		
		visit[depth] = true;
		powerSet(words, visit, depth + 1);
		
	}
	
	public static void overCheck(String sentence) {
		over_check = new HashSet<>();
		
		for (int i = 0; i < sentence.length(); i++) {
			over_check.add(sentence.charAt(i));
		}
		
		if(over_check.size() == 26) {
			result++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			System.out.println("#" + t + " " + result);
		}

	}

}
