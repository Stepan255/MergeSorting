import java.util.Random;

public class ArraySort {
	int[] array = {};

	public ArraySort(int length) {
		array = new int[length];
		Random rnd = new Random(System.currentTimeMillis());
		for (int i = 0; i < array.length; i++) {
			array[i] = 1 + rnd.nextInt(30 - 1);
		}
	}

	public void sortArray(){
		if (array == null) {
			return;
		}
		this.array = sortArray(array);
	}

	public int[] sortArray(int[] array){
		if (array.length < 2) {
			return array;
		}
		int[] arrayB = new int[array.length / 2];
		System.arraycopy(array, 0, arrayB, 0, array.length / 2);
		int[] arrayC = new int[array.length - array.length / 2];
		System.arraycopy(array, array.length / 2, arrayC, 0, array.length - array.length / 2);

		arrayB = sortArray(arrayB);
		arrayC = sortArray(arrayC);

		return margeArray(arrayB, arrayC);
	}

	public int[] margeArray(int[] arrayA, int[] arrayB){
		int[] arrayC = new int[arrayA.length + arrayB.length];
		int offsetForA = 0;
		int offsetForB = 0;
		for (int i = 0; i < arrayC.length; i++) {
			if (i - offsetForA >= arrayA.length) {
				arrayC[i] = arrayB[i - offsetForB];
				offsetForA++;
			} else if (i - offsetForB >= arrayB.length){
				arrayC[i] = arrayA[i - offsetForA];
				offsetForB++;
			} else if (arrayA[i - offsetForA] < arrayB[i - offsetForB]) {
				arrayC[i] = arrayA[i - offsetForA];
				offsetForB++;
			} else {
				arrayC[i] = arrayB[i - offsetForB];
				offsetForA++;
			}
		}
		return arrayC;
	}

	@Override
	public String toString() {
		String text = "";
		for (int i = 0; i < array.length ; i++) {
			text += Integer.toString(array[i]) + " ";
		}
		return text;
	}
}
