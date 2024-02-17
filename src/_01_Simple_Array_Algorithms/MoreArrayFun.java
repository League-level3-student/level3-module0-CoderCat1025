package _01_Simple_Array_Algorithms;

import java.util.Random;

public class MoreArrayFun {
	//1. Create a main method to test the other methods you write.
	public static void main(String[] args){
		String[] strings = {"a","b","c","d","e"};
		printStrings(strings);
		reversePrintStrings(strings);
		printEveryOtherString(strings);
		printStringsRandom(strings);
	}
	//2. Write a method that takes an array of Strings and prints all the Strings in the array.
	static void printStrings(String[] strings) {
		System.out.println("Strings in order");
		for (int i = 0; i<strings.length; i++) {
			System.out.println(strings[i]);
		}
	}

	//3. Write a method that takes an array of Strings and prints all the Strings in the array
	//   in reverse order.
	static void reversePrintStrings(String[] strings) {
		System.out.println("Strings in reverse order");
		for (int i = strings.length-1; i > -1; i--) {
				System.out.println(strings[i]);
		}
	}


	//4. Write a method that takes an array of Strings and prints every other String in the array.
	static void printEveryOtherString(String[] strings) {
		System.out.println("Every other string");
		boolean canPrint = true;
		for (int i = 0; i<strings.length; i++) {
			if (canPrint) {
				System.out.println(strings[i]);
				canPrint = false;
			} else {
				canPrint = true;
			}
		}
	}

	//5. Write a method that takes an array of Strings and prints all the Strings in the array
	//   in a completely random order. Almost every run of the program should result in a different order.
	static void printStringsRandom(String[] strings) {
		System.out.println("Strings in random order");
		Integer[] alreadyDone = new Integer[strings.length];
		for (int i = 0; i<alreadyDone.length; i++) {
			alreadyDone[i] = -1;
		}
		int random;
		boolean done = false;
		
		for (int i = 0; i<strings.length; i++) {
			done = false;
			random = new Random().nextInt(strings.length);

			for (int o = 0; o<alreadyDone.length; o++) {
				if (random == alreadyDone[o]) {
					done = true;
				}
			}
			if (!done) {
				System.out.println(strings[random]);
				alreadyDone[i] = random;
				
			} else {
i--;
				
			}
		}
	}

}
