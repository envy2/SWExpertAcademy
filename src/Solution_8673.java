import java.util.Scanner;

public class Solution_8673 {
	static int len,sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			int K = sc.nextInt();
			len = (int)Math.pow(2, K);
			sum = 0;
			int[] list = new int[len*2];
			
			for (int j = len; j < list.length; j++) {
				list[j] = sc.nextInt();
			}
			
			boring(list);
			System.out.println("#"+i+" "+sum);
		}
	}
	public static void boring(int[] list) {
		while(len != 1) {
			for (int i = len; i < len * 2; i+=2) {
				if(list[i] > list[i+1]) {
					sum += list[i] - list[i+1];
					list[i/2] = list[i];
				}
				else {
					sum += list[i+1] - list[i];
					list[i/2] = list[i+1];
				}
			}
			len /= 2;
		}
	}
}
