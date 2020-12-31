import java.util.ArrayList;
import java.util.Random;

public class Numbers {
	private int size;
	private ArrayList<Integer> numbers;
	private ArrayList<Integer> numbersCopy;
	private ArrayList<Integer> temp;

	public Numbers() {

	}

	/**
	 * Parameterized constructor creates the object of ArrayList and accepts an int
	 * parameter to set the size for numbers and numbersCopy ArrayList.
	 * 
	 * @param size get the size of ArrayList from user.
	 */
	public Numbers(int size) {
		this.size = size;
		numbers = new ArrayList<Integer>(size);
		numbersCopy = new ArrayList<Integer>(size);
	}

	/**
	 * This method generates random numbers(1-50) for the ArrayList numbers and copy
	 * elements from numbers to numbersCopy.
	 */
	public void generateNumbers() {
		Random random = new Random();
		int randomNumber;
		for (int i = 0; i < size; i++) {
			randomNumber = (int) Math.ceil(50 * random.nextDouble());
			numbers.add(randomNumber);
			numbersCopy.add(randomNumber);
		}
	}

	/**
	 * This method checks whether the array is created.
	 * 
	 * @return Returns -1 if array is not created, ot returns 0 otherwise.
	 */
	public int isArrayCreated() {
		if (this.numbers == null) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * This method checks whether the ArrayList is empty.
	 * 
	 * @return Returns -1 if ArrayList's size is not greather than 0 (empty), or
	 *         returns 0 otherwise.
	 */
	public int isEmpty() {
		if (this.size <= 0) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * This method copy elements from numbersCopy to numbers.
	 */
	public void reinstateNumbers() {
		for(int i=0;i<size;i++) {
			numbers.set(i, numbersCopy.get(i));
		}
	}

	/**
	 * This method change the integer from the array to String. Prints the index and
	 * each elements.
	 * 
	 * @return returns a String of the values in the array and the format it.
	 */
	public String toString() {
		String values = "";
		values += String.format("%9s", "Index");
		for (int i = 0; i < this.size; i++) {
			values += String.format("%4s |", i);
		}
		values += String.format("\n%9s", "Element");
		for (int j = 0; j < this.size; j++) {
			values += String.format("%4s |", Integer.toString(numbers.get(j)));
		}
		return values;
	}

	/**
	 * This method find the index of element in the array.
	 * 
	 * @param searchNumber The number that the user want to search.
	 * @return Returns an int which is the index of the number if it is present in
	 *         the array, or returns -1 otherwise.
	 */
	public int findIndex(int searchNumber) {
		int i = 0, count = 0;
		do {
//			if (this.list.get(i) == searchNumber) {
			if (numbers.get(i) == searchNumber) {
				count = 1; // change the count value to identify it's the first occurrence
			}
			i++;
		} while (count == 0 && i < size);

		if (count == 0) {
			return -1;
		} else {
			return i - 1;
		}
	}

	/**
	 * This method count the number of occurrences.
	 * 
	 * @param searchNumber The number that the user want to search.
	 * @return Return the number of occurrences in the array.
	 */
	public int findCount(int searchNumber) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (numbers.get(i) == searchNumber) {
				count++;
			}
		}
		return count;
	}

