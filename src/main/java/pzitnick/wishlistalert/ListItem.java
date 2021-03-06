package pzitnick.wishlistalert;

import java.util.LinkedList;

public class ListItem extends Item {

  protected class ListNode {
    String orderNum;
    String date; // There might be an obj for this that would be better used
                 // here

    protected ListNode() {
      orderNum = "";
      date = "";
    }

    protected ListNode(String newOrderNum, String newDate) {
      orderNum = newOrderNum;
      date = newDate;
    }

    protected String getOrderNum() {
      return orderNum;
    }

    protected String getDate() {
      return date;
    }

    protected void setOrderNum(String newOrderNum) {
      orderNum = newOrderNum;
    }

    protected void setDate(String newDate) {
      date = newDate;
    }
  }

  LinkedList<ListNode> requestList;

  public ListItem() {
    id = "";
    requestList = new LinkedList<ListNode>();
  }

  public ListItem(String newId) {
    id = newId;
    requestList = new LinkedList<ListNode>();
  }

  public void addRequest(String orderNum, String date) {
    ListNode temp = new ListNode(orderNum, date);
    requestList.addLast(temp); // FIFO
    return;
  }

  public void removeRequest() {
    requestList.removeFirst();
    return;
  }

  public void removeRequest(String orderNum) {
    return; // code needs to go in here probably
  }

}
