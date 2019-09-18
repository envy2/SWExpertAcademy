import java.util.Arrays;
import java.util.Scanner;

public class Solution_3814 {
	static int[] number;
	static int K,result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			int N = sc.nextInt();
			K = sc.nextInt();
			
			number = new int[N];
			
			for (int j = 0; j < number.length; j++) {
				number[j] = sc.nextInt();
			}
			minus(0,1000000000);
			System.out.println("#"+i+" "+result);
		}

	}
	
	public static void minus(int left, int right) {
		if(left == right) {
			result = left;
			return;
		}
		
		int c = (left + right) / 2;
		
		int[] top = new int[number.length];
		int[] bot = new int[number.length];
		int[] min = new int[number.length];
		
		top[0] = number[0];
		bot[number.length-1] = number[number.length-1];
		int sum = 0;
		
		for (int i = 1; i < top.length; i++) {
			top[i] = Math.min(top[i-1] + c, number[i]);
		}
		for (int i = bot.length - 2; i >= 0; i--) {
			bot[i] = Math.min(bot[i+1] + c, number[i]);
		}
		for (int i = 0; i < min.length; i++) {
			min[i] = Math.min(top[i], bot[i]);
		}
		for (int i = 0; i < number.length; i++) {
			sum += number[i] - min[i]; 
		}
		
		if(sum <= K) {
			minus(left, c);
		}
		else {
			minus(c+1, right);
		}
	}
}
