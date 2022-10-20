package problem1;

/**
 * Error object when the product is out of stock by the purchased quantity
 *
 * @author ycleo
 */
public class ProductStockNotEnoughError extends Throwable {

  /**
   * Constructs the ProductStockNotEnoughError with the error message
   *
   * @param message the error message
   */
  public ProductStockNotEnoughError(String message) {
    super(message);
  }
}
