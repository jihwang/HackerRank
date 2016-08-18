import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Read input from STDIN. Print output to STDOUT. Your class should be named Solution.

public class Solution {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      final int numberOfCases = scanner.nextInt();

      for(int i = 0; i < numberOfCases; i++) {
        final int sizeOfArray = scanner.nextInt();
        final int [] subsequence = getIntArray(sizeOfArray, scanner);
        final int [] weights = getIntArray(sizeOfArray, scanner);
        System.out.println(getWeight(subsequence, weights));
      }
    }

    private static int getWeight(int [] subsequence, int [] weights) {
      final int size = subsequence.length;
      int [] results = new int[size];
      results[0] = weights[0];
      int max = results[0];

      for(int j = 1; j < size; j++) {
        final int difference = subsequence[j] - subsequence[j-1];

        // Non increasing, use only own weight
        if (difference <= 0) {
          results[j] = weights[j];
        } else {
          results[j] = weights[j] + results[j-1];
        }
        if(results[j] > max) {
          max = results[j];
        }
      }
      return max;
    }

    private static int [] getIntArray(int sizeOfArray, Scanner scanner) {
      int [] array = new int[sizeOfArray];
      for(int j = 0; j < sizeOfArray; j++) {
        if(scanner.hasNextInt()) {
          array[j] = scanner.nextInt();
        } else {
          System.out.println("Size does not match inputA");
        }
      }
      return array;
    }
}

// 2
// 4
// 1 2 3 4
// 10 20 30 40
// 8
// 1 2 3 4 1 2 3 4
// 10 20 30 40 15 15 15 50
