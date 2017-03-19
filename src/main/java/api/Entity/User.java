package api.Entity;

/**
 * Created by rajasupadhye on 2/24/17.
 */
public class User {
    Integer userId = null;
    String firstName = null;
    String lastName = null;
    String emailId = null;
    String token = null;
    Integer status = null;

    public User(){
        firstName = "";
        lastName = "";
    }


    public User(String fname , String lname , String genToken , String email){
        firstName = fname;
        lastName = lname;
        token = genToken;
        emailId = email;

    }

    public User(User u){
        userId = u.getUserId();
        firstName = u.getFirstName();
        lastName = u.getLastName();
        token=u.getToken();
        status= u.getStatus();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
