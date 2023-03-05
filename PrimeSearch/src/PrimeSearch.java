import java.util.Random;
import java.util.Scanner;

/*
 *
    Írjon programot az alábbi feladatokból:
    1. Olvasson be ellenőrzötten egy integer tömbbe, majd írassa is ki azt!
    2. Rendezze először növekvő, majd csökkenő sorrendben a bekért tömböt!
    3. Döntse el milyen monoton a sor (monoton növekvő, monoton csökkenő vagy nem monoton)!
    4. Kérjen be egy számot az inputról és döntse el, hogy prím e!
    5. Vizsgálja meg bináris kereséssel, hogy a bekért szám benne van e a tömbben!
    6. A prím vizsgáló függvénnyel keresse meg előről majd hátulról a legelső prímszámot, ha van ilyen!
    7. Keresse meg a tömb legkisebb, legnagyobb elemeit, majd írassa ki a helyüket!
 */

	

public class PrimeSearch {
	
	static final int LENGTH = 5;
	static Random RANDOM = new Random(System.currentTimeMillis());
	static Scanner SCANNER = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] array = new int[LENGTH];
		fillArray(array);
		listArray(array);
		//asc(array);
		//listArray(array);
		howMonotone(array);
		int input = readNumber();
		System.out.println(isPrime(input)? "The given number is prime!" : "The given number is not prime!");
		searchNumber(array, input);
	}
	 
	

	static int generateRandom()
	{
		int rnd = RANDOM.nextInt((45 - 5) + 5);
		return rnd;
	}
	
	static void fillArray(int[] array)
	{
		for (int i = 0; i < array.length; i++) {
			array[i] = generateRandom();
		}
	}
	
	static void listArray(int[] array)
	{
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	static void desc(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}
	
	static void asc(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	static int monotoning(int[] array)
	{
		boolean increasing = true;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				increasing = false;
			}
		}
		
		boolean decreasing = true;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] < array[i]) {
				decreasing = false;
			}
		}
		
		if (increasing) {
			return 1;
		}
		else if (decreasing) {
			return 2;
		}else{
			return 3;
		}
		
	}

	static void howMonotone(int[] array)
	{
		switch (monotoning(array)) {
		case 1: {
			System.out.println("The array sequence is monotone increasing!");
			break;
		}
		case 2: {
			System.out.println("The array sequence is monotone decreasing!");
			break;
		}
		case 3: {
			System.out.println("The array sequence is non-monotone!");
			break;
		}
		}
	}

	static int readNumber()
	{
		int input;
		boolean ok;
		
		do {
			ok = true;
			input = SCANNER.nextInt();
			if (input < 0) {
				ok = false;
				System.out.println("Invalid input!");
				SCANNER.nextLine();
			}
		} while (!ok);
		return input;
	}

	static boolean isPrime(int input) {
		if (input < 2) {
			return false;
		}
		
		int count = 2;
		while (count > Math.sqrt(input) && input % count == 0) {
			count++;
		}
		
		if (count < Math.sqrt(input)) {
			return false;
		}
		return true;
	}
	
	static void searchNumber(int[] array, int input)
	{
		int first = 0;
		int last = array.length - 1;
		int middle = (first + last) / 2;
		
		while(first <= last)
		{
			if (array[middle] < input) {
				last = middle;
			}else if (array[middle] == input) {
				System.out.println("The given number was found at the index of "+middle+"int the array");
				break;
			}else {
				first = middle + 1; 
			}
			middle = (first + last) / 2;
		}
		
		if (first > last) {
			System.out.println("The given numbar was not found int the array");
		}
		
		
	}
}
