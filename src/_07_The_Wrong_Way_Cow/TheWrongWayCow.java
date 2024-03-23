/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
 */

package _07_The_Wrong_Way_Cow;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the [col, row] coordinate position of the
		// head (letter 'c') of the wrong way cow!

		int[] ints = {0, 0};
		int n = 0; 
		int e = 0;
		int s = 0;
		int w = 0;
		int[][] Ncoords = new int[1][2];
		int[][] Ecoords = new int[1][2];
		int[][] Scoords = new int[1][2];
		int[][] Wcoords = new int[1][2];

		for (int o = 0; o < field.length; o++) {
			for (int i = 0; i < field.length; i++) {
				if (field[o][i] == 'c') {
					//w
					if (i < field.length - 1) {
						if (field[o][i+1] == 'o') {
							if (field[o][i+2]=='w') {
								w++;
								Wcoords[0][0] = i;
								Wcoords[0][1] = o;

							}
						}
					}

					//e
					if (i > 1 && field[o][i-1] == 'o') {
						if (field[o][i-2]=='w') {
							e++;
							Ecoords[0][0] = i;
							Ecoords[0][1] = o;

						}
					}

					//s
					if (o > 1 && field[o-1][i] == 'o') {
						if (field[o-2][i]=='w') {
							s++;
							Scoords[0][0] = i;
							Scoords[0][1] = o;

						}
					}

					//n
					if (o < field.length - 1 && field[o+1][i] == 'o') {
						if (field[o+2][i]=='w') {
							n++;
							Ncoords[0][0] = i;
							Ncoords[0][1] = o;
						}	
					}
				}
			}
		}

		if (s==1) {
			ints[0] = Scoords[0][0];
			ints[1] = Scoords[0][1];
			return ints;
		} else if (w==1) {
			ints[0] = Wcoords[0][0];
			ints[1] = Wcoords[0][1];
			return ints;
		} else if (n==1) {
			ints[0] = Ncoords[0][0];
			ints[1] = Ncoords[0][1];
			return ints;
		} else if (e==1) {
			ints[0] = Ecoords[0][0];
			ints[1] = Ecoords[0][1];
			return ints;
		}



		return ints;
	}
}
