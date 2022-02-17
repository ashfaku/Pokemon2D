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
import javax.sound.sampled.*;
import java.util.*; 
/** This class is a GUI application made so the user can have fun
   @author Ashfak Uddin
   @since 1/15/2021
    
*/
public class JavaFx extends Application implements Runnable, EventHandler<ActionEvent>
{
   private String musicBase, musicEnd;
   private double x, y;
   double volume = 0.5;
   private static ArrayList<Item> userItems = new ArrayList();
   private static ArrayList<Pokemon> userPokemon = new ArrayList(), finalTeam = new ArrayList(), topLeft = new ArrayList(), bottomLeft = new ArrayList(), topRight = new ArrayList(), bottomRight = new ArrayList(), general;
   private ArrayList<ArrayList<String>> moveTypeList = new ArrayList(), arr = new ArrayList(), moveList = new ArrayList();
   private ArrayList<CheckBox> checkBoxList = new ArrayList();
   private ArrayList<ArrayList<ImageView>> typesList = new ArrayList();
   private ArrayList<String> gottenNames = new ArrayList(); 
   private ArrayList<ArrayList<Double>> statList = new ArrayList();
   private TranslateTransition[] animations = {new TranslateTransition(Duration.millis(1000))};
   private String[] animationContent = {"M 80 50 L 110 120 L 50 120 L 80 50 M -20 130 L 50 120 M 50 120 L 30 170 L 30 170 L -20 130 M 30 230 L 30 170 L 80 190 M 130 230 L 80 190 L 130 170 M 170 130 L 110 120 L 130 170 M 80 150 L 80 120 L 50 120 L 30 170 M 80 150 L 80 190 L 30 170 M 80 150 L 130 170 L 80 120 L 80 190 L 130 170 L 110 120 L 80 120"};   
   
   private final String[] names =
   {
      "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree",
      "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", 
      "Sandshrew", "Sandslash", "Nidoran", "Nidorina", "Nidoqueen", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", 
      "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian",
      "Psyduck", "Golduck", "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam", "Machop", 
      "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke", 
      "Slowbro", "Magnemite", "Magneton", "Farfetch'd", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder", "Cloyster", "Gastly", "Haunter", "Gengar",
      "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor", "Cubone", "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", 
      "Koffing", "Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", "Mr. Mime", 
      "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon","Flareon", "Porygon", 
      "Omanyte", "Omastar", "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew",
      "Chikorita", "Bayleef", "Meganium", "Cyndaquil", "Quilava", "Typhlosion", "Totodile", "Croconaw", "Feraligatr", "Sentret", "Furret", "Hoothoot", "Noctowl", "Ledyba",
      "Ledian", "Spinarak", "Ariados", "Crobat", "Chinchou", "Lanturn", "Pichu", "Cleffa", "Igglybuff", "Togepi", "Togetic","Natu", "Xatu", "Mareep", "Flaaffy", "Ampharos",
      "Bellossom", "Marill", "Azumarill", "Sudowoodo", "Politoed", "Hoppip", "Skiploom", "Jumpluff", "Aipom", "Sunkern", "Sunflora", "Yanma", "Wooper", "Quagsire", "Espeon",
      "Umbreon", "Murkrow", "Slowking", "Misdreavus", "Unown", "Wobbuffet", "Girafarig", "Pineco", "Forretress", "Dunsparce", "Gligar", "Steelix", "Snubbull", "Granbull",
      "Qwilfish", "Scizor", "Shuckle", "Heracross", "Sneasel", "Teddiursa", "Ursaring", "Slugma", "Magcargo", "Swinub", "Piloswine", "Corsola", "Remoraid", "Octillery", 
      "Delibird", "Mantine", "Skarmory", "Houndour", "Houndoom", "Kingdra", "Phanpy", "Donphan", "Porygontwo", "Stantler", "Smeargle", "Tyrogue", "Hitmontop", "Smoochum",
      "Elekid", "Magby", "Miltank", "Blissey", "Raikou", "Entei", "Suicune", "Larvitar", "Pupitar", "Tyranitar", "Lugia", "Ho-Oh", "Celebi", "Treecko", "Grovyle", "Sceptile", 
      "Torchic", "Combusken", "Blaziken", "Mudkip", "Marshtomp", "Swampert", "Poochyena", "Mightyena", "Zigzagoon", "Linoone", "Wurmple", "Silcoon", "Beautifly", "Cascoon", 
      "Dustox", "Lotad", "Lombre", "Ludicolo", "Seedot", "Nuzleaf", "Shiftry", "Taillow", "Swellow", "Wingull", "Pelipper", "Ralts", "Kirlia", "Gardevoir", "Surskit", "Masquerain",
      "Shroomish", "Breloom", "Slakoth", "Vigoroth", "Slaking", "Nincada", "Ninjask", "Shedinja", "Whismur", "Loudred", "Exploud", "Makuhita", "Hariyama", "Azurill", "Nosepass", 
      "Skitty", "Delcatty", "Sableye", "Mawile", "Aron", "Lairon", "Aggron", "Meditite", "Medicham", "Electrike", "Manectric", "Plusle", "Minun", "Volbeat", "Illumise", "Roselia", 
      "Gulpin", "Swalot", "Carvanha", "Sharpedo", "Wailmer", "Wailord", "Numel", "Camerupt", "Torkoal", "Spoink", "Grumpig", "Spinda", "Trapinch", "Vibrava", "Flygon", "Cacnea", 
      "Cacturne", "Swablu", "Altaria", "Zangoose", "Seviper", "Lunatone", "Solrock", "Barboach", "Whiscash", "Corphish", "Crawdaunt", "Baltoy", "Claydol", "Lileep", "Cradily", 
      "Anorith", "Armaldo", "Feebas", "Milotic", "Castform", "Kecleon", "Shuppet", "Banette", "Duskull", "Dusclops", "Tropius", "Chimecho", "Absol", "Wynaut", "Snorunt", "Glalie",
      "Spheal", "Sealeo", "Walrein", "Clamperl", "Huntail", "Gorebyss", "Relicanth", "Luvdisc", "Bagon", "Shelgon", "Salamence", "Beldum", "Metang", "Metagross", "Regirock", "Regice",
      "Registeel", "Latias", "Latios", "Kyogre", "Groudon", "Rayquaza", "Jirachi", "Deoxys", "Turtwig", "Grotle", "Torterra", "Chimchar", "Monferno", "Infernape", "Piplup", "Prinplup",
      "Empoleon", "Starly", "Staravia", "Staraptor", "Bidoof", "Bibarel", "Kricketot", "Kricketune", "Shinx", "Luxio", "Luxray", "Budew", "Roserade", "Cranidos", "Rampardos", "Shieldon", 
      "Bastiodon", "Burmy", "Wormadam", "Mothim", "Combee", "Vespiquen", "Pachirisu", "Buizel", "Floatzel", "Cherubi", "Cherrim", "Shellos", "Gastrodon", "Ambipom", "Drifloon", "Drifblim",
      "Buneary", "Lopunny", "Mismagius", "Honchkrow", "Glameow", "Purugly", "Chingling", "Stunky", "Skuntank", "Bronzor", "Bronzong", "Bonsly", "Mime Jr.", "Happiny", "Chatot", "Spiritomb",
      "Gible", "Gabite", "Garchomp", "Munchlax", "Riolu", "Lucario", "Hippopotas", "Hippowdon", "Skorupi", "Drapion", "Croagunk", "Toxicroak", "Carnivine", "Finneon", "Lumineon", "Mantyke",
      "Snover", "Abomasnow", "Weavile", "Magnezone", "Lickilicky", "Rhyperior", "Tangrowth", "Electivire", "Magmortar", "Togekiss", "Yanmega", "Leafeon", "Glaceon", "Gliscor", "Mamoswine",
      "Porygon-Z", "Gallade", "Probopass", "Dusknoir", "Froslass", "Rotom", "Uxie", "Mesprit", "Azelf", "Dialga", "Palkia", "Heatran", "Regigigas", "Giratina", "Cresselia", 
      "Phione", "Manaphy", "Darkrai", "Shaymin", "Arceus"};
   private class MyTimerTask extends TimerTask
   {
       @Override
       public void run() 
       {
           Platform.runLater(() -> setButtons(false));
       }
   }  
   
