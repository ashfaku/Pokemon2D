import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.paint.*;

public class AlertBox
{  
   private static boolean returnValue;   
   public static boolean display(String mes)
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
      layout.getChildren().addAll(l1, yesB, noB);
      layout.setAlignment(Pos.CENTER);
      window.setScene(new Scene(layout));
      window.showAndWait();
      return returnValue;
   }
}