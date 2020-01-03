package pzitnick.wishlistalert;

import java.util.ArrayList;

public class PatronItem extends Item {
  private String name;
  private String contact;
  private ArrayList<String> wishlists;

  public PatronItem() {
    id = "";
    name = "";
    contact = "";
    wishlists = new ArrayList<String>();

  }

  public PatronItem(String newId, String newName, String newContact) {
    id = newId;
    name = newName;
    contact = newContact;
    wishlists = new ArrayList<String>();
  }

  public String getName() {
    return name;
  }

  public String getContact() {
    return contact;
  }

  public int getNumberOfWishlists() {
    return wishlists.size();
  }

  public void setName(String newName) {
    name = newName;
  }

  public void setContact(String newContact) {
    contact = newContact;
  }

  public void addWishlist(String orderNum) {
    wishlists.add(orderNum);
    return;
  }

  public void removeWishlist(String orderNum) {
    wishlists.remove(orderNum); // not sure if this will work TODO
    return;
  }

  public String getOrderInfo() {
    String temp = "";
    for (int i = 0; i < wishlists.size(); i++) {
      temp += wishlists.get(i) + "\n";
    }
    return temp;
  }
}