   private String base_URL = "sprites-master/sprites-master/sprites/pokemon/", originalChoice = base_URL + "0.png", trollText = "This will break the program";
   private final Image[] pokeList = {
   new Image(originalChoice), new Image(originalChoice), 
   new Image(originalChoice), new Image(originalChoice),
   new Image(originalChoice), new Image(originalChoice)};
   
   private final ImageView[] viewPokeList = {new ImageView(), new ImageView(), new ImageView(), new ImageView(), new ImageView(), new ImageView()};
  
   private Button firstAttB = new Button(trollText), secondAttB = new Button(trollText), thirdAttB = new Button(trollText), returnB = new Button("Return to home");
   
   private static Stage window;
   
   private BackgroundImage myBI;
  
   private Media battleMusic, attackMusic;
   private MediaPlayer mediaPlayer, attackPlayer;
   private FloatControl gainControl;
   private Clip clip;
   private Label ownLabel = new Label(), enemyLabel = new Label();
   
   private TextField ownHealth = new TextField(), enemyHealth = new TextField(), battleAction = new TextField(), enemyAction = new TextField();
   
   private SVGPath animation = new SVGPath();
    
   private Pane homeLayout, catchLayout, excite, initialLayout;
   
   private BorderPane battleLayout, centerTop;
   
   private Scene battle, homeScene, choiceScene, catchScene, initialScene;
  
   private ImageView spriteView, finalOne, pokeBall;
   
   private ScrollPane choiceScroll, battleScroll;
   
   private GridPane choiceLayout;
   
