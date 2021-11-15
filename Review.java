/**
 * A Review contains a text String representing a review of a movie,
 * restaurant, purchase, etc.
 * 
 * To be used in the APCS-A case study Consumer Review
 * 
 * @author   Michael Buescher, Hathaway Brown School, modified from the Consumer Review case study code
 * @version  2020-05-30
 **/
 
import java.util.ArrayList;
 
public class Review 
{
    private String reviewText;
    
    public Review (String str)
    {
        reviewText = str;
    }
    
    public String toString()
    {
        return reviewText;
    }

    public double totalSentiment (SentimentList sentiments)
    {
        double ans = 0.0;
        String review = reviewText;
        review += " ";     // so there is always another space to find
        int nextSpace = review.indexOf(" ");
        while (nextSpace >= 0)
        {
            String nextWord = review.substring(0, nextSpace);
            nextWord = StringTools.removePunctuation(nextWord);
            double nextWordSentiment = sentiments.getSentimentValue(nextWord);
            ans += nextWordSentiment;
            if (nextWordSentiment != 0.0)
            {
                System.out.println (nextWord + "\t" + nextWordSentiment + "\t" + ans);
            }
            review = review.substring(nextSpace + 1);
            nextSpace = review.indexOf(" ");
        }
        
        return ans;
    }
    
    

}