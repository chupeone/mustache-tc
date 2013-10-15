	package example;

	import java.util.List;

	import twitter4j.Paging;
	import twitter4j.ResponseList;
	import twitter4j.Status;
	import twitter4j.Twitter;
	import twitter4j.TwitterException;
	import twitter4j.TwitterFactory;
	import twitter4j.User;
	public class RatePercentageExample {

		public static void main(String[] args){

			    try {

			    	TwitterInstanceCreator tic=new TwitterInstanceCreator();
			        Paging paging = new Paging(1, 1);
			        List<Status> statuses;
			        Integer counter=1;
			        for(int i=1;i<100;i++)
			        {

				        Twitter twitter = tic.getinstance("user tweets");
			            statuses = twitter.getUserTimeline("arturoelias", paging);
				        System.out.println(twitter.getScreenName());
			            for (Status s : statuses) {
			            	counter++;
			                System.out.println(counter+" "+s.getUser().getScreenName()+"////"+s.getText()+"///"+s.getCreatedAt());
			            }
			            
			        }

				            
			        
			    } catch (TwitterException e) {
			        e.printStackTrace();
			    }
			
		}
	

}
