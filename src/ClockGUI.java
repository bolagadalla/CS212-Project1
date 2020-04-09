import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * This class contains everything that would be needed to show a window on the screen
 * This class extends from the JFrame Library so it would be able to inherit everything that is in JFrame
 * 
 * @author Bola Gadalla
 *
 */
public class ClockGUI extends JFrame
{
   // Text area for the unsorted array
   JTextArea unsortedClockText = new JTextArea();
   // Text area for the sorted array
   JTextArea sortedClockText = new JTextArea();
   Container myContent = new Container();
   
   /**
    * 
    * @param title - The title of the window
    * @param width - The width of the window
    * @param height - The height of the window
    * @param unsorted - The unsorted array to be shown in the window
    * @param sorted - The sorted array to be shown in the window
    */
   public void ShowClockData(String title, int width, int height, Clock[] unsorted, Clock[] sorted)
   {
      // Sets Properties of the Window
      setTitle(title);
      setSize(width, height);
      setLocation(400, 200);
      setLayout(new GridLayout(1, 2));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      // Adds the JTextArea to the layout of the window
      add(unsortedClockText);
      add(sortedClockText);
      // Sets the text of the array to the JTextArea
      unsortedClockText.setText(AddingClockDataToTextArea(unsorted));
      unsortedClockText.setEditable(false);
      sortedClockText.setText(AddingClockDataToTextArea(sorted));
      sortedClockText.setEditable(false);
      // Sets the window visible
      setVisible(true);
   }
   
   /**
    * Adds data from the clock array to the text area
    * @param clockArray - The array to get data from
    * @return returns a string with all the data from the array
    */
   private String AddingClockDataToTextArea(Clock[] clockArray)
   {
      String clockText = "";
      // This will loop through the array and adds it to the string variable
      for (int i = 0; i < clockArray.length; i++)
         clockText += clockArray[i] + "\n";
      // Returns the string
      return clockText;
   }
}
