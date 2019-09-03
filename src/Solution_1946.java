import java.util.Scanner;

public class Solution_1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < tcase; i++) {
			int doc = Integer.parseInt(sc.nextLine());
			String line = "";
			System.out.printf("#%d",i+1);
            System.out.println();
            
			for (int j = 0; j < doc; j++) {
				String[] str = sc.nextLine().split(" ");
				String st = str[0];
				int num = Integer.parseInt(str[1]);
				
				for (int x = 0; x < num; x++) {
					line += st;
					
				}
				
			}
			int count = 0;
			for(int j = 0 ; j < line.length(); j++) {
				System.out.print(line.charAt(j));
				count++;
				if(count == 10) {
					System.out.println();
					count = 0;
				}
			}
			System.out.println();
		}

	}

}
