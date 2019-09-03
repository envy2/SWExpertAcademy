import java.util.Scanner;

public class Solution_3408 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			long n = sc.nextInt();
			
			long s1 = 0L + n * (n+1) / 2 ;
			long s2 = 0L + n * n;
			long s3 = 0L + n * n + n;
			
			System.out.printf("#%d",i+1);
			System.out.print(" " +s1+" "+s2+" "+s3 +"\n");
		}

	}

}
