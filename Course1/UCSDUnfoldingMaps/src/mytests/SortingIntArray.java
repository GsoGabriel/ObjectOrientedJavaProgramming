package mytests;

public class SortingIntArray {
	static int[] iniciaValores = {12,32,54,6,8,89,64,64,6};
	
	public static void sortMethod(int[] toSort) {
		// primeira versão
		for (int i = 0; i < toSort.length-1; i++) {
			int currValue = toSort[i];
			int lowerValue = currValue;
			int indexLowerValue = i;
			for (int j = i; j < toSort.length; j++) {
				if (toSort[j] < lowerValue) {
					lowerValue = toSort[j];
					indexLowerValue = j;
				}
			}
			if (lowerValue < currValue) {
				toSort[indexLowerValue] = currValue;
				toSort[i] = lowerValue;
			}
		}
	}
	public static void sortMethod2 (int[] toSort) {
		// segunda versão
		for (int i = 0; i < toSort.length-1; i++) {
			int indexLowerValue = i;
			for (int j = i+1; j < toSort.length; j++) {
				if (toSort[j] < toSort[indexLowerValue]) {
					indexLowerValue = j;
				}
			}
			swap(toSort, indexLowerValue, i);
		}
	}
	
	private static void swap(int[] list, int a, int b) {
		int valueA = list[a];
		int valueB = list[b];
		list[a] = valueB;
		list[b] = valueA;
			
	}
	
	public static void main(String[] args) {
		sortMethod2(iniciaValores);
		
	}
}
