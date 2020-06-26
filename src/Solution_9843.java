import java.util.Scanner;

public class Solution_9843 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc ; t++) {
			long N = sc.nextLong() * 2;
			long candle = (long) Math.sqrt(N);
			
			if(candle * candle + candle == N) {
				System.out.println("#" + t + " " + candle);
			}
			else {
				System.out.println("#" + t + " -1");
			}
		}

	}

}
