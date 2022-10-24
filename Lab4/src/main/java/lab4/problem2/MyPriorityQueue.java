package lab4.problem2;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Priority Queue ADT implemented by Linked List
 *
 * @param <E> comparable element
 */
public class MyPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {

  private LinkedList<E> linkedList;
  final private String ACCESS_PRIORITY_QUEUE_ERROR_MESSAGE = "The priority queue is empty.";
  final private int ZERO = 0;

  /**
   * Constructs the MyPriorityQueue object
   *
   * @param linkedList the internal linked list
   */
  public MyPriorityQueue(LinkedList<E> linkedList) {
    this.linkedList = linkedList;
  }

  /**
   * Inserts an element to the priority queue
   *
   * @param e The element to insert
   */
  @Override
  public void insert(E e) {
    LinkedList<E> internalLinkedList = this.getLinkedList();
    E head = internalLinkedList.peekFirst();
    if (e.compareTo(head) > 0) {
      internalLinkedList.addFirst(e);
    } else {
      int index = 0;
      while (index < internalLinkedList.size() && internalLinkedList.get(index).compareTo(e) > 0) {
        index++;
      }
      internalLinkedList.add(index, e);
    }
  }

  /**
   * Removes and returns the object at the front
   *
   * @return the object at the front
   */
  @Override
  public E remove() throws AccessEmptyPriorityQueueError {
    if (this.isEmpty()) {
      throw new AccessEmptyPriorityQueueError(this.ACCESS_PRIORITY_QUEUE_ERROR_MESSAGE);
    }
    return this.getLinkedList().removeFirst();
  }

  /**
   * Returns the object at the front without changing the Priority Queue
   *
   * @return the object at the front
   */
  @Override
  public E front() throws AccessEmptyPriorityQueueError {
    if (this.isEmpty()) {
      throw new AccessEmptyPriorityQueueError(this.ACCESS_PRIORITY_QUEUE_ERROR_MESSAGE);
    }
    return this.getLinkedList().peekFirst();
  }

  /**
   * Checks the Priority Queue is empty
   *
   * @return empty or not boolean state
   */
  @Override
  public boolean isEmpty() {
    return (this.getLinkedList().peekFirst() == null);
  }

  /**
   * Gets the internal linked list
   *
   * @return the internal linked list
   */
  public LinkedList<E> getLinkedList() {
    return this.linkedList;
  }

  /**
   * Tests two priority queue have the same contents or not
   *
   * @param o tested priority queue
   * @return boolean result
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    MyPriorityQueue<E> myPriorityQueue = (MyPriorityQueue<E>) o;
    LinkedList<E> list1 = this.getLinkedList();
    LinkedList<E> list2 = myPriorityQueue.getLinkedList();
    if (list1.size() != list2.size()) {
      return false;
    } else {
      for (int i = this.ZERO; i < list1.size(); i++) {
        if (list1.get(i) != list2.get(i)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns the hash code of the priority queue
   *
   * @return hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getLinkedList(), this.ACCESS_PRIORITY_QUEUE_ERROR_MESSAGE);
  }

  @Override
  public String toString() {
    return "Priority queue: " + this.getLinkedList().toString();
  }

}
