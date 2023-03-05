import java.util.Scanner;

public class PrintNumbers {
	
	static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		int input = readNumber();
		print(input);
	}
	
	static int readNumber() {
		int n = 0;
		do {
			System.out.println("Enter a number between 1 nad 9: ");
			while (!SCANNER.hasNextInt()) {
				System.out.println("Thats not a number!");
				SCANNER.next();
			}
			n = SCANNER.nextInt();
		} while (n < 1 || n > 9);
		
		return n;
	}
	
	static void print(int n) {
		
		 for(int i = 1; i <= n; i++) {
			
			for(int j = 1; j <= i; j++) {   
			System.out.print(i+" ");   
			}   
		System.out.println();
		}   
	
	}

}
