import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
* Program finds a number using insertion sort.
*
* @author Titwech Wal
* @version 1.0
* @since   2023-06-09
*/

public final class InsertSort {

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private InsertSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Take from the input file.
        final File input = new File("input.txt");

        // Display in the output file.
        final File output = new File("output.txt");

        // Create a list to store the input lines.
        final List<String> inputLines = new ArrayList<>();

        try {

            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(output);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(input);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            // Read the input file line by
            // Line and add each line to the list.
            while (sc.hasNextLine()) {
                // Read next line as a string
                final String line = sc.nextLine();

                // Add to list.
                inputLines.add(line);
            }

            // Process each line in the input file.
            for (String inputLine : inputLines) {
                try {
                    // Split the line into individual numbers.
                    final String[] numberStrings = inputLine.split(" ");
                    final int[] numbers = new int[numberStrings.length];

                    // Convert the number strings to integers.
                    for (int counter = 0; counter
                            < numberStrings.length; counter++) {
                        numbers[counter] =
                                    Integer.parseInt(numberStrings[counter]);
                    }

                    // Sort the array using the Insertion Sort algorithm.
                    final int[] sortedArray = sortInsert(numbers);

                    // Write the sorted array to the output file.
                    write.println(Arrays.toString(sortedArray));

                } catch (NumberFormatException e) {
                    // Write an error message for invalid input.
                    write.println("Invalid input!");
                }
            }
            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            System.out.println("An error occurred: "
                + error.getMessage());
        }
    }

    /**
     * Sort the array of integers using
     * Insertion Sort.
     *
     * @param array
     *
     * @return sorted array
     *
     */

    public static int[] sortInsert(int[] array) {
        for (int counter1 = 1; counter1 < array.length; counter1++) {
            final int current = array[counter1];
            int counter2 = counter1 - 1;

            // Shift elements to the right
            // to make space for the current element.
            while (counter2 >= 0 && array[counter2] > current) {
                array[counter2 + 1] = array[counter2];
                counter2--;
            }
            // Place the current element at its correct position.
            array[counter2 + 1] = current;
        }
        return array;
    }
}

