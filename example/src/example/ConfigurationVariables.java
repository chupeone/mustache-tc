package example;

public class ConfigurationVariables {
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
	if(whattosave.equals("nodes")){return this.tempEdgeStorageFile_bfs;}
	if(whattosave.equals("tweets")){return this.tempUserStorageFile_bfs;}
	if(whattosave.equals("users")){return this.tempTweetDir;}
	else return this.tempTweetDir;
	
	
}
public String getFinalTweetDir(String whattosave){
	if(whattosave.equals("nodes")){return this.edgeStorageFile_bfs;}
	if(whattosave.equals("tweets")){return this.userStorageFile_bfs;}
	if(whattosave.equals("users")){return this.finalTweetDir;}
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
