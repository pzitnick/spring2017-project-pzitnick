package pzitnick.wishlistalert;

import junit.framework.TestCase;
import pzitnick.wishlistalert.InventoryItem;
import pzitnick.wishlistalert.OrderItem;

public class OrderItemTest extends TestCase {

  public void testOrderItemConstructor() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/9", testItem);
    assertTrue(test != null);
  }

  public void testGetCompletion() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/9", testItem);
    test.setItemsReserved(3);
    assertTrue(test.getCompletion() == 0.60);
  }

  public void testGetCompletionStr() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/9", testItem);
    test.setItemsReserved(3);
    assertTrue(test.getCompletionStr().equals("60.0%"));
  }

  public void testGetDate() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/9", testItem);
    assertTrue(test.getDate().equals("9/9/9"));
  }

  public void testGetItemsReserved() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/9", testItem);
    assertTrue(test.getItemsReserved() == 0);
  }

  public void testGetOrderSize() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/9", testItem);
    assertTrue(test.getOrderSize() == 5);
  }

  public void testSetDate() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/8", testItem);
    test.setDate("9/9/9");
    assertTrue(test.getDate().equals("9/9/9"));
  }

  public void testSetItemsReserved() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/9", testItem);
    test.setItemsReserved(2);
    assertTrue(test.getItemsReserved() == 2);
  }

  public void testSetOrderSize() {
    InventoryItem testItem = new InventoryItem("1", "Watership Down", "Richard Adams", 9.99, 5);
    OrderItem test = new OrderItem("333", "9/9/9", testItem);
    test.setOrderSize(2);
    assertTrue(test.getOrderSize() == 2);
  }
}
