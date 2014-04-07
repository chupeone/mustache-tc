package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import twitter4j.Paging;
import twitter4j.Status;


public class mainymain {
    private static final String DB_PATH = "C:\\Users\\Juan\\Documents\\Neo4j\\";

    String myString;
    GraphDatabaseService graphDb;
    Node myFirstNode;
    Node mySecondNode;
    Relationship myRelationship;

    private static enum RelTypes implements RelationshipType
    {
        KNOWS
    }
    
    public static void main( final String[] args )
    {
    
  	  ConfigurationVariables confvar= new ConfigurationVariables();
	  String line;
	  int maxiterations=4;
	  int count=0;
    	TwitterInstanceCreator tic=new TwitterInstanceCreator();
        Paging paging = new Paging(1, 10);
        List<Status> statuses;
        Integer counter=1;
        String lastlinecollected=null;
	  try {
	  
	  
	  File file1 = new File(confvar.getLocalDir()+"numeric2screen_"+confvar.getAppNumber()+".txt");
	  File file=new File(confvar.getLocalDir()+"first1000000users.txt");
	  BufferedReader br=new BufferedReader(new FileReader(file));
	  String prevline=null;
	  while((line=br.readLine())!=null)
	  {
		  prevline=line;
		  count++;
	  }
	  System.out.println(count+" "+prevline);
        
    }catch(Exception e){e.printStackTrace();}
	  }
    
    void createDb()
    {
        graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );

        Transaction tx = graphDb.beginTx();
        try
        {
            myFirstNode = graphDb.createNode();
            myFirstNode.setProperty( "name", "Duane Nickull, I Braineater" );
            mySecondNode = graphDb.createNode();
            mySecondNode.setProperty( "name", "Randy Rampage, Annihilator" );

            myRelationship = myFirstNode.createRelationshipTo( mySecondNode, RelTypes.KNOWS );
            myRelationship.setProperty( "relationship-type", "knows" );
            
            myString = ( myFirstNode.getProperty( "name" ).toString() )
                       + " " + ( myRelationship.getProperty( "relationship-type" ).toString() )
                       + " " + ( mySecondNode.getProperty( "name" ).toString() );
            System.out.println(myString);

            tx.success();
        }
        finally
        {
            tx.finish();
        }
    }
    
    void removeData()
    {
        Transaction tx = graphDb.beginTx();
        try
        {
            myFirstNode.getSingleRelationship( RelTypes.KNOWS, Direction.OUTGOING ).delete();
            System.out.println("Removing nodes...");
            myFirstNode.delete();
            mySecondNode.delete();
            tx.success();
        }
        finally
        {
            tx.finish();
        }
    }
    
    void shutDown()
    {
        graphDb.shutdown();
        System.out.println("graphDB shut down.");   
    }   
}
