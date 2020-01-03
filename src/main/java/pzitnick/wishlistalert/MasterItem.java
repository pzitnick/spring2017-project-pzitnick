package pzitnick.wishlistalert;

import java.util.LinkedList;

public class MasterItem extends Item {

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

  private LinkedList<ListNode> requestList;

  public MasterItem() {
    id = "";
    requestList = new LinkedList<ListNode>();
  }

  public MasterItem(String newId) {
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
    String temp;
    for (int i = 0; i < requestList.size(); i++) {
      temp = requestList.get(i).getOrderNum();
      if (temp.equals(orderNum)) {
        requestList.remove(i);
        return;
      }
    }
    return;
  }

  public int getNumberOfRequests() {
    return requestList.size();
  }

  public String printRequestList() {
    String ret = "";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < requestList.size(); i++) {
      ret = requestList.get(i).getOrderNum() + " @ " + requestList.get(i).getDate() + "\n";
      sb.append(ret);
    }
    return sb.toString();
  }

}
