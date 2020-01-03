package pzitnick.wishlistalert;

import java.util.Scanner;

/*
 * Driver class
 *
 */
public class App {
  static final int ADD_BOOK = 1;
  static final int ADD_PATRON = 2;
  static final int ADD_ORDER = 3;
  //GET_PATRON_INFO
  //GET_ORDERS_FOR_BOOK
  //DElETE_ORDER
  //FILL_ORDER
  static final int QUIT = 4;
  
  public static void main(String[] args) {
    System.out.println("Now loading inventory...");
    // load inventory here. Maybe through factory pattern?
    PatronList patronList = new PatronList();
    PatronItem patron;
    patronList.read("patronList.txt");
    System.out.println("Read patronList...");
    
    OrderList orderList = new OrderList();
    OrderItem order;
    orderList.read("orderList.txt");
    System.out.println("Read orderList...");
    
    InventoryList inventoryList = new InventoryList();
    InventoryItem inventory;
    inventoryList.read("inventoryList.txt");
    System.out.println("Read inventoryList...");
    
    MasterList masterList = new MasterList();
    MasterItem master;
    masterList.read("masterList.txt");
    System.out.println("Read masterList...");
    
    for (int i = 0; i < patronList.size(); i++) {
      System.out.println(patronList.getPatronInfo(Integer.toString(i)));  
    }
    System.out.println("Number of orders on orderList: " + orderList.size());

    int intChoice = 0;
    Scanner input = new Scanner(System.in);
    do {
      printMenu();
      String choice = getChoice(input);
      while (!isValidChoice(choice)) {
        System.out.println(choice + " is not a valid choice.");
        printMenu();
        choice = getChoice(input);
      }
      // now that we have a valid choice
      // so here we need to trigger the change

      intChoice = Integer.parseInt(choice);
      if (intChoice == ADD_BOOK) {
        System.out.println("Adding book to inventory...");
        System.out.print("Enter ISBN for book: ");
        String orderIsbn = input.nextLine();
        System.out.print("Enter title for book: ");
        String orderTitle = input.nextLine();
        System.out.print("Enter author for book ");
        String orderAuth = input.nextLine();
        System.out.print("Enter price for book: $");
        double orderPrice = input.nextDouble();
        System.out.print("Enter quantity of books: ");
        int orderQty = input.nextInt();
        input.nextLine(); //clearing buffer
        
        if (inventoryList.inventoryExists(orderIsbn)) {
          inventory = inventoryList.get(orderIsbn);
          inventory.addToQuantity(orderQty);
          inventoryList.replace(orderIsbn, inventory);
        } else { //doesn't exist yet in inventorylist
          inventory = new InventoryItem(orderIsbn, orderTitle, orderAuth, orderPrice, orderQty);
          inventoryList.add(orderIsbn, inventory);
        }
        //now we need to check if it's in the masterList, and, if not, update masterList
        if (masterList.masterExists(orderIsbn)) {
          //TODO
          //if it's on the masterList then we need to update the newest order
          System.out.println("There is an outstanding order for " + orderTitle + " by a patron.");
        } else {
          System.out.println("Nobody has requested that book yet.");
        }
        
      } else if (intChoice == ADD_PATRON) {
        System.out.println("Adding new patron to patron list...");
        String patronId = Integer.toString(patronList.size());
        System.out.print("Enter name: ");
        String patronName = input.nextLine();
        System.out.println("Enter phone number: ");
        String patronContact = input.nextLine();
        patron = new PatronItem(patronId, patronName, patronContact);
        patronList.add(patronId, patron); //maybe do an error check here
        
      } else if (intChoice == ADD_ORDER) {
        System.out.println("Adding new order to patron's order list...");
        System.out.print("Enter patron ID: ");
        String patronId = input.nextLine();
        if (patronList.patronExists(patronId)) {
          //String newOrderId, String newDate, InventoryItem newItem
          //String newId, String newTitle, String newAuth, double newPrice, int newQty
          System.out.print("Enter ISBN for item desired: ");
          String orderIsbn = input.nextLine();
          System.out.print("Enter title for item desired: ");
          String orderTitle = input.nextLine();
          System.out.print("Enter author for item desired: ");
          String orderAuth = input.nextLine();
          System.out.print("Enter price for item desired: $");
          double orderPrice = input.nextDouble();
          System.out.print("Enter quantity of item desired: ");
          int orderQty = input.nextInt();
          inventory = new InventoryItem(orderIsbn, orderTitle, orderAuth, orderPrice, orderQty);
          input.nextLine(); //clearing buffer
          String orderId = Integer.toString(orderList.size());
          String orderDate = "now"; //make this a real date TODO

          order = new OrderItem(orderId, orderDate, inventory);
          orderList.add(orderId, order);
          patronList.addPatronOrder(patronId, orderId);
          //need to also add order to masterList
          
          if (masterList.masterExists(orderIsbn)) {
            master = masterList.get(orderIsbn);
            master.addRequest(orderId, orderDate);
          } else {
            master = new MasterItem(orderIsbn);
            masterList.add(orderIsbn, master);
          }
        } else {
          //patron does not exist
          System.out.println("Patron does not exist.");
        }
      }

    } while (intChoice != QUIT);
    System.out.println("Now saving inventory before quitting...");
    // save inventory here
    patronList.write("patronList.txt");
    orderList.write("orderList.txt");
    inventoryList.write("inventoryList.txt");
    masterList.write("masterList.txt");
    
    input.close();
    System.out.println("Goodbye");
  }

  public static void printMenu() {
    System.out.print("\n\n**************************************************" 
        + "\nPlease select an operation to perform"
        + "\n**************************************************" 
        + "\n1. Add book to the inventory"
        + "\n2. Add new patron to patron list" 
        + "\n3. Add new order for existing patron" 
        + "\n4. Quit"
        + "\n**************************************************" 
        + "\nType 1, 2, 3, or 4 for choice: ");
    return;
  }

  public static String getChoice(Scanner input) {
    return input.nextLine();
  }

  private static boolean isValidChoice(String choice) {
    try {
      int intChoice = Integer.parseInt(choice);
      if (intChoice > 0 && intChoice < 5) {
        return true;
      }
    } catch (NumberFormatException e) {
      System.err.println("Choice not an integer");
      return false;
    }
    return false;
  }

}
