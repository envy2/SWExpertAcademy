import java.util.HashSet;
import java.util.Scanner;

public class Solution_9940 {

	public static boolean solution(Scanner sc) {
		int N = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}
		
		if(set.size() == N) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc ; t++) {
			if(solution(sc)) {
				System.out.println("#"+t+" Yes");
			}
			else {
				System.out.println("#"+t+" No");
			}
		}

	}

}
