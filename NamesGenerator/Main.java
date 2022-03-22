/* Anthony Gutierrez
   03/22/2021
   Main.java
   This program generates a random name and continuously prompts the user if they
   want to keep generating new names.
*/

import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws FileNotFoundException {
    File nameFile = new File("names.txt");
    // Scanner to read the file for the first time
    Scanner reader = new Scanner(nameFile);
    // Scanner to read the file into array
    Scanner names = new Scanner(nameFile);
    // Scanner to receive user input
    Scanner input = new Scanner(System.in);
    Random newName = new Random();
    int namesCount = 0;
    String userWord = "";
    
    while(reader.hasNext())
    {
      reader.next();
      namesCount++;
    }
    
    String[] namesList = new String[namesCount];
    System.out.println("There are a total of " + namesCount + " names in the file.");

    namesCount = 0;
    
    while(names.hasNext())  
    {
      String listName = names.next();
      namesList[namesCount] = listName;
      namesCount++;
    }
    //System.out.println(Arrays.toString(namesList)); Check to make sure the array has the nmaes from the names.txt file
    String randomName = namesList[newName.nextInt(namesList.length)];
    System.out.println(randomName); //Check to make sure a different name is chosen and the name randomizer works
    System.out.println("Would you like to generate a new name?\nEnter yes or no");
    userWord = input.nextLine();
    while(!userWord.equalsIgnoreCase("yes") && !userWord.equalsIgnoreCase("no"))
      {
        System.out.println("Enter yes or no");
        userWord = input.nextLine();
      }
    while(!userWord.equalsIgnoreCase("no"))
      {
        randomName = namesList[newName.nextInt(namesList.length)];
        System.out.println(randomName);
        System.out.println("Would you like to generate a new name?\nEnter yes or no");
        userWord = input.nextLine();
        while(!userWord.equalsIgnoreCase("yes") && !userWord.equalsIgnoreCase("no"))
          {
            System.out.println("Enter yes or no");
            userWord = input.nextLine();
          }
      }
  }
}
