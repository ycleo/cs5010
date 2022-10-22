package lab4.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class StackTest {

  private Stack<Integer> testStack;
  private Integer item1;
  private Integer item2;

  @BeforeEach
  void setUp() {
    testStack = new Stack<>();
    item1 = 5;
    item2 = 6;
    testStack.push(item1);
  }

  @Test
  void push() {
    assertEquals(item1, testStack.peek());
  }

  @Test
  void remove() {
    testStack.push(item2);
    assertEquals(item2, testStack.pop());
  }

  @Test
  void top() {
    testStack.push(item2);
    assertEquals(item2, testStack.peek());
  }
}
