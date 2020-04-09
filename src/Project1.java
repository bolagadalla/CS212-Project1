import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This program creates a window and adds data to that window from a text file
 * We read a text file filled with clock times and we display that in a two column grid layout
 * The first column is for the unsorted times of the text file
 * The second column is for the sorted times of the text file
 * 
 * @author Bola Gadalla
 * @StudentID 23604922
 */
public class Project1
{
   // A global StringToneizer
   public static StringTokenizer myTokens;
   
   public static void main(String[] args) throws IOException
   {
      // Setting the array, unosrted
      Clock[] unsortedClock = GetArray("project1.txt");
      // Setting the array unsorted, but sorts it in the next line
      Clock[] sortedClock = CopyArray(unsortedClock);
      SortArray(sortedClock);
      // Creates a new ClockGUI object
      ClockGUI clockGUI = new ClockGUI();
      // Showing a window with the data in it
      clockGUI.ShowClockData("Clock Times", 400, 400, unsortedClock, sortedClock);
      
   }
   
   /**
    * This Function is to read the correctly formatted lines from the file and puts them in Clock object and adds that object into the Clock array
    * 
    * @param myFile is the file name to read from
    * @return An array of Clock objects
    * @throws IOException - reason for throwing an exception is because it might not find that file
    */
   public static Clock[] GetArray(String myFile) throws IOException
   {
      // Creates a BufferedReader object
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(myFile)));
      // Size of array
      int size = 0;
      // Creating an array of Clocks
      Clock[] myClock;
      // While loop to get the number of lines in the file, excluding any line that is incorrectly formatted.
      while(true)
      {
         // Reads the first line in the file
         String line = br.readLine();
         // If the line is not null
         if(line != null)
         {
            // Tokenize the line
            myTokens = new StringTokenizer(line, ":");
            // If the line has only two tokens, incorrectly formatted then skip the loop
            if(myTokens.countTokens() < 3) continue;
            
            // If the line is correctly formatted then increase the size
            size++;
         }
         // If the line is null, end of file, then break out of the loop
         else break;
      }
      
      // Closes the file
      br.close();
      // Initialize the array
      myClock = new Clock[size];
      // reinitialize the BufferedReader
      br = new BufferedReader(new InputStreamReader(new FileInputStream(myFile)));
      // Loop the file to add the strings into a Clock object and add that object into the myClock array
      for (int i = 0; i < myClock.length; i++)
      {
         // Reads the first line
         String line = br.readLine();
         // Tokenize the string
         myTokens = new StringTokenizer(line, ":");
         // If its correctly formatted, having 3 tokens
         if(myTokens.countTokens() > 2)
         {
            // Create a Clock object with parameters being the tokens
            Clock clock = new Clock(Integer.parseInt(myTokens.nextToken()), Integer.parseInt(myTokens.nextToken()), Integer.parseInt(myTokens.nextToken()));
            // Add that object to the array
            myClock[i] = clock;
         }
         else
         {
            // Prints out the lines with the incorrect format
            print(line);
            // Subtract 1 from i so that the loop would repeat but reads the next line correctly and keeps the correct index of the array
            i--;
            // Then skip the current iteration of the loop
            continue;
         }
      }
      // Finally returns the myClock Array
      return myClock;
   }
   
   /**
    * This function would sort the array by the hour, from the least to the greatest
    * @param unsortedArray - Takes in the unsortedArray to sort
    */
   private static void SortArray(Clock[] unsortedArray)
   {
      for (int i = 0; i < unsortedArray.length; i++)
      {
         // Stores in the lowest index which what would be on top
         int lowestIndex = i;
         for (int j = i + 1; j < unsortedArray.length; j++)
         {
            // We are making sure that the current index of the array is less then the lowest index of the array
            if (unsortedArray[j].getHours() < unsortedArray[lowestIndex].getHours())
            {
               // If it is, then we set the current index as the new lowest index
               lowestIndex = j;
               if (unsortedArray[lowestIndex].getHours() < unsortedArray[i].getHours())
               {
                  // Then we swap positions in the array
                  swap(unsortedArray, lowestIndex, i);
               }
            }
         }
      }
   }
   
   /**
    * This is the swap function that would swap element's index positions
    * @param unsortedArray - The array that would be sorted
    * @param lowestIndex - The current lowest index
    * @param i - The current index of the array
    */
   private static void swap(Clock[] unsortedArray, int lowestIndex, int i)
   {
      Clock temp = unsortedArray[lowestIndex];
      unsortedArray[lowestIndex] = unsortedArray[i];
      unsortedArray[i] = temp;
   }
   
   /**
    * This Method would take in a Clock[] and copies it to another array
    * This is so that we can copy the array without copying the pointer address of the array as when you do array = otherArray
    * This also prevents the program from going and read the file again which can slow down the program.
    * @param arrayToCopy - The array to copy from
    * @return Clock[] which is the new copied array
    */
   private static Clock[] CopyArray(Clock[] arrayToCopy)
   {
      Clock[] array = new Clock[arrayToCopy.length];
      for (int i = 0; i < arrayToCopy.length; i++)
      {
         Clock currentClock = arrayToCopy[i];
         array[i] = currentClock;
      }
      return array;
   }

   /**
    * Helper function so I can easily type in print("something") rather then the long line of System.out.println("something")
    * @param s - The string to print out
    */
   public static void print(String s)
   {
      System.out.println(s);
   }
}
