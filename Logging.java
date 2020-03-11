import java.io.IOException; 
import java.util.logging.*; 

public class Logging {

    public static Logging instance;
    private static Logger logger = Logger.getLogger("GardenLog"); 
    
    // Using singleton for global access
    public static Logging getInstance() {
        if (instance == null) {
            instance = new Logging();
        }
        return instance;
    }

    public void log(String message) {
        FileHandler fh;  
    
        try {  
            // This block configure the logger with handler and formatter  
            fh = new FileHandler("GardenLog.log", true);  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
    
            // the following statement is used to log any messages  
            logger.info(message);  
    
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}

