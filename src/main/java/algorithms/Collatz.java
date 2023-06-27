package algorithms;

import java.util.List;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

/**
 * A class to calculate the collatz sequence of an int number
 *
 * Provided a recursive implementation of: <a href="https://en.wikipedia.org/wiki/Collatz_conjecture">...</a>
 *
 */
public class Collatz {

  /**
   * Tail recursion
   * @param n is the input int number
   * @param sequence is an accumulator of number step by step
   * @return the sequence as a string
   */
  public static String collatz(int n, List<Integer> sequence) {
    if(n<=0) throw new IllegalArgumentException("N should be greater than zero!");
    sequence.add(n);
    if (n == 1) return stringOf(sequence);
    return collatz(isEven(n)? half(n): tripleAndAddOne(n), sequence);
  }

  /**
   * Non-tail recursion
   * @param n is the input int number
   * @return the sequence as a string
   */
  public static String collatzNonTail(int n) {
    if(n<=0) throw new IllegalArgumentException("N should be greater than zero!");
    if (n == 1) return valueOf(n);
    return n + ", " + collatzNonTail( isEven(n)? half(n) : tripleAndAddOne(n));
  }

  private static int tripleAndAddOne( int n) {
    return 3*n + 1;
  }

  private static int half(int n) {
    return n / 2;
  }

  private static boolean isEven(int n){
    return n % 2 == 0;
  }

  private static String stringOf(List<Integer> sequence){
    return sequence.stream().map(String::valueOf).collect(joining(", "));
  }

}

