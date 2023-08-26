/**
 * @ Nikunj Gupta 
 * This program utilizes user inputs to determine the shape, direction and dimensions of the figure.
 * This program then prints either a solid or the border of the shape based on user choice. 
 */

// imports the scanner class to enable user input
import java.util.Scanner;

public class Unit6Lab {

	public static void main(String[] args) {

		// Utilizes the scanner class for user input
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome! This program will draw a geometry figure of your choice.\n ");

		int selection;
		// Uses do while loop to check if user wants to continue the program again
		do {
			// Prints different options for user such as shape type and whether to continue
			System.out.println(" ");
			System.out.println("Make your choice from the following:\n" + "1 a square\n" + "2 a rectangle\n"
					+ "3 a triangle\n" + "-1 to quit");
			selection = input.nextInt();

			// Checks if the user wants a shape
			if (selection == 1) {
				System.out.println("What is the side length of the square? ");
				int side = input.nextInt();

				System.out.println("Border-only or solid (enter border/solid) ");
				String border = input.next();

				System.out.println("Character to use for drawing? ");
				String character = input.next();

				if (border.equals("solid")) {
					squareSolid(side, character);
				}

				else {
					squareBorder(side, character);
				}

			}

			// Checks if the user wants a rectangle
			if (selection == 2) {
				System.out.println("What is the width? ");
				int width = input.nextInt();

				System.out.println("What is the height? ");
				int height = input.nextInt();

				System.out.println("Border-only or solid (enter border/solid) ");
				String border = input.next();

				System.out.println("Character to use for drawing? ");
				String character = input.next();

				if (border.equals("border")) {
					rectangleBorder(width, height, character);
				}

				else {
					rectangleSolid(width, height, character);
				}

			}

			// Checks if the user wants a triangle
			if (selection == 3) {
				System.out.println("What is the height? ");
				int height = input.nextInt();

				System.out.println("Point up or down (enter up/down) ");
				String direction = input.next();

				System.out.println("Border-only or solid (enter border/solid) ");
				String border = input.next();

				System.out.println("Character to use for drawing? ");
				String character = input.next();

				if (direction.equals("up") && border.equals("solid")) {
					upSolidTriangle(height, character);
				}

				if (direction.equals("down") && border.equals("solid")) {
					downSolidTriangle(height, character);
				}

				if (direction.equals("up") && border.equals("border")) {
					upBorderTriangle(height, character);
				}

				if (direction.equals("down") && border.equals("border")) {
					downBorderTriangle(height, character);
				}
			}

			if (selection == -1) {
				System.out.println("Thank you and have a great day! ");
				break;
			}

		} while (selection != -1);

	}

	// Creates method for square border
	public static void squareBorder(int side, String character) {
		for (int i = 0; i < side; i++) {
			System.out.print(character);
		}
		System.out.println(" ");
		for (int i = 1; i < side - 1; i++) {
			for (int j = 0; j < side; j++) {
				if (j == 0 || j == side - 1) {
					System.out.print(character);
				}

				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < side; i++) {
			System.out.print(character);
		}

	}

	// Creates method for square solid
	public static void squareSolid(int side, String character) {
		for (int i = 0; i < side; i++) {
			System.out.println("");
			for (int j = 0; j < side; j++) {
				System.out.print(character);
			}
		}
	}

	// Creates method for rectangle border
	public static void rectangleBorder(int width, int height, String character) {
		for (int i = 0; i < width; i++) {
			System.out.print(character);
		}
		System.out.println(" ");
		for (int i = 1; i < height - 1; i++) {
			for (int j = 0; j < width; j++) {
				if (j == 0 || j == width - 1) {
					System.out.print(character);
				}

				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < width; i++) {
			System.out.print(character);
		}

	}

	// Creates method for rectangle solid
	public static void rectangleSolid(int width, int height, String character) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(character);
			}
			System.out.println();
		}
	}

	// Creates method for upward facing solid triangle
	public static void upSolidTriangle(int height, String character) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= 2 * height - 1; j++) {
				if (j >= height - (i - 1) && j <= height + (i - 1)) {
					System.out.print(character);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
	}

	// Creates method for downward facing solid triangle
	public static void downSolidTriangle(int height, String character) {
		for (int i = height; i >= 1; i--) {
			for (int j = (height * 2) - 1; j >= 1; j--) {
				if (j >= height - (i - 1) && j <= height + (i - 1)) {
					System.out.print(character);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
	}

	// Creates method for upward facing border triangle
	public static void upBorderTriangle(int height, String character) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= 2 * height - 1; j++) {
				if (j == height - (i - 1) || j == height + (i - 1)) {
					System.out.print(character);
				} else if (i == height) {
					for (j = 1; j <= 2 * height - 2; j++) {
						System.out.print(character);
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
	}

	// Creates method for downward facing border triangle
	public static void downBorderTriangle(int height, String character) {
		for (int i = height; i >= 1; i--) {
			if (i == height) {
				for (int k = 1; k <= (2 * height) - 1; k++) {
					System.out.print(character);
				}
			}
			for (int j = (height * 2) - 1; j >= 1; j--) {
				if (i == height) {
					continue;
				} else if (j == height - (i - 1) || j == height + (i - 1)) {
					System.out.print(character);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
	}

}
