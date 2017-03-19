package api.Controllers;

/**
 * Created by rajasupadhye on 2/24/17.
 */
/* Purpose : To define all resource endpoints for API
* So the main api call will be accepted here and then desired service will be chosen */
import api.Entity.Error;
import api.Entity.Tweet;
import api.Entity.User;
import api.Service.TweetServiceImpl;
import api.Service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    UserServiceImpl userService =  new UserServiceImpl();
    TweetServiceImpl tweetService = new TweetServiceImpl();
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET , value ="/status")
    public ResponseEntity<?> getStatus(){
        try{
            //Its here that means our API is up to hit
            return new ResponseEntity<Object>("{'status' : 'API is up and running!'}", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            log.info("Error in API Status");
            Error error = new Error("Error occured in getting spot by the requested type!");
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userService.createUser(user));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.info("Sending error message since info is not correctly passed");
                Error error = new Error("Error in user creation . Please provide First name , Last name and email ID");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("Error in creating User");
            Error error = new Error("Error in creating user!");
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST , value = "/tweet")
    public ResponseEntity<?> postTweet(@RequestBody Tweet tweet){
        try{
            /*Verification of userId with status required before processing further */
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tweetService.postTweet(tweet));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.info("Sending error message since tweet has problem");
                Error error = new Error("User : Error in tweet posting. Please provide User ID and Tweet text as required.");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("Severe : Error in posting Tweet");
            Error error = new Error("Severe : Error in posting Tweet!");
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tweet/user/{userId}")
    public ResponseEntity<?> getTweetsByUserId(@PathVariable Integer userId){
        try{
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tweetService.getTweetsByUserId(userId));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.info("Sending error message since tweet has problem");
                Error error = new Error("User : Error in tweet retrieval. Please provide User ID as required.");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.info("Error in getting tweets by user id" + userId);
            Error error = new Error("Severe : Error in getting tweets by user " + userId);
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value =  "/tweet/{tweetId}")
    public ResponseEntity<?> deleteTweetById(@PathVariable Integer tweetId){
        try{
            Boolean result = tweetService.deleteTweet(tweetId);
            if(result)
                return new ResponseEntity<Object>("{'result' : 'Delete done '}", HttpStatus.OK);
            else{
                Error error = new Error("Error in deleting tweet " +tweetId);
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            log.info("Error in deleting tweet" + tweetId);
            Error error = new Error("Severe : Error in deleting tweet " + tweetId);
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }
    }

}
