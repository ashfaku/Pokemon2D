import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.paint.*;

public class EndBox
{        
   private static boolean returnValue;   
   public static boolean display(String mes, String button)
   {
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL);
      window.setTitle("Good game!");
      window.setMinWidth(250);
     
      Label l1 = new Label(mes);
      Button endButton = new Button(button);
      l1.setTextFill(Color.web("#000000"));
     
      endButton.setOnAction(e -> 
      {
         System.exit(0);
      });
      
      window.setOnCloseRequest(e -> e.consume());
      VBox layout = new VBox(10);
      layout.getChildren().addAll(l1, endButton);
      layout.setAlignment(Pos.CENTER);
      
      Scene scene1 = new Scene(layout);
      window.setScene(scene1);
      window.showAndWait();
      
      return returnValue;
   }
}