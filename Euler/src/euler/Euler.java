package euler;

public class Euler {

	public static void main(String[] args) {
		System.out.println("e: "+euler(11));
	}
	
	static long faktorial(int n) {
		long fakt = 1;
		for (int i = 1; i <= n; i++) {
			fakt *= i;
		}
		
		return fakt;
	}
	
	static double euler(int n) {
		double result = 0;
		for (int i = 0; i <= n; i++) {
			double e = 1.0 / faktorial(i);
			result += e;
		}
		
		return result;
	}

}
