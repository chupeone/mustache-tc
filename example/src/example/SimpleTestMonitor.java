package example;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class SimpleTestMonitor {

    // A hardcoded path to a folder you are monitoring .

         

    public static void main(String[] args) throws Exception {
        // The monitor will perform polling on the folder every 5 seconds
        final long pollingInterval = 5 * 1000;
    	ConfigurationVariables confv=new ConfigurationVariables();
        String directoryToWatch =confv.getFinalTweetDir("tweets");
        File folder = new File(directoryToWatch);

        if (!folder.exists()) {
            // Test to see if monitored folder exists
            throw new RuntimeException("Directory not found: " + directoryToWatch);
        }

        FileAlterationObserver observer = new FileAlterationObserver(folder);
        FileAlterationMonitor monitor =
                new FileAlterationMonitor(pollingInterval);
        FileAlterationListener listener = new FileAlterationListenerAdaptor() {
            // Is triggered when a file is created in the monitored folder
            @Override
            public void onFileCreate(File file) {
                try { 
                    // "file" is the reference to the newly created file
                    System.out.println("File created: "
                            + file.getCanonicalPath());
                   ParseFromFile pff= new ParseFromFile();
                   pff.Parse(file);
                   pff=null;
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }

            // Is triggered when a file is deleted from the monitored folder
            @Override
            public void onFileDelete(File file) {
                try {
                    // "file" is the reference to the removed file
                    System.out.println("File removed: "
                            + file.getCanonicalPath());
                    // "file" does not exists anymore in the location
                    System.out.println("File still exists in location: "
                            + file.exists());
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        };

        observer.addListener(listener);
        monitor.addObserver(observer);
        monitor.start();
    }
}