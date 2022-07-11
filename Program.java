// Реализовать алгоритм сортировки слиянием
public class Program {
	public static void main(String[] args) {
		ConsoleScaner consoleScaner = new ConsoleScaner();
		int length = consoleScaner.getLength("Введите длинну массива: ", 0, 30);
		consoleScaner.close();
		ArraySort array = new ArraySort(length);
		System.out.println("Начальный массив:       " + array);
		array.sortArray();
		System.out.println("Отсортированный массив: " + array);
	}

	
}