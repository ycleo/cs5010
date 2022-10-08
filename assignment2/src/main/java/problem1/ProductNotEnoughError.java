package problem1;

public class ProductNotEnoughError extends Throwable {
  public ProductNotEnoughError(String message) {
    super(message);
  }
}
