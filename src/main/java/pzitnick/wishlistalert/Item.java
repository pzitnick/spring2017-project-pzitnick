package pzitnick.wishlistalert;

import java.io.Serializable;

public abstract class Item implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  protected String id;
  protected double price;

  public Item() {
  }

  public String getId() {
    return id;
  }

  public double getPrice() {
    return price;
  }

  public void setId(String newId) {
    id = newId;
  }

  public void setPrice(double newPrice) {
    price = newPrice;
  }
}