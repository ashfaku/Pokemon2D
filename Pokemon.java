public class Pokemon
{
  private String name;
  private double health;
  private double attack;
  private double defense;
  private String type;
  private String secondType;
  private static int numOfPokemon;
  private double restartHealth;
  public Pokemon (double h, double att, double def, String t, String n)
  {
    health = h;
    restartHealth = h;
    attack = att;
    defense = def;
    type = t;
    name = n;
    numOfPokemon++;
  }
  public Pokemon (double h, double att, double def, String t, String str, String n)
  {
    health = h;
    restartHealth = h;
    attack = att;
    defense = def;
    type = t;
    secondType = str;
    name = n;
    numOfPokemon++;
  }
  public double getMaxHealth()
  {
    return restartHealth;
  }
  public String getName()
  {
    return name;
  }
  public static int getNumOfPokemon()
  {
   return numOfPokemon;
  }
  public static void subtract(int t)
  {
   numOfPokemon -= t;
  }
  public void restart()
  {
      health = restartHealth;
  }
  public double getHealth()
  {
    return health;
  }
  public double getAttack()
  {
    return attack;
  }
  public double getDefense()
  {
    return defense;
  }
  public String getType()
  {
    return type;
  }
  public boolean equals(Pokemon p)
  {
   if (p.secondType == null && this.secondType == null)
      return p.name.equals(this.name) && p.attack == this.attack & p.defense == this.defense && p.health == this.health && p.restartHealth == this.restartHealth && p.type.equals(this.type);
   else if (p.secondType == null && this.secondType != null || p.secondType != null && this.secondType == null)
      return false;
   else if (p.secondType != null && this.secondType != null)
      return p.secondType.equals(this.secondType) &&  p.name.equals(this.name) && p.attack == this.attack & p.defense == this.defense && p.health == this.health && p.restartHealth == this.restartHealth && p.type.equals(this.type);
   return true;
  }
  public boolean hasSecondType()
  {
      if (secondType == null)
         return false;
      return true;
  }
  public String getSecondType()
  {
    return secondType;
  }
  public void setHealth(double modifier)
  {
    health -= modifier;
  }
  public void maxHealth()
  {
   health = restartHealth;
  }
  public void zeroHealth()
  {
    health = 0;
  }
  public String toString()
  {
    String first = (name + " has " + health + " health, " + attack + " attack, " + defense + " defense, and");
    String second = " is " + type + " type";
    if (secondType != null)
      second += "/" + secondType + " type.";
    else
      second += ".";
    return first + second;
  }
  public void setName(String n)
  {
      name = n;
  }
  public void setAttack(int n)
  {
      attack += n;
  }
  public void setDefense(int n)
  {
    defense += n;
  }
}