   private Timer timer = new java.util.Timer();         
   /**
      arrayIndexOf method returns the index e is in for the array, provided it's in the array. 
   */
   private int arrayIndexOf(String[] arr, String e)
   {
      for (int i = 0; i < arr.length; i++)
         if (arr[i].equals(e))
            return i; 
      return -1;
   }
   private String getStyleColor(String buttonText)
   {
     String[] backgroundColors = {"#9ACD32", "#403B37", "#000080", "#FFFF00", "#FFC0CB", "#800000", "#FF0000", "#ADD8E6", "#00008B",
                                  "#00FF00", "#B5651D", "#0000FF", "#C0C0C0", "#800080", "#E75480", "#DEB887", "#696969", "#0000DD"};
     String[] fontColors = {"#000000", "#FFFFFF", "#FF0000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", 
                            "#000000", "#000000", "#000000", "#000000", "#FFFF00", "#000000", "#000000", "#000000", "#000000"};
     for (int row = 0; row < moveTypeList.size(); row++)
     {
         for (int col = 0; col < moveTypeList.get(row).size(); col++)
           if (buttonText.equals(moveTypeList.get(row).get(col)))
               return backgroundColors[row] + fontColors[row];
     }  
     return "#FFFFFF" + "#000000";
   }
   private void setUpItems()
   { 
      for (int i = 0; i < 10; i++)
         userItems.add(new Item("Hyper Potion", "sprites-master/sprites-master/sprites/items/dream-world/Hyper Potion.png"));
      for (int i = 0; i < 7; i++)
         userItems.add(new Item("Attack Boost", "sprites-master/sprites-master/sprites/items/dream-world/x-attack.png"));
      for (int i = 0; i < 5; i++)
         userItems.add(new Item("Defense Boost", "sprites-master/sprites-master/sprites/items/dream-world/x-defense.png"));    
   }
   public ArrayList<Item> getUserItems()
   {
      return userItems;
   }
   public static ArrayList<Pokemon> getUserPokemon()
   {
      return userPokemon;
   }
   private void setUpMoveTypes() throws Exception
   {
      BufferedReader temp = new BufferedReader(new FileReader("Texts/moveTypeList.txt"));
      String e = temp.readLine();
      for (int i = 0; i < 18; i++)
      {
         moveTypeList.add(new ArrayList<String>());
         while (!e.equals(","))
         {       
            moveTypeList.get(i).add(e.substring(0, e.indexOf(",")));
            System.out.println(e.substring(0, e.indexOf(",")));
            System.out.println(e);
            e = temp.readLine();
         }
         System.out.println(moveTypeList);
         e = temp.readLine();
      }
   }  
   private void setUpMoves() throws Exception
   {
      BufferedReader te = new BufferedReader(new FileReader("Texts/moveList.txt"));
      String fileLine = te.readLine();
      for (int i = 0; i < names.length; i++)
      {
         moveList.add(new ArrayList<String>());
         for (int j = 10; j < 92; j++)
            while (!fileLine.contains("1. [") || fileLine.contains("#")||fileLine == "" || fileLine.contains(j + ". ["))
              fileLine = te.readLine();    
         int start =  fileLine.substring(0, fileLine.indexOf("[") + 2).length();
         String firstMove = fileLine.substring(start, fileLine.substring(start).indexOf("'") + fileLine.substring(0, start - 2).length() + 2);
         moveList.get(i).add(firstMove);
         System.out.print(firstMove + ", ");
         start = fileLine.substring(start).indexOf("'") + fileLine.substring(0, start - 2).length() + 2 + 4;
         String secondMove = fileLine.substring(start, fileLine.substring(start).indexOf("'") + fileLine.substring(0, start - 2).length() + 2);
         moveList.get(i).add(secondMove);
         System.out.print(secondMove + ", ");
         start = fileLine.substring(start).indexOf("'") + fileLine.substring(0, start - 2).length() + 2 + 4;
         String thirdMove = fileLine.substring(start, fileLine.substring(start).indexOf("'") + fileLine.substring(0, start - 2).length() + 2);
         moveList.get(i).add(thirdMove);
         System.out.println(thirdMove);
         fileLine = te.readLine();
     }
   }
   private void setUpStats() throws Exception
   {
      BufferedReader e = new BufferedReader(new FileReader("Texts/pokemon.csv"));
      String an = e.readLine();
      double[] statMultipliers = {3, 1.5, .95};
      for (int i = 0; i < names.length; i++)
      {
         String s = e.readLine();
         statList.add(new ArrayList<Double>());
         for (int f = 0; f < 5; f++)
            s = s.substring(s.indexOf(",") + 1);
         for (int stat = 0; stat < 3; stat++)
         {
            Double stats = new Integer(Integer.parseInt(s.substring(0, s.indexOf(",")))) * statMultipliers[stat];
            s = s.substring(s.indexOf(",") + 1);
            statList.get(i).add(stats);          
         }
      }
   }
  /* public static void main(String args[])
   {
      System.out.print(System.getProperty("os.name").startsWith("Windows"));
      launch(args);
   }*/
   private void shiftImages(CheckBox t)
   {
      for (int check = 0; check < gottenNames.size(); check++)
      {
         if (t.getText() == gottenNames.get(check))
         {
            gottenNames.remove(check);
            break;
         }
      }
   }
   private void setUpCheckBox()
   {
      int columnLength = 41, teamSize = 5; 
      int columnAmount = names.length / columnLength;
      int statementExecutionCount = 0;
      for (int j = 0; j < columnAmount; j++)
      {
         for (int i = 0; i < columnLength; i++)
         {
            statementExecutionCount++;
            checkBoxList.add(new CheckBox());  
            GridPane.setConstraints(checkBoxList.get(i + j * columnLength), j + j*2, i + 10);
            checkBoxList.get(i + j * columnLength).setText(names[i + j * columnLength]);
            checkBoxList.get(i + j * columnLength).setId("fireAttack");
            checkBoxList.get(i + j * columnLength).setTextFill(Color.web("#00FFFF"));
            checkBoxList.get(i + j * columnLength).setPrefSize(100, 40);
            checkBoxList.get(i + j * columnLength).setOnAction(ev ->    
            {          
               resetImages(teamSize);
               CheckBox tmp = (CheckBox) ev.getSource();
               if (tmp.isSelected())
                 gottenNames.add(tmp.getText());
               else
                 shiftImages(tmp);
               if (gottenNames.size() > teamSize)
               {
                  gottenNames.remove(teamSize);
                  for (int remover = 0; remover < checkBoxList.size(); remover++)
                  {
                     if (checkBoxList.get(remover).getText() == gottenNames.get(0))
                     {
                        checkBoxList.get(remover).setSelected(false);
                        break;
                     }
                  }
                  for (int index = 0; index < gottenNames.size() - 1; index++)
                      gottenNames.set(index, gottenNames.get(index + 1));
                  gottenNames.set(gottenNames.size() - 1, tmp.getText());
               }
               for (int a = 0; a < gottenNames.size(); a++)
               {
                  pokeList[a] = new Image(base_URL + gottenNames.get(a).toLowerCase() + ".png");
                  viewPokeList[a].setImage(pokeList[a]);
               }
            });
            choiceLayout.getChildren().addAll(checkBoxList.get(i + j * columnLength));
         }
      }
      System.out.println(statementExecutionCount);
   }
   private void setUpChoices()
   {
      setUpCheckBox();
      setUpTypeImages();   
   }
   private void setUpTypes() throws Exception
   {
      BufferedReader reader = new BufferedReader(new FileReader("Texts/types.txt"));
      String fileLine = reader.readLine();
      int index = 0;
      while (index < names.length)
      {
         arr.add(new ArrayList<String>());
         if (fileLine.substring(fileLine.indexOf("{"), fileLine.substring(fileLine.indexOf("{")).indexOf("}")).contains(","))
         {
            String firstType = fileLine.substring(fileLine.indexOf("\"") + 1, fileLine.substring(fileLine.indexOf("\"") + 1).indexOf("\"") + fileLine.indexOf("\"") + 1);
            arr.get(index).add(firstType);
            String secondType = fileLine.substring(fileLine.indexOf(",") + 3, fileLine.indexOf("}") - 1);
            arr.get(index).add(secondType);
         }
         else
         {
            String type = fileLine.substring(fileLine.indexOf("\"") + 1, fileLine.indexOf("}") - 1);
            arr.get(index).add(type); 
         }
         System.out.println(arr.get(index));
         fileLine = reader.readLine();
         index++;
      } 
   }
   private void setUpTypeImages()
   {
      for (int p = 0; p < arr.size(); p++)
      {
         typesList.add(new ArrayList<ImageView>());
         for (int y = 0; y < arr.get(p).size(); y++)
         {  
            ImageView type = new ImageView("Types/" + arr.get(p).get(y) + ".png");
            typesList.get(p).add(type);
            //typesList.get(p).get(y).setFitWidth(30);
            //typesList.get(p).get(y).setFitHeight(30); OH MY GOD THESE TWO LINES WERE THE SOURCE OF LAG BCUZ RESIZING IMAGES TAKES TOO MUCH PROCESSING POWER  
            GridPane.setConstraints(typesList.get(p).get(y), GridPane.getColumnIndex(checkBoxList.get(p)) + y + 1, GridPane.getRowIndex(checkBoxList.get(p))); 
            choiceLayout.getChildren().add(typesList.get(p).get(y));
         }
      }
   }
   private void resetImages(int team)
   {
      for (int a = 0; a < team; a++)
      {
         pokeList[a] = new Image(originalChoice);
         viewPokeList[a].setImage(pokeList[a]);      
      }
   }
   private void setButtons(boolean r)
   {
      firstAttB.setDisable(r);
      secondAttB.setDisable(r);
      thirdAttB.setDisable(r);
   }
   @Override
   public void run()
   {
      System.out.println("hi");
      try 
      {
         Thread.sleep(1000);
         setButtons(false);
         System.out.print(1);
      }
      catch (Exception e)
      {
      }
   }
   public static double returnWidth()
   {
      return window.getWidth();
   }
   public static double returnHeight()
   {
      return window.getHeight();
   }
   private void setUpLayouts()
   {  
      choiceLayout = new GridPane();
      choiceLayout.setId("choiceLayout");
      
      choiceLayout.setVgap(8);
      choiceLayout.setHgap(10);
      choiceLayout.setPadding(new Insets(10, 10, 10, 10));
      
      choiceScroll = new ScrollPane();
      choiceScroll.setContent(choiceLayout);
      battleLayout = new BorderPane();
      battleLayout.setTop(new HBox(20, ownLabel, ownHealth, battleAction, enemyAction, enemyLabel, enemyHealth));
      ((HBox) battleLayout.getTop()).setAlignment(Pos.CENTER);
      battleLayout.setLeft(new VBox(20));
      battleLayout.setRight(new VBox(20));
      battleLayout.setCenter(new BorderPane());
      VBox bigRight = (VBox) battleLayout.getRight();
      bigRight.setAlignment(Pos.TOP_CENTER);
      
      battleScroll = new ScrollPane(battleLayout);
      centerTop = (BorderPane) battleLayout.getCenter();
      centerTop.setTop(new HBox(20));
      centerTop.setRight(new VBox(0));
      centerTop.setLeft(new VBox(0));
      centerTop.setCenter(new Pane());
      ((HBox)(centerTop.getTop())).setAlignment(Pos.CENTER);
     
      homeLayout = new Pane();
      catchLayout = new Pane();
      initialLayout = new Pane();
      initialLayout.setId("initialLayout");
   }
   private int whichPokemon(ArrayList<Pokemon> array, String input)
   {  
      for (int i = 0; i < array.size(); i++)
         if (array.get(i).getName().equals(input))
            return i;
      return 0;
   }
   private int arrayListOf(ArrayList<String> a, String str)
   {
      for (int i = 0; i < a.size(); i++)
         if (str.equals(a.get(i)))
            return i;
      return 0;
   }
   private void setButtonColors(String firstText, String secondText, String thirdText)
   {
      firstAttB.setText(firstText);
      String t = getStyleColor(firstAttB.getText());
      firstAttB.setStyle("-fx-background-color: " + t.substring(0, 7) + "; -fx-text-fill: " + t.substring(7) + ";");
      secondAttB.setText(secondText);  
      t = getStyleColor(secondAttB.getText());
      secondAttB.setStyle("-fx-background-color: " + t.substring(0, 7) + "; -fx-text-fill: " + t.substring(7) + ";");
      thirdAttB.setText(thirdText);
      t = getStyleColor(thirdAttB.getText());
      thirdAttB.setStyle("-fx-background-color: " + t.substring(0, 7) + "; -fx-text-fill: " + t.substring(7) + ";");                    
   }
   private void setUpCorners()
   {
      String[] eliteFourURLs = {originalChoice, originalChoice, originalChoice, originalChoice};  
      ImageView[] viewEliteFour = 
      {
         new ImageView(new Image(eliteFourURLs[0])), new ImageView(new Image(eliteFourURLs[1])),
         new ImageView(new Image(eliteFourURLs[2])), new ImageView(new Image(eliteFourURLs[3]))  
      };
   
      int[] xarr = {0, (int) (window.getWidth() * .9), 0, (int) (window.getWidth() * .9)};
      int[] yarr = {0, 0, (int) (window.getHeight() * .81), (int) (window.getHeight() * .81)};
      for (int i = 0; i < xarr.length; i++)
      {  
         viewEliteFour[i].relocate(xarr[i], yarr[i]);
         homeLayout.getChildren().add(viewEliteFour[i]);
      }
   }
   private boolean checkNames(String r)
   {
      for (int i = 0; i < userPokemon.size(); i++)
         if (userPokemon.get(i).getName().equals(r))
            return true;
      return false;
   }
   private void addWildPokemon(ArrayList<Pokemon> e)
   {
      int index = (int)(Math.random() * (names.length));
      if (!checkNames(names[index]))
      {
         if (arr.get(index).size() == 2)   
           e.add(new Pokemon(statList.get(index).get(0), statList.get(index).get(1), statList.get(index).get(2), arr.get(index).get(0), arr.get(index).get(1), names[index]));
         else
           e.add(new Pokemon(statList.get(index).get(0), statList.get(index).get(1), statList.get(index).get(2), arr.get(index).get(0), names[index]));
      }
      else
         addWildPokemon(e);
   }
   private void setUpScenes()
   {
      String startingMessage = "Please click one of your pokemon to call it out, then press a button.";
      window.show();
      window.setMaximized(true);  
      setUpCorners();
      initialScene = new Scene(initialLayout, window.getWidth(), window.getHeight());
      initialScene.getStylesheets().add(getClass().getResource("CSS/initialScene.css").toExternalForm());
      initialScene.setOnMouseClicked(e -> 
      {
         if (AlertBox.display("Do you want to play?"))
         {
            window.setTitle("Pokemon Picker");
            window.setScene(choiceScene);
            setUpMusic(musicBase + "opening" + musicEnd);
         }
         else
            System.exit(0);
      });
      choiceScene = new Scene(choiceScroll, window.getWidth(), window.getHeight());
      choiceScene.getStylesheets().add(getClass().getResource("CSS/choiceScene.css").toExternalForm()); 
      for (int i = 0; i < 5; i++)
      {
         GridPane.setConstraints(viewPokeList[i], i*3, 0);
         //viewPokeList[i].setFitWidth(75);            this is how i would fix the magikarp size issue but nah, easter egg haha :)
         //viewPokeList[i].setFitHeight(75);
         choiceLayout.getChildren().add(viewPokeList[i]);
      }
      KeyCombination combination = new KeyCodeCombination(KeyCode.W, KeyCodeCombination.SHIFT_DOWN);
      choiceScene.setOnKeyPressed(event ->
      {
         if (combination.match(event))
         {
            String temp = NameBox.display("","Please type the name of the pokemon you want here.");
            for (int i = 0; i < checkBoxList.toArray().length; i++)
            {
               if (temp != null && checkBoxList.get(i).getText().toLowerCase().contains(temp.toLowerCase()))
                  checkBoxList.get(i).setStyle("-fx-background-color:rgb(000, 000, 000);"); 
               else
                  checkBoxList.get(i).setStyle("-fx-background-color: #D83F87;");	
            }
            return;
         }
         switch (event.getCode())
         {
            case I:
               Information.displayInformation();
               break;
            case M:
               volume += .1;
               break;
            case N:
               volume -= .1;
               break;
            case P:
               if (gottenNames.size() == 0)
                   return;
               if (AlertBox.display("Are these the Pokemon you want on your team? Once you confirm this, you can no longer hand pick your Pokemon."))
               {
                 for (int i = 0; i < gottenNames.size(); i++)
                 {
                     int index = arrayIndexOf(names,gottenNames.get(i));
                     if (arr.get(arrayIndexOf(names,gottenNames.get(i))).size() == 2)   
                        System.out.println(userPokemon.add(new Pokemon(statList.get(index).get(0) * 1.5, statList.get(index).get(1), statList.get(index).get(2), arr.get(index).get(0), arr.get(index).get(1), gottenNames.get(i))));
                     else
                        userPokemon.add(new Pokemon(statList.get(index).get(0) * 1.5, statList.get(index).get(1), statList.get(index).get(2), arr.get(index).get(0), gottenNames.get(i)));
                 } 
                 ((VBox) battleLayout.getLeft()).setAlignment(Pos.CENTER);
                 ((VBox) centerTop.getLeft()).setAlignment(Pos.CENTER);
                 ((VBox) centerTop.getLeft()).getChildren().add(new Label());
                 ((VBox) centerTop.getRight()).setAlignment(Pos.CENTER);
                 ((VBox) centerTop.getRight()).getChildren().add(new Label());
                 Label outPokemon = (Label) ((VBox) centerTop.getLeft()).getChildren().get(0);
                 window.setScene(homeScene);
                 window.setTitle("Home");
                 setUpMusic(musicBase + "homeMusic" + musicEnd);
               }
               break;
            default:
               return;
         }   
         if (volume < 0)//-80)
            volume = 0;
         if (volume > 1)// 6.0206)
            volume = 1;
    //     gainControl.setValue((float) volume);
         mediaPlayer.setVolume(volume);
      });
      x = (int)(window.getWidth() / 2);
      y = (int)(window.getHeight() / 2);
      battle = new Scene(battleScroll, window.getWidth(), window.getHeight());
      battle.getStylesheets().add(getClass().getResource("CSS/battleScene.css").toExternalForm());
      battle.setOnKeyPressed(ev -> 
      {
         switch (ev.getCode())
         {
            case I:
              Information.displayInformation();
              break;
            case M:
               volume += .1;
               break;
            case N:
               volume -= .1;
               break;
            case P:
               HealBox.displayHealBox();
               displayTeams(userPokemon, battleLayout.getLeft(), "ownList");
               break;
            default:
               return;    
         }
         if (volume < 0)
            volume = 0;
         if (volume > 1)
            volume = 1;
         //gainControl.setValue((float) volume);
         mediaPlayer.setVolume(volume);
      });
      catchScene = new Scene(catchLayout, window.getWidth(), window.getHeight());
      catchLayout.setStyle("-fx-background-image: url(grass.png);");
      ImageView catchPokemon = new ImageView(base_URL + "player.png");
      catchPokemon.setFitWidth(30);
      catchPokemon.setFitHeight(30);
      catchLayout.getChildren().add(catchPokemon);
      catchScene.setOnKeyPressed(ev ->
      {
         switch (ev.getCode())
         {
            case I:
               Information.displayInformation();
               break;
            case D:
               if (catchPokemon.getLayoutX() > 1285)
                  x += 0;
               else 
                  x += 10;
               break;
            case W:
               if (catchPokemon.getLayoutY() < 0)
                  y -= 0;
               else
                  y -= 10;
               break;
            case S:
               if (catchPokemon.getLayoutY() > (window.getHeight() * .8))
                  y += 0;
               else
                  y += 10;
               break;
            case A:
               if (catchPokemon.getLayoutX() < 0)
                  x -= 0;
               else   
                  x -= 10;
               break; 
            case M:
               volume += .1;
               break;
            case N:
               volume -= .1;
               break;
            default:
               return;
         }
         if (volume < 0)
            volume = 0;
         if (volume > 1)
            volume = 1;
         mediaPlayer.setVolume(volume);
        // gainControl.setValue((float) volume);
         catchPokemon.relocate(x, y);
         if (6 > userPokemon.size())
         {   
            String wildName = names[(int)(Math.random() * names.length)];
            ArrayList<Pokemon> wildTeam = new ArrayList();
            pokeBall = new ImageView();
            addWildPokemon(wildTeam);
            if (Math.random() < .1)
            {
               general = wildTeam;
               ComboBox<String> tempItems = new ComboBox<>();
               tempItems.getItems().addAll("Poke-Ball", "Ultra-Ball");
               tempItems.setOnAction(e -> 
               {
                  excite.getChildren().remove(pokeBall);
                  pokeBall = new ImageView(new Image("sprites-master/sprites-master/sprites/items/" + tempItems.getValue().toLowerCase() + ".png"));
                  pokeBall.relocate(0, window.getHeight() / 2);
                  excite.getChildren().add(pokeBall);
               });
               HBox buttonRow = (HBox) centerTop.getTop();
               Button tryCatch = new Button("Throw your ball");
               tryCatch.setOnAction(e ->
               {
                  if (tempItems.getValue() != null)
                  {
                     if (wildTeam.size() > 0)
                     {
                        System.out.println(1 - ((double) wildTeam.get(0).getHealth() / wildTeam.get(0).getMaxHealth()) / 2);
                        double a = (double) wildTeam.get(0).getHealth() / wildTeam.get(0).getMaxHealth();  
                        if (tempItems.getValue().equals("Ultra-Ball"))
                           a /= 2;
                        if ((1 - a) > Math.random())
                        {
                           userPokemon.add(wildTeam.get(0));
                           wildTeam.remove(0);   
                           VBox p = (VBox) centerTop.getRight();
                           Label y = (Label) p.getChildren().get(0);
                           y.setGraphic(null); 
                           displayTeams(userPokemon, battleLayout.getLeft(), "ownList");
                           displayTeams(general, battleLayout.getRight(), "pokemonList");
                        }
                        else
                           AlertBox.display("Your " + tempItems.getValue() + " failed! Try again");
                     }
                     else
                     {
                        buttonRow.getChildren().remove(tempItems);
                        AlertBox.display("What are you doing Mr.Holmer? There aren't any more pokemon left to catch...");
                        window.setScene(homeScene);
                        setUpMusic(musicBase + "homeMusic" + musicEnd);
                        x = window.getWidth() / 2;
                        y = window.getHeight() / 2;
                        spriteView.relocate(x, y);
                     }
                  }
               });
               setUpBattle(musicBase + "wildBattle" + musicEnd, startingMessage);
               excite.getChildren().add(tempItems);
               buttonRow.getChildren().add(tryCatch);  
            }
         }
         else
         {
            AlertBox.display("You already have 6 pokemon, no more ._.");
            window.setScene(homeScene);
            window.setTitle("Home");
            setUpMusic(musicBase + "homeMusic" + musicEnd);     
            x = window.getWidth() / 2;
            y = window.getHeight() / 2;
            spriteView.relocate(x, y);
         }
      });
      homeScene = new Scene(homeLayout, window.getWidth(), window.getHeight());
      homeScene.setOnKeyPressed(ev ->
      {
         switch (ev.getCode())
         {
             case I:
               Information.displayInformation();
               break;    
            case P:
               HealBox.displayHealBox();
               break;
            case D:
               if (spriteView.getLayoutX() > window.getWidth() * .945)
                  x += 0;
               else 
                  x += 10;
               break;
            case W:
               if (spriteView.getLayoutY() < 0)
                  y -= 0;
               else
                  y -= 10;
               break;
            case S:
               if (spriteView.getLayoutY() > (window.getHeight() * .85))
                  y += 0;
               else
                  y += 10;
               break;
            case A:
               if (spriteView.getLayoutX() < 0)
                  x -= 0;
               else   
                  x -= 10;
               break; 
            case M:
               volume += .1;
               break;
            case N:
               volume -= .1;
               break;
            default:
               return;
         }
         int cornerDimension = 96;
         if (finalOne != null && spriteView.getLayoutX() > (int)(window.getWidth() / 2) && spriteView.getLayoutY() > (int)(window.getHeight() / 2) && AlertBox.display("Are you ready?"))
         {
            general = finalTeam;
            setUpBattle(musicBase + "topLeftMusic" + musicEnd, "Don't even try, leave.");
         }
         else if (spriteView.getLayoutX() < cornerDimension && spriteView.getLayoutY() == window.getHeight() / 2)
         {
            window.setScene(catchScene);
            window.setTitle("Time to try your luck!");
         }
         else if (spriteView.getLayoutX() < cornerDimension && spriteView.getLayoutY() < cornerDimension)
         {
            general = topLeft;
            if (general.size() > 0 && AlertBox.display("Are you sure you want to fight Mr.Turner?"))
               setUpBattle(musicBase + "topLeftMusic" + musicEnd, startingMessage); 
            else
            {
               x = (int)(window.getWidth() / 2);
               y = (int)(window.getHeight() / 2);   
            }
         }
         else if (spriteView.getLayoutX() < cornerDimension && spriteView.getLayoutY() > (int) (window.getHeight() * .81) - cornerDimension)
         { 
            general = bottomLeft;
           
            if (general.size() > 0 && AlertBox.display("Are you sure you want to fight Mr.Folwell?"))
              setUpBattle(musicBase + "bottomLeftMusic" + musicEnd, startingMessage);
            else
            {
               x = (int)(window.getWidth() / 2);
               y = (int)(window.getHeight() / 2);   
            }  
         }
         else if (spriteView.getLayoutX() > (int)(window.getWidth() * .9 - 25 - cornerDimension) && spriteView.getLayoutY() < cornerDimension)
         { 
            general = topRight;      
            if (general.size() > 0 && AlertBox.display("Are you sure you want to fight Mr.Holmer?"))
               setUpBattle(musicBase + "topRightMusic" + musicEnd, startingMessage);
            else
            {
               x = (int)(window.getWidth() / 2);
               y = (int)(window.getHeight() / 2);   
            }  
         }
         else if (spriteView.getLayoutX() > (int)(window.getWidth() * .9 - 25 - cornerDimension) && spriteView.getLayoutY() > (int) (window.getHeight() * .81) - cornerDimension)
         {    
            general = bottomRight;
            if (general.size() > 0 && AlertBox.display("Are you sure you want to fight Mr.Miller?"))
               setUpBattle(musicBase + "topRightMusic" + musicEnd, startingMessage); // MAKE SURE TO FIND ONE MORE MP3 FILE FOR THIS BATTLE
            else
            {
               x = (int)(window.getWidth() / 2);
               y = (int)(window.getHeight() / 2);   
            }  
         }
         spriteView.relocate(x, y);
          if (volume < -80)
             volume = -80;
          if (volume > 6.0206)
             volume = 6.0206;        
   //       gainControl.setValue((float) volume);
         mediaPlayer.setVolume(volume);
      });
   }
   private void setUpBattle(String musicurl, String mes)
   {
      excite.getChildren().clear();
      if (general.size() == 0)
         excite.getChildren().add(returnB);
      else
         excite.getChildren().add(animation);
      HBox smallTop = (HBox) centerTop.getTop();
      smallTop.getChildren().clear();
      smallTop.getChildren().addAll(firstAttB, secondAttB, thirdAttB);
      VBox smallLefty = (VBox) centerTop.getLeft();
      smallLefty.getChildren().clear();
      smallLefty.getChildren().add(new Label());
      Label y = (Label) smallLefty.getChildren().get(0);      
      y.setGraphic(new ImageView(new Image(base_URL + "/back/" + userPokemon.get(0).getName() + ".png")));      
      setUpTextFields(String.format("%.2f", userPokemon.get(0).getHealth()), String.format("%.2f", (float)general.get(0).getHealth()), mes, mes);   
      displayTeams(userPokemon, battleLayout.getLeft(), "ownList");
      displayTeams(general, battleLayout.getRight(), "pokemonList");    
      setUpMusic(musicurl);
      returnB.relocate(excite.getWidth() / 2, excite.getHeight() / 2);
      ownLabel.setText(userPokemon.get(0).getName() + "'s Health:");
      enemyLabel.setText(general.get(0).getName() + "'s Health:");
      window.setTitle("Let's duel!");
      window.setScene(battle);   
   }
   private void setUpTextFields(String health, String enHealth, String batAction, String enAction)
   {
      ownHealth.setText(health);
      enemyHealth.setText(enHealth); 
      
      battleAction.setText(batAction);
      enemyAction.setText(enAction);
   }   
   private void playAttackAudio()
   {
      String attackFile = musicBase + "attackAudio" + musicEnd; //credit to zapsplat website lul
      /*try 
      {
         Clip clip = AudioSystem.getClip();
         clip.open(AudioSystem.getAudioInputStream(new File(attackFile)));
         gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue((float) volume);
         clip.start();
      }
      catch (Exception ex)
      {
          ex.printStackTrace();
      }
     */ attackPlayer = new MediaPlayer(new Media(new File(attackFile).toURI().toString()));
      attackPlayer.setVolume(volume);
      attackPlayer.play();
   }
   private void animate(Node e)
   {
      Path path = new Path();
      path.getElements().addAll(new MoveTo(0, excite.getHeight() / 2), new HLineTo(250), new CubicCurveTo(40f, 10f, 390f, 240f, excite.getWidth(), excite.getHeight() / 2)); 
      
      PathTransition pathTrans = new PathTransition(Duration.millis(2500), path, e);
      pathTrans.setCycleCount(1);
      pathTrans.setAutoReverse(false);
      pathTrans.play();
   }
   private void buttonAction(Button bt, int m)
   {
      double[] multipliers = {.9, 1, 1.2};                 
      if (userPokemon.size() > 0 && general.size() > 0)
      {
         VBox smallLefty = (VBox) centerTop.getLeft();
         Label y = (Label) smallLefty.getChildren().get(0);      
         setButtons(true);        
         VBox smallRight = (VBox) centerTop.getRight();
         Collections.swap(userPokemon, 0, arrayListOf(gottenNames, y.getText()));                
         Attack ownAttack = new Attack(multipliers[m], userPokemon.get(0), general.get(0), bt.getText());
         general.get(0).setHealth(ownAttack.getModifier());
         Attack enemyAttack = new Attack(multipliers[m], general.get(0), userPokemon.get(0), moveList.get(arrayIndexOf(names, general.get(0).getName())).get((int)(Math.random() * 3)));
         System.out.println(userPokemon.get(0));
         System.out.println(general.get(0));
         System.out.println(ownAttack);
         System.out.println(enemyAttack);
         userPokemon.get(0).setHealth(enemyAttack.getModifier());
         timer.schedule(new MyTimerTask(), 2500);
         playAttackAudio();
         animate(animation);
         if (userPokemon.get(0).getHealth() <= 0 && general.get(0).getHealth() <= 0)
         {
            battleAction.setText(userPokemon.get(0).getName() + " and " + general.get(0).getName() +  " were both knocked out.");
            userPokemon.remove(0);
            general.remove(0);
            if (general.size() == 0)
            {
               VBox last = (VBox) battleLayout.getRight();
               last.getChildren().clear();
               setButtons(true);
               smallRight.getChildren().clear();
               excite.getChildren().add(returnB);
               return;
            }
            enemyLabel.setText(general.get(0).getName() + "'s Health: ");
            if (userPokemon.size() == 0)
            {
               EndBox.display("Sadly, you\'ve lost because you weren\'t gamer enough. Thank you for playing, please come again!", ":( Very sad");
               VBox last = (VBox) battleLayout.getRight();
               last.getChildren().clear();
               HBox buttonRow = (HBox) centerTop.getTop();
               buttonRow.getChildren().clear();
            }
            y.setGraphic(new ImageView(new Image(base_URL + "/back/" + userPokemon.get(0).getName() + ".png")));      
         }
         else if (userPokemon.get(0).getHealth() <= 0)
         {
            battleAction.setText(userPokemon.get(0).getName() + " was defeated."); 
            userPokemon.get(0).zeroHealth();
            userPokemon.remove(0);
            if (userPokemon.size() == 0)
            {
               EndBox.display("Sadly, you\'ve lost because you weren\'t gamer enough. Thank you for playing, please come again!", ":( Very sad");   
               VBox last = (VBox) battleLayout.getRight();
               last.getChildren().clear();
               HBox buttonRow = (HBox) centerTop.getTop();
               buttonRow.getChildren().clear();
               return;
            }
            ownLabel.setText(userPokemon.get(0).getName() + "'s Health: ");
            ownHealth.setText(userPokemon.get(0).getHealth() + "");
            enemyHealth.setText(general.get(0).getHealth() + "");   
            y.setGraphic(new ImageView(new Image(base_URL + userPokemon.get(0).getName().toLowerCase() + ".png")));
         }
         else if (general.get(0).getHealth() <= 0)
         {
            battleAction.setText(general.get(0).getName() + " was defeated."); 
            general.remove(0);
            if (general.size() == 0)
            {
               setButtons(true);   
               VBox last = (VBox) battleLayout.getRight();
               smallRight.getChildren().clear();
               last.getChildren().clear();
               BorderPane a = (BorderPane) battleLayout.getCenter();
               Pane b = (Pane) a.getCenter();
               b.getChildren().add(returnB);
               return;
            }
            enemyLabel.setText(general.get(0).getName() + "'s Health: ");
            ownHealth.setText(userPokemon.get(0).getHealth() + "");
            enemyHealth.setText(general.get(0).getHealth() + "");
            y.setGraphic(new ImageView(new Image(base_URL + userPokemon.get(0).getName().toLowerCase() + ".png")));   
         }
         else
         {
            ownHealth.setText(userPokemon.get(0).getHealth() + "");        
            ownLabel.setText(userPokemon.get(0).getName() + "'s Health:");
         }
         if (general.size() == 0)
         {
            VBox last = (VBox) battleLayout.getRight();
            last.getChildren().clear();   
         }
         else
            setUpTextFields(String.format("%.2f", userPokemon.get(0).getHealth()), String.format("%.2f", general.get(0).getHealth()), ownAttack.toString(), enemyAttack.toString()); 
         setButtonColors(moveList.get(arrayIndexOf(names, userPokemon.get(0).getName())).get(0), moveList.get(arrayIndexOf(names, userPokemon.get(0).getName())).get(1), moveList.get(arrayIndexOf(names, userPokemon.get(0).getName())).get(2));
         if (general.size() > 0)
         {
            smallRight.getChildren().clear();
            smallRight.getChildren().add(new Label());
            Label enemyPoke = (Label) smallRight.getChildren().get(0);
            enemyPoke.setGraphic(new ImageView(new Image(base_URL + general.get(0).getName().toLowerCase() + ".png")));
         }  
         y.setGraphic(new ImageView(new Image(base_URL + "/back/" + userPokemon.get(0).getName() + ".png")));      
         displayTeams(general, battleLayout.getRight(), "pokemonList");
         displayTeams(userPokemon, battleLayout.getLeft(), "ownList");     
      }
   }
   private void setUpButtons()
   {
      returnB.setPrefSize(200, 50);
      returnB.setId("return");
      returnB.setOnAction(e -> 
      {
         if (userPokemon.size() == 0)
         {
            EndBox.display("Sadly, you\'ve lost because you weren\'t gamer enough. Thank you for playing, plase come again!", ":( Very sad");
            return;
         }
         if (topLeft.size() == 0 && bottomLeft.size() == 0 && topRight.size() == 0 && bottomRight.size() == 0)
         {
            finalOne = new ImageView(base_URL + "0" + ".png");
            finalOne.relocate((int)(window.getWidth() / 2), (int)(window.getHeight() / 2));
            homeLayout.getChildren().add(finalOne);
         }
         window.setScene(homeScene);
         window.setTitle("Home");
         setUpMusic(musicBase + "homeMusic" + musicEnd);
         x = window.getWidth() / 2;
         y = window.getHeight() / 2;
         spriteView.relocate(x, y);
      });
      firstAttB.setOnAction(this);
      secondAttB.setOnAction(this);
      thirdAttB.setOnAction(this);
   }
   private void displayTeams(ArrayList<Pokemon> a, Node b, String id)
   {      
       VBox side = (VBox) b; 
       side.getChildren().clear();
       for (int row = 0; row < a.size(); row++)    
       {
         side.getChildren().add(new Label(a.get(row).getName()));
         side.getChildren().add(new ProgressBar());
         ProgressBar health = (ProgressBar) side.getChildren().get(row * 2 + 1);
         health.setProgress((double) a.get(row).getHealth() / a.get(row).getMaxHealth());
         health.setId("health");
         Label whichPokemon = (Label) side.getChildren().get(row * 2);
         whichPokemon.getStyleClass().add(id);
         whichPokemon.setGraphic(new ImageView(new Image(base_URL + whichPokemon.getText().toLowerCase() + ".png"))); 
         VBox smallLeft = (VBox) centerTop.getLeft();
         Label ownPoke = (Label) smallLeft.getChildren().get(0);
         final int i = row;
         if (side.equals(battleLayout.getLeft()))
         {
            side.getChildren().get(row * 2).setOnMouseClicked(e -> 
            {
              if (userPokemon.size() > 1)   
               Collections.swap(userPokemon, i, 0);              
              ownHealth.setText(userPokemon.get(0).getHealth() + "");
              if (general.size() > 0)
               enemyHealth.setText(general.get(0).getHealth() + "");
              ownLabel.setText(userPokemon.get(0).getName() + "'s Health:");  
              setButtonColors(moveList.get(arrayIndexOf(names, userPokemon.get(0).getName())).get(0), moveList.get(arrayIndexOf(names, userPokemon.get(0).getName())).get(1), moveList.get(arrayIndexOf(names, userPokemon.get(0).getName())).get(2));
              ownPoke.setGraphic(new ImageView(new Image(base_URL + "/back/" + userPokemon.get(0).getName() + ".png")));
              displayTeams(userPokemon, battleLayout.getLeft(), "ownList");
              Label firstOne = (Label) side.getChildren().get(0);
              firstOne.setId("darkRed");         
            });
         }
         whichPokemon.setGraphic(new ImageView(new Image(base_URL + whichPokemon.getText().toLowerCase() + ".png")));
         whichPokemon.setPrefWidth(175);
         whichPokemon.setPrefHeight(60);
         whichPokemon.getStyleClass().add(id);
         Label firstOne = (Label) side.getChildren().get(0);
      }
   }
   private void setUpMusic(String music_URL)
   {
   /*     if (clip != null)
         clip.stop();
        try 
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(music_URL)));
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue((float) volume);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
   */
      if (mediaPlayer != null)
         mediaPlayer.stop();                   
      mediaPlayer = new MediaPlayer(new Media(new File(music_URL).toURI().toString()));
      mediaPlayer.setVolume(volume);
      mediaPlayer.setAutoPlay(true);
      mediaPlayer.play();
      mediaPlayer.setOnEndOfMedia(new Runnable() 
      {
         @Override
         public void run()
         {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
         }
      });
   }
   private void setUpEnemyTeams()
   { 
      String[][] nameList =
      {
          {"Blastoise", "Kyogre", "Gyarados", "Empoleon"},
          {"Rayquaza", "Salamence", "Dragonite", "Garchomp"},
          {"Ho-Oh", "Entei", "Moltres", "Infernape"},
          {"Jirachi", "Dialga", "Metagross", "Lucario"},
          {"Arceus", "Magikarp"}
      };
      ArrayList<ArrayList<Pokemon>> enemyTeams = new ArrayList();
      enemyTeams.add(topLeft);
      enemyTeams.add(bottomLeft);
      enemyTeams.add(topRight);
      enemyTeams.add(bottomRight);
      enemyTeams.add(finalTeam);
      for (int i = 0; i < 4; i++)
      {
        for (int j = 0; j < nameList[i].length; j++)
        {    
            int index = arrayIndexOf(names, nameList[i][j]);
            System.out.println(index);
            if (arr.get(index).size() == 2)   
               enemyTeams.get(i).add(new Pokemon(statList.get(index).get(0), statList.get(index).get(1), statList.get(index).get(2), arr.get(index).get(0), arr.get(index).get(1), nameList[i][j]));
            else
               enemyTeams.get(i).add(new Pokemon(statList.get(index).get(0), statList.get(index).get(1), statList.get(index).get(2), arr.get(index).get(0), nameList[i][j]));
         }
      }
   }  
   @Override
   public void start(Stage primaryStage) throws Exception
   {  
      musicBase = "Windows/";// System.getProperty("os.name").substring(0, System.getProperty("os.name").indexOf(" ")) + "/";
     // if (System.getProperty("os.name").startsWith("Windows"))
         musicEnd = ".mp3";
     // else
    //     musicEnd = ".wav";
     // musicBase = "Mac/";
   //   musicEnd = ".wav"; this is just Mac stuff that Wilson and I did  
      window = primaryStage;
      window.setOnCloseRequest(e ->
      {
         if (AlertBox.display("Are you sure you want to leave?"))
            System.exit(0);
         else
            e.consume();
      });
      window.requestFocus();
      window.getIcons().add(new Image(base_URL + "magikarp.png"));
      setUpItems();
      setUpTypes();
      setUpMoves();
      setUpMoveTypes();
      setUpButtons();   
      setUpLayouts();  
      setUpChoices();
      setUpScenes(); 
      setUpStats();
      setUpEnemyTeams();
      
      ownHealth.setEditable(false);
      enemyHealth.setEditable(false);
      battleAction.setEditable(false);
      enemyAction.setEditable(false);
      battleAction.setPrefSize(400, 25); 
      enemyAction.setPrefSize(400, 25);
      
      ownLabel.setTextFill(Color.web("#FF0000"));
      enemyLabel.setTextFill(Color.web("#00FF00"));
    
      excite = (Pane) ((BorderPane) battleLayout.getCenter()).getCenter();
   
      Label clickMessage = new Label("Please click the screen.");
      clickMessage.relocate(window.getWidth() / 2, window.getHeight() / 2);
      initialLayout.getChildren().add(clickMessage);
   
      animation.setContent(animationContent[0]);
      excite.getChildren().add(animation);
      window.setScene(initialScene);
      window.setTitle("");
    
      // poke ball url --> /sprites-master/sprites-master/sprites/items/poke-ball.png");
      spriteView = new ImageView(base_URL + "player.png");
      spriteView.relocate(window.getWidth() / 2, window.getHeight() / 2);
      ImageView grassImage = new ImageView("grass.png");
      grassImage.relocate(0, window.getHeight() / 2);
      homeLayout.getChildren().addAll(spriteView, grassImage);
      homeLayout.setBackground(new Background(new BackgroundImage(new Image("pokemonarena.jpg", window.getWidth(), window.getHeight(), false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
      Information.displayInformation();
   }
   @Override
   public void handle(ActionEvent e)
   {
      //(new Thread(new JavaFx())).start();      
      if (((Button) e.getSource()).getText().equals(trollText))
      {
        AlertBox.display("Please follow the instructions Mr. Holmer, don't try to break my program smh");
        return;
      }
      Button[] attackButtons = {firstAttB, secondAttB, thirdAttB};
      for (int i = 0; i < attackButtons.length; i++)
         if (attackButtons[i].equals((Button) e.getSource()))
             buttonAction((Button) e.getSource(), i);
   }
}