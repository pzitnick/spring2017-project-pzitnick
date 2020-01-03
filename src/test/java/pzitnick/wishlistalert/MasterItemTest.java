package pzitnick.wishlistalert;

import junit.framework.TestCase;
import pzitnick.wishlistalert.MasterItem;

public class MasterItemTest extends TestCase {

  public void testListItemConstructor() {
    MasterItem test = new MasterItem("1234567890");
    assertTrue(test != null);
  }

  public void testAddRequest() {
    MasterItem test = new MasterItem("1234567890");
    test.addRequest("333", "9/9/9");
    assertTrue(test.getNumberOfRequests() == 1);
  }

  public void testRemoveRequest() {
    MasterItem test = new MasterItem("1234567890");
    test.addRequest("333", "9/9/9");
    test.removeRequest("333");
    test.removeRequest("333");
    assertTrue(test.getNumberOfRequests() == 0);
  }

  public void testListNode() {
    MasterItem test = new MasterItem("1234567890");
    test.addRequest("333", "9/9/9");
    String testStr = test.printRequestList();
    assertTrue(testStr.equals("333 @ 9/9/9\n"));
  }

  public void testGetNumberOfRequests() {
    MasterItem test = new MasterItem("1234567890");
    test.addRequest("333", "9/9/9");
    test.addRequest("353", "9/9/9");
    assertTrue(test.getNumberOfRequests() == 2);
  }

  public void testPrintRequestList() {
    MasterItem test = new MasterItem("1234567890");
    test.addRequest("333", "9/9/9");
    test.addRequest("353", "9/9/9");
    String testStr = test.printRequestList();
    assertTrue(testStr.equals("333 @ 9/9/9\n353 @ 9/9/9\n"));
  }

}
