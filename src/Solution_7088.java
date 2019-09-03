import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_7088 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int iT = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= iT; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			int[][] sum = new int[3][N+1];
			
			for (int j = 1; j < sum[0].length; j++) {
				int a = Integer.parseInt(br.readLine()) - 1;
				sum[a][j] = sum[a][j-1] + 1;
				sum[(a+1)%3][j] = sum[(a+1)%3][j-1];
				sum[(a+2)%3][j] = sum[(a+2)%3][j-1];
			}
			
			System.out.println("#"+ i);
			for (int j = 0; j < Q; j++) {
				StringTokenizer sst = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(sst.nextToken());
				int end = Integer.parseInt(sst.nextToken());
			
				bw.write(String.format("%d %d %d\n",sum[0][end]-sum[0][start-1],sum[1][end]-sum[1][start-1],sum[2][end]-sum[2][start-1]));
			}
			bw.flush();
		}
		bw.close();

	}

}
