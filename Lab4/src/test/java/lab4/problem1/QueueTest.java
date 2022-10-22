package lab4.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {

  private ArrayDeque<Integer> testQueue;
  private Integer expectedItem;

  @BeforeEach
  void setUp() {
    testQueue = new ArrayDeque<>();
    expectedItem = 5;
  }

  @Test
  void enqueue() {
    testQueue.addLast(expectedItem);
    assertEquals(expectedItem, testQueue.peek());
  }

  @Test
  void dequeue() {
    testQueue.addLast(expectedItem);
    assertEquals(expectedItem, testQueue.pop());
  }

  @Test
  void front() {
    testQueue.addLast(expectedItem);
    assertEquals(expectedItem, testQueue.peekFirst());
  }
}
