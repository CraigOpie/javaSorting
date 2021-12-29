/**
 * <h1>Selection Sort</h1>
 * This class demonstrates in depth understanding of selection sort techniques.
 *
 * @author  Craig Opie
 * @version 1.0, 09/20/19
 * @throws  Exception
 * @class   SelectionSort
 * @concept The core concept for this lesson is the ability to code the selection sort.
 *
 */
import java.util.Scanner;   // Required for user input
import java.lang.Math;      // Used to generate random numbers to populate the intList

/**
 * <h2>SelectionSort Class</h2>
 * Demonstrates selection sort techniques.
 *
 * @param intList    Stores twenty randomly generated integers (Local List).
 * @param userInput  Stores the user's input for exiting the program (Local Variable).
 *
 */
public class SelectionSort {

    // Program entry point
    public static void main(String[] args) throws Exception {

        // Inform the user about this program
        System.out.println("This program demonstrates in depth understanding of Selection Sorting.");

        // Create scanner object to capture user input
        Scanner input_ = new Scanner(System.in);
        char userInput = 'y';

        // Create overall program loop
        boolean condition = false;
        while (condition == false) {

            // Tell the user what you want for an input
            System.out.print("Would you like to run this program (y/n)?: ");

            // Verify the user entered an appropriate value
            try {
                userInput = input_.next().charAt(0);
                if (userInput != 'n' && userInput != 'N' && userInput != 'y' && userInput != 'Y') throw new Exception();

                // The user wants to exit the program
                if (userInput == 'n' || userInput == 'N') {
                    condition = true;
                    break;
                }
            }

            // The user did not enter a valid value so inform them and clear the input buffer
            catch (Exception e) {
                System.out.println("Error: Input must be 'y' or 'n'.  Please try again.");
                input_.nextLine();
                System.out.println();
            }

            // The user wants to run the program
            if (userInput == 'y' || userInput == 'Y') {
                // Create a list of twenty integers
                int[] intList = new int[20];

                // Populate the list of integers with random numbers between 1 and 1000
                for (int i = 0; i < intList.length; i++) {
                    intList[i] = (int)(Math.random() * (1000 - 1) + 1) + 1;
                }

                // Display the unsorted list
                System.out.print("Unsorted list:");
                for (int i = 0; i < intList.length; i++) {
                    System.out.print(" " + Integer.toString(intList[i]));
                }
                System.out.println();

                // Sort the list
                Sort(intList);
            }
        }
    }

    /**
     * <h2>Sort</h2>
     * This method sorts the list that is provided using a selection sort.
     *
     * @param max_   This value is the base during sorting passes.
     *
     */
    public static void Sort(int[] list_) {

        // Sort the list
        for (int i = 0; i < (list_.length - 1); i++) {

            // Establish the base max value
            int max_ = list_[i];
            for (int x = i; x < list_.length; x++) {
                if (max_ >= list_[x]) {
                    max_ = list_[x];
                    list_[x] = list_[i];
                    list_[i] = max_;
                }
            }

            // Display the results of each pass
            System.out.print("Pass " + Integer.toString(i+1) + ":");
            for (int y = 0; y < list_.length; y++) {
                System.out.print(" " + Integer.toString(list_[y]));
            }
            System.out.println();
        }
        System.out.println();
    }
}
