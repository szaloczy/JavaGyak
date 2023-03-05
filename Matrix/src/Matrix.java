import java.util.Scanner;

public class Matrix {

	static Scanner SCANNER = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[][] matrix = {{1,3,2},{6,5,7},{4,9,8}};
		print(matrix);
		int mark = readInput();
		System.out.println(linearSearching(matrix, mark)? "I found the element" : "i didnt find the element");
		
	}
	
	static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static int readInput() {
		int n = 0;
		do {
			System.out.println("Enter  a number between 1 and 50: ");
			while (!SCANNER.hasNextInt()) {
				System.out.println("Thats not a number!");
				SCANNER.next();
			}
			n = SCANNER.nextInt();
		} while (n < 1 || n > 50);
		
		return n;
	}
	
	static boolean linearSearching(int[][] matrix, int mark) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == mark) {
					return true;
				}
			}
		}
		return false;
	}

}
