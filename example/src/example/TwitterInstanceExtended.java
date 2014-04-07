package example;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import twitter4j.RateLimitStatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterInstanceExtended {
public Twitter twittstance;
public 	Map<String,RateLimitStatus> ratelimits;
public 	Map<String,Integer> ratelimitsRemaining;
public Integer timesCalledSinceLastRefresh;
public boolean connected;
TwitterInstanceExtended(AccessToken accessToken){

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true)
	.setJSONStoreEnabled(true)
	.setUseSSL(true)
	.setHttpReadTimeout(300000)
;
	TwitterFactory factory = new TwitterFactory(cb.build());
    this.twittstance = factory.getInstance();
    this.twittstance.setOAuthConsumer("ABykWUVGjbvAdW2Ix0Ouw", "yJ6rnyBNrqeGQyJqG0Y1z8YijMmhbOOPGVOLTdrTo");
    this.twittstance.setOAuthAccessToken(accessToken);
    
    this.refreshRateLimit();
    this.timesCalledSinceLastRefresh=0;
    this.ratelimitsRemaining=(Map<String,Integer>) new HashMap();
    this.syncRateLimits();
}
TwitterInstanceExtended(AccessToken accessToken,String consumerkey,String consumersecret){

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true)
	.setJSONStoreEnabled(true)
	.setUseSSL(true)
	.setHttpReadTimeout(300000)
;
	TwitterFactory factory = new TwitterFactory(cb.build());
    this.twittstance = factory.getInstance();
    this.twittstance.setOAuthConsumer(consumerkey, consumersecret);
    this.twittstance.setOAuthAccessToken(accessToken);
    
    this.refreshRateLimit();
    this.timesCalledSinceLastRefresh=0;
    this.ratelimitsRemaining=(Map<String,Integer>) new HashMap();
    this.syncRateLimits();
}
void syncRateLimits(){
	Iterator iterator = this.ratelimits.keySet().iterator();  
	   
	while (iterator.hasNext()) {  
	   String key = iterator.next().toString();  
	   RateLimitStatus value = this.ratelimits.get(key)  ;
	//   System.out.println(key + "////" + value.getRemaining()+"///"+value.getLimit());
	   this.ratelimitsRemaining.put(key, value.getRemaining());
	}  
}
void refreshRateLimit(){
 try {
	if(this.twittstance.getScreenName().isEmpty()){
		this.connected=false;
	}else this.connected=true;
	this.ratelimits= this.twittstance.getRateLimitStatus();
    this.timesCalledSinceLastRefresh=0;
    this.ratelimitsRemaining=(Map<String,Integer>) new HashMap();
    this.syncRateLimits();
} catch (TwitterException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
Float rateLimitForCall(String callmethod){
	String key=callmethodabreviated(callmethod);
	   RateLimitStatus value = this.ratelimits.get(key)  ;
if(ConfigurationVariables.isDebugging())
{
	   try {
		System.out.println(key + "////" + value.getRemaining()+"///"+value.getLimit()+"///"+this.ratelimitsRemaining.get(key)+" "+(this.ratelimitsRemaining.get(key)+0f/value.getLimit())+"---"+this.twittstance.getScreenName());
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TwitterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
}
	   return (float) (this.ratelimitsRemaining.get(key)*100f/value.getLimit());
}
void informCall(String callmethod){
	String key=callmethodabreviated(callmethod);
	
	
	this.ratelimitsRemaining.put(key,this.ratelimitsRemaining.get(key)-1);
	


}
String callmethodabreviated(String callmethod){
	if(callmethod=="user tweets"){return "/statuses/user_timeline";}
	if(callmethod=="user followers"){return "/followers/ids";}
	if(callmethod=="user friends"){return "/friends/ids";}
	if(callmethod=="users lookup"){return "/users/lookup";}
	return callmethod;
}
}
