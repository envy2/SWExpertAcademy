import java.util.Scanner;

public class Solution_5215 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 0; i < iT; i++) {
			int Tc = sc.nextInt();
			int L = sc.nextInt();
			
			Hamburger[] ham = new Hamburger[Tc+1]; 
			int[][] table = new int[Tc+1][L+1];
			
			for (int j = 1; j < ham.length; j++) {
				ham[j] = new Hamburger(sc.nextInt(), sc.nextInt());
			}
			for (int x = 1; x < table.length; x++) {
				for (int y = 1; y < table[0].length; y++) {
					if(ham[x].kalories > y) {
						table[x][y] = table[x-1][y]; 
					}
					else {
						table[x][y] = Math.max(ham[x].point + table[x-1][y - ham[x].kalories], table[x-1][y]);
					}
				}
			}
			System.out.printf("#%d %d\n",i+1,table[Tc][L]);
		}

	}

}
class Hamburger{
	int point;
	int kalories;
	
	public Hamburger(int point, int kalories) {
		this.point = point;
		this.kalories = kalories;
	}
	
}