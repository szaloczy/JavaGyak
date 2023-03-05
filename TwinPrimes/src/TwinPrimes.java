import java.util.Scanner;

public class TwinPrimes {
	
	static Scanner SCANNER = new Scanner(System.in);
	
	public static void main(String[] args) {
		int input = ReadInput();
		twinPrimes(input);
		
	}
	
	static int ReadInput() {
		
		int n = 0;
		do {
			System.out.println("Enter a number between 1 and 10: ");
			while (!SCANNER.hasNextInt()) {
				System.out.println("Thats not a number !");
				SCANNER.next();
			}
			n = SCANNER.nextInt();
		} while (n < 1 || n > 10);
		
		return n;
	}
	
	static boolean sameDiv(int a, int b) {
		int mod = a % b;
		while (mod != 0) {
			a = b;
			b = mod;
			mod = a % b;
		}
		
		if (b == 1) {
			return true;
		}
		return false;
	}
	
	static void twinPrimes(int n) {
		for (int i = 10; i < (10 + n) * 2; i++) {
			if (sameDiv(i,i+2)) {
				System.out.println(i + "|" + (i + 2));
			}
		}
	}
	

}
