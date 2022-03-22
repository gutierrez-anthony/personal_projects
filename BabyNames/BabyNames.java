/* Anthony Gutierrez
   11/15/2021
   BabyNames.java
   This program prompts the user for a name and reads through a 
   file to search for that name. The program then displays the years 
   and ranking for that name. If a name is not found, a short
   message will indicate so.
*/

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class BabyNames
{
   static Scanner fileScanner;
   static Scanner lineScanner;
   static Scanner keyboardScanner;
   static boolean found;
   
   public static void main(String[] args) throws FileNotFoundException
   {
      System.out.println("This program uses data from " + 
      "the Social Security \nAdministration to see how popular " + 
      "a particular name has \nbeen over the last century. " +
      "The first column displays \nthe year, and the second " +
      "column displays the ranking. \nOnly the top 100 rankings " +
      "are tracked. A zero means that \nthe name was not in " +
      "the top 1000 for that year.");
      
      //Open the file
      File namesFile = new File("names.txt");
      fileScanner = new Scanner(namesFile);
      
      String name = getName();
      
      getBabyName(name);
      
      validator(name);
      
   } //End of main
   
   public static String getName()
   {
      //Get the name from the user
      keyboardScanner = new Scanner(System.in);
      System.out.print("Enter a name: ");
      String name = keyboardScanner.nextLine();
      
      return name;
   } //End of getName()
   
   public static void getBabyName(String name)
   {
      //Read file until match is found
      while(fileScanner.hasNext())
      {
         //Read a line from the file into the line scanner
         String line = fileScanner.nextLine();
         lineScanner = new Scanner(line);
         
         //Get the name from the line
         String babyName = lineScanner.next();
         
         //If it matches the search 
         if (babyName.equalsIgnoreCase(name))
         {
            int max_year = getYear();
            
            System.out.print(babyName + " was most popular in " + max_year);
            
            found = true;
            break;
         }
      } // End of while loop
   } //End of getBabyName()
   
   public static int getYear()
   {
      int rank = 0;
      int max_rank = 0;
      int max_year = 0;
      //Print the line
      //System.out.println(line);
      for (int year = 1910; year <= 2010; year=year+10)
      {
         rank = lineScanner.nextInt();
         System.out.println(year + ": " + rank);
         if (rank >= max_rank)
         {
            max_year = year;
            max_rank = rank;
         }
      }
      return max_year;
   }
   public static void validator(String name)
   {
      // Validate the name has been found
      if (found == false)
      {
         System.out.println(name + " not found.");
      }
   }
} //End of class