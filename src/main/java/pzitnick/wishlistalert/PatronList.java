package pzitnick.wishlistalert;

import java.util.Hashtable;

public class PatronList extends List<PatronItem> {

  public PatronList() {
    list = new Hashtable<String, PatronItem>(CAPACITY);
  }
  
  public String getPatronInfo(String id) {
    return "Patron ID: " + id
        + "\nPatron name: " + list.get(id).getName()
        + "\nPatron contact: " + list.get(id).getContact()
        + "\nNumber of wishlists: " + list.get(id).getNumberOfWishlists()
        + "\nWishlist Order #s:\n" + list.get(id).getOrderInfo();
  }
  
  public boolean patronExists(String id) {
    return itemExists(id); 
  }

  public void addPatronOrder(String patronId, String orderId) {
    PatronItem temp = list.get(patronId);
    temp.addWishlist(orderId);
    list.replace(patronId, temp);
    return;
    
  }
  
  
  
}
