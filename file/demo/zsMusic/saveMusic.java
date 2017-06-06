package zsMusic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class saveMusic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//URL url = new URL("file:/Users/llmzs/Desktop/4659.wav");
		//AudioStream mus = new AudioStream(url.openStream());
		//AudioPlayer.player.start(mus);
		
		//ObjectInputStream mmm=(ObjectInputStream) url.openStream();
		//tcp
		
		//Object oo=(Object)mmm;
		
		FileInputStream filename1=new FileInputStream("/Users/llmzs/Desktop/4659.wav");
		FileOutputStream filename=new FileOutputStream("/Users/llmzs/Desktop/test.wav");
		
		byte [] bb=new byte[1024];
		int len;
		while( (len=filename1.read(bb))>0){ //接收
			filename.write(bb, 0, len);  //写入文件
		}
		filename.close();
		filename1.close();
		
		//File f2=new File("/Users/llmzs/Downloads/4659.wav");
		
		//AudioInputStream mmmm=new FileOutputStream (filename);

//		mmmm.write(f2);
//		mmmm.flush();
//		mmmm.close();
	}

}
