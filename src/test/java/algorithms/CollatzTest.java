package algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

class CollatzTest {

  @ParameterizedTest
  @ValueSource(strings = {
      "6, 3, 10, 5, 16, 8, 4, 2, 1",
      "12, 6, 3, 10, 5, 16, 8, 4, 2, 1",
      "19, 58, 29, 88, 44, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1",
      "27, 82, 41, 124, 62, 31, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1"
  })
  @DisplayName("Should return the expected sequence for valid inputs")
  void shouldReturnTheExpectedSequence(final String sequence) {
    int input = parseInt(sequence.split(",")[0]);
    assertAll(
        ()-> assertEquals(sequence, Collatz.collatz(input, new LinkedList<>()), "Tail version should return the expected sequence for valid inputs"),
        ()-> assertEquals(sequence, Collatz.collatzNonTail(input), "Non tail version should return the expected sequence for valid inputs")
    );
  }

  @ParameterizedTest
  @ValueSource(ints = { -5, 0 })
  @DisplayName("Tail collatz should throw Exception for zero and negatives")
  void tailShouldThrowIllegalArgumentException(int n) {
    String expectedMessage = "N should be greater than zero!";
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> Collatz.collatz(n, new LinkedList<>()));
    assertEquals(expectedMessage, exception.getMessage(), "Tail collatz should throw Exception for zero and negatives");
  }

  @ParameterizedTest
  @ValueSource(ints = { -7, 0 })
  @DisplayName("Non tail collatz should throw Exception for zero and negatives")
  void nonTailShouldThrowIllegalArgumentException(int n) {
    String expectedMessage = "N should be greater than zero!";
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> Collatz.collatzNonTail(n));
    assertEquals(expectedMessage, exception.getMessage(), "Non tail collatz should throw Exception for zero and negatives");
  }

}
