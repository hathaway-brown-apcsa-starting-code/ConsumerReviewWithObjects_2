
/**
 * The main code for the APCS-A Consumer Review Lab
 * This calls upon the SentimentList class and the Review class
 *
 * @author  Michael Buescher
 * @version 2020-05-30
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ReviewManager
{
    private SentimentList sentiments; 
    private ArrayList<String> positiveWords, negativeWords;
        
    public ReviewManager ()
    {
        sentiments = new SentimentList();
        positiveWords = new ArrayList<String>();
        negativeWords = new ArrayList<String>();
        LoadWordListFromFile (positiveWords, "positiveAdjectives.txt");
        LoadWordListFromFile (negativeWords, "negativeAdjectives.txt");
    }
    
    public double getTotalSentiment (Review r)
    {
        return r.totalSentiment(sentiments);
    }
    
    private void LoadWordListFromFile(ArrayList<String> wordList, String fileName)
    {
        // open the file
        File file = new File(fileName);
        Scanner input = null;
        try
        {
             input = new Scanner(file);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);        // quit the program
        } 

        // read the words from the file, one per line
        while (input.hasNext())
        {
          wordList.add(input.nextLine());
        }
        input.close();
    }
    
    /** 
     * returns a string containing all of the text in fileName (including punctuation), 
     * with words separated by a single space 
     */
    public static String textFileToString( String fileName )
    {  
      String temp = "";
      try {
          Scanner input = new Scanner(new File(fileName));
      
          //add each line in the file to the string, separated by a single space
          while(input.hasNext()){
            temp = temp + input.next() + " ";
          }
          input.close();
      
      }
      catch(Exception e){
        System.out.println("Unable to locate " + fileName);
      }
      //make sure to remove any additional space that may have been added at the end of the string.
      return temp.trim();
    }

    public static void main (String[] args)
    {
        ReviewManager manager = new ReviewManager();
        System.out.println ("Review Manager initialized");
        //System.out.println ("Review:  \"This place sucks. It is smelly and gross.\" ");
        //Review rev = new Review("This place sucks. It is smelly and gross.");
        Review rev = new Review(textFileToString("26WestReview.txt"));
        System.out.println ("Review initialized");
        System.out.println("Total sentiment: " + manager.getTotalSentiment(rev));
    }

}
