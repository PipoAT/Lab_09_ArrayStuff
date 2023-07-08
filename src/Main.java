import java.util.Random; // import random for use with array

public class Main {
    public static void main(String[] args) {
        // Step 1A: Declare Array of type int of length 100, dataPoints
        int[] dataPoints = new int[100];

        // Step 1B: Code loop that iterates through array and initializes
        // each element to a random value between 1 and 100
        Random rand = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1; // range of random number between 1 and 100
        }

        // Step 1C: Code second loop that displays the values
        // format: value | nextValue | ...
        for (int j = 0; j < dataPoints.length; j++) {
            System.out.print(dataPoints[j]); // prints out the dataPoint at specified location
            System.out.print(" | "); // adds space, |, space
        }

        // Step 1D: Code loop to calculate sum and average of the
        // values in array
        int sumOfArrayValues = 0; // initializes the variable for the sum
        double averageOfArrayValues = 0; // initializes the variable for the average
        for (int k = 0; k < dataPoints.length; k++) {
            sumOfArrayValues += dataPoints[k]; // adds each data value in array to the sum
        }
        averageOfArrayValues = (double) sumOfArrayValues / dataPoints.length; // takes the sum and averages over the length of the array

        // print out the sum and average
        System.out.println("\n"); // for new line after array
        System.out.println("The sum of the values in dataPoints is: " + sumOfArrayValues);
        System.out.println("The average of the values in dataPoints is: " + averageOfArrayValues);

    }
}