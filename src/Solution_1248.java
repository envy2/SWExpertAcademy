import java.util.Scanner;

public class Solution_1248 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ;i++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			int sub1 = sc.nextInt();
			int sub2 = sc.nextInt();
			
			int[] merge1 = new int[E];
			int[] merge2 = new int[E];

			for (int m = 0; m < merge2.length; m++) {
				merge1[m] = sc.nextInt();
				merge2[m] = sc.nextInt();
			}
			
			int[] merge = new int[V];
			int count = 0;
			merge[count++] = Integer.MAX_VALUE;
			
			int sub1_value = 0;
			int sub2_value = 0;
			int result = 0;
			
			while(true) {
				for (int m = 0; m < merge2.length; m++) {
					if(merge2[m] == sub1 && merge[count] > merge1[m]) {
						sub1_value = merge1[m];
					}
					if(merge2[m] == sub2 && merge[count] > merge1[m]) {
						sub2_value = merge1[m];
					}
				}
				if(sub1_value > sub2_value) {
					merge[count++] = sub1_value;
					sub1 = sub1_value;
				}
				else if(sub1_value == sub2_value) {
					result = sub1_value;
					break;
				}
				else {
					merge[count++] = sub2_value;
					sub2 = sub2_value;
				}
			}
			
		}

	}

}
