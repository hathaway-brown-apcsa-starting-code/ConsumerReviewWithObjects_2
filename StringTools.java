
/**
 * Helper methods for working with Strings in the ConsumerReview Lab
 *
 * @author College Board case study, modified by Michael Buescher
 * @version 2020-06
 */
public class StringTools
{
    /**
     * Returns the word after removing any beginning or ending punctuation
     */
    public static String removePunctuation( String word )
    {
        while(word.length() > 0 && !Character.isNumberOrDigit(word.charAt(0)))
        {
            word = word.substring(1);
        } 
        while(word.length() > 0 && !Character.isNumberOrDigit(word.charAt(word.length()-1)))
        {
            word = word.substring(0, word.length()-1);
        }
    
        return word;
    }
 
}
