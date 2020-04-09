/**
 * This is a custom object called Clock that would hold hours, minutes, and seconds in a clock format
 * This is the model of clock
 * 
 * @author Bola Gadalla
 *
 */
public class Clock
{
   private int hours;
   private int minutes;
   private int seconds;
   
   /**
    * This is the constructor of the class Clock which would take in the following parameters and storing them
    * 
    * @param hours - The hours part of the clock
    * @param minutes - The minutes part of the clock
    * @param seconds - The seconds part of the clock
    */
   public Clock(int hours, int minutes, int seconds)
   {
      this.setHours(hours);
      this.setMinutes(minutes);
      this.setSeconds(seconds);
   }

   /**
    * @return hours
    */
   public int getHours()
   {
      return hours;
   }

   /**
    * @param hours - The number of hours to set
    */
   public void setHours(int hours)
   {
      this.hours = hours;
   }

   /**
    * @return minutes
    */
   public int getMinutes()
   {
      return minutes;
   }

   /**
    * @param minutes - The amount of minutes to set
    */
   public void setMinutes(int minutes)
   {
      this.minutes = minutes;
   }

   /**
    * @return seconds
    */
   public int getSeconds()
   {
      return seconds;
   }

   /**
    * @param seconds - The amount of seconds to set
    */
   public void setSeconds(int seconds)
   {
      this.seconds = seconds;
   }
   
   /**
    * @return It returns the time in a clock format, e.g. hours:minutes:seconds
    */
   public String toString()
   {
      return hours + ":" + minutes + ":" + seconds;
   }
}
