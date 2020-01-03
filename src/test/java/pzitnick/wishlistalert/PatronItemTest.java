package pzitnick.wishlistalert;

import junit.framework.TestCase;
import pzitnick.wishlistalert.PatronItem;

public class PatronItemTest extends TestCase {

  public void testPatronItemConstructor() {
    PatronItem test = new PatronItem("pzitnick", "Paula Z", "123-456-7890");
    assertTrue(test != null);
  }

  public void testAddWishlist() {
    PatronItem test = new PatronItem("pzitnick", "Paula Z", "123-456-7890");
    test.addWishlist("1234");
    assertTrue(test.getNumberOfWishlists() == 1);
  }

  public void testGetContact() {
    PatronItem test = new PatronItem("pzitnick", "Paula Z", "123-456-7890");
    assertTrue(test.getContact().equals("123-456-7890"));
  }

  public void testGetName() {
    PatronItem test = new PatronItem("pzitnick", "Paula Z", "123-456-7890");
    assertTrue(test.getName().equals("Paula Z"));
  }

  public void testGetNumberOfWishlists() {
    PatronItem test = new PatronItem("pzitnick", "Paula Z", "123-456-7890");
    test.addWishlist("1234");
    assertTrue(test.getNumberOfWishlists() == 1);
  }

  public void testRemoveWishlist() {
    PatronItem test = new PatronItem("pzitnick", "Paula Z", "123-456-7890");
    test.addWishlist("1234");
    test.removeWishlist("1234");
    assertTrue(test.getNumberOfWishlists() == 0);
  }

  public void testSetContact() {
    PatronItem test = new PatronItem("pzitnick", "Paula Z", "1");
    test.setContact("123-456-7890");
    assertTrue(test.getContact().equals("123-456-7890"));
  }

  public void testSetName() {
    PatronItem test = new PatronItem("pzitnick", "Paula Zitnick", "123-456-7890");
    test.setName("Paula Z");
    assertTrue(test.getName().equals("Paula Z"));
  }

}
