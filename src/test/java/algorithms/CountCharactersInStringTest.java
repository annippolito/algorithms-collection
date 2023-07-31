package algorithms;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountCharactersInStringTest {

  @Test
  @Order(1)
  public void testEmptyString() {
    Map<Character, Integer> d = new HashMap<>();
    assertEquals(d, CountCharactersInString.count(""));
  }

  @Test
  @Order(2)
  public void testSingleCharacter() {
    Map<Character, Integer> d = new HashMap<>();
    d.put('a', 1);
    assertEquals(d, CountCharactersInString.count("a"));
  }

  @Test
  @Order(3)
  public void testMultipleCharacters() {
    Map<Character, Integer> d = new HashMap<>();
    d.put('a', 3);
    d.put('b', 3);
    d.put('c', 1);
    assertEquals(d, CountCharactersInString.count("aabbbac"));
  }

  @Test
  @Order(4)
  public void testAllCharactersUnique() {
    Map<Character, Integer> d = new HashMap<>();
    d.put('a', 1);
    d.put('b', 1);
    d.put('c', 1);
    assertEquals(d, CountCharactersInString.count("abc"));
  }

  @Test
  @Order(5)
  public void testAllCharactersSame() {
    Map<Character, Integer> d = new HashMap<>();
    d.put('a', 5);
    assertEquals(d, CountCharactersInString.count("aaaaa"));
  }

  @Test
  @Order(6)
  public void testDifferentCharacters() {
    Map<Character, Integer> expected = new HashMap<>();
    expected.put('a', 2);
    expected.put('b', 2);
    Map<Character, Integer> actual = CountCharactersInString.count("aabb");
    assertEquals(expected, actual);
  }
}