import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3263 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= iT ; i++) {
			int len = Integer.parseInt(br.readLine());
			int[] arr = new int[len];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int count =1;
			int c = 1;
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = j+1; j2 < arr.length; j2++) {
					if(arr[j] + c == arr[j2]) {
						count++;
						c++;
					}
				}
			
				max = max > count ? max : count;
				c = 1;
				count = 1;
			}
			
			
			String str = String.format("#%d %d\n", i,len-max);
			bw.write(str);
			bw.flush();
		}
		bw.close();

	}

}
