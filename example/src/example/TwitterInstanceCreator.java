package example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.PropertyConfiguration;
public class TwitterInstanceCreator {
	private Boolean initialized=false;
	
	private ConfigurationVariables confvar;
	Map <Integer,TwitterInstanceExtended> twittstanceList;
	public TwitterInstanceCreator(){
		this.confvar=new ConfigurationVariables();
	    this.twittstanceList=(Map<Integer,TwitterInstanceExtended>) new HashMap();
		
		System.out.println("construyendo");
	    
	    
	    
//	  System.exit(0);
//		TwitterFactory factory = new TwitterFactory();



	}
	public void CreateFromFile(String filename){
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(filename));
	    	String line;
	    	String line2;
	    	int found=0;
	    	int notfound=0;
	    
	    	String[] subl2=null;
	    	int i=0;
	        while ((line = br.readLine())!=null) {
	        	
	        	String[] subl1=line.split("	");
	        	System.out.println(subl1[0]);
	        	System.out.println(subl1[1]);
	    	    AccessToken accessToken = new AccessToken(subl1[0],subl1[1]);

	    	    TwitterInstanceExtended twi=new TwitterInstanceExtended(accessToken);
	    	    if(twi.connected){
	    	    this.twittstanceList.put(i, twi);
	    	    i++;
	    	    }
	    	    
	        	}
	        br.close();
	    }catch(Exception exept)
	    {
	    	exept.printStackTrace();
	    } 
	}
	public Twitter getinstance(String callmethod){
		if(!this.initialized)
		{
			this.CreateFromFile(this.confvar.getUserTokenFile());
			this.initialized=true;
		}
		Random randomGenerator = new Random();
		while(true)
		{
		for(int i=0;i<this.twittstanceList.size()*2;i++)
		{
			int selected=randomGenerator.nextInt(this.twittstanceList.size());
			
			if(this.twittstanceList.get(selected).rateLimitForCall(callmethod)>this.confvar.getRateThreshold())
			{
				System.out.println(selected+" was selected");
				this.twittstanceList.get(selected).informCall(callmethod);
				return this.twittstanceList.get(selected).twittstance;
			}
		}
		try {
	    	Calendar cal = Calendar.getInstance();
	    	cal.getTime();
	    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    	System.out.println( sdf.format(cal.getTime()) );
			System.out.println("Thread sleeping waiting for new rate limits.");
			this.refreshAllRates();
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	public void refreshAllRates(){
		for(int i=0;i<this.twittstanceList.size();i++)
		{
			this.twittstanceList.get(i).refreshRateLimit();
		}
	}
	public TwitterStream getStream(int appNumber)
	{
		String consumerkey=null,consumersecret=null,accesstoken=null,accesstokensecret=null;
		try {
			
	        URL configurl = new URL("http://www.siix-inmobiliaria.com/TwitterTokens/gettokens.php?appid="+appNumber);
	        System.out.println(configurl);
	        BufferedReader br = new BufferedReader(
	        new InputStreamReader(configurl.openStream()));
			 consumerkey = br.readLine();
			 consumersecret = br.readLine();
			 accesstoken = br.readLine();
			 accesstokensecret = br.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(consumerkey)
		  .setOAuthConsumerSecret(consumersecret)
		  .setOAuthAccessToken(accesstoken)
		  .setOAuthAccessTokenSecret(accesstokensecret);
		TwitterStreamFactory tsf = new TwitterStreamFactory(cb.build());
		
		return tsf.getInstance();
		
		
	}

	public void printlimits(int i){
	    RateLimitStatus rateLimitStatus;
		try {
			Twitter twitter=this.twittstanceList.get(i).twittstance;
			Map<String,RateLimitStatus> rls= twitter.getRateLimitStatus(); 
			String key="/statuses/user_timeline";
			   RateLimitStatus value = rls.get(key)  ;
			   
			   System.out.println(key + "////" + value.getRemaining());  
			

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printAllLimits(int i){
	    RateLimitStatus rateLimitStatus;
		try {
			Twitter twitter=this.twittstanceList.get(i).twittstance;
			Map<String,RateLimitStatus> rls= twitter.getRateLimitStatus();
			Iterator iterator = rls.keySet().iterator();  
			   
			while (iterator.hasNext()) {  
			   String key = iterator.next().toString();  
			   RateLimitStatus value = rls.get(key)  ;
			   
			   System.out.println(key + "////" + value.getRemaining());  
			}  

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
