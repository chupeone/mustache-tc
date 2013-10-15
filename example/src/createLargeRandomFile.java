import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.google.code.externalsorting.*;

public class createLargeRandomFile {

	public static void main(String[] args)
	{
		try{
			File file = new File("tochecknotinchecked.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			File filecheckednew = new File("checkednew.txt");
			FileWriter fwchn = new FileWriter(filecheckednew.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedWriter bwchn = new BufferedWriter(fwchn);
    	BufferedReader br = new BufferedReader(new FileReader("checked.txt"));
    	BufferedReader br2 = new BufferedReader(new FileReader("tocheck.txt"));
    	String line=br.readLine();
    	String line2=br2.readLine();
    	Integer n1,n2;
        while (true) {
  //      System.out.println(line+"   "+line2);
        if(line==null&&line2==null){break;}
       if(line==null){
           n2=Integer.parseInt(line2);
    	   System.out.println(n2);
    	   bw.write(n2+"\n");
    	   bwchn.write(n2+"\n");
    	   line2=br2.readLine();
    	   
    	   
    	   }else{
        n1=Integer.parseInt(line);
        n2=Integer.parseInt(line2);

        if(n1==n2){
        line=br.readLine();
        line2=br2.readLine();
        bwchn.write(n1+"\n");
        }
        if(n1<n2)
        {
        	bwchn.write(n1+"\n");
        	line=br.readLine();
        }
        if(n1>n2){
        	bwchn.write(n2+"\n");
        	System.out.println(n2);
        	line2=br2.readLine();
        	bw.write(n2+"\n");
        }
    	}
        }
        bw.flush();
        bwchn.flush();
        bwchn.close();
        br.close();
		}catch (Exception e){e.printStackTrace();}
        
	}
	public static void main3(String[] args)
	{
		try{
			File file = new File("superlarge_sorted_unique.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
    	BufferedReader br = new BufferedReader(new FileReader("superlarge_sorted.txt"));
    	String line;
    	String line2;


    
    	String[] subl2=null;
    	int i=0;
    	line=br.readLine();
        while ((line2 = br.readLine())!=null) {
        
        if(!line.equals(line2))
        {
        	bw.write(line+"\n");
        }
        line=line2;
        }
        bw.flush();
        br.close();
		}catch (Exception e){e.printStackTrace();}
        
	}
	public static void main1(String[] args) {
		try{
		ExternalSort es=new ExternalSort();
		// TODO Auto-generated method stub
		 Comparator<String> comparator = new Comparator<String>() {
             public int compare(String r1, String r2){
                 if(Integer.parseInt(r1)>Integer.parseInt(r2)){
                	 return(0);
                 }else 
            	 return 1;
                     }
             };
     List<File> listf = es.sortInBatch(new File("superlarge.txt"), comparator);
     es.mergeSortedFiles(listf, new File("superlarge_sorted.txt"), comparator);
     
     
	}catch (Exception e){e.printStackTrace();}
	}
	public static void main2(String[] args) {
		// TODO Auto-generated method stub
		try{
			Random generator = new Random();
			
		File file = new File("superlarge.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0;i<=10000;i++)
		{
			bw.write(generator.nextInt(10000)+"\n");
		}
		bw.flush();
	}catch (Exception e){e.printStackTrace();}
	}

}
