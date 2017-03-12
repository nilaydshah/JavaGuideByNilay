package in.nilayshah.programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWriteBinaryFile {
	
  public static void main(String... aArgs) throws IOException{
	  ReadWriteBinaryFile binary = new ReadWriteBinaryFile();
	    byte[] bytes = binary.readSmallBinaryFile(FILE_NAME);
	    System.out.println("Small - size of file read in:" + bytes.length);
	    binary.writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
	  }

	  final static String FILE_NAME = "C:\\Users\\nilsha\\Pictures\\my-artistic-skills.png";
	  final static String OUTPUT_FILE_NAME = "C:\\Users\\nilsha\\Pictures\\out-my-artistic-skills.png";

	byte[] readSmallBinaryFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    return Files.readAllBytes(path);
	}
	  
	void writeSmallBinaryFile(byte[] aBytes, String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    Files.write(path, aBytes); //creates, overwrites
  	}
}
