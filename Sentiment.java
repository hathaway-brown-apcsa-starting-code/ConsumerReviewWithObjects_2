
/**
 * Sentiment contains a word and a sentiment value.
 * Positive values are for positive words; negative for negative.
 * Larger numbers are for stronger words.
 * 
 * For use with the APCS-A lab "Consumer Review"
 *
 * @author Michael Buescher, Hathaway Brown School, modified from the Consumer Review case study code
 * @version 2020-05-30
 */

public class Sentiment
{
    private String word;
    private double value;
    
    /** Stores a word and a value for the new Sentiment object
     *  @param str   a word
     *  @param v     the value associated with the word
     */
    public Sentiment (String str, double v)
    {
        word = str;
        value = v;
    }
    
    /** Returns the word for this Sentiment object
     *  @return the word for this Sentiment object     */
    public String getWord ()
    {  return word;  }
    
    /** Returns the value of this Sentiment object
     *  @return the value of this Sentiment object     */
    public double getValue ()
    {  return value; }
}
