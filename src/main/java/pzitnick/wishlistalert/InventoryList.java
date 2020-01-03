package pzitnick.wishlistalert;

import java.util.Hashtable;

public class InventoryList extends List<InventoryItem> {

  public InventoryList() {
    list = new Hashtable<String, InventoryItem>(CAPACITY);
  }
  
  public boolean inventoryExists(String id) {
    return itemExists(id);
  }
}

