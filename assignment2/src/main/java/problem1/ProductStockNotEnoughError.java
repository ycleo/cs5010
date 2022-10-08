package problem1;

public class ProductStockNotEnoughError extends Throwable {

  public ProductStockNotEnoughError(String message) {
    super(message);
  }
}
