package zsMusic;

import java.io.FileWriter;
import java.io.IOException;

public class saveFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String filename="/Users/llmzs/Desktop/test.txt";
		String data="zhangshu";
		FileWriter writer = new FileWriter(filename);  
        writer.write(data);  
        writer.close();  
	}

}
