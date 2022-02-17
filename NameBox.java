import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.event.*;

public class NameBox
{
   private static Label l1;
   public static boolean checkForL(String s) // checks if there're any actual letters using very pogger unicode
   {
      for (int a = 0; a < s.length(); a++)
      {
         for (int i = 65; i < 65 + 26; i++)
         {
            if ((s.charAt(a) == ((char) i)) || s.charAt(a) == ((char) (i+32)))
               return true;
         }
      }
      l1.setText("Please don't be like this, user.");
      return false;
   }  
   
   private static String returnValue;   
   
   public static String display(String str, String mes)
   {
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL);
      window.setTitle(str);
      window.setMinWidth(250);
      
      l1 = new Label(mes);
      Button yesB = new Button("Search");
      l1.setTextFill(Color.web("#FF0000"));
      TextField makeName = new TextField();
      makeName.setPromptText("Please enter your name here.");
      yesB.setOnAction(e -> 
      {
          returnValue = makeName.getText();
          if (!(checkForL(returnValue)))
          {
            l1.setText("Please don't be like this, user.");
            return;
          }
          window.close();
      });
      
      VBox layout = new VBox(10);
      layout.getChildren().addAll(l1, yesB, makeName);
      layout.setAlignment(Pos.CENTER);

      Scene scene1 = new Scene(layout, 400, 400);
      window.setScene(scene1);
       
      window.showAndWait();
      window.setMaximized(true);

      return returnValue;
   }
}