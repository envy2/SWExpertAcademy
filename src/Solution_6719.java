import java.util.Arrays;
import java.util.Scanner;

public class Solution_6719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 0; i < iT; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			double[] pro = new double[n];
			double result = 0;
			for (int j = 0; j < n; j++) {
				pro[j] = (double)sc.nextInt();
			}
			Arrays.sort(pro);

			for (int j = pro.length - k; j < pro.length; j++) {
				result = (result + pro[j]) /2 ;
			}
			System.out.printf("#%d %f\n",i+1,result);
		}

	}

}
