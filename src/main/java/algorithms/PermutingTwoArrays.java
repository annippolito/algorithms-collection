package algorithms;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * There are two n-element arrays of integers, A and B. Permute them into some A' and B' such that the relation A'[i] + B'[i] >= k holds for all i where 0 <= i <= n.
 * There will be q queries consisting of A, B, and k. For each query, return YES if some permutation , A',B' satisfying the relation exists. Otherwise, return NO.
 * Example
 * A = [0,1], B = [0,2], k = 1
 * A valid A', B' is A' = [1,0] and B' = [0,2]. Return YES.
 * Input:
 * - int k: an integer
 * - int A[n]: an array of integers
 * - int B[n]: an array of integers
 * Output:
 * - string: either YES or NO
 */

public final class PermutingTwoArrays {

  private PermutingTwoArrays() {}

  public static String twoArrays(int k, List<Integer> first, List<Integer> second) {
    if(first.size() != second.size()) {
      return "NO";
    }

    first.sort(Integer::compareTo);
    second.sort(Comparator.reverseOrder());

    var lowerPairs = IntStream.range(0, first.size())
        .anyMatch(i -> first.get(i) + second.get(i) < k);

    return lowerPairs ? "NO":"YES";
  }

}
