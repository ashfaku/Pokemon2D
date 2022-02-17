public class Cheese
{
   private String quality;
   private boolean isOld;
   private static boolean isDivisible(int a, int b)
   {
     return a % b == 0 || b % a == 0;
   }                                                           
   private static int indexInt(int num, int index)
   {
     return Integer.parseInt((num + "").substring(index, index + 1));                    
   }
   private static int frequency(int num, int check)
   {
      String str = num + "";
      int amount = 0;
      for (int i = 0; i < str.length(); i++)
         if (str.substring(i, i + 1).equals(check + ""))
            amount++;
      return amount;             
   }
   private static int maxDigit(int num)
   {
      String test = num + "";
      int a = 0;
      String[] array = {};
      int max = Integer.parseInt(test.substring(0, 1));
      for (int i = 0; i < test.length(); i++)
      {
         a = Integer.parseInt(test.substring(i, i + 1));
         if (a > max)
            max = a;
      }
      return max;
   }       
   private static int minDigit(int num)
   {
      String test = num + "";
      int a = 0;
      int min = Integer.parseInt(test.substring(0, 1));
      for (int i = 0; i < test.length(); i++)
      {
         a = Integer.parseInt(test.substring(i, i + 1));
         if (a < min)
            min = a;
      }
      return min;      
   }
   private static int sum(int num)
   {
      int returnVal = 0;
      for (int i = 0; i < (num + "").length(); i++)
         returnVal += indexInt(num, i);
      return returnVal;
  }
  private static double average(int num)
  {
      return (double) sum(num) / (num + "").length();    
  }  
  private static int mode(int num)
  {
      int[] array = {0, 0, 0, 0, 0, 0, 0, 0, 0};
      String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
      for (int i = 0; i < (num + "").length(); i++)
         for (int j = 0; j < arr.length; j++)
            if ((num + "").substring(i, i+1).equals(arr[j]))
               array[j] += 1;     
      int max = 0;
      for (int i = 0; i < array.length; i++)
         max = Math.max(max, array[i]);
      for (int i = 0; i < arr.length; i++)
         if (array[i] == max)
            return Integer.parseInt(arr[i]);   
      return -1;               
  }                          
  private static int minIndex(int[] array)
  {
     int a = array[0];
     for (int i: array)
        a = Math.min(a, i);
     return a;
  }
  private static int maxIndex(int[] array)
  {
     int a = array[0];
     for (int i: array)
        a = Math.max(a, i);
     return a;
  }
  private static int sumArray(int[] array)
  {
     int a = 0;
     for (int c: array)
        a += c;
     return a;
  }
  private static double mean(int[] array)
  {
     return sumArray(array) / array.length;
  } 
  private static int frequency(int[] array, int a)
  {
     int amount = 0;
     for (int i: array)
        if (i == a)
           amount++;
     return amount;
  }
  private static int mode(int[] array)
  {
       int whichNum = array[0];
       int freq = frequency(array, array[0]);
       for (int i: array)
         if (i != whichNum && frequency(array, i) >= freq) 
         {
            freq = frequency(array, i);
            whichNum = i;
         }
       return whichNum;
  } 
  private boolean checkOnePokemon()
  {
     Pokemon[] cheese = {new Pokemon(250, 100, 30, "Water", "Swampert"), new Pokemon(300, 110, 40, "Water", "Ground", "Kyogre"),
     new Pokemon(300, 110, 40, "Water", "Gyarados"), new Pokemon(300, 110, 40, "Water", "Mudkip")};
     for (int i = 0; i < cheese.length; i++)
     if (cheese[i].hasSecondType())
        return true;
     return false;
  }
  private boolean checkAllPokemon()
  {
     Pokemon[] cheese = {new Pokemon(250, 100, 30, "Water", "Ground",  "Swampert"), new Pokemon(300, 110, 40, "Water", "Ground", "Kyogre"),
     new Pokemon(300, 110, 40, "Water", "Ground", "Gyarados"), new Pokemon(300, 110, 40, "Water", "Ground", "Mudkip")};
     int a = 0;
     for (int i = 0; i < cheese.length; i++)
        if (cheese[i].hasSecondType())
           a++;
    return a == cheese.length;
  }
  private int checkForAmountOfPokemonWithCriteria()
  {
     Pokemon[] cheese = {new Pokemon(250, 100, 30, "Water", "Ground",  "Mudkip"), new Pokemon(300, 110, 40, "Water", "Ground", "Kyogre"),
     new Pokemon(300, 110, 40, "Water", "Gyarados"), new Pokemon(250, 100, 30, "Water", "Mudkip")};
     int a = 0;
     for (int i = 0; i < cheese.length; i++)
        if (cheese[i].hasSecondType())
           a++;
     return a; 
  } 
  private void pairOfElements()
  {
     String[] cheese = {"Hi ", "Mr. Holmer, ", "you ", "are ", "very ", "epic."};
     for (int i = 0; i < cheese.length; i+=2)
        System.out.print(cheese[i] + cheese[i+1]);
  }
  private static boolean checkDuplicates(int[] array)
  {
      for (int i: array)
         if (frequency(array, i) > 1)
            return true;
       return false;    
  }  
  private static int[] shiftRight(int[] array)
  {
      int[] hold = new int[array.length];
      for (int i = 0; i < array.length; i++)
        hold[i] = array[i]; 
      int holder = array[array.length - 1];
      for (int i = hold.length - 1; i > 0; i--)
         hold[i] = array[i-1];   
      hold[0] = holder;
      return hold;
  }
  private static int[] shiftLeft(int[] array)
  {
     int[] hold = new int[array.length];
     for (int i = 0; i < array.length; i++)
       hold[i] = array[i];
     int holder = array[0];
     for (int i = 0; i < hold.length - 1; i++) 
       hold[i] = array[i+1];
     hold[array.length - 1] = holder;
     return hold;
  }
  private static int[] reverseOrder(int[] array)
  {
    int[] hold = new int[array.length];
    for (int i = 0; i < array.length; i++)
      hold[i] = array[i];
    for (int i = 0; i < hold.length; i++) 
      hold[i] = array[array.length - i - 1];
    return hold; 
  }
  private static boolean containsElement(int[] array, int a)
  {
      for (int i: array)
         if (i == a)
            return true;
      return false;
  }
  public static void main(String[] args)
  {  
     System.out.println(isDivisible(10, 3));
     System.out.println(indexInt(12344, 2));
     System.out.println(frequency(12344, 4));
     System.out.println(maxDigit(12344)); // idk why i used 12344 specifically
     System.out.println(minDigit(12344)); 
     System.out.println(sum(12344));
     System.out.println(average(12344));
     System.out.println(mode(12344));
     int[] ints = {6, 5, 4, 3, 2, 1, 100, -199, 0};
     String[] strings = {"s", "s", "s", "Hi", "Mr.", "Holmer", "hi", "Mr.", "holmer", "ashfak", "is", "very", "pogger", "and", "smart", "And", "his", "brain", "Is", "expanding"};
     System.out.println(maxIndex(ints));
     System.out.println(minIndex(ints));
     System.out.println(sumArray(ints)); 
     System.out.println(mean(ints));
     System.out.println(mode(ints));
     System.out.println(containsElement(ints, 2));
     System.out.println(frequency(ints, 2));
     System.out.println(checkDuplicates(ints));
     int[] leftInts = shiftLeft(ints);       
     for (int i = 0; i < leftInts.length; i++)
        System.out.print(leftInts[i] + (i != leftInts.length - 1 ? ", " : "\n"));       
     int[] rightInts = shiftRight(ints);
     for (int i = 0; i < rightInts.length; i++)
        System.out.print(rightInts[i] + (i != rightInts.length - 1 ? ", " : "\n"));  
     int[] reverseInts = reverseOrder(ints);
     for (int i = 0; i < reverseInts.length; i++)
        System.out.print(reverseInts[i] + (i != reverseInts.length - 1 ? ", " : "\n"));  
  }
}