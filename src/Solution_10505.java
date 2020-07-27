import java.util.Scanner;

public class Solution_10505 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc ; t++) {
			int N = sc.nextInt();
			int[] number = new int[N];
			int sum = 0;
			int result = 0;
			
			for (int i = 0; i < number.length; i++) {
				number[i] = sc.nextInt();
				sum += number[i];
			}
			
			sum /= N;
			
			for (int i = 0; i < number.length; i++) {
				if(number[i] <= sum) {
					result++;
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
