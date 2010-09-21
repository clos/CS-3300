import java.io.*;


public class SerialIO {

	private int packetsize;
	private File file;
	private FileInputStream  fis = null;

	public SerialIO(String filename){
		packetsize = 100;
		file = new File(filename);
		try{
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String pull(){
		String packet = "";
		try{
			int tempByte=fis.read();
			for(int cnt=0; tempByte > 0  && cnt < this.packetsize; cnt++ ){
				packet = packet.concat(Character.toString(((char)tempByte)));
				tempByte=fis.read();
			}
		}
		catch(IOException e){
		}
		return packet;
	}
	
	public void close() throws IOException{
		try{
			fis.close();
		}
		catch(IOException e){
		}
	}
}
