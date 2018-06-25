
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;



public class CustomLogger {
	
	private static CustomLogger single_instance = null;
	public Logger logger;
	private FileHandler fh;
	
	private CustomLogger(String FILE_PATH) throws IOException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String filename = FILE_PATH + "logs"+df.format(new Date()) + ".log" ;
		File f=new File(filename);
		if(!f.exists()){
			f.createNewFile();
		}
		logger=Logger.getLogger("");
		fh=new FileHandler(filename, true);
		logger.addHandler(fh);
		MyFormatter formatter=new MyFormatter();
		fh.setFormatter(formatter);
	}
	
	public static CustomLogger getInstance(String FILE_PATH) throws IOException
    {
        if (single_instance == null)
            single_instance = new CustomLogger(FILE_PATH);
 
        return single_instance;
    }
	
	
	
	
}
