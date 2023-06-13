package algorithms;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PermutingTwoArraysTest {

  static List<Integer> A = Arrays.asList(1, 2);
  static List<Integer> B = Arrays.asList(1, 2, 3, 0, 5, 6, 1, 9);
  static List<Integer> C = Arrays.asList(4, 2, 1, 5, 8, 0, 4, 0);

  @Test
  void twoArraysKO() {
    var result = PermutingTwoArrays.twoArrays(5, B, C);

    Assertions.assertEquals("YES", result);
  }

  @Test
  void twoArraysKOWithDifferentSizes() {
    var result = PermutingTwoArrays.twoArrays(5, A, C);

    Assertions.assertNotEquals(A.size(), C.size());
    Assertions.assertEquals("NO", result);
  }

  @Test
  void twoArraysOK() {
    var result = PermutingTwoArrays.twoArrays(6, B, C);

    Assertions.assertEquals("NO", result);
  }
}