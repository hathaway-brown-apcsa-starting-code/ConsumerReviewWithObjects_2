
/**
 * SentimentList is a List of Sentiment objects.
 * A Sentiment contains a word and a sentiment value.
 * 
 * For use with the APCS-A lab "Consumer Review"
 *
 * @author Michael Buescher, Hathaway Brown School, modified from the Consumer Review case study code
 * @version 2020-05-30
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class SentimentList
{
    private ArrayList<Sentiment> wordList;
    
    /** Constructor creates a new empty list and fills it from the file cleanSentiment.csv  */
    public SentimentList()
    {
        wordList = new ArrayList<Sentiment>();
        LoadSentimentsFromFile("cleanSentiment.csv");
    }
    
    /**
     * Loads the list of Sentiments from a Comma-Separated-Values file
     * PRECONDITION: The file contains text in the format [word, value]
     *   stored in alphabetical order by word
     * 
     * @param fileName  The name of the file containing words and their sentiments
     */
    public void LoadSentimentsFromFile (String fileName)
    {
        File f = new File(fileName);
        Scanner input = null;
        try 
        {
            input = new Scanner(f);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);        // quit the program
        } 
        
        while(input.hasNextLine())
        {
            String temp = input.nextLine();
            int comma = temp.indexOf(',');
            String word = temp.substring(0, comma);
            double value = Double.parseDouble(temp.substring(comma + 1));
            
            wordList.add(new Sentiment (word, value));
            
            //System.out.println("added " + word + ", " + value);
        }
        input.close();
    }
  

    
    /** 
     * Returns the sentiment value of the given word.
     * Returns 0 if there is no sentiment value found for that word.
     * Searches for the given word using a binary search.
     * 
     * @param  word   The word to get the sentiment value for
     * @return the sentiment value of the word parameter
     */
    public double getSentimentValue (String word)
    {
        // ignore case when searching
        word = word.toLowerCase();
        System.out.println("Finding sentiment value for \"" + word + "\"");
        
        // Searches the wordList using a binary search
        int low = 0; 
        int high = wordList.size() - 1;
        while (low <= high)
        {
            int middle = (low + high) / 2;
            String currentWord = wordList.get(middle).getWord();
            if (currentWord.equals(word))
            {
                return wordList.get(middle).getValue();
            }
            else if (currentWord.compareTo(word) < 0)
            {
                low = middle + 1;
            }
            else
            {
                high = middle - 1;
            }
        }
        
        // If you get here, the word was not found
        return 0.0;
    }
}
