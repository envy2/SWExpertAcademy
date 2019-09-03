import java.util.Arrays;
import java.util.Scanner;

public class Solution_7333 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			int N = sc.nextInt();
			int[] box = new int[N];
			for (int j = 0; j < box.length; j++) {
				box[j] = sc.nextInt();
			}
			Arrays.sort(box);
			
			int left = 0;
			int right = box.length - 1;
			int carry = 0;
			
			while(left <= right) {
				int count = right - left;
				if(box[right] >= 50) {
					carry++;
					right--;
				}
				else {
					int index = 1;
					for (index = 1; index <= count; index++) {
						if(box[right] * (index + 1) >= 50) {
							carry++;
							right--;
							break;
						}
					}
					left += index;
				}
			}
			System.out.println("#"+i+" "+carry);
		}
		sc.close();
	}

}
