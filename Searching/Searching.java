/**
 * <h1>Searching</h1>
 * This class demonstrates in depth understanding of search techniques.
 *
 * @author  Craig Opie
 * @version 1.0, 09/27/19
 * @throws  Exception
 * @class   Searching
 * @concept The core concept for this lesson is the ability to code the linear and binary search.
 *
 */
import java.util.Scanner;   // Required for user input
import java.lang.Math;      // Used to generate random numbers to populate the intList

/**
 * <h2>Searching Class</h2>
 * Demonstrates linear and binary search techniques.
 *
 * @param intList    Stores twenty randomly generated integers (Local List).
 * @param userInput  Stores the user's input for exiting the program (Local Variable).
 *
 */
public class Searching {

    // Program entry point
    public static void main(String[] args) throws Exception {

        // Inform the user about this program
        System.out.println("This program demonstrates in depth understanding of linear and binary searches.");

        // Create scanner object to capture user input
        Scanner input_ = new Scanner(System.in);
        char userInput = 'y';
        int value_ = 0;
        int sortType = 0;
        int searchType = 0;
        boolean firstRun = true;
        boolean found = false;

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

        // Create overall program loop
        boolean condition = false;
        while (condition == false) {
            boolean loop_ = true;

            // Tell the user what you want for an input
            if (firstRun == false) {
                System.out.print("Would you like to search again? (y/n): ");
            } else {
                System.out.print("Would you like to search for a number in the list? (y/n): ");
            }
            firstRun = false;

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

                while(loop_) {
                    System.out.println("What value would you like to search for?");
                    try {
                        value_ = input_.nextInt();
                        loop_ = false;
                    }

                    // The user did not enter a valid integer so inform them and clear the input buffer
                    catch (Exception e) {
                        System.out.println("Error: Input must be an integer.  Please try again.");
                        input_.nextLine();
                        System.out.println();
                        loop_ = true;
                    }
                }

                loop_ = true;
                while(loop_) {
                    System.out.println("Which search technique should be used (1 for linear or 2 for binary)?");
                    try {
                        searchType = input_.nextInt();

                        if (searchType == 1) {
                            found = Linear(intList, 0, intList.length-1, value_);
                            if (found == true) {
                                System.out.println("Using a linear search, " + Integer.toString(value_) + " was found in the list.");
                            }
                            else {
                                System.out.println("Using a linear search, " + Integer.toString(value_) + " was not found in the list.");
                            }
                            loop_ = false;
                        }
                        else if (searchType == 2) {
                            intList = BubbleSort(intList);
                            found = Binary(intList, 0, intList.length-1, value_);
                            if (found == true) {
                                System.out.println("Using a binary search, " + Integer.toString(value_) + " was found in the list.");
                            }
                            else {
                                System.out.println("Using a binary search, " + Integer.toString(value_) + " was not found in the list.");
                            }
                            loop_ = false;
                        }
                        else {
                            System.out.println("Please choose either 1 or 2.");
                        }
                    }

                    // The user did not enter a valid integer so inform them and clear the input buffer
                    catch (Exception e) {
                        System.out.println("Error: Input must be an integer.  Please try again.");
                        input_.nextLine();
                        System.out.println();
                    }
                }
            }
        }
    }

    /**
     * <h2>Bubble Sort</h2>
     * This method sorts the list that is provided using a bubble sort.
     *
     * @param intList     This is the list of integers to be sorted.
     * @param condition This value causes the loop to break if the sort is complete.
     * @param max_      This value is the base during sorting passes.
     * @return  intList   Returns the list after being sorted.
     *
     */
    public static int[] BubbleSort(int[] intList) {

        // Create a loop that continues until the sort is complete
        boolean condition = true;
        while (condition) {

            // Assume the sort is complete unless a value's position is changed
            condition = false;
            for (int i = 0; i < (intList.length - 1); i++) {
                int max_ = intList[i];
                if (max_ >= intList[i + 1]) {
                    condition = true;
                    max_ = intList[i + 1];
                    intList[i + 1] = intList[i];
                    intList[i] = max_;
                }
            }
        }
        return(intList);
    }

    /**
     * <h2>Linear</h2>
     * This method uses a linear search method through the list to find a specific item.
     *
     */
    public static boolean Linear(int[] intList, int lower_, int upper_, int value_) {

        if (upper_ < lower_) return false;
        if (intList[upper_] == value_) return true;
        if (intList[lower_] == value_) return true;
        return Linear(intList, lower_ + 1, upper_ - 1, value_);
    }

    /**
     * <h2>Binary</h2>
     * This method uses a binary search method through the list to find a specific item.
     *
     */
    public static boolean Binary(int[] intList, int lower_, int upper_, int value_) {

        // Declare required vairables
        int mid_ = (int)((lower_ + (upper_ - 1)) / 2);

        if (upper_ < lower_) return false;
        if (intList[mid_] == value_) return true;
        if (value_ < intList[mid_]) return Binary(intList, lower_, mid_ - 1, value_);
        else return Binary(intList, mid_ + 1, upper_, value_);
    }
}
