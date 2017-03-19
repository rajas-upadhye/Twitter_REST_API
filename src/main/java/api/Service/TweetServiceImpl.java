package api.Service;

import api.DAO.TweetDAOImpl;
import api.Entity.Tweet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by rajasupadhye on 2/24/17.
 */
public class TweetServiceImpl implements TweetService {
    private static final Logger log = LoggerFactory.getLogger(TweetServiceImpl.class);
    TweetDAOImpl tweetDAO = null;

    public TweetServiceImpl(){
        tweetDAO = new TweetDAOImpl();
    }

    @Override
    public Tweet postTweet(Tweet tweet) {
        if(tweetDAO!=null){
            log.info("Done posting tweet");
            return tweetDAO.postTweet(tweet);
        }
        return null;
    }

    @Override
    public List<Tweet> getTweetsByUserId(Integer userId) {
        if(tweetDAO!=null){
            log.info("Done reading tweets for user " + userId);
            return tweetDAO.getTweetsByUserId(userId);
        }
        return null;
    }

    @Override
    public boolean deleteTweet(Integer tweetId) {
        if(tweetDAO!=null){
            log.info("Done deleting tweet " + tweetId );
            return tweetDAO.deleteTweetById(tweetId);
        }
        return false;
    }
}
