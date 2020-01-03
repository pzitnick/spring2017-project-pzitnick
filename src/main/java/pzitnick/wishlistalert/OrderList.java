package pzitnick.wishlistalert;

import java.util.Hashtable;

public class OrderList extends List<OrderItem> {

  public OrderList() {
    list = new Hashtable<String, OrderItem>(CAPACITY);
  }

}
