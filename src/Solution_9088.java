import java.util.Scanner;

public class Solution_9088 {
	static int[] diamonds, give_diamonds;
	public static void init(Scanner sc) {
		int N = sc.nextInt(); 
		int K = sc.nextInt();
		
		diamonds = new int[N];
		give_diamonds = new int[10001];
		
		solution(K, sc);
	}
	
	public static void solution(int K, Scanner sc) {
		for (int i = 0; i < diamonds.length; i++) {
			diamonds[i] = sc.nextInt();
			
			for (int j = diamonds[i]; j <= diamonds[i] + K; j++) {
				if(j == give_diamonds.length) {
					break;
				}
				give_diamonds[j]++;
				
			}
		}
		
	}
	
	public static int maxDiamond() {
		int result = 0;
		for (int i = 0; i < diamonds.length; i++) {
			result = result > give_diamonds[diamonds[i]] ? result : give_diamonds[diamonds[i]];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc ; t++) {
			init(sc);
			int result = maxDiamond();
			
			System.out.println("#"+t+ " "+ result);
		}

	}

}
