package example;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Properties;


public class ConfigurationVariables {
	
public String collectionMethodImlpemented="DowJonesPrediction";
	

private static boolean isDebugging=false;
private String tempTweetDir="tweetstoimport/";
private String finalTweetDir="C:\\Users\\Juan\\Dropbox\\MonitoredbyTwitterAggregator\\";
private String processedTweetDir="processed_tweet_dir/";
private String graphdir="GraphDB_Dir/";
private String logDir="Logs/";
private String logExceptionDir="ExceptionLogs/";
private String logTerribleExceptionDir="TerribleExceptionLogs/";
private String dbUser="postgres";
private String dbPassword="";
private String dbHost="jdbc:postgresql://localhost/twittercollector";
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
private int sleepCyclesBeforeUpdatingTokens=5;
private HashMap hostnamesToAppNumbers;
private String CalculationStorageDirectory="AnalysisResults/";
private String OutDegreeResultsForDatasets="OutDegreeResultsForDatasets/";
private String InDegreeResultsForDatasets="InDegreeResultsForDatasets/";
private String CreatedAtResultsForDatasets="CreatedAtResultsForDatasets/";
private String LocationResultsForDatasets="LocationResultsForDatasets/";
private String OutDegreePrefix="OutDegreeResults_";
private String InDegreePrefix="InDegreeResults_";
private String CreatedAtPrefix="CreatedAtResults_";
private String LocationPrefix="LocationResultsForDatasets_";
private String Location_aggregatedPrefix="Location_aggregatedResultsForDatasets_";
private String Location_aggregatedResultsForDatasets="Location_aggregatedResultsForDatasets/";
private String LanguagesPrefix="LanguagesResultsForDatasets_";
private String LanguagesResultsForDatasets="LanguagesResultsForDatasets/";
private String StatusesCountPrefix="StatusesCount_";
private String StatusesCountForDatasets="StatusesCountForDatasets/";
private String RateOfTweetsPrefix="RateOfTweets_";
private String RateOfTweetsDirForDatasets="RateOfTweetsForDatasets/";
private String protectedPrefix="IsProtected_";
private String protectedirForDatasets="IsProtectedForDatasets/";
private String localSampleDir="Samples/";
private String tempdir="TemporalDirectory/";

public String getTempDir()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.tempdir;
}

public String getIsProtectedPrefix(){
	return protectedPrefix;
}
public String getOutDegreePrefix(){
	return OutDegreePrefix;
}
public String getRateOfTweetsPrefix(){
	return RateOfTweetsPrefix;
}
public String getStatusesCountPrefix(){
	return StatusesCountPrefix;
}
public String getInDegreePrefix(){
	return InDegreePrefix;
}
public String getLanguagePrefix(){
	return LanguagesPrefix;
}
public String getLocation_aggregatedPrefix(){
	return Location_aggregatedPrefix;
}
public String getCreatedAtPrefix(){
	return CreatedAtPrefix;
}
public String getLocationPrefix(){
	return LocationPrefix;
}
public String getLocalSampleDir()
{
	return this.getLocalDir()+this.localSampleDir;
}
public String getDirRateOfTweetsForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.RateOfTweetsDirForDatasets;
}
public String getDirIsProtectedsForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.protectedirForDatasets;
}
public String getDirLocationResultsForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.LocationResultsForDatasets;
}
public String getDirStatusesCountForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.StatusesCountForDatasets;
}
public String getDirLanguageResultsForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.LanguagesResultsForDatasets;
}
public String getDirLocation_aggregatedResultsForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.Location_aggregatedResultsForDatasets;
}
public String getDirCreatedAtResultsForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.CreatedAtResultsForDatasets;
}
public String getDirInDegreeResultsForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.InDegreeResultsForDatasets;
}
public String getDirOutDegreeResultsForDatasets()
{
	return this.getLocalDir()+this.CalculationStorageDirectory+this.OutDegreeResultsForDatasets;
}
public String getGraphDBDir()
{
	return this.getLocalDir()+this.graphdir;
}
public String getProcessedTweetDir()
{
	return this.rootdirectory+this.processedTweetDir;
}
public static boolean isDebugging()
{
	return isDebugging;
}
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
		this.dbHost="jdbc:postgresql://localhost:5432/twittercollector";
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
	
	

	
	this.hostnamesToAppNumbers = new HashMap<String, Integer>();
	this.hostnamesToAppNumbers.put("guzman", 7);
	this.hostnamesToAppNumbers.put("twit1.cs.ucl.ac.uk", 0);
	this.hostnamesToAppNumbers.put("twit2.cs.ucl.ac.uk", 1);
	this.hostnamesToAppNumbers.put("twit3.cs.ucl.ac.uk", 2);
	this.hostnamesToAppNumbers.put("twit4.cs.ucl.ac.uk", 3);
	this.hostnamesToAppNumbers.put("twit5.cs.ucl.ac.uk", 4);
	this.hostnamesToAppNumbers.put("twit6.cs.ucl.ac.uk", 5);
	this.hostnamesToAppNumbers.put("twit7.cs.ucl.ac.uk", 6);
	this.hostnamesToAppNumbers.put("twit8.cs.ucl.ac.uk", 7);
	this.hostnamesToAppNumbers.put("twit9.cs.ucl.ac.uk", 8);
	this.hostnamesToAppNumbers.put("twit10.cs.ucl.ac.uk", 9);
	this.hostnamesToAppNumbers.put("twitdb.cs.ucl.ac.uk", 9);
	Properties prop=System.getProperties();
	try {
		if (InetAddress.getLocalHost().getHostName().equals("guzman"))
		{
		this.rootdirectory_path=prop.getProperty("user.home")+prop.getProperty("file.separator");

		}else{
			
			this.rootdirectory_path=prop.getProperty("file.separator")+"cs"+prop.getProperty("file.separator")+"research"+prop.getProperty("file.separator")+"fmedia"+prop.getProperty("file.separator")+"twitter_data"+prop.getProperty("file.separator")+"TwitterRawFiles"+prop.getProperty("file.separator");
			this.finalTweetDir=this.rootdirectory_path+"FinalTweetDirectory";
		}
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.rootdirectory=this.rootdirectory_path+this.rootdirectory_name+prop.getProperty("file.separator");
}
public int getSleepCyclesBeforeUpdatingTokens()
{
	return this.sleepCyclesBeforeUpdatingTokens;
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

public String getAppNumber()
{String ret=null;
	try {
		String hostname=InetAddress.getLocalHost().getHostName();
		return this.hostnamesToAppNumbers.get(hostname).toString();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ret;
}
public String getAppNumber(String key)
{

		return this.hostnamesToAppNumbers.get(key).toString();


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
