package lab4.problem2;

/**
 * Describe an priority queue ADT
 *
 * @param <E> The data type to store in the ADT
 */
public interface PriorityQueue<E> {

  /**
   * Inserts an element to the priority queue
   *
   * @param e The element to insert
   */
  void insert(E e);

  /**
   * Removes and returns the object at the front
   *
   * @return the object at the front
   */
  E remove() throws AccessEmptyPriorityQueueError;

  /**
   * Returns the object at the front without changing the Priority Queue
   *
   * @return the object at the front
   */
  E front() throws AccessEmptyPriorityQueueError;

  /**
   * Checks the Priority Queue is empty
   *
   * @return empty or not boolean state
   */
  boolean isEmpty();

  /**
   * Tests two priority queue have the same contents or not
   *
   * @param o tested priority queue
   * @return boolean result
   */
  @Override
  boolean equals(Object o);

  /**
   * Returns the hash code of the priority queue
   *
   * @return hash code value
   */
  @Override
  int hashCode();

  /**
   * Returns the string represents the priority queue information
   *
   * @return String about the priority queue
   */
  @Override
  String toString();
}
