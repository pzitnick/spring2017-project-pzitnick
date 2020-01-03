package pzitnick.wishlistalert;

public class InventoryItem extends Item {
  private BookItem book;
  private int quantity;

  public InventoryItem() {
    book = new BookItem();
    quantity = 0;
    id = "";
    price = 0.00;
  }

  public InventoryItem(String newId, String newTitle, String newAuth, double newPrice, int newQty) {
    book = new BookItem(newId, newTitle, newAuth, newPrice);
    id = newId;
    price = newPrice;
    quantity = newQty;
  }

  public String getIsbn() {
    return id;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getTitle() {
    return book.getTitle();
  }

  public String getAuthor() {
    return book.getAuthor();
  }

  public double getPrice() {
    return price;
  }

  public void setIsbn(String newIsbn) {
    id = newIsbn;
  }

  public void setQuantity(int newQuantity) {
    quantity = newQuantity;
  }

  public void addToQuantity(int add) {
    if (add < 1 && ((quantity + add) < 0)) {
      return;
    } // quantity must > -1
    quantity += add;
    return;
  }

  public void subFromQuantity(int sub) {
    if (sub > 0 && ((quantity - sub) < 0)) {
      return;
    } // quantity must > -1
    quantity -= sub;
    return;
  }

}
