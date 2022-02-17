import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.transform.*;
import javafx.scene.media.*;
import java.io.*;
import java.util.*;
public class Item
{
   private String name;
   private String url;
   private ArrayList<Item> t;
   public Item(String n, String u)
   {
      name = n;
      url = u;
      t = (new JavaFx()).getUserItems();
   }
   public String getName()
   {
      return name;
   }
   public String getURL()
   {
      return url;
   }
   public String toString()
   {
      return name + ": " + amountOfItem(name);
   }
   private int amountOfItem(String str)
   {
      int amount = 0;
      for (int i = 0; i < t.size(); i++)
         if (t.get(i).getName().equals(str))
            amount++;
     return amount;
   }
   public boolean equals(Item i)
   {
      return i.url.equals(this.url) && i.name.equals(this.name);
   }
}