import java.util.Scanner;

public class Solution_6907 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i <= iT ; i++) {
			String number = sc.next();
			String str = sc.next();
			String end = sc.next();
			
			int pow = 0;
			int point = 0;
			String res = "";
			
			for (int j = 0; j < number.length(); j++) {
				if(number.charAt(j) == '.') {
					point = j;
				}
			}
			
			if(point == 0) { // 소수점이 없는경우
				
			}
			else {
				
			}
		}

	}
	public static int UnitConversion(String s) {
		int pow = 0;
		switch(s) {
		case "yotta": 
			pow = 24;
			break;
		case "zetta":
			pow = 21;
			break;
		case "exa":
			pow = 18;
			break;
		case "peta":
			pow = 15;
			break;
		case "tera":
			pow = 12;
			break;
		case "giga": 
			pow = 9;
			break;
		case "mega":
			pow = 6;
			break;
		case "kilo":
			pow = 3;
			break;
		case "hecto":
			pow = 2;
			break;
		case "deca":
			pow = 1;
			break;
		case "deci": 
			pow = -1;
			break;
		case "centi":
			pow = -2;
			break;
		case "milli":
			pow = -3;
			break;
		case "micro":
			pow = -6;
			break;
		case "nano":
			pow = -9;
			break;
		case "pico": 
			pow = -12;
			break;
		case "femto":
			pow = -15;
			break;
		case "ato":
			pow = -18;
			break;
		case "zepto":
			pow = -21;
			break;
		case "yocto":
			pow = -24;
			break;
		}
		return pow;
	}
}
