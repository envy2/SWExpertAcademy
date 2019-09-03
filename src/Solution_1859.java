import java.util.Scanner;

public class Solution_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = sc.nextInt();
		
		for(int i = 0 ; i < tcase ; i++) {
			int numcount = sc.nextInt();
			int[] arr = new int[numcount];
			for (int j = 0; j < numcount; j++) {
				arr[j] = sc.nextInt();
			}
			
			int max = arr[numcount - 1];
			long money = 0L ; // 1859번 문제에서 타입 오류가 있어서 변경
			for (int j = numcount - 2; j >= 0 ; j--) {
				if(max > arr[j]) {
					money += max - arr[j];
				}
				else {
					max = arr[j];
				}
			}
			
			System.out.printf("#%d %d",i+1,money);
			System.out.println();
		}
		
	}

}
