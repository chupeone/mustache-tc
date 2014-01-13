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
		        	  File usersfile=new File(confvar.getLocalDir()+"users_scraped_40million");
		        	  FileWriter fw=new FileWriter(usersfile.getAbsoluteFile());
		        	  BufferedWriter bw = new BufferedWriter(fw);
		        	  BufferedReader br = new BufferedReader(new FileReader(numeric2screen));
				      String line;
		        	  TwitterInstanceCreator tic=new TwitterInstanceCreator();

		              int linecounter=0,totallinecounter=0;
		              String userstolookfor="";
				        while ((line = br.readLine())!=null) {
				        	if(totallinecounter>=50)break;
				        	linecounter++;
				        	userstolookfor+=line.split(" ")[1]+",";
				        	
				    if(linecounter>=99)
				    {
			              Twitter twitter = tic.getinstance("users lookup");
				              ResponseList<User> users = twitter.lookupUsers(userstolookfor.split(","));
		              for (User user : users) {

		                     bw.write( DataObjectFactory.getRawJSON(user)+System.getProperty("line.separator"));

		              }
		              totallinecounter++;
		              linecounter=0;
		              userstolookfor="";
				    }
				      }
				        bw.flush();
				        bw.close();
				      System.out.println(userstolookfor);
				      System.out.println(userstolookfor);
		              System.exit(0);
		          } catch (TwitterException te) {
		              te.printStackTrace();
		              System.out.println("Failed to lookup users: " + te.getMessage());
		              System.exit(-1);
		         } catch (IOException e)
		         {e.printStackTrace();}
		      }
		  
}
