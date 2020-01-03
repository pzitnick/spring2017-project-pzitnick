package pzitnick.wishlistalert;

import java.util.Hashtable;

public class MasterList extends List<MasterItem> {

  public MasterList() {
    list = new Hashtable<String, MasterItem>(CAPACITY);
  }

  public boolean masterExists(String id) {
    return itemExists(id);
  }
}
