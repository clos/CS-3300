import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SerialIO {

	private int packetsize;
	private File file;
	private String packet;
	private Scanner sc;
	private FileInputStream  fis = null;

	public SerialIO(String filename){
		file = new File(filename);
		try{
			fis = new FileInputStream(file);
			sc = new Scanner(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String pull() throws IOException{
		packet = null;
		if(sc.hasNext()){
			packet = sc.next(Pattern.compile("(.*){" + packetsize + "}"));
		}
		return packet;
	}
	
	public void close() throws IOException{
		fis.close();
		sc.close();
	}
}
