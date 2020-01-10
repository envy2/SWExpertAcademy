import java.util.Scanner;

public class Solution_9229 {
	static int[] cookies;
	
	public static int init(Scanner sc) {
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		cookies = new int[N];
		for (int i = 0; i < cookies.length; i++) {
			cookies[i] = sc.nextInt();
		}
		
		return M;
	}
	
	public static int maxCarry(int weight) {
		int max = -1;
		int twoHand;
		for (int i = 0; i < cookies.length; i++) {
			for (int j = i+1; j < cookies.length; j++) {
				twoHand = cookies[i] + cookies[j];
				if(twoHand <= weight && twoHand > max) {
					max = twoHand;
				}  
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc ; t++) {
			int weight = init(sc);
			int result = maxCarry(weight);
			
			System.out.println("#"+ t + " " + result);
		}

	}

}
