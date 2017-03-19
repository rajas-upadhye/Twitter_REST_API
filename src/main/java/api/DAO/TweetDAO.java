package api.DAO;

import api.Entity.Tweet;

import java.util.List;

/**
 * Created by rajasupadhye on 2/24/17.
 */
public interface TweetDAO {
    public Tweet postTweet(Tweet tweet);
    public List<Tweet> getTweetsByUserId(Integer userId);
    public boolean deleteTweetById(Integer tweetId);
}
