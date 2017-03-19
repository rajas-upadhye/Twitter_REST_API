package api.DAO;

import api.Entity.Tweet;
import api.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by rajasupadhye on 2/24/17.
 */
public class TweetDAOImpl implements TweetDAO {
    private static final Logger log = LoggerFactory.getLogger(TweetDAOImpl.class);
    private SqlSessionFactory sqlSessionFactory = null;

    public TweetDAOImpl(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    @Override
    public Tweet postTweet(Tweet tweet) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            if(tweet!=null){
                tweet.setTimestamp((int)System.currentTimeMillis()/1000);
                int result = session.insert("Tweet.insert",tweet);
                session.commit();
                if(result>0){
                    log.info("Tweet created with ID " + tweet.getTweetId());
                    return tweet;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("Error in insert tweet");

        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Tweet> getTweetsByUserId(Integer userId) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            if(userId!=null && userId > 0){
                List<Tweet> result = session.selectList("Tweet.getTweetsByUserId",userId);
                log.info("Tweets got of size " + result.size());
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("Error in getting Tweets DOA ");
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean deleteTweetById(Integer tweetId) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            if(tweetId!=null && tweetId > 0){
                int result = session.update("Tweet.deleteTweetById",tweetId);
                session.commit();
                if(result > 0){
                    return true;
                }
            }
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            log.info("Error in deleting a tweet");
        }finally {
            session.close();
        }
        return false;
    }
}
