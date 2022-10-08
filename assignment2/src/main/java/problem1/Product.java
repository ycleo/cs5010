package problem1;

public interface Product {

  String getManufacturer();

  String getName();

  double getPrice();

  int getMinAgeToBuy();

  @Override
  boolean equals(Object o);

  @Override
  int hashCode();

  @Override
  String toString();
}
