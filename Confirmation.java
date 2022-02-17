import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.paint.*;

public class Confirmation
{  
   private static boolean returnValue;   
   public static boolean display(String mes, double health, double attack, double defense)
   {
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL);
      window.setTitle("");
      window.setMinWidth(250);
      
      Label l1 = new Label(mes);
      Button yesB = new Button("Yes");
      l1.setTextFill(Color.web("#000000"));
     
      yesB.setOnAction(e -> 
      {
          returnValue = true;
          window.close();
      });
      Button noB = new Button("No");
      noB.setOnAction(e -> 
      {
         returnValue = false;
         window.close();
      }); 
      
      VBox layout = new VBox(10);
      layout.setAlignment(Pos.CENTER); 
      layout.getChildren().addAll(l1, new Label("Health: " + String.format("%.2f", (float) health)), new Label("Attack: " + String.format("%.2f", (float) attack)), new Label("Defense: " + String.format("%.2f", (float)defense)), yesB, noB);
      Scene scene1 = new Scene(layout);
      window.setScene(scene1);
      window.showAndWait();
      return returnValue;
   }
}