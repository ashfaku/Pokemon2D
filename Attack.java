public class Attack 
{ 
  private String[][] weaknesses = 
  {
    /*0, Bug*/{"Bug","Fighting", "Fire", "Flying", "Poison", "Ghost", "Steel", "Fairy"},
    /*1, Dark*/{"Dark", "Fighting", "Dark", "Fairy"},
    /*2, Dragon*/{"Dragon", "Steel", "Fairy"},
    /*3, Electric*/{"Electric", "Grass", "Dragon", "Ground"},
    /*4, Fairy*/{"Fairy", "Poison", "Steel", "Fire"},
    /*5, Fighting*/{"Fighting", "Flying", "Poison", "Bug", "Psychic", "Fairy", "Ghost"},
    /*6, Fire*/{"Fire", "Rock", "Water", "Dragon"},
    /*7, Flying*/{"Flying", "Rock", "Steel", "Electric"},
    /*8, Ghost*/{"Ghost", "Dark", "Normal"},
    /*9, Grass*/{"Grass", "Flying", "Poison", "Bug", "Steel", "Fire", "Dragon"},
    /*10, Ground*/{"Ground", "Bug", "Grass", "Flying"},
    /*11, Ice*/{"Ice", "Steel", "Fire", "Water"},
    /*12,Normal*/{"Normal", "Rock", "Steel", "Ghost"},
    /*13, Ppison*/{"Poison", "Ground", "Rock", "Steel", "Ghost"},
    /*14, Psychic*/{"Psychic", "Steel", "Dark"},
    /*15, Rock*/{"Rock", "Fighting", "Ground", "Steel"},
    /*16, Steel*/{"Steel", "Fire", "Ground", "Fighting"},
    /*17, Water*/{"Water", "Grass", "Electric", "Dragon"}
  };  
  private double enemyDefense, ownAttack, modifier;
  private Pokemon a, b;
  private String attack;
  private int getWeakness()
  {
      int amount = 0;
      for (String[] arr: weaknesses)
      {
         if (b.getType().equals(arr[0]) || (b.hasSecondType() && b.getSecondType().equals(arr[0])))
            for (int j = 1; j < arr.length; j++)
               if (a.getType().equals(arr[j]) || (a.hasSecondType() && a.getSecondType().equals(arr[j])))
                   amount++;
      }
      return amount;  
  }
  /**
      * @attacker will never be null
      * @defender will never be null
  */
  public Attack(double mp, Pokemon attacker, Pokemon defender, String text) 
  {
    a = attacker;
    b = defender;
    ownAttack = a.getAttack() * (1 + (getWeakness() * .35)) * mp;
    enemyDefense = b.getDefense();
    attack = text;
    if (ownAttack > enemyDefense)
      modifier = ownAttack - enemyDefense; 
    else
      modifier = 2;
  }
  /**
      modifier will never be 0
  */
  public double getModifier()
  {
    return modifier;
  }
  public Pokemon getAttacker()
  {
    return a;
  }
  public Pokemon getDefender()
  {
    return b;
  }
  public String toString()
  {
    return a.getName() + " did " + attack + ". " + b.getName() + " took " + String.format("%.2f", modifier) + " damage.";
  }
}