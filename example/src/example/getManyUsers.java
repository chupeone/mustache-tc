package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import twitter4j.*;
import twitter4j.json.DataObjectFactory;


public class getManyUsers {

	  public static void main(String[] args) {
		          try {
		        	  ConfigurationVariables confvar= new ConfigurationVariables();
		        	  File numeric2screen=new File(confvar.getLocalDir()+"numeric2screen");
		        	  File lastbatchprocessed=new File(confvar.getLocalDir()+"last_batch_processed_first15mil.txt");
		        	  boolean notfirstcollection=false;
		        	  if (lastbatchprocessed.exists())notfirstcollection=true;
		        	  File usersfile=new File(confvar.getLocalDir()+"users_scraped_40million_first15mil");
		        	  FileWriter fw=new FileWriter(usersfile.getAbsoluteFile(),true);
		        	  BufferedWriter bw = new BufferedWriter(fw);
		        	  BufferedReader br = new BufferedReader(new FileReader(numeric2screen));
				      String line;
		        	  TwitterInstanceCreator tic=new TwitterInstanceCreator();
		        	  String lastlinecollected=null;
		              int linecounter=0,totallinecounter=0,numusercollected=0;
		              String userstolookfor="";
		              ResponseList<User> users=null;
		              int usersaftersharon=8000;
		              int sharonisat=15241169;
		              int linestogo=sharonisat+usersaftersharon;
		              if(notfirstcollection)
		              {
		            	  BufferedReader lastLineReader=new BufferedReader(new FileReader(lastbatchprocessed));
		            	  lastlinecollected=lastLineReader.readLine();
		            	  System.out.println(lastlinecollected);
		            	  while ((line = br.readLine())!=null) {
		            		  if(linestogo--<=0)
		            		  {
		            			  System.out.println("We have finished (no queries)");
		            			  System.exit(1);
		            		  }
		            		  if (line.equals(lastlinecollected)){
		            			  System.out.println("Jumping until "+line+" "+linestogo);
		            			  break;}
		            	  }
		              }
				        while ((line = br.readLine())!=null) {
		            		  if(linestogo--<=0)
		            		  {
		            			  System.out.println("We have finished");
		            			  System.exit(1);
		            		  }
				        	userstolookfor+=line.split(" ")[1]+",";
				        	
				        	
				        	if(totallinecounter!=0&&totallinecounter%20==0)
				        		{

				        		if (lastbatchprocessed.exists())
				        		{
				        			lastbatchprocessed.delete();
				        		}
				        		lastbatchprocessed.createNewFile();
				        		FileWriter fw_lbp=new FileWriter(lastbatchprocessed.getAbsoluteFile());
				        		fw_lbp.write(line);
				        		fw_lbp.close();
				        		System.out.println("Lap number"+totallinecounter+"-userscollected-"+numusercollected);
				        		totallinecounter=0;
				        		
				        		}
				        	linecounter++;
	
				        	
				    if(linecounter>=99)
				    {
				    	
				    	try{
				    	 users=getUsersFromCSV(tic,userstolookfor);
				    }catch(TwitterException twex)
				    {if(twex.getErrorCode()==131)
				    {
				    	try {
							Thread.sleep(300000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	System.out.println("Thread sleeping for 15 seconds due to exception");
				    	try{
					    	users=getUsersFromCSV(tic,userstolookfor);
					    }catch(TwitterException twex2)
					    {
					    	try {
								Thread.sleep(300000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    	System.out.println("Thread sleeping for 15 seconds due to exception(Second time)");
					    	try{
						    	users=getUsersFromCSV(tic,userstolookfor);
						    }catch(TwitterException twex3)
						    {
						    	twex3.printStackTrace();
						    	System.exit(-1);
						    }
					    }
				    }else{
				    	twex.printStackTrace();
				    	System.exit(-1);
				    }
				    }
		              for (User user : users) {

		                     bw.write( DataObjectFactory.getRawJSON(user)+System.getProperty("line.separator"));
		                     numusercollected++;

		              }
		              totallinecounter++;
		              linecounter=0;
		              userstolookfor="";
				    }
				      }
			              Twitter twitter = tic.getinstance("users lookup");
			           
						try {
							users = twitter.lookupUsers(userstolookfor.split(","));
						} catch (TwitterException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	              for (User user : users) {

	                     bw.write( DataObjectFactory.getRawJSON(user)+System.getProperty("line.separator"));
	                     numusercollected++;

	              }
				        bw.flush();
				        bw.close();
		              System.exit(0);
		          }  catch (IOException e)
		         {e.printStackTrace();}
		      }
	  public static ResponseList<User> getUsersFromCSV(TwitterInstanceCreator tic,String usercsv) throws TwitterException
	  {
          Twitter twitter = tic.getinstance("users lookup");
          ResponseList<User> users = twitter.lookupUsers(usercsv.split(","));
          return(users);
	  }
		  
}
