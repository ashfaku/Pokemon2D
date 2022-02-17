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

public class HealBox
{  
   private static boolean returnValue;
   private static ComboBox<Item> second;   
   private static ImageView centerImage;
   private static BorderPane layout;
   private static boolean checkName(String s)
   {
      for (Item a: second.getItems())
         if (a.getName().equals(s))
            return false;
      return true; 
   }
   /*public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage prim) throws Exception
   {
      displayHealBox();
   }*/
   private static void setHealthBars()
   {
      VBox left = (VBox) layout.getLeft(); 
      for (int i = 0; i < JavaFx.getUserPokemon().size(); i++)
      {
         ProgressBar tmp = (ProgressBar) left.getChildren().get(i*2 + 1);
         tmp.setProgress((double) JavaFx.getUserPokemon().get(i).getHealth() / JavaFx.getUserPokemon().get(i).getMaxHealth());   
      }
   }
   private static void removeItem(Item s)
   {
      for (int i = 0; i < (new JavaFx()).getUserItems().size(); i++)
      {
         if ((new JavaFx()).getUserItems().get(i).equals(s))
         {
            (new JavaFx()).getUserItems().remove(i);
            break;
         }
      }
      //second = new ComboBox<Item>();
      second.getItems().clear();
      if ((new JavaFx()).getUserItems().size() > 0)
         second.getItems().add((new JavaFx()).getUserItems().get(0));
      for (int i = 1; i < (new JavaFx()).getUserItems().size(); i++)
         if (checkName((new JavaFx()).getUserItems().get(i).getName()))
            second.getItems().add((new JavaFx()).getUserItems().get(i));
      second.setOnAction(e -> centerImage.setImage(new Image(second.getValue().getURL())));  
   }
   public static void displayHealBox()
   {
      Stage window = new Stage();
      window.setMaximized(true);
      window.initModality(Modality.APPLICATION_MODAL);
      window.setTitle("Healing Area");
      layout = new BorderPane();
      ScrollPane layoutScroll = new ScrollPane();
      layoutScroll.setPrefSize(JavaFx.returnWidth(), JavaFx.returnHeight());
      layoutScroll.setContent(layout);
      layout.setRight(new VBox(20));
      layout.setLeft(new VBox(20));
      ImageView itemImage = new ImageView("sprites-master\\sprites-master\\sprites\\pokemon\\0.png");
      layout.setCenter(new Pane(itemImage, new Label("")));
      centerImage = ((ImageView)(((Pane)layout.getCenter()).getChildren().get(0)));
      Label moveLabel = ((Label)(((Pane)layout.getCenter()).getChildren().get(1)));
      moveLabel.relocate(JavaFx.returnWidth(), JavaFx.returnHeight());
      centerImage.relocate(JavaFx.returnWidth() / 2, JavaFx.returnHeight() / 2);
      second = new ComboBox<Item>();  
      layout.setTop(new HBox(20, second));
      ((HBox)layout.getTop()).setAlignment(Pos.CENTER);
      if ((new JavaFx()).getUserItems().size() > 0)
         second.getItems().add((new JavaFx()).getUserItems().get(0));
      for (int i = 1; i < (new JavaFx()).getUserItems().size(); i++)
         if (checkName((new JavaFx()).getUserItems().get(i).getName()))
            second.getItems().add((new JavaFx()).getUserItems().get(i));
      second.setOnAction(e -> centerImage.setImage(new Image(second.getValue().getURL())));
      for (int i = 0; i < (new JavaFx()).getUserPokemon().size(); i++)
      {
         Label temp = new Label((new JavaFx()).getUserPokemon().get(i).getName());
         ProgressBar tempHealth = new ProgressBar();
         ((VBox)layout.getLeft()).getChildren().add(temp);
         ((VBox)layout.getLeft()).getChildren().add(tempHealth);
         tempHealth.setProgress((new JavaFx()).getUserPokemon().get(i).getHealth() / (new JavaFx()).getUserPokemon().get(i).getMaxHealth());
         final int j = i;  // annoying final variable rules yet again
         temp.setGraphic(new ImageView(new Image("sprites-master\\sprites-master\\sprites\\pokemon\\" + temp.getText() + ".png")));  
         temp.setOnMouseClicked(e -> 
         {
            if (second.getValue() == null)
               return;
            else if (Confirmation.display("Are you sure you want to use one " + second.getValue().getName() + " on " + temp.getText() + "?", JavaFx.getUserPokemon().get(j).getHealth(), JavaFx.getUserPokemon().get(j).getAttack(), JavaFx.getUserPokemon().get(j).getDefense()))
            {
               switch (second.getValue().getName())
               {
                  case "Hyper Potion":
                     JavaFx.getUserPokemon().get(j).setHealth(-100);
                     if (JavaFx.getUserPokemon().get(j).getHealth() > JavaFx.getUserPokemon().get(j).getMaxHealth())
                        JavaFx.getUserPokemon().get(j).maxHealth();
                     setHealthBars();
                     removeItem(second.getValue());
                     break;
                  case "Attack Boost":
                     JavaFx.getUserPokemon().get(j).setAttack(15);
                     removeItem(second.getValue());
                     break;
                  case "Defense Boost":
                     JavaFx.getUserPokemon().get(j).setDefense(10);
                     removeItem(second.getValue());
                     break;
                  default:
                     break;   
               }
               second.setValue(null);
               itemImage.setImage(new Image("sprites-master\\sprites-master\\sprites\\pokemon\\0.png"));
            }      
         });
      }
      window.setScene(new Scene(layoutScroll));
      window.showAndWait();
   }
}