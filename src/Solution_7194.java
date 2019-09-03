import java.util.Arrays;
import java.util.Scanner;

public class Solution_7194 {
	static int[] arr;
	static boolean[] visit;
	static int start,end,feed,drug,res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			
			feed = sc.nextInt();
			drug = sc.nextInt();
			
			res = 0;
			arr = new int[100000];
			visit = new boolean[1000000];
			for (int j = start; j <= end; j++) {
				if(j- feed >= start) {
					arr[j] = arr[j-feed] + 1;
				}
				if(j % drug == 0 && j / drug >= start) {
					arr[j] = Math.min(arr[j], arr[j/drug] + 1);
				}
			}
			System.out.printf("#%d %d\n",i,arr[end]);
		}
	}
}