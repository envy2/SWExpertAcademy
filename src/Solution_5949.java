import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < iT; i++) {
			char[] a = br.readLine().toCharArray();
			char[] b = br.readLine().toCharArray();
			int count = 0;
			for (int j = 0; j < a.length-1; j++) {
				if(a[j] != b[j]) {
					swap(a, j, j+1);
					count++;
				}
			}
			for (int j = 0; j < b.length; j++) {
				if(a[j] != b[j]) {
					count = -1;
					break;
				}
			}
			System.out.println("#"+(i+1)+" "+count);
		}
	}

	public static void swap(char[] arr, int a , int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
