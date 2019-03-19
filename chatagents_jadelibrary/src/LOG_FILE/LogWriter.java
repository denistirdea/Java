package LOG_FILE;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter {

	public LogWriter(String content)
	{	
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();
		
		try {
			String writeToFile = "["+dateFormat.format(date)+"]" + content + System.lineSeparator();
			System.out.println(writeToFile);
			 Files.write(Paths.get("LOGFILE.txt"), writeToFile.getBytes() , StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			System.out.println("That file doesn't exist");
			e.printStackTrace();
		}
		
	}
}
