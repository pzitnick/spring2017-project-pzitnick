package pzitnick.wishlistalert;

import java.util.Hashtable;

public class OrderItem extends Item {
  private Hashtable<String, InventoryItem> items;
  private int orderSize;
  private int itemsReserved;
  private String date;

  public OrderItem() {
    id = "";
    date = "";
    orderSize = 0;
    itemsReserved = 0;
    items = new Hashtable<String, InventoryItem>();
  }

  // relying on user to supply a valid newItem
  public OrderItem(String newOrderId, String newDate, InventoryItem newItem) {
    id = newOrderId;
    date = newDate;
    orderSize = newItem.getQuantity();
    itemsReserved = 0;
    items = new Hashtable<String, InventoryItem>();
    items.put(newItem.getId(), newItem);
  }

  public String getDate() {
    return date;
  }

  public double getCompletion() {
    return (double) itemsReserved / orderSize;
  }

  public String getCompletionStr() {
    return ((double) itemsReserved / orderSize) * 100.0 + "%";
  }

  public void setDate(String newDate) {
    date = newDate;
  }

  public int getItemsReserved() {
    return itemsReserved;
  }

  public int getOrderSize() {
    return orderSize;
  }

  public void setItemsReserved(int newItemsReserved) {
    itemsReserved = newItemsReserved;
  }

  public void setOrderSize(int newOrderSize) {
    orderSize = newOrderSize;
  }

}
