package api.DAO;

import api.Entity.User;
import api.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rajasupadhye on 2/24/17.
 */
public class UserDAOImpl implements UserDAO {
    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
    private SqlSessionFactory sqlSessionFactory = null;

    public UserDAOImpl(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    @Override
    public User createUser(User u) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
        if(u!=null){
            int userId = session.insert("User.insert",u);
            session.commit();
            if(userId>0){
                log.info("User created with id : " + u.getUserId());
                return u;
            }
        }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }
}
