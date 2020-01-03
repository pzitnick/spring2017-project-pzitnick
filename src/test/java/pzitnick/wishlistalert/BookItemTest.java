package pzitnick.wishlistalert;

import junit.framework.TestCase;
import pzitnick.wishlistalert.BookItem;

public class BookItemTest extends TestCase {

  public void testBookConstructor() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    assertTrue(test != null);
  }

  public void testGetIsbn() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    assertTrue(!test.getIsbn().isEmpty());
  }

  public void testGetAuthor() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    assertTrue(!test.getAuthor().isEmpty());
  }

  public void testGetTitle() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    assertTrue(!test.getTitle().isEmpty());
  }

  public void testGetPrice() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    assertTrue(test.getPrice() == 5.00);
  }

  public void testSetIsbn() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    test.setIsbn("0987654321");
    assertTrue(test.getIsbn().equals("0987654321"));
  }

  public void testSetAuthor() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    test.setAuthor("0987654321");
    assertTrue(test.getAuthor().equals("0987654321"));
  }

  public void testSetTitle() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    test.setAuthor("0987654321");
    assertTrue(test.getAuthor().equals("0987654321"));
  }

  public void testSetPrice() {
    BookItem test = new BookItem("1234567890", "Watership Down", "Richard Adams", 5);
    test.setPrice(0.01);
    assertTrue(test.getPrice() == 0.01);
  }

}
