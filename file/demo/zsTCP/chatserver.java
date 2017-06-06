package zsTCP;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class chatserver {

	public static void main(String[] args) throws ClassNotFoundException, IOException, UnsupportedAudioFileException {
		// TODO Auto-generated method stub
		chatserver app = new chatserver();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Scanner sc=new Scanner (System.in);
				while (true)
				{
					str=sc.nextLine();
					try {
						app.action();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					app.run();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		//app.run();
	}

	private ObjectInputStream ois=null;
	private ObjectOutputStream oos=null;

	private static String str = "start from server";
	AudioInputStream ais=null;

	public chatserver() throws IOException, ClassNotFoundException, UnsupportedAudioFileException {
		// TODO Auto-generated constructor stub
		run() ;
		
	}

	public void action() throws IOException {
		oos.writeObject(str);
		oos.flush();
	}

	public void run() throws IOException, ClassNotFoundException, UnsupportedAudioFileException {
		ServerSocket server = new ServerSocket(5000);

		while (true) {
			System.out.println("wait");

			Socket s = server.accept();
			System.out.println("get" + s.getInetAddress() + ":" + s.getPort());

			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());

			for (int i = 1; i <= 3; i++) {
				str = "server" + i;
				action();
			}
			
			oos.writeObject("link success");
			oos.flush();

			do {
				ais=AudioSystem.getAudioInputStream((InputStream) ois.readObject());
				wav(ais);
				//str = (String) ois.readObject();
				//System.out.println(str);
			} while (!str.equalsIgnoreCase("q"));

			oos.writeObject("q");
			oos.flush();

			oos.close();
			ois.close();
			s.close();
		}
	}
	
	public void wav(AudioInputStream audioInputStream) throws IOException
	{
		double sampleRate = 44100.0;
	    double frequency = 440;
	    double frequency2 = 90;
	    double amplitude = 1.0;
	    double seconds = 2.0;
	    double twoPiF = 2 * Math.PI * frequency;
	    double piF = Math.PI * frequency2;
	    float[] buffer = new float[(int) (seconds * sampleRate)];
	    for (int sample = 0; sample < buffer.length; sample++) 
	    {
	        double time = sample / sampleRate;
	        buffer[sample] = (float) (amplitude * Math.cos((double)piF *time)* Math.sin(twoPiF * time));
	    }
	    final byte[] byteBuffer = new byte[buffer.length * 2];
	    int bufferIndex = 0;
	    for (int i = 0; i < byteBuffer.length; i++) {
	    final int x = (int) (buffer[bufferIndex++] * 32767.0);
	    byteBuffer[i] = (byte) x;
	    i++;
	    byteBuffer[i] = (byte) (x >>> 8);
	    }
	    File out = new File("/Users/llmzs/Desktop/testzs.wav");
	    boolean bigEndian = false;
	    boolean signed = true;
	    int bits = 16;
	    int channels = 1;
	    AudioFormat format;
	    format = new AudioFormat((float)sampleRate, bits, channels, signed, bigEndian);
	    ByteArrayInputStream bais = new ByteArrayInputStream(byteBuffer);
	    //AudioInputStream audioInputStream;
	    
		//URL url = new URL("file:/Users/llmzs/Desktop/4659.wav");
		//AudioStream mus = new AudioStream(url.openStream());
	    //audioInputStream =AudioSystem.getAudioInputStream(url);
	    //audioInputStream = new AudioInputStream(bais, format,buffer.length);
	    AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, out);
	    audioInputStream.close();
	}
}
