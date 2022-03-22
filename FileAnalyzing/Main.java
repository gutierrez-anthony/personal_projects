/* Anthony Gutierrez
   03/15/2022
   Main.java
   This program analyzes files, creates an updated version of the file, 
   sorts the file by date of birth, and prompts the user for a year to 
   show all of the members born that year.
*/

import java.util.*;
import java.io.*;

class Main {
  public static PrintStream outputPaused;
  public static PrintStream outputCompleted;
  public static PrintStream outputCancelled;
  
  public static void main(String[] args) throws FileNotFoundException
  {
    File pausedFile = new File("fitness-paused-members.csv");
    File completedFile = new File("fitness-completed-members.csv");
    File cancelledFile = new File("fitness-cancelled-members.csv");
    Scanner keyboard = new Scanner(System.in);
    //Create new files that can be rewritten
    outputPaused = newPrintStream(pausedFile);
    outputCompleted = newPrintStream(completedFile);
    outputCancelled = newPrintStream(cancelledFile);
    
    //call filePopulator method to update new files with the old file information
    filePopulator(pausedFile, outputPaused);
    filePopulator(completedFile, outputCompleted);
    filePopulator(cancelledFile, outputCancelled);

    File updatedPausedFile = new File("updated-fitness-paused-members.csv");
    File updateCompletedFile = new File("updated-fitness-completed-members.csv");
    File updatedCancelledFile = new File("updated-fitness-cancelled-members.csv");

    String[][] updatedPausedArray = createFileArray(updatedPausedFile);
    String[][] updatedCompletedArray = createFileArray(updateCompletedFile);
    String[][] updatedCancelledArray = createFileArray(updatedCancelledFile);

    //Check to make sure array was created properly
    //System.out.println(Arrays.toString(updatedPausedArray));
    //System.out.println(updatedPausedArray[0][6]);
    arraySorter(updatedPausedArray);
    arraySorter(updatedCompletedArray);
    arraySorter(updatedCancelledArray);
    //Check to make sure original array was overwritten
    // for(int i = 0; i < updatedPausedArray.length; i++)
    //   {
    //     System.out.println(Arrays.toString(updatedPausedArray[i]));
    //   }
    //Deletes the old updated file
    updatedPausedFile.delete();
    updateCompletedFile.delete();
    updatedCancelledFile.delete();
    //Creates a new updated file
    outputPaused = new PrintStream(new File("updated-" + pausedFile.getName()));
    outputCompleted = new PrintStream(new File("updated-" + completedFile.getName()));
    outputCancelled = new PrintStream(new File("updated-" + cancelledFile.getName()));
    //Stores the sorted arrays into the new updated file
    createSortedFile(updatedPausedArray, outputPaused);
    createSortedFile(updatedCompletedArray, outputCompleted);
    createSortedFile(updatedCancelledArray, outputCancelled);

    updatedPausedFile = new File("updated-fitness-paused-members.csv");
    updateCompletedFile = new File("updated-fitness-completed-members-a.csv");
    updatedCancelledFile = new File("updated-fitness-cancelled-members-a.csv");
    
    System.out.println("Your original files has been sorted by date of birth.");
    System.out.println("Enter which file you would like to use.\n(paused, completed, cancelled)\ntype q to quit");
    String fileChoice = keyboard.nextLine();
    while(!fileChoice.equalsIgnoreCase("q"))
      {
        while(!fileChoice.equalsIgnoreCase("paused") && !fileChoice.equalsIgnoreCase("completed") && !fileChoice.equalsIgnoreCase("cancelled") && !fileChoice.equalsIgnoreCase("q"))
        {
          System.out.println("Enter which file you would like to use.\n(paused, completed, cancelled)\ntype q to quit");
          fileChoice = keyboard.nextLine();
        }
        if(fileChoice.equalsIgnoreCase("q"))
        {
          break;
        }
        System.out.println("Enter the lowest year to search: ");
        int minYear = keyboard.nextInt();
        keyboard.nextLine();
        while(minYear < 0 || minYear > 2021)
          {
            System.out.println("Enter the lowest year to search: ");
            minYear = keyboard.nextInt();
            keyboard.nextLine();
          }
        System.out.println("Enter the max year to search: ");
        int maxYear = keyboard.nextInt();
        keyboard.nextLine();
        while(maxYear < minYear || maxYear > 2022)
          {
            System.out.println("Enter the max year to search: ");
            maxYear = keyboard.nextInt();
            keyboard.nextLine();
          }
        if(fileChoice.equalsIgnoreCase("paused"))
        {
          printInfo(updatedPausedArray, minYear, maxYear);
        }
        else if(fileChoice.equalsIgnoreCase("completed"))
        {
          printInfo(updatedCompletedArray, minYear, maxYear);
        }
        else if(fileChoice.equalsIgnoreCase("cancelled"))
        {
          printInfo(updatedCancelledArray, minYear, maxYear);
        }
        System.out.println("Enter which file you would like to use.\n(paused, completed, cancelled)\ntype q to quit");
        fileChoice = keyboard.nextLine();
      }
    
  }//End of main method

  public static PrintStream newPrintStream(File myCSV) throws FileNotFoundException
  {
    return new PrintStream(new File("updated-" + myCSV.getName()));
  }//End of newPrintStream method
  
