package pzitnick.wishlistalert;

public class BookItem extends Item {
  private String title;
  private String author;

  public BookItem() {
    title = "";
    author = "";
    id = "";
    price = 0.00;
  }

  public BookItem(String newName, String newTitle, String newAuthor, double newPrice) {
    title = newTitle;
    author = newAuthor;
    id = newName;
    price = newPrice; // maybe do a format here to make sure two decimal
                      // points/price form
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public void setTitle(String newTitle) {
    title = newTitle;
  }

  public void setAuthor(String newAuthor) {
    author = newAuthor;
  }

  // Wrapper functions
  public String getIsbn() {
    return id;
  }

  public void setIsbn(String newIsbn) {
    id = newIsbn;
  }

}