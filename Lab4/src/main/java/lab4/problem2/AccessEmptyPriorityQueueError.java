package lab4.problem2;

/**
 * Error when performing remove or font operations on an empty priority queue
 */
public class AccessEmptyPriorityQueueError extends Throwable {

  /**
   * Constructs error by error message
   *
   * @param message error message
   */
  public AccessEmptyPriorityQueueError(String message) {
    super(message);
  }

}
