package pzitnick.wishlistalert;

import junit.framework.TestCase;
import pzitnick.wishlistalert.InventoryItem;

public class InventoryItemTest extends TestCase {

  public void testInventoryItemConstructor() {
    InventoryItem test = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    assertTrue(test != null);
  }

  public void testaddToQuantity() {
    InventoryItem test = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    test.addToQuantity(2);
    test.addToQuantity(-1);
    test.addToQuantity(-7);
    assertTrue(test.getQuantity() == 6);
  }

  public void testGetPrice() {
    InventoryItem test = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    assertTrue(test.getPrice() == 9.99);
  }

  public void testGetQuantity() {
    InventoryItem test = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    assertTrue(test.getQuantity() == 5);
  }

  public void testSetQuantity() {
    InventoryItem test = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    test.setQuantity(6);
    assertTrue(test.getQuantity() == 6);
  }

  public void testSubFromQuantity() {
    InventoryItem test = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    test.subFromQuantity(6);
    test.subFromQuantity(1);
    test.subFromQuantity(-7);
    assertTrue(test.getQuantity() == 11);
  }

  public void testSetPrice() {
    InventoryItem test = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    test.setPrice(0.01);
    assertTrue(test.getPrice() == 0.01);
  }

}
