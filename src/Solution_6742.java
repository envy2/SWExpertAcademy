import java.util.Scanner;

public class Solution_6742 {
	static long[] point;
	static int res;
	static long A,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ; i++) {
			int N = sc.nextInt();
			A = sc.nextLong();
			B = sc.nextLong();
			
			point = new long[N*2];
			res = 0;
			for (int j = 0; j < point.length; j+=2) {
				point[j] = sc.nextLong();
				point[j+1] = sc.nextLong();
			}
			
			for (int a = 0; a < point.length-2; a+=2) {
				for (int b = a+2; b < point.length-1; b+=2) {
					for (int c = b+2; c < point.length; c+=2) {
						triangle(point[a],point[a+1],point[b],point[b+1],point[c],point[c+1]);
					}
				}
			}
			System.out.printf("#%d %d\n",i,res);
		}

	}
	public static void triangle(long ax, long ay, long bx, long by, long cx, long cy) {
		double S = Math.abs(((ax*by) + (bx*cy) + (cx*ay)) - ((ax*cy) + (cx*by) + (bx*ay)));
		if(S >= A && S <= B) {
			res++;
		}
	}
}
