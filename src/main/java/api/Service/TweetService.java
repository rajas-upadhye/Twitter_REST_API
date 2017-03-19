package api.Service;

import api.Entity.Tweet;
import java.util.*;

/**
 * Created by rajasupadhye on 2/24/17.
 */
public interface TweetService {
    public Tweet postTweet(Tweet tweet);
    public List<Tweet> getTweetsByUserId(Integer userId);
    public boolean deleteTweet(Integer tweetId);
}
