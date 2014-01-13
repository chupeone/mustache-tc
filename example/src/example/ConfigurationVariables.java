package example;

import java.io.File;
import java.util.Properties;

public class ConfigurationVariables {
	
public String collectionMethodImlpemented="DowJonesPrediction";
	
	
private String tempTweetDir="tweetstoimport/";
private String finalTweetDir="C:\\Users\\Juan\\Dropbox\\MonitoredbyTwitterAggregator\\";
private String logDir="Logs/";
private String logExceptionDir="ExceptionLogs/";
private String logTerribleExceptionDir="TerribleExceptionLogs/";
private String dbUser="postgres";
private String dbPassword="postgres";
private String dbHost="jdbc:postgresql://localhost:5433/twittercollector";
private Integer batchSize=500;
private Integer percentageLimitThreshold=15;
private String userStorageFile_bfs="userstoimport_bfs/";
private String edgeStorageFile_bfs="edgestoimport_bfs/";
private String tempUserStorageFile_bfs="userstoimport_bfs_temp/";
private String tempEdgeStorageFile_bfs="edgestoimport_bfs_temp/";
private String localConfigurationDir="LocalConfigurationDir/";
private String rootdirectory;
private String rootdirectory_path;
private String rootdirectory_name="TwitterCollection101";
private String apptokenfile="apptokens.txt";
private String usertokenfile="tokens.txt";

public ConfigurationVariables(){
	
	if(this.collectionMethodImlpemented.equals("DowJonesPrediction"))
	{
		this.tempTweetDir="tweetstoimport/";
		this.finalTweetDir="C:\\Users\\Juan\\Dropbox\\MonitoredbyTwitterAggregator\\";
		this.logDir="Logs/";
		this.logExceptionDir="ExceptionLogs/";
		this.logTerribleExceptionDir="TerribleExceptionLogs/";
		this.dbUser="postgres";
		this.dbPassword="postgres";
		this.dbHost="jdbc:postgresql://localhost:5433/twittercollector";
		this.batchSize=500;
		this.percentageLimitThreshold=15;
		this.userStorageFile_bfs="userstoimport_bfs/";
		this.edgeStorageFile_bfs="edgestoimport_bfs/";
		this.tempUserStorageFile_bfs="userstoimport_bfs_temp/";
		this.tempEdgeStorageFile_bfs="edgestoimport_bfs_temp/";
		this.localConfigurationDir="LocalConfigurationDir/";
		this.rootdirectory_name="TwitterCollection_DowJones";
		this.apptokenfile="apptokens.txt";
		this.usertokenfile="tokens.txt";
	}
	Properties prop=System.getProperties();
	this.rootdirectory_path=prop.getProperty("user.home")+prop.getProperty("file.separator");
	this.rootdirectory=this.rootdirectory_path+this.rootdirectory_name+prop.getProperty("file.separator");
	
}
public String getAppTokenFile(){
	return this.rootdirectory+localConfigurationDir+this.apptokenfile;
}
public String getLocalDir(){
	return this.rootdirectory;
}
public String getUserTokenFile(){
	System.out.println(this.rootdirectory+localConfigurationDir+this.usertokenfile);
	return this.rootdirectory+localConfigurationDir+this.usertokenfile;
}
public String getLocalConfDir(){
	return this.rootdirectory+this.localConfigurationDir;
}
public void createstructure()
{
	
	new File(this.rootdirectory).mkdir();
	System.out.println(this.rootdirectory);
	new File(this.rootdirectory+this.tempTweetDir).mkdir();
	new File(this.rootdirectory+this.finalTweetDir).mkdir();
	new File(this.rootdirectory+this.logDir).mkdir();
	new File(this.rootdirectory+this.logExceptionDir).mkdir();
	new File(this.rootdirectory+this.logTerribleExceptionDir).mkdir();
	new File(this.rootdirectory+this.userStorageFile_bfs).mkdir();
	new File(this.rootdirectory+this.edgeStorageFile_bfs).mkdir();
	new File(this.rootdirectory+this.tempUserStorageFile_bfs).mkdir();
	new File(this.rootdirectory+this.tempEdgeStorageFile_bfs).mkdir();
	new File(this.rootdirectory+this.localConfigurationDir).mkdir();


}



public String getUserStorage(String method){
if(method=="bfs"){ return this.userStorageFile_bfs;}
else return null;
	
}
public String getLogDir(){
	return this.logDir;
}
public String getLogExeptionDir(){
	return this.logExceptionDir;
}
public String getTerribleLogExeptionDir(){
	return this.logExceptionDir;
}
public String getTempTweetDir(String whattosave){
	if(whattosave.equals("nodes")){return this.rootdirectory+this.tempEdgeStorageFile_bfs;}
	if(whattosave.equals("users")){return this.rootdirectory+this.tempUserStorageFile_bfs;}
	if(whattosave.equals("tweets")){return this.rootdirectory+this.tempTweetDir;}
	else return this.tempTweetDir;
	
	
}
public String getFinalTweetDir(String whattosave){
	if(whattosave.equals("nodes")){return this.rootdirectory+this.edgeStorageFile_bfs;}
	if(whattosave.equals("users")){return this.rootdirectory+this.userStorageFile_bfs;}
	if(whattosave.equals("tweets")){return this.rootdirectory+this.finalTweetDir;}
	return this.finalTweetDir;
}
public Integer getBatchSize(){
	return this.batchSize;
}
public String getDbHost(){
	return this.dbHost;
}
public String getDbPwd(){
	return this.dbPassword;
}
public String getDbUser(){
	return this.dbUser;
}
public Integer getRateThreshold()
{
	return this.percentageLimitThreshold;
}
}
