package algorithms;

import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * A class to evaluate if two strings are anagrams.
 *
 * Prerequisites:
 * The program will throw an exception if any input string is null.
 * Two strings equals(ignoring case) are not considered anagrams, because characters are not re-arranged.
 * In the evaluation are only considered letter and digits characters.
 *
 * Algorithm:
 * I tried to provide hopefully a readable solution, using a functional style programming.
 * Also, I paid attention to the performance, that is linear in space and time.
 * The map seems to me a good data structure to face the problem, where I can save all the occurrences for each character of
 * the two strings. After that I can check if the map has at least one char with an odd occurrence value, it means that
 * the strings are not anagrams.
 *
 */
public class AnagramsEvaluator {

  public boolean evaluate(String first, String second) {
    if(first == null || second == null) {
      throw new IllegalArgumentException("Input argument cannot be null");
    }

    return stringNotAnagramOfItSelf()
        .and(checkAreAnagram())
        .test(first, second);
  }

  private static BiPredicate<String, String> checkAreAnagram() {
    return (first, second) -> {
      var totalString = first + second;

      var charsOccurrences = totalString
          .chars()
          .filter(Character::isLetterOrDigit)
          .mapToObj(Character::toString)
          .map(String::toLowerCase)
          .collect(groupingBy(Function.identity(), counting()));

      return charsOccurrences.entrySet()
          .parallelStream()
          .noneMatch(oddCharOccurrences());
    };
  }

  private static BiPredicate<String, String> stringNotAnagramOfItSelf() {
    return (first, second) -> !first.equalsIgnoreCase(second);
  }

  private static Predicate<Entry<String, Long>> oddCharOccurrences() {
    return entry -> entry.getValue() % 2 != 0;
  }

}
