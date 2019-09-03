import java.util.Arrays;
import java.util.Scanner;

public class Solution_1265 {
	static int dollar;
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			dollar = sc.nextInt();
			num = sc.nextInt();
			
			int[] arr = new int[num];
			calc(arr,0);
			long result = 1;
			for (int j = 0; j < arr.length; j++) {
				result *= arr[j];
			}
			System.out.printf("#%d %d\n",i,result);
		}
	}
	public static void calc(int[] arr,int depth) {
		if(depth == arr.length) {
			return;
		}
		arr[depth] = dollar / num;
		dollar = dollar - arr[depth];
		num--;
		calc(arr,depth+1);
	}
	
}
