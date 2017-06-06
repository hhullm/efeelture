package zsMusic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.*; 

public class openMusic {

	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		// TODO Auto-generated method stub

		//File m= new File("/Users/llmzs/Downloads/music.mp3");
		//System.out.println(m.toURL());
		URL url = null;
		try {
			url = new URL("file:/Users/llmzs/Downloads/4659.wav");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AudioStream mus = null;
		try {
			mus = new AudioStream(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		AudioPlayer.player.start(mus);
//		
//		
//		//AudioStream  as;
//		try {
//			
//			AudioInputStream mu=AudioSystem.getAudioInputStream(m);
//			
//		} catch (UnsupportedAudioFileException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	}

}
