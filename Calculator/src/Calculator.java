import java.util.Scanner;

public class Calculator {

		static Scanner SCANNER = new Scanner(System.in);
	public static void main(String[] args) {
		int frst = readInput();
		char op = readOperator();
		int scnd = readInput();
		if (scnd == 0 && (op == '%' ||  op == '/')) {
			System.out.println("You cant divide with 0, enter the second number again!");
			scnd = readInput();
		}
		
		
		
		count(frst, scnd, op);
	}
	
	static int readInput() {
		int n = 0;
		do {
			System.out.println("Enter a number: ");
			while (!SCANNER.hasNextInt()) {
				System.out.println("Invalid input!");
				SCANNER.next();
			}
			n = SCANNER.nextInt();
		} while (n < -999999 || n > 999999);
	return n;
	}
	
	static char readOperator() {
		System.out.println("What operator do you would like to use? : ");
		char op;
		do {
			op = (char)SCANNER.next().charAt(0);
		} while (op != '+' && op != '-' && op!= '*' && op!= '/' && op!= '%');
	return op;
	}

	static void count(int frst, int scnd, char op) {
		switch (op) {
		case '+': {
			System.out.println(frst + scnd);
		}
		break;
		case '-': {
			System.out.println(frst - scnd);
		}
		break;
		case '*': {
			System.out.println(frst * scnd);
		}
		break;
		case '/': {
			System.out.println((double)frst / scnd);
		}
		break;
		case '%': {
			System.out.println((double)frst % scnd);
		}
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
	}


}
