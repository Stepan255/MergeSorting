import java.util.Scanner;

public class ConsoleScaner {
	Scanner cScanner = new Scanner(System.in);

	public int getLength(String text, int min, int max){
		int length = 0;
		System.out.print(text);
		Scanner cScanner = new Scanner(System.in);
		Boolean firstTry = true;
		do{
			if (!firstTry){
				System.out.print("Вы ввели число меньше " + min + " или больше " + max + ", введите число:");
			}
			while (!cScanner.hasNextInt()) {
				System.out.print("Вы ввели не число." + text);
				cScanner = new Scanner(System.in);
			}
			firstTry = false;
			length = cScanner.nextInt();
		} while( length < min || length > max);
		cScanner.close();
		return length;
	}

	public void close() {
		cScanner.close();
	}
}
