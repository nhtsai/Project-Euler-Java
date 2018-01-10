/**
 * Project Euler Problem 12 - Highly Divisible Triangular Number:
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
 * The first ten terms would be:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 *
 * What is the value of the first triangle number to have over five
 * hundred divisors?
 *
 * @author  Nathan Tsai
 * @version 1.0, 5 Jan 2018
 * @since   5 Jan 2018
 */

public class Problem12 {

  /**
   * Runs the program and prints the solution of the problem to System.out.
   *
   * @param args the input taken in from the command line during runtime
   */
  public static void main(String[] args) {
    System.out.printf("The triangle number with over 500 divisors is: %d," +
    " which has an index of %d.\n", triangle(indexDiv(500)), indexDiv(500));
  }

  /**
   * Returns the index of the triangle number with the number of divisors
   * greater than the specified minDivisors value by iterating through
   * triangle numbers until getting the desired divisor count value.
   *
   * @param  minDivisors the minimum amount divisors to exceed
   * @return             the index of the triangular number with over
   *                     the specified amount divisors
   */
  public static int indexDiv(int minDivisors) {

    int i = 1;

    // Iterate through triangular numbers until one has divisors greater
    // than minDivisors, then return the index of the triangular number.
    while (true) {
      if (numDivisors(triangle(i)) > minDivisors) {
        return i;
      }
      else {
        i++;
      }
    }
  }

  /**
   * Returns the triangular number at the specified index by adding all of the
   * numbers from 1 to the index number, inclusive.
   *
   * @param  index the index of the triangular number
   * @return       the value of the triangular number at the specified index
   */
  public static long triangle(int index) {

    long triangularNum = 0;

    // Follow definition of triangular number and add the counting numbers.
    for (int i = 1; i <= index; i++) {
      triangularNum += i;
    }
    return triangularNum;
  }

  /**
   * Returns the number of divisors a triangular number has by iterating
   * through numbers and counting the divisors.
   *
   * @param  triangularNum the triangular number calculate the number of
   *                       its divisors
   * @return               the number of divisors of a triangular number
   */
  public static int numDivisors(long triangularNum) {
    int divisors = 2;

    // Iterate through numbers to find number of divisors
    // Utilize square of number to count divisor pairs, rather than one by one
    for (int i = 1; i*i < triangularNum; i++) {
      if (triangularNum % i == 0) {
        divisors += 2;
      }
    }
    return divisors;
  }
} // End class Problem12