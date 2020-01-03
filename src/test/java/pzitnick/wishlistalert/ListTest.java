package pzitnick.wishlistalert;

import junit.framework.TestCase;
import pzitnick.wishlistalert.List;

public class ListTest extends TestCase {
  
  public void testItemExists(){
    MasterList test = new MasterList();
    MasterItem master = new MasterItem("x");
    test.add("x", master);
    assertTrue(test.itemExists("x"));
  }

}
