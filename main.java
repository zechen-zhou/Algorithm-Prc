import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class that include main method, creates an object of
 * Numbers and display a menu that promots users to execute each of the methods
 * and promots for user input.
 * 
 * @author Zechen Zhou
 * @version 1.0
 * @since 1.8
 */
public class main {
	/**
	 * This method create an object of Numbers class. Display a menu and call the
	 * method from Numbers class.
	 * 
	 * @param args Allow values to be passed to the program when it is called upon
	 *             to run.
	 */
	public static void main(String[] args) {
		Numbers numbers = new Numbers(); 
		int choice = 0; // Initilize the choice variable
		int size = 0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1. Create array with new size");
			System.out.println("2. Generate random numbers and store it in the array");
			System.out.println("3. Sort numbers");
			System.out.println("4. Search a number");
			System.out.println("5. Display array");
			System.out.println("6. Quit");
			System.out.print("Enter your option: ");
			try {
				choice = input.nextInt();
				if (choice == 1) {
					System.out.print("Enter required size: ");
					size = input.nextInt();
					numbers = new Numbers(size);
					System.out.println();
				} else if (choice == 2) {
					if (numbers.isArrayCreated() == -1) {
						System.err.println("Array is not created... Please create the array first.");
					} else {
						numbers.generateNumbers();
						System.out.println();
					}
				} else if (choice == 3) {
					if (numbers.isArrayCreated() == -1) {
						System.err.println("Array is not created... Please create the array first.");
					} else if (numbers.isEmpty() == -1) {
						System.err.println("Array is empty");
					} else {
						int sortChoice = 0;
						System.out.println(
								"1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Merge Sort\n5. Quick Sort");
						System.out.print("Enter your choice: ");
						try {
							sortChoice = input.nextInt();
							switch (sortChoice) {
							case 1:
								numbers.reinstateNumbers();// call reinstateNumbers()
								System.out.println("Unsorted numbers\n" + numbers.toString() + "\n");// print numbers
								long start1 = System.nanoTime();// record start time
								numbers.bubbleSort();// do sorting
								long end1 = System.nanoTime();// record end time
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\nTime taken for Bubble Sort: " + (end1 - start1));// calculate the
																										// time taken
																										// for the
																										// sorting
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\n\nSorted numbers - Bubble Sort\n" + numbers.toString() + "\n");// print
																														// sorted
																														// numbers
								break;
							case 2:
								numbers.reinstateNumbers();
								System.out.println("Unsorted numbers\n" + numbers.toString() + "\n");
								long start2 = System.nanoTime();
								numbers.insertionSort();
								long end2 = System.nanoTime();
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\nTime taken for Insertion Sort: " + (end2 - start2));
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\n\nSorted numbers - Insertion Sort\n" + numbers.toString());
								System.out.println();
								break;
							case 3:
								numbers.reinstateNumbers();// call reinstateNumbers()
								System.out.println("Unsorted numbers\n" + numbers.toString() + "\n");// print numbers
								long start3 = System.nanoTime();// record start time
								numbers.SelectionSort();// do sorting
								long end3 = System.nanoTime();// record end time
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\nTime taken for Insertion Sort: " + (end3 - start3));// calculate
																											// the time
																											// taken for
																											// the
																											// sorting
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\n\nSorted numbers - Insertion Sort\n" + numbers.toString() + "\n");// print
																														// sorted
																														// numbers
								break;
							case 4:
								numbers.reinstateNumbers();// call reinstateNumbers()
								System.out.println("Unsorted numbers\n" + numbers.toString() + "\n");// print numbers
								long start4 = System.nanoTime();// record start time
								numbers.MergeSort(size);// do sorting
								long end4 = System.nanoTime();// record end time
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\nTime taken for Merge Sort: " + (end4 - start4));// calculate the
																										// time taken
																										// for the
																										// sorting
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\n\nSorted numbers - Merge Sort\n" + numbers.toString() + "\n");// print
																													// sorted
																													// numbers
								break;
							case 5:
								numbers.reinstateNumbers();// call reinstateNumbers()
								System.out.println("Unsorted numbers\n" + numbers.toString() + "\n");// print numbers
								long start5 = System.nanoTime();// record start time
								numbers.quickSort(0, size - 1);// do sorting
								long end5 = System.nanoTime();// record end time
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\nTime taken for Quick Sort: " + (end5 - start5));// calculate the
																										// time taken
																										// for the
																										// sorting
								for (int i = 0; i < 48; i++) {
									System.out.print("=");
								}
								System.out.println("\n\nSorted numbers - Quick Sort\n" + numbers.toString() + "\n");// print
																													// sorted
																													// numbers
								break;
							default:
								System.out.println("Please enter a valid menu option.\n");
							}
						} catch (InputMismatchException e) {
							System.out.println("Please enter a valid data type(Integer number)\n");
						} finally {
//								input.nextLine();
						}
					}
				} else if (choice == 4) {
					if (numbers.isArrayCreated() == -1) {
						System.err.println("Array is not created... Please create the array first.");
					} else if (numbers.isEmpty() == -1) {
						System.err.println("Array is empty");
					} else {
						System.out.println("\n1. Linear Search");
						System.out.println("2. Iterative Binary Search");
						System.out.println("3. Recursive Binary Search");
						System.out.print("Enter your choice: ");
						try {
							int choiceSearch = input.nextInt();
							int searchNumber = 0;
							switch (choiceSearch) {
							case 1:
								System.out.print("Enter the number to be searched: ");
								searchNumber = input.nextInt();
								if (numbers.findIndex(searchNumber) == -1) {
									System.out.println("\nNumber " + searchNumber + " occured 0 times in the array\n");
								} else {
									System.out.println(
											"\nNumber " + searchNumber + " occurred " + numbers.findCount(searchNumber)
													+ " times in the array, and its first occurrence is at index "
													+ numbers.findIndex(searchNumber) + "\n");
								}
								;
								break;
							case 2:
								if (numbers.ifSorted() == 0) {
									System.out.print("Enter the number to be searched: ");
									int key = input.nextInt();
									if (numbers.iterativeBinarSearch(key) == -1) {
										System.out.println("\n" + key + " not present\n");
									} else {
										System.out.println(
												"\n" + key + " is found at index " + numbers.findIndex(key) + "\n");
									}
								} else if (numbers.ifSorted() == -1) {
									System.out.println(
											"Array not sorted. Please sort the array before applying binary search\n");
								}
								;
								break;
							case 3:
								if (numbers.ifSorted() == 0) {
									System.out.print("Enter the number to be searched: ");
									int key = input.nextInt();
									if (numbers.recursiveBinarySearch(key, 0, size - 1) == -1) {
										System.out.println(key + " not present\n");
									} else {
										System.out.println(key + " is found at index " + numbers.findIndex(key) + "\n");
									}
								} else if (numbers.ifSorted() == -1) {
									System.out.println(
											"Array not sorted. Please sort the array before applying binary search\n");
								}
								;
								break;
							default:
								System.out.println("Please enter a valid menu option.\n");
							}
						} catch (InputMismatchException e) {
							System.out.println("Please enter a valid data type(Integer number)\n");
						}
					}
				} else if (choice == 5) {
					if (numbers.isArrayCreated() == -1) {
						System.err.println("Array is not created... Please create the array first.");
					} else if (numbers.isEmpty() == -1) {
						System.err.println("Array is empty");
					} else {
						System.out.println(numbers.toString() + "\n");
					}
				} else if (choice == 6) {
					System.out.println("Bye... have a nice day!");
				} else {
					System.out.println("Please enter a valid menu option.\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nPlease enter a valid data type(Integer number)\n");
			} finally {
				input.nextLine();// Refreash
			}
		} while (choice != 6);
		input.close();
	}
}