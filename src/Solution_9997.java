import java.util.Scanner;

public class Solution_9997 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int angle = 0;
		
		for(int t = 1 ; t <= tc ; t++) {
			angle = sc.nextInt() * 2;
			System.out.println("#" + t + " " + angle/60 + " " + angle%60);
		}
	}
}
