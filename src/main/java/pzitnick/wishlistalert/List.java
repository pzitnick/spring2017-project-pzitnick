package pzitnick.wishlistalert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public abstract class List<T> extends Subject {
  protected static final int CAPACITY = 1000; // arbitrary capacity for
                                              // hashtable
  protected Hashtable<String, T> list;

  public List() {
    list = new Hashtable<String, T>(CAPACITY);
  }
  
  public void add(String key, T value) {
    list.put(key, value);
    return;
  }
  
  public T get(String key) {
    if (list.containsKey(key)) {
      return list.get(key);
    } else {
      return null;
    }
  }
  
  public boolean itemExists(String key) {
    if (list.containsKey(key)) {
      return true;
    } else {
      return false;
    }
  }
  
  public void replace(String key, T value) {
    if (list.containsKey(key)) {
      list.replace(key, value);
    }
    return;
  }
  
  public void remove(String key) {
    list.remove(key);
    return;
  }
  
  public int size() {
    return list.size();
  }
  
  public void write(String filename) {
    FileOutputStream fos;
    ObjectOutputStream oos;
    try {
      fos = new FileOutputStream(filename);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(list);
      oos.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
    return;
  }
  
  public void read(String filename) {
    FileInputStream fis;
    ObjectInputStream ois;
    try {
      fis = new FileInputStream(filename);
      ois = new ObjectInputStream(fis);
      list = (Hashtable<String, T>) ois.readObject();
      ois.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println(filename + " not found.");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
    return;
  }

}