	/**
	 * This method checks whether the array is sorted
	 * 
	 * @return Returns 0 if the array is sorted, or returns -1 otherwise.
	 */
	public int ifSorted() {
		int i = 0, sorted = 0; // if sorted equal to 0, the array is sorted.
		do {
			if (numbers.get(i) <= numbers.get(i + 1)) {
				sorted = 0;
			} else {
				sorted = -1;
			}
			i++;
		} while (sorted == 0 && (i + 1) < size);
		if (sorted == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * This method sort the array using Bubble Sort Algorithm
	 */
	public void bubbleSort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (numbers.get(j) > numbers.get(j + 1)) {
					int temp = numbers.get(j + 1);
					numbers.set(j + 1, numbers.get(j));
					numbers.set(j, temp);
				}
			}
		}
	}

	/**
	 * This method sort the array using Insertion Sort Algorithm
	 */
	public void insertionSort() {
		for (int i = 0; i < size; i++) {
			int temp = numbers.get(i);

			if (temp < numbers.get(0)) {
				numbers.remove(i);
				numbers.add(0, temp);
			} else {
				for (int j = 1; j < i; j++) {
					if (numbers.get(j - 1) < temp && temp <= numbers.get(j)) {
						numbers.remove(i);
						numbers.add(j, temp);
					}
				}
			}
		}
	}

	/**
	 * This method sort the array using Selection Sort Algorithm
	 */
	public void SelectionSort() {
		for (int i = 0; i < size - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < size; j++)
				if (numbers.get(j) < numbers.get(smallest))
					smallest = j;
			int temp = numbers.get(smallest);
			numbers.set(smallest, numbers.get(i));
			numbers.set(i, temp);
		}
	}
	/**
	 * This method sort the array using Merge Sort Algorithm
	 * 
	 * @param a	The parameter of Arraylist
	 * @param first The first index of the arrayList
	 * @param last	The last index of the arrayList
	 */
	public void merge(ArrayList<Integer> a, int first, int last) {
		if (first >= last)
			return;

		// Allocate tempory strage
		this.temp = new ArrayList<Integer>(last - first + 1);

		// Diveide the subarray in half
		int mid = (first + last) / 2;

		int i = 0;// The initial index of the temp arrayList(array)
		int j = first;// The first index of the first half of the arrayList(array)
		int k = mid + 1;// The first index of the second half of the arrayList(array)
		// Put the elements of the halves (which are assumed to be sorted) in temp in
		// the proper order
		while ((j <= mid) && (k <= last)) {
			if (numbers.get(j) <= numbers.get(k)) {///
				temp.add(i, numbers.get(j));
				i++;
				j++;
			} else {
				temp.add(i, numbers.get(k));
				i++;
				k++;
			}
		}
		// Since the two halves may not be the same size we need to copy the remaining
		// elements of the subarray into temp
		while (j <= mid) {
			temp.add(i, numbers.get(j));
			i++;
			j++;
		}
		while (k <= last) {
			temp.add(i, numbers.get(k));
			i++;
			k++;
		}
		
		//Copy the elements of temp into the original arraylist(numbers)
		for(i=first;i<=last;i++) {
			numbers.set(i, temp.get(i-first));
		}
	}
	/**
	 * Does the actual work of the merge sort
	 * 
	 * @param a		The arrayList
	 * @param first	The index of the first element of the subarrayList
	 * @param last	The index of the first element of the subarrayList
	 * 
	 * @effects		The order of the elements in a is changed
	 */
	public void mergeSort(ArrayList<Integer> a,int first,int last) {
		if(first<last) {
			int mid=(first+last)/2;
			mergeSort(numbers,first,mid);
			mergeSort(numbers,mid+1,last);
			merge(numbers,first,last);
		}
	}
	public void MergeSort(int size) {
		mergeSort(numbers,0,size-1);
	} 
  
	/**
	 * This method sort the array using Quick Sort Algorithm
	 */
	public void quickSort(int start, int end) {
		if (start >= end)
			return;
		int pivot = start, left = start + 1, right = end;
		while (left < right) {
			while (numbers.get(left) < numbers.get(pivot) && left < right)
				left++;
			while (numbers.get(right) > numbers.get(pivot) && left < right)
				right--;
			int temp = numbers.get(left);
			numbers.set(left, right);
			numbers.set(right, temp);
			if (left < right) {
				left++;
				right--;
			}
		}
		if (numbers.get(left) > numbers.get(pivot)) {
			int temp = numbers.get(pivot);
			numbers.set(pivot, left - 1);
			numbers.set(left - 1, temp);
			quickSort(start, left - 2);
			quickSort(left, end);
		} else {
			int temp = numbers.get(pivot);
			numbers.set(pivot, left);
			numbers.set(left, temp);
			quickSort(start, left - 1);
			quickSort(left + 1, end);
		}
	}

	/**
	 * This method search the number using recursive binary search.
	 * 
	 * @param key   The number that the user want to search.
	 * @param first The first index of the array
	 * @param last  The last index of the array
	 * @return Return the index of the key if it is present in the arry. Returns -1
	 *         otherwise.
	 */
	public int recursiveBinarySearch(int key, int first, int last) {

		for (int i = first; i < last; i++) {
			System.out.print(numbers.get(i) + " ");
		}
		System.out.println("");

		int mid = (first + last) / 2;
		if (this.numbers.get(mid) == key) {
			return mid;
		} else if (first >= last) {
			return -1;
		} else if (key > numbers.get(mid)) {
			return recursiveBinarySearch(key, mid + 1, last);
		} else if (key < numbers.get(mid)) {
			return recursiveBinarySearch(key, first, mid - 1);
		}
		return -1;
	}

	/**
	 * This method search the number using iterative binary search.
	 * 
	 * @param key The number that the user want to search.
	 * @return Return the index of the key if it is present in the arry. Returns -1
	 *         otherwise.
	 */
	public int iterativeBinarSearch(int key) {
		int mid;
		int first = 0, count = 0;
		int last = this.size - 1;
		do {
			for (int i = first; i <= last; i++) {
				System.out.print(numbers.get(i) + " ");
			}
			System.out.println("");
			mid = (first + last) / 2;

			if (key < numbers.get(mid)) {
				last = mid - 1;
			} else if (key > numbers.get(mid)) {
				first = mid + 1;
			} else if (key == numbers.get(mid)) {
				System.out.println("Numbers of interations: " + count);
				return mid;
			}
			count++;
		} while (first <= last);
		System.out.println("Numbers of interations: " + count);
		return -1;
	}
}
