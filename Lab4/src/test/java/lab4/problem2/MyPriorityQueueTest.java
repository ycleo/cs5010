package lab4.problem2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyPriorityQueueTest {

  private MyPriorityQueue<Integer> testPriorityQueue;
  private MyPriorityQueue<Integer> expectedPriorityQueue;
  private LinkedList<Integer> expectedLinkedList;
  private Integer expectedItem;

  @BeforeEach
  void setUp() {
    this.expectedLinkedList = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 5));
    this.testPriorityQueue = new MyPriorityQueue<>(this.expectedLinkedList);
    // {0, 1, 2, 5}
    this.expectedItem = -3;

  }

  @Test
  void insert() {
    this.expectedPriorityQueue = new MyPriorityQueue<>(
        new LinkedList<Integer>(Arrays.asList(0, 1, 2, 5, -3)));
    this.testPriorityQueue.insert(this.expectedItem);
    assertEquals(this.expectedPriorityQueue, this.testPriorityQueue);
  }

  @Test
  void remove() throws AccessEmptyPriorityQueueError {
    this.expectedPriorityQueue = new MyPriorityQueue<>(
        new LinkedList<Integer>(Arrays.asList(1, 2, 5)));
    assertEquals(0, testPriorityQueue.remove());
    assertEquals(this.expectedPriorityQueue, this.testPriorityQueue);
  }

  @Test
  void front() throws AccessEmptyPriorityQueueError {
    assertEquals(0, this.testPriorityQueue.front());
  }

  @Test
  void isEmpty() {
    assertFalse(this.testPriorityQueue.isEmpty());
    this.testPriorityQueue.getLinkedList().clear();
    assertTrue(this.testPriorityQueue.isEmpty());
  }

  @Test
  void getLinkedList() {
    assertEquals(this.expectedLinkedList, this.testPriorityQueue.getLinkedList());
  }

  @Test
  void equals_SameObject() {
    assertTrue(testPriorityQueue.equals(testPriorityQueue));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testPriorityQueue.equals(null));
  }

  @Test
  void equals_DifferentObject() {
    assertFalse(testPriorityQueue.equals(expectedItem));
  }

  @Test
  void equals_DifferentLinkedList() {
    this.expectedPriorityQueue = new MyPriorityQueue<>(
        new LinkedList<Integer>(Arrays.asList(1, 2, 5)));
    assertNotEquals(testPriorityQueue, expectedPriorityQueue);
  }

  @Test
  void equals_SamePriorityQueue() {
    this.expectedPriorityQueue = new MyPriorityQueue<>(
        new LinkedList<Integer>(Arrays.asList(0, 1, 2, 5)));
    assertTrue(testPriorityQueue.equals(expectedPriorityQueue));
  }

  @Test
  void testHashCode() {
    assertEquals(
        Objects.hash(this.testPriorityQueue.getLinkedList(), "The priority queue is empty."),
        this.testPriorityQueue.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("Priority queue: [0, 1, 2, 5]", this.testPriorityQueue.toString());
  }
}
