package problem1;

public class Main {

  public static void main(String[] args) {
    Product sa = new Salmon("hibrand", "good sal", 3.66, 2, 7.8);
    Product ch = new Cheese("adf", "great", 22.5, 23, 15.5);
    StockItem saStock = new StockItem(sa, 5);
    System.out.println(sa instanceof AbstractProduct);

    Inventory inv = new Inventory();
    inv.addStockItem(saStock);
    Customer c = new Customer("allen", 5);

    c.addProduct(inv, saStock, 900);
    System.out.println(sa.getClass());
    System.out.println(ch.getClass());


  }

}
