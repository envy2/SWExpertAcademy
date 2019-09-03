import java.util.Scanner;

public class Solution_3750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			String a = n+"";
			int[] ar = new int[a.length()];
			for (int j = 0; j < ar.length; j++) {
				ar[j] = a.charAt(j) -'0';
			}
			System.out.println("#"+(i+1)+" "+fn(ar));
		}
	}

	public static int fn(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		String line = sum+"";
		int[] list = new int[line.length()];
		for (int i = 0; i < line.length(); i++) {
			list[i] = line.charAt(i) - '0';
		}
		if(list.length > 1) {
			fn(list);
		}
		return list[0];
	}
}
