import java.util.Scanner;

public class Solution_5356 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = Integer.parseInt(sc.nextLine());
		
		for(int t = 0; t< tcase ; t++) {
			char[][] word = new char[15][15];
			for (int five = 0; five < 5; five++) {
				String line = sc.nextLine();
				for (int i = 0; i < line.length(); i++) {
					word[five][i] = line.charAt(i);
				}
			}
			System.out.printf("#%d ",t+1);
			for(int i =0 ;i < word.length ;i++) {
				for(int j = 0 ;j <word[i].length ;j++) {
					if(word[j][i] != '\0') {
						System.out.print(word[j][i]);
					}
				}
			}
			System.out.println();
			
		}

	}

}
