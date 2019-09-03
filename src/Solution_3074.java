import java.util.Scanner;

public class Solution_3074 {
	static long left,right;
	static int people;
	static int[] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ; i <= iT ; i++) {
			int N = sc.nextInt();
			people = sc.nextInt();
			time = new int[N];
			
			left = 0;
			right = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				time[j] = sc.nextInt();
				right = Math.min(right, time[j]);
			}
			right *= people;
			Parametric();
			System.out.printf("#%d %d\n",i,left);
		}
	}
	public static void Parametric() {
		long point = 0;
		int sum = 0;
		while(right > left) {
			point = (left + right)/2;
			sum = 0;
			for (int i = 0; i < time.length; i++) {
				sum += point / time[i];
				if(sum > people) {
					break;
				}
			}
			
			if(sum > people) {
				right = point-1;
			}
			else if(sum < people){
				left = point+1;
			}
			else {
				right = point;
			}
			
		}
	}
}
