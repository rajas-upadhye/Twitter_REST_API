package api.Entity;

/**
 * Created by rajasupadhye on 2/24/17.
 */
public class Tweet {
    Integer tweetId = null;
    Integer userId = null;
    String tweet = null;
    Integer timestamp = null;
    Integer status = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Tweet(){

    }

    public Integer getTweetId() {
        return tweetId;
    }

    public void setTweetId(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Tweet(Integer userID, String tweetMsg, Integer ts){
        tweet = tweetMsg;
        userId = userID;
        timestamp = ts;

    }
}
