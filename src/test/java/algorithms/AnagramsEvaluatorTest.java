package algorithms;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnagramsEvaluatorTest {

  AnagramsEvaluator underTest;

  @BeforeEach
  void setup() {
    underTest = new AnagramsEvaluator();
  }

  @ParameterizedTest
  @MethodSource("provideIllegalArguments")
  void evaluate_shouldThrowIllegalArgumentException(String first, String second) {

    var ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> underTest.evaluate(first, second));
    Assertions.assertEquals("Input argument cannot be null", ex.getMessage());
  }

  @ParameterizedTest
  @MethodSource("provideArguments")
  void evaluate(String first, String second, boolean areAnagrams) {

    boolean result = underTest.evaluate(first, second);

    Assertions.assertEquals(result, areAnagrams, "[" + first + "] and [" + second + "] are not anagrams");
  }

  static Stream<Arguments> provideArguments() {
    return Stream.of(
        Arguments.of("equals", "equals", false),
        Arguments.of("", "", false),
        Arguments.of("not blank", "bla not kn", true),
        Arguments.of("42", "24", true),
        Arguments.of("string with numbers 12345", "12 string 345 numbers with", true),
        Arguments.of("New York Times", "monkeys write", true),
        Arguments.of("Church of Scientology", "rich-chosen goofy cult", true),
        Arguments.of("McDonald's restaurants", "Uncle Sam's standard rot", true),
        Arguments.of("coronavirus", "carnivorous", true),
        Arguments.of("She Sells Sanctuary", "Santa; shy, less cruel", true)
    );
  }

  static Stream<Arguments> provideIllegalArguments() {
    return Stream.of(
        Arguments.of(null, null),
        Arguments.of(null, "some string"),
        Arguments.of("some string", null)
    );
  }

}