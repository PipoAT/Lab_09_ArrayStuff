import java.util.Random; // import random for use with array
import java.util.Scanner; // import scanner for user input

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
        // averageOfArrayValues = (double) sumOfArrayValues / dataPoints.length; // takes the sum and averages over the length of the array

        // Step 3 Sum Refactor and Recode
        sumOfArrayValues = sum(dataPoints);
        averageOfArrayValues = getAverage(dataPoints);

        // print out the sum and average for Step 1D/3
        System.out.println("\n"); // for new line after array
        System.out.println("The sum of the values in dataPoints is: " + sumOfArrayValues);
        System.out.println("The average of the values in dataPoints is: " + averageOfArrayValues);


        // Step 2A Add user prompt for int between 1 and 100
        Scanner in = new Scanner(System.in); // initialize scanner for user input
        int userValue = SafeInput.getRangedInt(in, "Please enter a value between 1 and 100: ",1, 100);

        // Step 2B Iterate through array and add count of number
        // of occurrences the userValue is in array.
//        int countOfUserValue = 0; // initialize counter
//        for (int l = 0; l < dataPoints.length; l++) {
//            if (dataPoints[l] == userValue) {
//                countOfUserValue++; // add 1 to counter for each occurrence
//            }
//        }

        // Step 3 occurrenceScan Refactor and Recode
        int countOfUserValue = occurrenceScan(dataPoints, userValue);

        // output results for step 2B/3
        System.out.println("The value " + userValue + " was found " + countOfUserValue + " times in the dataPoints array.");

        // Step 2C Prompt for second user input of same parameters
        // iterate through array and on first instance of input being found
        // break loop and display position

        int secondUserValue = SafeInput.getRangedInt(in, "Please enter another value between 1 and 100: ",1, 100);

        int position = -1; // initialize position
//        for (int m = 0; m < dataPoints.length; m++) {
//            // check for the first time the value matches
//            if (dataPoints[m] == secondUserValue) {
//                // set position and break loop
//                position = m;
//                break;
//            }
//        }
        // Step 3 contains Refactor and Recode
        if (contains(dataPoints, secondUserValue)) {
          for (int y = 0; y < dataPoints.length; y ++) {
              if (dataPoints[y] == secondUserValue) {
                  position = y;
                  break;
              }
          }
        }


        // output results for Step 2C/3
        if (position != -1) {
            System.out.println("The value " + secondUserValue + " was found at array index " + position + ".");
        } else {
            System.out.println("The value " + secondUserValue + " was not found in the dataPoints array.");
        }

          // Step 2D Code loop that determines the max and min of the array and display to user
//        int max = dataPoints[0]; // assume that max and min are the first value of array
//        int min = dataPoints[0]; // initially until loop runs
//        for (int n = 0; n < dataPoints.length; n++) {
//            if (dataPoints[n] < min) {
//                min = dataPoints[n]; // if the next value is less than min, set new min
//            }
//            if (dataPoints[n] > max) {
//                max = dataPoints[n]; // if next value is larger than max, set new max
//            }
//        }

        // Step 3 Max/Min Refactoring and Recoding
        int min = min(dataPoints);
        int max = max(dataPoints);

        // output results for step 2D/3
        System.out.println("The minimum value in the dataPoints array is: " + min);
        System.out.println("The maximum value in the dataPoints array is: " + max);

        // Step 2E create getAverage method to return average of array
        // output results
        double average = getAverage(dataPoints);
        System.out.println("Average of dataPoints is: " + average);

    }

    public static double getAverage(int[] values)
    {
        int sum = 0; // initialize sum for array values
        for (int v = 0; v < values.length; v++) {
            sum += values[v]; // like above, add each array value to sum
        }
        return (double) sum / values.length; // return the average via calculation
    }

    // Step 3 (Extra Credit) Refactor program using below array methods
    public static int min(int[] values) { // returns min value found
        int min = values[0]; // initialize min as the first element
        for (int value : values) {
            if (value < min) { // checks if the next value is less than min
                min = value; // set new min if true
            }
        }

        return min; // returns min
    }

    public static int max(int[] values) { // returns max value found
        int max = values[0]; // initialize max as first element
        for (int value: values) {
            if (value > max) { // checks if next value is larger than max
                max = value; // sets max to new value if true
            }
        }

        return max;
    }

    public static int occurrenceScan(int[] values, int target) {
        int countOfUserValue = 0; // initialize counter
        for (int value : values) {
            if (value == target) {
                countOfUserValue++; // add 1 to counter for each occurrence
            }
        }

        return countOfUserValue;
    } // returns the number of times target is found

    public static int sum(int[] values) {
        int sum = 0; // initialize variable for sum
        for (int value : values) {
            sum += value; // adds each element to sum/total
        }
        return sum;
    } // returns the sum of values of array

    public static boolean contains(int[] values, int target) {
        for (int value : values) { // runs through array
            if (value == target) { // checks for first instance of target
                return true; // returns true if target exists
            }
        }
        return false; // returns false if target does not exist
    }

}