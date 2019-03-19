package LOG_FILE;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LogReader {
	
	String line = null;
	
	public LogReader()
	{
		try {
			Scanner scan = new Scanner(new File("LOGFILE.txt"));
		    while(scan.hasNextLine()){
		        line += scan.nextLine() + System.lineSeparator();
		    }
		    scan.close();
		    System.out.println("Citit: "+line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String ReturnReadedLines()
	{
		return line;
	}
}
