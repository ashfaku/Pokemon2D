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

public class Information// extends Application
{  
   public static void displayInformation()
   {
      String base = "sprites-master\\sprites-master\\sprites\\pokemon\\";
      Stage window = new Stage();
      window.setMaximized(true);
      window.initModality(Modality.APPLICATION_MODAL);
      window.setTitle("General Information");
      window.show();
      VBox layout = new VBox(20);
      Pane t = (Pane) layout;
      ComboBox<String> whichInfo = new ComboBox<String>();
      Label vol = new Label("You can press M to increase in-game volume and you can press N to decrease it, everywhere but in the Healing Screen and this Screen. If the pc doesn't have focus on the window, try to make it have focus with your mouse.");
      Label header = new Label("Welcome! This is the general repository of gameplay information. You can access this from anywhere in the game, except the Healing Screen, if you click the I key like you just did.");
      Label fill = new Label("Please click this drop down menu to access gameplay information for the different areas.");
      
      ImageView pika = new ImageView(base + "pikachu.png");
      whichInfo.getItems().addAll("Choice Screen", "Home Screen", "Healing Screen (to be given a better name eventually)", "Battle Screen", "Catch Screen");
      whichInfo.setOnAction(e -> 
      {
       //  System.out.println(whichInfo.getValue()); 
         switch (whichInfo.getValue())
         {
            case "Choice Screen":
               layout.getChildren().clear();
               layout.getChildren().addAll(pika, header, vol, fill, whichInfo,  
               new Label("The images are meant to represent the types of each Pokemon. For example, Bulbsaur has the Grass/Purple images to his right because he's Grass and Poison."), 
               new Label("You can press SHIFT + W to search for a Pokemon. It will highlight in black any Pokemon that fit the search criteria you entered."),
               new Label("Other than that, once you've picked your team (I really recommend you have a team of 5), press P."),
               new Label("You'll be able to catch one more pokemon in game."));
               break;
            case "Home Screen":
               layout.getChildren().clear();
               layout.getChildren().addAll(pika, header, vol, fill, whichInfo, 
               new Label("You can use WASD keys to move your character around towards each of the Elite Four at the screen corners."), 
               new Label("You can press the P key here to access a place to rest your Pokemon after battle. I do advise though, be careful with what you have because I haven't given you infinite potions."), 
               new Label("If one of your Pokemon dies, that's it. I'm not letting you revive anyone with this version, that's going to be implemented in a future update :)"),
               new Label("You can move your character to the grass icon at the middle left of the screen to try to catch a random Pokemon!"),
               new Label("You're free to do whatever you want in this limited game, but I haven't given you much choice in what to do."));
               break;
            case "Healing Screen (to be given a better name eventually)":
               layout.getChildren().clear();
               layout.getChildren().addAll(pika, header, vol, fill, whichInfo,
               new Label("You can access this screen by pressing the P key while on the Home screen. I intended to not let you use this in battle, but the opponents are too OP to not let you. "),
               new Label("You can't do much here - you're meant to stay here for a minute then go back. You click the drop down menu at the top center and decide which item you want to use, then you click which Pokemon you want to use it on."),
               new Label("Fair warning - if you use a Hyper Potion and the Pokemon's health exceeds their original health, they won't be getting any of that extra health you so wanted. Try to conserve your Potions.")); 
               break;
            case "Battle Screen":
               layout.getChildren().clear();
               layout.getChildren().addAll(pika, header, vol, fill, whichInfo,
               new Label("Here is the centerpiece of my program. Please click on the buttons before you start battling, I've added a surprise :)"),
               new Label("You can click any of your Pokemon (on the left side) to swap them out with the one you have out currently, like any Pokemon game."),
               new Label("The buttons will change as you swap Pokemon, and keep in mind - attacks are affected by types, so if you aren't a true gamer, you're going to lose."),
               new Label("If you're able to beat your opponent, there will be a large button that appears in the center of the screen. You can press it to return to the Home page."),
               new Label("If you're able to beat all the Elite Four, please proceed to the final boss battle of my game at the centerish of the Home screen."));
               break;
            case "Catch Screen":
               layout.getChildren().clear();
               layout.getChildren().addAll(pika, header, vol, fill, whichInfo,
               new Label("The instructions on how to get here are detailed in the Home Screen information."),
               new Label("You can try your luck at catching a wild Pokemon! You happen to have an unlimited supply of Poke and Ultra Balls. (I totally wasn't lazy and didn't feel like programming that)"),
               new Label("You can choose which kind of ball to use by clicking the drop down menu on the screen."),
               new Label("Press the \"Throw your ball\" button when you want to try. It's a pseudo-random chance, and if you're lucky, you'll get him."),
               new Label("Once you've caught him, please press the same button again and it'll lead you back to the home screen.")
               );
               break;
         }
     });    
     layout.getChildren().addAll(pika, header, vol, fill, whichInfo); 
     ScrollPane layoutScroll = new ScrollPane();
     layoutScroll.setContent(layout);   
     layoutScroll.setPrefSize(JavaFx.returnWidth(), JavaFx.returnHeight());
     window.setScene(new Scene(layoutScroll));
   }
}