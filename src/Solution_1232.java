import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1232 {
	static String[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int iT = 1; iT <= 10; iT++) {
			int N = Integer.parseInt(br.readLine());
			input = new String[N+1]; 
			
			for (int i = 1; i < input.length; i++) {
				input[i] = br.readLine();
			}
			System.out.println("#"+iT+" "+Binary(1));
		}
	}
	public static int Binary(int i) {
		StringTokenizer st = new StringTokenizer(input[i]);
		st.nextToken();
		String operator = st.nextToken();
		if(operator.equals("+")) {
			return Binary(Integer.parseInt(st.nextToken())) + Binary(Integer.parseInt(st.nextToken()));
		}
		else if(operator.equals("-")) {
			return Binary(Integer.parseInt(st.nextToken())) - Binary(Integer.parseInt(st.nextToken()));
		}
		else if(operator.equals("*")) {
			return Binary(Integer.parseInt(st.nextToken())) * Binary(Integer.parseInt(st.nextToken()));
		}
		else if(operator.equals("/")) {
			return Binary(Integer.parseInt(st.nextToken())) / Binary(Integer.parseInt(st.nextToken()));
		}
		else {
			return Integer.parseInt(operator);
		}
	}

}
