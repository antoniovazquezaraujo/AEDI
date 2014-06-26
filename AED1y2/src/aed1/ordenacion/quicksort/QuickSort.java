package aed1.ordenacion.quicksort;

public class QuickSort {
	public static boolean arrayOrdenado(int[] v) {
		for (int n = 0; n < v.length - 1; n++) {
			if (v[n] > v[n + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 9, 9, 4, 7, 9, 2, 3 };
		assert (!arrayOrdenado(a));
		quickSort(a, 0, a.length - 1);
		assert (arrayOrdenado(a));

		int[] b = { 1, 1 };
		quickSort(b, 0, b.length - 1);
		assert (arrayOrdenado(b));

		int[] c = { 10000, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		assert (!arrayOrdenado(c));
		quickSort(c, 0, c.length - 1);
		assert (arrayOrdenado(c));

	}

	private static void swap(int[] a, int i, int j) {
		int elem = a[i];
		a[i] = a[j];
		a[j] = elem;
	}

	public static int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		;

		return i;
	}

	public static void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}
}
