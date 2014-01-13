package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class mainymain {



	public static void main(String[] args) {
	    URL connection;
		try {
			connection = new URL("http://checkip.amazonaws.com/");

	    URLConnection con = connection.openConnection();

	    String str = null;
	    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    str = reader.readLine();
	    System.out.println(str);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
//		File file=new File("C:\\Users\\Juan\\Dropbox\\MonitoredbyTwitterAggregator\\2013-5-5-14.txt");
//		File file=new File("C:\\Users\\cheve\\workspace\\example\\tweetstoimport\\2013-7-6-23.txt");
 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		ParseFromFile pff=new ParseFromFile();
//		pff.Parse(file);
//		int num=30;
//		System.out.println(String.format("%04d", num));
	}

}