  public static void filePopulator (File oldFile, PrintStream fileName) throws FileNotFoundException
  {
    Scanner read = new Scanner(oldFile);
    Scanner words = new Scanner(oldFile);

    // Variable counter to check to see how big the array created needs to be
    int count = 0;
    String columnCheck = "";
    // Loop that reads every row in file and keeps count of how many rows read
    while(read.hasNextLine())
    {
      if(count == 0)
      {
        columnCheck = read.nextLine();
        count++;
      }
      else
      {
        read.nextLine();
        count++;
      }
      
    }
    String[] columnCount = columnCheck.split(",");
    //Create a 2-d array with the number of rows read in the loop
    String[][] wordsList = new String[count][columnCount.length];

    //Create a new counter variable incase orginal gets confused
    int wordsCount = 0;
    // Checking to make sure no errors with the array
    //System.out.println(Arrays.toString(wordsList[0]));

    // Go through file again and split the first row to make sure the program is on the right track
    while(words.hasNextLine())  
    {
      String listWord = words.nextLine();
      //Create a temporary array that takes in the split line
      String[] tempArray = listWord.split(",");
      for(int i = 0; i < tempArray.length; i++)
        {
          wordsList[wordsCount][i] = tempArray[i];
        }
      wordsCount++;
      fileName.println(Arrays.toString(tempArray));
    }
  }//End of reCreateFile method

  public static String[][] createFileArray(File newFile) throws FileNotFoundException
  {
    Scanner read = new Scanner(newFile);
    Scanner words = new Scanner(newFile);

    // Variable counter to check to see how big the array created needs to be
    int count = 0;
    String columnCheck = "";
    // Loop that reads every row in file and keeps count of how many rows read
    while(read.hasNextLine())
    {
      if(count == 0)
      {
        columnCheck = read.nextLine();
        count++;
      }
      else
      {
        read.nextLine();
        count++;
      }
      
    }
    String[] columnCount = columnCheck.split(",");
    //Create a 2-d array with the number of rows read in the loop
    String[][] updatedArray = new String[count][columnCount.length];

    int wordsCount = 0;

    // Go through file again and populate the updatedArray
    while(words.hasNextLine())  
    {
      String listWord = words.nextLine();
      String[] tempArray = listWord.split(",");
      for(int i = 0; i < tempArray.length; i++)
        {
          updatedArray[wordsCount][i] = tempArray[i];
        }
      wordsCount++;
    }
    return updatedArray; 
  }//End of createFileArray method
  
  public static void arraySorter(String[][] arr)
  {
    String[] tempArray = new String[arr.length];
    //Scan the array, pull the "age" column and place it in a temp array
    int count = 0;
    // Count how many spaces do not contain a date
    for(int i = 0; i < arr.length; i++)
      {
        tempArray[i] = arr[i][6];
        if(tempArray[i].equals(" ") || tempArray[i].equals(" dob"))
        {
          count++;
        }
      }
    Arrays.sort(tempArray);
    // System.out.println(count);
    //Narrow down the list to only contain the dates
    String[] tempList = new String[tempArray.length-count];
    count = 0;
    for(int i = 0; i < tempList.length; i++)
      {
        for(int n = count; n < tempArray.length; n++ )
          {
            if(!tempArray[n].equals(" "))
            {
              tempList[i] = tempArray[n];
              count++;
              break;
            }
            else
            {
              count++;
            }
          }
      }
    // System.out.println(Arrays.toString(tempArray));
    // System.out.println(Arrays.toString(tempList));
    String[] tempDatesList = new String[tempList.length];
    for(int i = 0; i < tempList.length; i++)
      {
        for(int n = 0; n < tempDatesList.length; n++)
          {
            if(!tempList[i].equals(tempDatesList[n]) && tempDatesList[n] == null)
            {
              tempDatesList[n] = tempList[i];
              break;
            }
            else if(tempList[i].equals(tempDatesList[n]))
            {
              break;
            }
          }
      }
    //System.out.println(Arrays.toString(tempDatesList));
    count = 0;
    for(int i = 0; i < tempDatesList.length; i++)
      {
        if(tempDatesList[i] == null)
        {
          count++;
        }
      }
    String[] datesList = new String[tempDatesList.length - count];
    for(int i = 0; i < datesList.length; i++)
      {
        datesList[i] = tempDatesList[i];
      }
    //System.out.println(Arrays.toString(datesList));
    String[][] sortedArr = new String[arr.length][arr[0].length];
    int sortArrCount = 0;
    for(int i = 0; i < arr.length; i++)
      {
        if(arr[i][6].equals(" ") || arr[i][6].equals(" dob"))
        {
          sortedArr[sortArrCount] = arr[i];
          sortArrCount++;
        }
      }
    for(int i = 0; i < datesList.length; i++)
      {
        for(int n = 0; n < arr.length; n++)
          {
            if(datesList[i].equals(arr[n][6]))
            {
              sortedArr[sortArrCount] = arr[n];
              sortArrCount++;
            }
          }
      }
    for(int i = 0; i < sortedArr.length; i++)
      {
        arr[i] = sortedArr[i];
      }
  }//End of arraySorter method

  public static void createSortedFile(String[][] sortedArr, PrintStream fileName)
  {
    for(int i = 0; i < sortedArr.length; i++)
      {
        String newLine = "";
        for(int n = 0; n < sortedArr[i].length; n++)
          {
            if(n == sortedArr[i].length-1)
            {
              newLine += sortedArr[i][n];
            }
            else
            {
              newLine += sortedArr[i][n] + ",";
            }
          }
        fileName.println(newLine);
      }        
  }//End of createSortedFile method

  public static void printInfo(String[][] arr, int minNum, int maxNum)
  {
    for(int i = 1; i < arr.length; i++)
      {
        if(arr[i][6].equals(" ") && minNum == 0)
        {
          System.out.println(arr[i]);
        }
        else if(arr[i][6].equals(" "))
        {
          continue;
        }
        else if(Integer.parseInt(arr[i][6].trim()) >= minNum &&  Integer.parseInt(arr[i][6].trim()) <= maxNum)
        {
          System.out.println(Arrays.toString(arr[i]));
        }
      }
  }//End of printInfo method
}//End of Class
