package example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import twitter4j.FilterQuery;
import twitter4j.RawStreamListener;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.json.DataObjectFactory;

public class FilteredStreamForDowJones {
	
	
	public static void main(String[] args) throws TwitterException, IOException{
		
		
		
   
	    RawStreamListener listener = new RawStreamListenerImplementation();

	    TwitterStream twitterStream = new TwitterInstanceCreator().getStream(10);
        String[] searchfor={"3M","American Express","amex,","AT&T","Boeing","Caterpillar","Chevron","Cisco","Coca Cola","DuPont","Exxon","General Electric","Goldman Sachs","Home Depot","intel","ibm","johnson johnson"," jpmorgan","mcdonalds","merck","microsoft","nike","pfizer","procter","travelers","united health group","united technologies","verizon","visa","wal mart","walt disney","disney"};
        FilterQuery query=new FilterQuery();
        query.track(searchfor);
        twitterStream.addListener(listener);
        twitterStream.filter(query);
	    
	}
	
}
