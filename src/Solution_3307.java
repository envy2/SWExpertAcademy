import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_3307 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= iT ; i++) {
			int len = Integer.parseInt(br.readLine());
			int[] arr = new int[len];
			int[] res = new int[len];
			Arrays.fill(res, 1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int j1 = len -1 ; j1 >= 1 ; j1--) {
				for (int j2 = j1-1; j2 >= 0; j2--) {
					if(arr[j1] > arr[j2]) {
						res[j2] = Math.max(res[j1]+1, res[j2]);
					}
				}
			}
			Arrays.sort(res);
			max = res[len-1];
			String str = String.format("#%d %d\n", i,max);
			bw.write(str);
			bw.flush();
		}
		bw.close();
	}
}